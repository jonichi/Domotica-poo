/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ciber
 */
public class Error {
    
    public Error(){
        
    }
    public boolean comprobar(int opciones){
        return opciones !=0;
    }
    
    public boolean comprobar(String cadena){
        return !cadena.equals("");    
    }
}
