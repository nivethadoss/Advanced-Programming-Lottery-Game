/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lottery;

import java.util.ArrayList;

/**
 *
 * @author Nivetha
 */
public class Bet {
    
    ArrayList<Integer> betnumberslist = new ArrayList<>();
    public int betmoney;
    public int gain;
    public String betname;
    Tolo T1;
    
 public Bet(ArrayList<Integer> numbers, int betmoney, String name){
     this.betnumberslist = numbers;
     this.betmoney = betmoney;
     this.betname = name;
    
 }   
 
 public void computeGain(ArrayList<Integer> randomarray, int luckynum){
     int count = 0;
     luckynum = 0;
     
    for(int num :this.betnumberslist){
        if(randomarray.contains(num)){
            count++;
        } 
    }
    
    if (count == 3){
        gain = this.betmoney * 5;}
    else if(count == 4){
        gain = this.betmoney * 50;}
  
 }
 public String getgain(){
     return String.valueOf(gain);
 }
 
 }

    

