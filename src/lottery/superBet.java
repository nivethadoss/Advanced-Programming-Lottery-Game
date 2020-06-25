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
public class superBet extends Bet {
    public int luckynumber;

    public superBet(ArrayList<Integer> numbers, int betmoney, String name, int luckynum) {
        super(numbers, betmoney, name);
        this.luckynumber = luckynum;
    }

    @Override
    public void computeGain( ArrayList<Integer> randomarray, int luckynum) {
        int count = 0;
        for(int num : this.betnumberslist){
            if (randomarray.contains(num)){
                count++;
            }
        }    
        
        if (count == 3){
             gain = this.betmoney * 5;}
        else if(count == 4){
             gain = this.betmoney * 50;}
            
        if (luckynum == this.luckynumber){
            gain = gain * 5;
            }
        
    }
   
}
