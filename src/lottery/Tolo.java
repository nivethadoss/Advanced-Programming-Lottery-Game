/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lottery;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author Nivetha
 */
public class Tolo extends javax.swing.JFrame implements ActionListener {
    
    JPanel panel = new JPanel();
    JLabel wellabel = new JLabel("WELCOME TO THE TOLO BET INTERFACE");
    JLabel chosingnumlabel = new JLabel("Choosing your numbers");
    JLabel extrabetlabel = new JLabel("Extra number for Super Bet");
    JLabel betlabel = new JLabel("Bet = ");
    JTextField moneyfield = new JTextField(); 
    JTextField text1 = new JTextField();
    JTextField text2 = new JTextField();
    JTextField text3 = new JTextField();
    JTextField text4 = new JTextField();
    JTextField text5 = new JTextField();
    JTextField text6 = new JTextField();
    JCheckBox tickedornot = new JCheckBox("Super Bet ?");
    JButton drawbutton = new JButton("Draw Numbers");
    JLabel eurolabel = new JLabel("€");
    Bet betobject;
    boolean flag;
    int luckyrannum;
    int num1,num2, num3, num4, num5;
    
    public Tolo(){
        initcomponents();
        this.setVisible(true);
        
    }
    
    public void initcomponents(){
        
        this.getContentPane().add(panel);
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
        
        //adding  labels to the panel
        panel.add(wellabel);
        panel.add(chosingnumlabel);
        panel.add(extrabetlabel); 
        panel.add(tickedornot);
        panel.add(betlabel);
        panel.add(eurolabel);
        panel.add(drawbutton);
        panel.add(text1);
        panel.add(text2);
        panel.add(text3);
        panel.add(text4);
        panel.add(text5);
        panel.add(text6);
        this.text1.setColumns(2);
        this.text2.setColumns(2);
        this.text3.setColumns(2);
        this.text4.setColumns(2);
        this.text5.setColumns(2);
        this.text6.setColumns(5);
        text5.setVisible(false);
        extrabetlabel.setVisible(false);
        drawbutton.addActionListener(this);
        
        //wellabel constraints
        layout.putConstraint(SpringLayout.NORTH, wellabel,
                     5,
                     SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, wellabel,
                     150,
                     SpringLayout.WEST, panel);

        //chosinglabel constraints
        layout.putConstraint(SpringLayout.NORTH, chosingnumlabel,
                     10,
                     SpringLayout.SOUTH, wellabel);
        layout.putConstraint(SpringLayout.WEST, chosingnumlabel,
                     5,
                     SpringLayout.WEST, panel);
        
        //extralabel contraints       
        layout.putConstraint(SpringLayout.NORTH, extrabetlabel ,
                     10,
                     SpringLayout.SOUTH, wellabel);
        layout.putConstraint(SpringLayout.EAST, extrabetlabel,
                     400,
                     SpringLayout.EAST, chosingnumlabel);
        
        //text1 constraints      
        layout.putConstraint(SpringLayout.NORTH, text1 ,
                     10,
                     SpringLayout.SOUTH, chosingnumlabel);
        layout.putConstraint(SpringLayout.WEST, text1,
                     10,
                     SpringLayout.WEST, chosingnumlabel);
        
        //text2 constraints
        layout.putConstraint(SpringLayout.NORTH, text2 ,
                     10,
                     SpringLayout.SOUTH, chosingnumlabel);
        layout.putConstraint(SpringLayout.WEST, text2,
                     10,
                     SpringLayout.EAST, text1);
        
        //text3 constraints
        layout.putConstraint(SpringLayout.NORTH, text3 ,
                     10,
                     SpringLayout.SOUTH, chosingnumlabel);
        layout.putConstraint(SpringLayout.WEST, text3,
                     10,
                     SpringLayout.EAST, text2);
        
        //text4 constraints
        layout.putConstraint(SpringLayout.NORTH, text4 ,
                     10,
                     SpringLayout.SOUTH, chosingnumlabel);
        layout.putConstraint(SpringLayout.WEST, text4,
                     10,
                     SpringLayout.EAST, text3);
        
        //text5 constraints
        layout.putConstraint(SpringLayout.NORTH, text5 ,
                     10,
                     SpringLayout.SOUTH, extrabetlabel);
        layout.putConstraint(SpringLayout.WEST, text5,
                     250,
                     SpringLayout.EAST, text4);
        
       //tickedornot constraints
        layout.putConstraint(SpringLayout.NORTH, tickedornot ,
                     10,
                     SpringLayout.SOUTH, text1);
        layout.putConstraint(SpringLayout.WEST, tickedornot,
                     10,
                     SpringLayout.WEST, panel);
        
        //betlabel constraints
        layout.putConstraint(SpringLayout.NORTH, betlabel ,
                     20,
                     SpringLayout.SOUTH, tickedornot);
        layout.putConstraint(SpringLayout.WEST, betlabel,
                     10,
                     SpringLayout.WEST, panel);
        
        //text6 constraints
        layout.putConstraint(SpringLayout.WEST, text6 ,
                     20,
                     SpringLayout.EAST, betlabel);
        layout.putConstraint(SpringLayout.NORTH, text6 ,
                     20,
                     SpringLayout.SOUTH, tickedornot);
        
       //eurolabel contraints
        layout.putConstraint(SpringLayout.WEST, eurolabel ,
                     5,
                     SpringLayout.EAST, text6);
        layout.putConstraint(SpringLayout.NORTH, eurolabel ,
                     20,
                     SpringLayout.SOUTH, tickedornot);
        
        //drawbutton contraints
        layout.putConstraint(SpringLayout.NORTH, drawbutton ,
                     5,
                     SpringLayout.SOUTH, text6);
        layout.putConstraint(SpringLayout.EAST, drawbutton,
                     -10,
                     SpringLayout.EAST, panel);
        
        
      tickedornot.addItemListener(new ItemListener(){
              
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (ie.getStateChange() == 1) {

                    text5.setVisible(true);
                    extrabetlabel.setVisible(true);

                } else {
                   extrabetlabel.setVisible(false);
                   text5.setVisible(false);

                }
            }

        });

