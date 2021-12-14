package SportsManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4;
    JTextField tf1, tf2;
    JPasswordField pf1, pf2;
    JButton b1;

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b1) {
                Random random = new Random();
                Conn c2 = new Conn();
                int id = random.nextInt(999999);
                String name = tf1.getText();
                String username = tf2.getText();
                String password = pf1.getText();
                String cpassword = pf2.getText();
                if (password.equals(cpassword)) {
                    String query = "insert into Users values('" + id + "','" + name + "','" + username + "','" + password + "')";
                    c2.s.executeUpdate(query);
                    System.out.println("New User Created");
                    new Login().setVisible(true);
                    setVisible(false);
                } else {
                    System.out.println("Passwords do not match");
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    Signup() {
        setTitle("SPORTS MANAGEMENT SYSTEM");

        setLayout(null);


        l1 = new JLabel("Create A New User");
        l1.setFont(new Font("Osward", Font.BOLD, 22));
        l1.setBounds(280, 40, 450, 40);
        add(l1);

        l2 = new JLabel("Enter Name");
        l2.setFont(new Font("Raleway", Font.BOLD, 20));
        l2.setBounds(115, 120, 375, 30);
        add(l2);

        tf1 = new JTextField(15);
        tf1.setBounds(300, 120, 230, 30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf1);

        l3 = new JLabel("Enter Username");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        l3.setBounds(115, 170, 375, 30);
        add(l3);

        tf2 = new JTextField(15);
        tf2.setBounds(300, 170, 230, 30);
        tf2.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf2);

        l3 = new JLabel("Enter Password");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        l3.setBounds(115, 220, 375, 30);
        add(l3);

        pf1 = new JPasswordField(15);
        pf1.setFont(new Font("Arial", Font.BOLD, 14));
        pf1.setBounds(300, 220, 230, 30);
        add(pf1);

        l4 = new JLabel("Confirm Password");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        l4.setBounds(115, 270, 375, 30);
        add(l4);

        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300, 270, 230, 30);
        add(pf2);

        b1 = new JButton("SIGN UP");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300, 340, 200, 30);
        add(b1);
        b1.addActionListener(this);


        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);
        setLocation(550, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Signup().setVisible(true);
    }

}
