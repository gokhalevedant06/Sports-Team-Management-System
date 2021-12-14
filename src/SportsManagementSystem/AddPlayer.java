package SportsManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPlayer extends JFrame implements ActionListener {

    JLabel WindowTitle, playerName, playerAge, homeTown, contactNumber, department, rollNumber, gender;
    JTextField playerNameTF, playerAgeTF, homeTownTF, contactNumberTF, rollTF;
    JComboBox departmentCB;
    JRadioButton MaleRB, FemaleRB;
    JButton addPlayer, back;
    ButtonGroup genderBtns;
    String currentSport;


    AddPlayer(String sport) {
        setTitle("SPORTS MANAGEMENT SYSTEM");
        setLayout(null);
        setCurrentSport(sport);
        WindowTitle = new JLabel("ADD PLAYER - Fill Player Details");
        WindowTitle.setFont(new Font("Osward", Font.BOLD, 30));
        WindowTitle.setBounds(450, 40, 600, 40);
        add(WindowTitle);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(20, 10, 100, 40);
        add(back);
        back.addActionListener(this);


        playerName = new JLabel("Enter Name");
        playerName.setFont(new Font("Raleway", Font.BOLD, 20));
        playerName.setBounds(50, 120, 450, 40);
        add(playerName);

        playerNameTF = new JTextField(15);
        playerNameTF.setBounds(300, 120, 230, 40);
        playerNameTF.setFont(new Font("Arial", Font.BOLD, 14));
        add(playerNameTF);

        rollNumber = new JLabel("Enter Roll Number");
        rollNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        rollNumber.setBounds(50, 180, 450, 40);
        add(rollNumber);

        rollTF = new JTextField(15);
        rollTF.setBounds(300, 180, 230, 40);
        rollTF.setFont(new Font("Arial", Font.BOLD, 14));
        add(rollTF);

        playerAge = new JLabel("Enter Age");
        playerAge.setFont(new Font("Raleway", Font.BOLD, 20));
        playerAge.setBounds(50, 240, 450, 40);
        add(playerAge);

        playerAgeTF = new JTextField(15);
        playerAgeTF.setBounds(300, 240, 230, 40);
        playerAgeTF.setFont(new Font("Arial", Font.BOLD, 14));
        add(playerAgeTF);

        contactNumber = new JLabel("Enter Contact Number");
        contactNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        contactNumber.setBounds(50, 300, 450, 40);
        add(contactNumber);

        contactNumberTF = new JTextField(15);
        contactNumberTF.setBounds(300, 300, 230, 40);
        contactNumberTF.setFont(new Font("Arial", Font.BOLD, 14));
        add(contactNumberTF);

        homeTown = new JLabel("Enter Birth Place");
        homeTown.setFont(new Font("Raleway", Font.BOLD, 20));
        homeTown.setBounds(50, 360, 450, 40);
        add(homeTown);


        homeTownTF = new JTextField(15);
        homeTownTF.setBounds(300, 360, 230, 40);
        homeTownTF.setFont(new Font("Arial", Font.BOLD, 14));
        add(homeTownTF);

        gender = new JLabel("Select Gender");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(50, 420, 450, 40);
        add(gender);

        MaleRB = new JRadioButton("Male");
        MaleRB.setBackground(Color.white);
        MaleRB.setBounds(300, 420, 100, 40);
        MaleRB.setActionCommand("Male");

        FemaleRB = new JRadioButton("Female");
        FemaleRB.setBackground(Color.white);
        FemaleRB.setBounds(400, 420, 100, 40);
        FemaleRB.setActionCommand("Female");


        add(MaleRB);
        add(FemaleRB);

        genderBtns = new ButtonGroup();
        genderBtns.add(MaleRB);
        genderBtns.add(FemaleRB);

        department = new JLabel("Select Your Department");
        department.setFont(new Font("Raleway", Font.BOLD, 20));
        department.setBounds(50, 480, 450, 40);
        add(department);

        String[] branches = {"Computer Science", "Information Technology", "Data Science", "Electronics", "Mechanical", "Chemical", "Instrumentation", "Production"};
        departmentCB = new JComboBox(branches);
        departmentCB.setBounds(300, 480, 230, 40);
        departmentCB.setBackground(Color.white);
        add(departmentCB);

        addPlayer = new JButton("ADD PLAYER");
        addPlayer.setBackground(Color.BLACK);
        addPlayer.setForeground(Color.WHITE);
        addPlayer.setBounds(140, 570, 250, 45);
        add(addPlayer);

        addPlayer.addActionListener(this);
        getContentPane().setBackground(Color.WHITE);

        setSize(1510, 840);
        setLocation(10, 10);
        setVisible(true);

    }

    public void setCurrentSport(String currentSport) {
        this.currentSport = currentSport;
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == addPlayer) {
            try {
                String playername = playerNameTF.getText();
                int roll = Integer.parseInt(rollTF.getText());
                int age = Integer.parseInt(playerAgeTF.getText());
                String number = contactNumberTF.getText();
                String hometown = homeTownTF.getText();
                String gender = genderBtns.getSelection().getActionCommand();
                String dept = (String)departmentCB.getSelectedItem();

                Conn c2 = new Conn();
                String query = "insert into " + currentSport + " values('" + playername + "','" + roll + "','" + age + "','" + number + "','" + hometown + "','" + gender + "','" + dept + "')";
                c2.s.executeUpdate(query);
                System.out.println("New Player Added");
                new Badminton().setVisible(true);
                setVisible(false);
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource()==back){
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

}
