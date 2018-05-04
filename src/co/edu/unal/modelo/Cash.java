/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.modelo;

/**
 *
 * @author Flexxo333
 */
public class Cash implements Asset{
   
    private int amount;

    public Cash(int amount) {
        this.amount = amount;
    }
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
        
    @Override
    public double getMarketValue(){
        return this.amount;
    }
    
    @Override
    public double getProfit(){
        return 0;
    }
    
    public String informacion(){
        String str = "";
        str += "Cash: " + this.amount;
        return str;
    }
    
}
