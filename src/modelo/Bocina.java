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
public class Bocina extends Dispositivo{
private int volumen; // Nivel de volumen de TV

	public Bocina(String marca, String modelo){ //
		super(marca, modelo);
	}

	public void volumeUp(){
		volumen++;
	}

	public void volumeDown(){
		volumen--;
	}

	public String getInfo(){
		String info = "Dispositivo: " + getId() + 
			";Marca: " + getMarca() + 
			";Modelo: " + getModelo() +
			";Estado: " + getEstado() +
			";Volumen: " + volumen;
		return info;
	}
}