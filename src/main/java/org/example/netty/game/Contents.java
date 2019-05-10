/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.netty.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author alpalpalapalallapala
 */
public  class Contents extends  JPanel implements ActionListener{
    
    Random rand ;
    private Timer t; // variable to refresh rate 
   
    
    
    public Contents (){
        super.setDoubleBuffered(true);
        t = new Timer(getRandomNumber(), this);  // 7ms refresh rate
        t.start();
        
    }
      public  int getRandomNumber(){  // random number generator via time
         rand = new Random(System.currentTimeMillis()*735);
        int x = rand.nextInt(300);
        return x;
    }
      
      
      public int initializeValue(int value){
          value = getRandomNumber();
          return value;
      }
      
      
      public Color randColor(int x){
          x = x % 4;
          Color red = Color.RED;
          Color blue = Color.BLUE;
          Color green = Color.GREEN;
          Color yellow = Color.YELLOW;
          
          switch (x){
              case 0:
                  return red;
                 
              case 1:
                  return blue;
                  
              case 2:
                  return green;
                  
              case 3:
                  return yellow;
                  
              default:
                  return Color.CYAN;
                  
          }
      }
      
      public void randShape(int x, Graphics g){
          x = x % 2;
          int y = getRandomNumber();
          int dp1[] ={getRandomNumber(),getRandomNumber(),getRandomNumber()};
          int dp2[] = {getRandomNumber(),getRandomNumber(),getRandomNumber()};
          
         Graphics2D g2d = (Graphics2D) g;
         

          switch(x){
              case 0:
                  g2d.fillRect(initializeValue(y),initializeValue(y),initializeValue(y),initializeValue(y));
                  break;
              case 1:
                  g2d.fillOval(initializeValue(y),initializeValue(y),initializeValue(y),initializeValue(y));
                  break;
           
              default:
                  break;
                  
          }
      }
      
    
    @Override
    
    public void paintComponent(Graphics g){
        
        Graphics2D g2d =  (Graphics2D) g;
        super.paintComponent(g);
        
        int randC = getRandomNumber(); // randomColorGenerator
       Color rrandC = randColor(randC);
         g2d.setColor(rrandC);

             randShape(getRandomNumber(),g); // doenst work on while loop for some reason
         

    }



    @Override
    public void actionPerformed(ActionEvent e) {
       
             repaint();  // infinite loop
   
   
    }

   
}
