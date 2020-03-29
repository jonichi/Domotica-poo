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
public class Foco extends Dispositivo{
    
    public Foco(String marca, String modelo){ //
		super(marca, modelo);
	}

	public String getInfo(){
		String info = "Dispositivo: " + getId() + 
			";Marca: " + getMarca() + 
			";Modelo: " + getModelo() +
			";Estado: " + getEstado() ;
		return info;
	}
}