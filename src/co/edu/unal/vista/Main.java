/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.vista;


import co.edu.unal.modelo.*;
import java.util.Scanner;

/**
 *
 * @author Flexxo333
 */
public class Main {
    
    /* NOTAS
    Línea 114 en Cliente.java
    Linea 88 en Compania.java
    
    */
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Compania compania = new Compania("Compania");
        Stock sto = new Stock(20, "dollar", 15, 19);
        MutualFund mf = new MutualFund(25, "euro", 22, 24);
        DividendStock ds = new DividendStock(10, 20, "Yen", 15, 30);
        Cash cash1 = new Cash(500000);
        
        Cliente cliente1 = new Cliente(1234, "Diana", "Obando", "2223344", 29, "email@domain");
        
        Cliente cliente2 = new Cliente(1235, "Marina", "Obando", "2223344", 29, "email@domain");
        
        compania.anadirCliente(cliente1);
        compania.anadirCliente(cliente2);
        System.out.println(compania.listarClientes());
        System.out.println("Digite la cedula del cliente al cual desea añadir uno o varios activos");
        int cedula = sc.nextInt();        
        System.out.println("1. Cash requiere una cantidad entera");
        System.out.println("2. Stock (int totalShares, String symbol, double totalCost, double currentPrice)");
        System.out.println("3. Mutual Fund (double totalShares, String symbol, double totalCost, double currentPrice");
        System.out.println("4. Dividend Stock (double dividends, int totalShares, String symbol, double totalCost, double currentPrice)");
        System.out.println("0. Para salir");
        compania.crearActivoACliente(cedula);
        
        System.out.println(compania.listarActivosPorCedula(1234));
        
        

        
        
        
        
        

        
//        cliente1.anadirActivo(sto);
//        cliente1.anadirActivo(mf);
//        cliente1.anadirActivo(cash1);
//        cliente1.anadirActivo(ds);
//        cliente1.anadirActivo(sto);
//        cliente1.anadirActivo(mf);
//        cliente1.anadirActivo(cash1);
//        cliente1.anadirActivo(ds);
//        cliente1.anadirActivo(sto);
//        cliente1.anadirActivo(mf);
//        cliente1.anadirActivo(cash1);
//        cliente1.anadirActivo(ds);
//        
//        
//        
//        
//        
//        System.out.println(cliente1.infoActivos());
//        
//        System.out.println("Size" + cliente1.getActivos().size());
        
        
        
    }
    
}
