package SportsManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6;

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            new Badminton().setVisible(true);
            setVisible(false);
        }else if(ae.getSource()==b2){
            new Cricket().setVisible(true);
            setVisible(false);
        }else if(ae.getSource()==b3){
            new LawnTennis().setVisible(true);
            setVisible(false);

        }else if(ae.getSource()==b4){
            new TableTennis().setVisible(true);
            setVisible(false);

        }else if(ae.getSource()==b5){
            new Football().setVisible(true);
            setVisible(false);
        }else if(ae.getSource()==b6){
            new Hockey().setVisible(true);
            setVisible(false);
        }
    }

    Dashboard() {
        setTitle("SPORTS MANAGEMENT SYSTEM");
        setLayout(null);
        l1 = new JLabel("Manage Your Teams");
        l1.setFont(new Font("Osward", Font.BOLD, 22));
        l1.setBounds(280, 40, 450, 40);
        add(l1);

        b1 = new JButton("Badminton");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(140,120,200,40);
        add(b1);

        b2 = new JButton("Cricket");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(140,220,200,40);
        add(b2);

        b3 = new JButton("Lawn Tennis");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(140,320,200,40);
        add(b3);

        b4 = new JButton("Table Tennis");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(440,120,200,40);
        add(b4);

        b5 = new JButton("Football");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(440,220,200,40);
        add(b5);

        b6 = new JButton("Hockey");
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setBounds(440,320,200,40);
        add(b6);


        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);
        setLocation(450, 200);
        setVisible(true);
    }



}
