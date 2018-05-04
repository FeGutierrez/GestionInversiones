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
    
    private ArrayList<Asset> activos;

    public Cliente(String nombre, String apellido, String telefono, int edad, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.edad = edad;
        this.email = email;
        this.activos = new ArrayList<>();
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
    
    public String infoActivos(){
        String str = "";
        int j= 0;
        for (int i = 0; i < this.activos.size(); i++) {
            Asset var = this.activos.get(i);
            str += i + " ";
            if (var instanceof Stock) {
                str += ((Stock) var).informacion() +"\n";
            }
            if (var instanceof MutualFund) {
                str += ((MutualFund) var).informacion() +"\n";
            }
            if (var instanceof DividendStock) {
                //str += "0";
                //str += ((DividendStock) var).informacion() +"\n";
            }
            if (var instanceof Cash) {
                str += ((Cash) var).informacion() +"\n";
            }
           
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
    
    
    
    
    
    
    
}
