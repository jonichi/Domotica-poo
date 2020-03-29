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
public class TV extends Dispositivo{
   private int volumen = 35;
	private int canal=1; 

	
	public TV(String marca, String modelo){ //
		super(marca, modelo);
	}

	public void setChannel(int channelTv){
		canal = channelTv;
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
			";Channel: " + canal +
			";Volume: " + volumen;
		return info;
	}
} 

