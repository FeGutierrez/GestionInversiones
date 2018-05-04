/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.modelo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Flexxo333
 */
public class Compania {
    
    private String nombre;
    private ArrayList<Cliente> clientes;
    private ArrayList<Asset> todosActivos;

    public Compania(String nombre) {
        this.nombre = nombre;
        this.clientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Asset> getTodosActivos() {
        return todosActivos;
    }

    public void setTodosActivos(ArrayList<Asset> todosActivos) {
        this.todosActivos = todosActivos;
    }
    
    public String listarClientes(){
        String str = "";
        for (int i = 0; i < this.clientes.size(); i++) {
            str += this.clientes.get(i).toString() + "\n";
            //str += this.clientes.get(i).getNombre()+ "\n";
        }
        return str;
    }
    
    public boolean anadirCliente(Cliente cliente1){
        Cliente existente = null;
        boolean res = false;
        for (int i = 0; i < this.clientes.size(); i++) {
            if (cliente1.getCedula()==this.clientes.get(i).getCedula()) {
                existente = this.clientes.get(i);
            }
        }
        if (existente == null) {
            res = true;
            this.clientes.add(cliente1);
        } else {
            res = false;
            System.out.println("Cedula ya registrada");
        }
        return res;        
    }
    
    public boolean crearActivoACliente(int cedula){
        Cliente existente = null;
        boolean res = false;
        for (int i = 0; i < this.clientes.size(); i++) {
            if (cedula==this.clientes.get(i).getCedula()) {
                existente = this.clientes.get(i);
            }
        }
        if (existente !=null) {
            Scanner sc = new Scanner(System.in);
            int tipo = sc.nextInt();
            //while (tipo !=0 ) { //Este while me genera cierta dificultad, al habilitarlo no me deja registrar de manera adecuada los productos
            //Es como si bucleara el scanner, lo estoy revisando para hacerlo funcionar adecuadamente, básicamente quiero que alguien pueda intentar registrar 
            //activos hasta que desee y le permitan las restricciones de cantidad del sistema.
                switch(tipo){
                case 1: //Cash
                    int amount = sc.nextInt();
                    Cash cash = new Cash(amount);
                    existente.anadirActivo(cash);
                    this.todosActivos.add(cash);
                    res = true;
                    break;
                case 2: //Stock
                    int shares = sc.nextInt();
                    String symbol = sc.next();
                    double totalCost = sc.nextDouble();
                    double currentPrice = sc.nextDouble();
                    Stock stock = new Stock(shares, symbol, totalCost, currentPrice);
                    existente.anadirActivo(stock);
                    this.todosActivos.add(stock);
                    res = true;
                    break;
                case 3: //Mutual Fund 
                    double sharesF = sc.nextDouble();
                    String symbolF = sc.next();
                    double totalCostF = sc.nextDouble();
                    double currentPriceF = sc.nextDouble();
                    MutualFund mutualFund = new MutualFund(sharesF, symbolF, totalCostF, currentPriceF);
                    existente.anadirActivo(mutualFund);
                    this.todosActivos.add(mutualFund);
                    res = true;
                    break;
                case 4: //Dividend Stock public DividendStock(double dividends, int totalShares, String symbol, double totalCost, double currentPrice) {
                    double dividends = sc.nextDouble();
                    int sharesDS = sc.nextInt();
                    String symbolDS = sc.next();
                    double totalCostDS = sc.nextDouble();
                    double currentPriceDS = sc.nextDouble();
                    DividendStock dividendStock = new DividendStock(dividends, sharesDS, symbolDS, totalCostDS, currentPriceDS);
                    existente.anadirActivo(dividendStock);
                    this.todosActivos.add(dividendStock);
                    res = true;
                    break;
                case 0: System.out.println("¡Gracias!");
                    break;
                default: System.out.println("Por favor digite un valor adecuado");
                    break;
            //    }  
            };
            
               
        } else {
            System.out.println("No existe esta cedula");
            res = false;
        }   
        return res;
    }
    
    public String listarActivosPorCedula(int cedula){
        Cliente existente = null;
        String str = null;
        for (int i = 0; i < this.clientes.size(); i++) {
            if (cedula==this.clientes.get(i).getCedula()) {
                existente = this.clientes.get(i);
            }
        }
        if (existente != null) {
            str = existente.infoActivos();
        } else {
            System.out.println("Cedula no existente");
        }
        return str;
    }
    
    public double valorMercadoTodoslosCliente(){
        double sum = 0;
        for (int i = 0; i < this.clientes.size(); i++) {
            sum += this.clientes.get(i).valorMercadoCliente();
        }
        return sum;
    }
    
    public String valorMercadoBeneficioPorActivo(/*int tipoActivo*/){
        //El valor en el mercado se da por las funciones del documento y se declaran en cada clase segun sea necesario
        //Mi pregunta es ¿El valor del mercado es una sumatoria simple o es un promedio?
        //O sea, 10 activos de 10 en marketValue y 5 en Profit dan como resultado $100 en marketValue o $10, y $50 en marketValue o $5
        //No se muy bien como funciona este tipo de gestiones financieras en la vida práctica
//        for (int i = 0; i < this.todosActivos.size(); i++) {
//            Asset var = this.todosActivos.get(i);
//            switch(tipoActivo){
//                case 1:
//                    double cash = 0;
//                    double cashProfit = 0;
//                    if (var instanceof Cash) {
//                        cash += var.getMarketValue();
//                        cashProfit += var.getProfit();
//                    }
//                    break;
//                case 2:
//                    double stock = 0;
//                    double stockProfit = 0;
//                    break;
//            }
//        }        
        double divStock = 0;
        double divStockProfit = 0;
        double mutualFund = 0;
        double mutualFundProfit = 0;        
        double cash = 0;
        double cashProfit = 0;        
        double stock = 0;
        double stockProfit = 0;        
        
        for (int i = 0; i < this.todosActivos.size(); i++) {
            Asset var = this.todosActivos.get(i);
            if (var instanceof DividendStock) {
                divStock += var.getMarketValue();
                divStockProfit += var.getProfit();
            } else {
                if (var instanceof Stock) {
                stock += var.getMarketValue();
                stockProfit += var.getProfit();
                }
            }            
            if (var instanceof MutualFund) {
                mutualFund += var.getMarketValue();
                mutualFundProfit += var.getProfit();
            }
            if (var instanceof Cash) {
                cash += var.getMarketValue();
                cashProfit += var.getProfit();
            }
        }
        return "Cash: Valor en el mercado: "+ cash  + " Beneficio: " + cashProfit
                +"\nStock: Valor en el mercado: " + stock + " Beneficio: " + stockProfit 
                +"\nMutualFund: Valor en el mercado: " + mutualFund  + " Beneficio: " + mutualFundProfit
                +"\nDividend Stock: Valor en el mercado: " + divStock + " Beneficio " + divStockProfit;
    }
    
    public double beneficioTotalObtenido(){

        double totalProfit = 0;       
        
        for (int i = 0; i < this.todosActivos.size(); i++) {
            totalProfit += this.todosActivos.get(i).getProfit();     
        }
        
        return totalProfit;
    }
    
    public String beneficioValorMercadoPorEdades(){
        double ceroVeinteMarket = 0;
        double ceroVeinteProfit = 0;
        double veinteCuarentaMarket = 0;
        double veinteCuarentaProfit = 0;
        double cuarentaPlusMarket = 0;
        double cuarentaPlusProfit = 0;
        for (int i = 0; i < this.clientes.size(); i++) {
            Cliente cliente = this.clientes.get(i);
            if (0 <= cliente.getEdad() && cliente.getEdad() < 20 ) {
                ceroVeinteMarket += cliente.valorMercadoCliente();
                ceroVeinteProfit += cliente.beneficioCliente();
            }
            if (20 <= cliente.getEdad() && cliente.getEdad() < 40 ) {
                veinteCuarentaMarket += cliente.valorMercadoCliente();
                veinteCuarentaProfit += cliente.beneficioCliente();
            }
            if (40 <= cliente.getEdad()) {
                cuarentaPlusMarket += cliente.valorMercadoCliente();
                cuarentaPlusProfit += cliente.beneficioCliente();
            }
        }
        
        return "0-20:"+ "Market: " + ceroVeinteMarket + "Profit: " + ceroVeinteProfit  + "\n20 - 40" + 
                "Market: " +veinteCuarentaMarket + "Profit: " +veinteCuarentaProfit + " \n40+ " 
                + "Market: " +cuarentaPlusMarket + "Profit: " +cuarentaPlusProfit;
    }
    
    public Cliente clienteMayorBeneficio(){
        Cliente mayor = null;
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i)!=null && mayor ==null) {
                mayor = this.clientes.get(i);
            } else {
                if (this.clientes.get(i)!=null && this.clientes.get(i).beneficioCliente() > mayor.beneficioCliente()) {
                    mayor = this.clientes.get(i);
                }
            }
        }
        return mayor;
    }
    
    
    
}