        this.setPreferredSize(new Dimension(600, 230));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
      
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ArrayList<Integer> randomnum = new ArrayList<>();
        Random r = new Random();
        int myRandomNumber = 0;
        int maxValue = 20;
        int minValue = 1;
       
        for(int i = 0; i<4; i++){
        myRandomNumber = r.nextInt(maxValue-minValue+1)+minValue;
        randomnum.add(myRandomNumber);
       
        }
         maxValue = 10;
         minValue = 1;
         luckyrannum = r.nextInt(maxValue-minValue+1)+minValue;
        
        
        
        if(tickedornot.isSelected() == true){
            try{
                this.num1 =Integer.parseInt(text1.getText());
                this.num2 =Integer.parseInt(text2.getText());
                this.num3 =Integer.parseInt(text3.getText());
                this.num4 =Integer.parseInt(text4.getText());
                this.num5 =Integer.parseInt(text5.getText());
                int betmoney  = Integer.parseInt(text6.getText());
                if(num1 <=20 && num2 <=20 && num3 <=20 && num4 <=20 && num5 <=20){
                    ArrayList<Integer> betlist = new ArrayList<>();
                    betlist.add(num1);
                    betlist.add(num2);
                    betlist.add(num3);
                    betlist.add(num4); 
                    betobject = new superBet(betlist, betmoney, "Superbet", luckyrannum);
                    flag = true;
                }
                else{
                    System.out.println("Draw numbers should be less than 20");
                }
              
            }
            
            catch(Exception e){ 
                Warning war = new Warning();
                war.setVisible(true);
                war.setLocationRelativeTo(this);
            }  
            
        }
        else{
            try{
                this.num1 =Integer.parseInt(text1.getText());
                this.num2 =Integer.parseInt(text2.getText());
                this.num3 =Integer.parseInt(text3.getText());
                this.num4 =Integer.parseInt(text4.getText());
       
                if(num1 <=20 && num2 <=20 && num3 <=20 && num4 <=20 ){
                    ArrayList<Integer> betlist = new ArrayList<>();
                    int betmoney  = Integer.parseInt(text6.getText());
                    System.out.println(betmoney);
                    betlist.add(num1);
                    betlist.add(num2);
                    betlist.add(num3);
                    betlist.add(num4);
                    betobject = new Bet(betlist, betmoney, "Bet");
                    flag = false;}
                else{
                    System.out.println("Draw numbers should be less than 20");    
                    }
            }    
       catch(Exception e){
            Warning war = new Warning();
            war.setVisible(true);
            war.setLocationRelativeTo(this);
            
           
       }
    }   
   
    //Result GUI
     try{
            betobject.computeGain(randomnum, luckyrannum); 
            int betgain = Integer.parseInt(betobject.getgain());
            ResultGUI window = new ResultGUI();
            window.setregularlabels(num1, num2, num3, num4);
            window.setrandonlabels(randomnum.get(0), randomnum.get(1), randomnum.get(2), randomnum.get(3));
        if (flag){
            java.awt.Label userluckylabel;
            userluckylabel = window.getluckylabel();
            userluckylabel.setVisible(true);
            window.setuserluckynum(this.text5.getText());

            java.awt.Label randomluckylabel;
            randomluckylabel=window.getrandlnum();
            randomluckylabel.setVisible(true);
            window.setrandomluckynumber(String.valueOf(this.luckyrannum));

        }
         window.setgain(String.valueOf(betgain));
         window.setVisible(true);

        }
    catch(Exception e){
        Warning war = new Warning();
        war.setVisible(true);
        war.setLocationRelativeTo(this);
                
}
    } 
}
