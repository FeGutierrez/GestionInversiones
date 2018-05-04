/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.modelo;

import java.util.ArrayList;

/**
 *
 * @author Flexxo333
 */
public class Cliente {
    //Nombre, apellido, telefono, edad, email
    private String nombre;
    private String apellido;
    private String telefono;
    private int edad;
    private String email;
    private int cedula;
    
    private ArrayList<Asset> activos;

    public Cliente(int cedula, String nombre, String apellido, String telefono, int edad, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.edad = edad;
        this.email = email;
        this.activos = new ArrayList<>();
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Asset> getActivos() {
        return activos;
    }

    public void setActivos(ArrayList<Asset> activos) {
        this.activos = activos;
    }
    
    @Override
    public String toString(){
        return  "Cedula: "+this.cedula + " Nombre: " +this.nombre + " Apellido: " + this.apellido + " Edad: " + this.edad;
    }
    
    public String infoActivos(){
        String str = "Activos:\n";
        for (int i = 0; i < this.activos.size(); i++) {
            Asset var = this.activos.get(i);
            str += i + " ";
            if (var instanceof DividendStock) {
                str += ((DividendStock) var).informacion() +"\n";
            } else {
                if (var instanceof Stock) {
                str += "Stock: "+((Stock) var).informacion() +"\n";
                }
            }            
            if (var instanceof MutualFund) {
                str += "Mutual Fund: " + ((MutualFund) var).informacion() +"\n";
            }
            if (var instanceof Cash) {
                str += "Cash: " + ((Cash) var).informacion() +"\n";
            }
//            if (var instanceof DividendStock) {
//                //Tengo una duda, cuando no coloco el DividendStock en un if(){}else{} previo al Stock el toma los objetos de tipo
//                  DividendStock como objetos de tipo Stock, tengo entendido que la superclase puede apuntar a sus descendientes
                    //Pero en "var instanceof DividendStock" estoy haciendo explicito que debe ser un objeto de esa clase y no de Stock
                    //Porque hace esa categorización. Está corregido, pero si hace falta replicar el error vuelvo a escribir lo que borré profe.
                    // ¡Gracias!
//                //str += ((DividendStock) var).informacion() +"\n";
//            }
        }
        return str + "\n";
    }
    
    public boolean anadirActivo(Asset activo){
            if (this.activos.size()<10) {
                this.activos.add(activo);
                return true;
            } else{
                return false;
            }
    } 
    
    public double valorMercadoCliente(){
        double sum = 0;
        for (int i = 0; i < this.activos.size(); i++) {
            sum += this.activos.get(i).getMarketValue();
        }
        return sum;
    }
    
    public double beneficioCliente(){
        double sum = 0;
        for (int i = 0; i < this.activos.size(); i++) {
            sum += this.activos.get(i).getProfit();
        }
        return sum;
        
    }
}
