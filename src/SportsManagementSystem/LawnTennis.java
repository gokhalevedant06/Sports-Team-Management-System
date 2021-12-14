package SportsManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LawnTennis extends JFrame implements ActionListener {
    JLabel l1;
    JButton back,addPlayers,removePlayers,updateTeam,viewPlayerList;


    public void actionPerformed(ActionEvent ae){try{
        if(ae.getSource()==back){
            new Dashboard().setVisible(true);
            setVisible(false);
        }else if (ae.getSource()==addPlayers){
            new AddPlayer("lawntennis").setVisible(true);
            setVisible(false);
        }else if(ae.getSource()==viewPlayerList){
            new ViewPlayerList("lawntennis").setVisible(true);
            setVisible(false);
        }else if(ae.getSource()==removePlayers){
            new RemovePlayer("lawntennis").setVisible(true);
            setVisible(false);
        }else if(ae.getSource()==updateTeam){
            new UpdatePlayer("lawntennis").setVisible(true);
            setVisible(false);
        }
    }catch (Exception e){
        System.out.println(e);
    }}

    LawnTennis(){
        setTitle("SPORTS MANAGEMENT SYSTEM");
        setLayout(null);

        l1 = new JLabel("Manage Cricket Team");
        l1.setFont(new Font("Osward",Font.BOLD,22));
        l1.setBounds(260,40,450,40);
        add(l1);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(20,10,100,40);
        add(back);

        addPlayers = new JButton("Add Player");
        addPlayers.setBackground(Color.BLACK);
        addPlayers.setForeground(Color.WHITE);
        addPlayers.setBounds(150,120,150,80);
        add(addPlayers);

        removePlayers = new JButton("Remove Player");
        removePlayers.setBackground(Color.BLACK);
        removePlayers.setForeground(Color.WHITE);
        removePlayers.setBounds(450,120,150,80);
        add(removePlayers);

        updateTeam = new JButton("Update Details");
        updateTeam.setBackground(Color.BLACK);
        updateTeam.setForeground(Color.WHITE);
        updateTeam.setBounds(150,280,150,80);
        add(updateTeam);

        viewPlayerList = new JButton("View Players List");
        viewPlayerList.setBackground(Color.BLACK);
        viewPlayerList.setForeground(Color.WHITE);
        viewPlayerList.setBounds(450,280,150,80);
        add(viewPlayerList);

        back.addActionListener(this);
        addPlayers.addActionListener(this);
        removePlayers.addActionListener(this);
        updateTeam.addActionListener(this);
        viewPlayerList.addActionListener(this);


        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);
        setLocation(450, 200);
        setVisible(true);
    }

}