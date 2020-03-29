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
public class AC extends Dispositivo{

	private int temperatura = 16; //temperatura del clima;

	//Constructor define marca y modelo del AC
	public AC(String marca, String modelo){ //
		super(marca, modelo);
	}

	public int getTemperatura(){
		return temperatura;
	}

	//Baja temperatura
	public void coolDown(){
		if(temperatura>16){
			temperatura--;
		}
	}
	//Sube temperatura
	public void SubirTemperatura(){
		if(temperatura<30){
			temperatura++;
		}
	}

	//Despliega informacion del AC
	public String getInfo(){
		String info = "Dispositivo: " + getId() + 
			";Marca: " + getMarca() + 
			";Modelo: " + getModelo() +
			";Estado: " + getEstado() +
			";Temperatura: " + getTemperatura() + ";";
		return info;
	}
}