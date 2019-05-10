/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.netty.game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author alpalpalapalallapala
 */
public class MainScreen extends JFrame implements ActionListener {
    
    protected JButton btnstart ;
   protected  static JTextField txtname;
    protected static JFrame jf = new JFrame();
   String nickname;
    
    public MainScreen(){
        
        jf.setTitle("Main Screen");
        jf.setLayout(new GridLayout(2,3));
        jf.setSize(700,700);
        jf.setResizable(false);
        btnstart = new JButton("Start Game!");
        btnstart.addActionListener(this);
        txtname = new JTextField("Enter Nickname here!");
        jf.add(btnstart);
        jf.add(txtname);
        jf.setVisible(true);
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
          new GameScreen(700,700);
         nickname = txtname.getText();
            jf.setVisible(false);
     
        
    }
    
    public static void main(String[] args){
        
       
          new MainScreen();
    }
    
}
