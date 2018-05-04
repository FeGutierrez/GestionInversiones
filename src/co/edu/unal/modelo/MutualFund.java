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
public class MutualFund extends ShareAsset {
    private double totalShares;

    public MutualFund(double totalShares, String symbol, double totalCost, double currentPrice) {
        super(symbol, totalCost, currentPrice);
        this.totalShares = totalShares;
    }
    
    
    
    @Override
    public double getMarketValue(){
        return this.totalShares*super.getCurrentPrice();
    }
    
    @Override
    public double getProfit(){
        return (this.totalShares*super.getCurrentPrice())-super.getTotalCost();
    }
    
    public String informacion(){
        String str = "";
        str += this.getSymbol() + " " + this.totalShares + " "+ 
                super.getCurrentPrice() + " " + super.getTotalCost();
        return str;
    }
}
