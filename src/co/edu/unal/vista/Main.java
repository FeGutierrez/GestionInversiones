/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.vista;


import co.edu.unal.modelo.*;

/**
 *
 * @author Flexxo333
 */
public class Main {
    
    public static void main(String[] args) {
        
        Stock sto = new Stock(20, "dollar", 15, 19);
        MutualFund mf = new MutualFund(25, "euro", 22, 24);
        DividendStock ds = new DividendStock(10, 20, "Yen", 15, 30);
        Cash cash1 = new Cash(500000);
        
        Cliente cliente1 = new Cliente("Diana", "Obando", "2223344", 29, "email@domain");
        
        //cliente1.getActivos().add(sto);
        //cliente1.getActivos().add(mf);
        
        cliente1.anadirActivo(sto);
        cliente1.anadirActivo(mf);
        cliente1.anadirActivo(cash1);
        cliente1.anadirActivo(ds);
        
        
        
        
        System.out.println(cliente1.infoActivos());
        
        System.out.println("Size" + cliente1.getActivos().size());
        
        
        
    }
    
}
