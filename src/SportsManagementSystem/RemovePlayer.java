package SportsManagementSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RemovePlayer extends JFrame implements ActionListener {
    JTable playerDetails;
    JLabel tableTitle, removeRollNumber;
    JButton remove, back;
    JTextField rollNumber;
    String currentSport = null;

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == remove) {
            try {
                Conn c1 = new Conn();
                String rollnumber = rollNumber.getText();
                String query = "DELETE FROM " + currentSport + " where RollNumber = " + rollnumber + "";
                c1.s.executeUpdate(query);
                System.out.println("Player Removed");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == back) {

            switch (currentSport) {
                case "badminton" -> {
                    new Badminton().setVisible(true);
                    setVisible(false);
                }
                case "cricket" -> {
                    new Cricket().setVisible(true);
                    setVisible(false);
                }
                case "football" -> {
                    new Football().setVisible(true);
                    setVisible(false);
                }
                case "lawntennis" -> {
                    new LawnTennis().setVisible(true);
                    setVisible(false);
                }
                case "tabletennis" -> {
                    new TableTennis().setVisible(true);
                    setVisible(false);
                }
                case "hockey" -> {
                    new Hockey().setVisible(true);
                    setVisible(false);
                }
            }

        }
    }

    RemovePlayer(String sport) {
        setTitle("SPORTS MANAGEMENT SYSTEM");
        Conn c1 = new Conn();
        setLayout(null);

        setCurrentSport(sport);


        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(20, 10, 100, 40);
        add(back);
        back.addActionListener(this);

        tableTitle = new JLabel("Remove player from Team - " + sport);
        tableTitle.setFont(new Font("Osward", Font.BOLD, 30));
        tableTitle.setBounds(500, 40, 600, 40);
        add(tableTitle);

        removeRollNumber = new JLabel("Enter Roll Number");
        removeRollNumber.setFont(new Font("Osward", Font.BOLD, 20));
        removeRollNumber.setBounds(50, 120, 600, 40);
        add(removeRollNumber);

        rollNumber = new JTextField(15);
        rollNumber.setBounds(250, 125, 230, 30);
        rollNumber.setFont(new Font("Arial", Font.BOLD, 14));
        add(rollNumber);

        remove = new JButton("Remove");
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.WHITE);
        remove.setBounds(500, 125, 100, 30);
        add(remove);

        remove.addActionListener(this);


        String[][] data = {{"Amit", "12", "120132", "12312", "Pune", "Male", "QGWG"}
        };
        String[] column = {"PlayerName", "Age", "RollNumber", "ContactNumber", "City", "Gender", "Department"};


        playerDetails = new JTable(data, column);
        playerDetails.setBounds(50, 200, 1400, 550);
        playerDetails.setBackground(Color.darkGray);
        playerDetails.setGridColor(Color.white);
        playerDetails.setForeground(Color.white);
        playerDetails.setRowHeight(40);

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(column);
        playerDetails.setModel(model);


        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> roll = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<String> number = new ArrayList<>();
        ArrayList<String> city = new ArrayList<>();
        ArrayList<String> gender = new ArrayList<>();
        ArrayList<String> department = new ArrayList<>();

        int count = 0;
        try {
            ResultSet rs = c1.s.executeQuery("SELECT * FROM " + sport + "");

            while (rs.next()) {

                names.add(rs.getString(1));
                roll.add(rs.getInt(2));
                age.add(rs.getInt(3));
                number.add(rs.getString(4));
                city.add(rs.getString(5));
                gender.add(rs.getString(6));
                department.add(rs.getString(7));
                count++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        for (int i = 0; i < count; i++) {
            String[] rowData = {names.get(i), String.valueOf(roll.get(i)), String.valueOf(age.get(i)), number.get(i), city.get(i), gender.get(i), department.get(i)};
            model.addRow(rowData);
        }

        add(playerDetails);


        getContentPane().setBackground(Color.WHITE);

        setSize(1510, 840);
        setLocation(10, 10);
        setVisible(true);
    }

    public void setCurrentSport(String currentSport) {
        this.currentSport = currentSport;
    }


}
