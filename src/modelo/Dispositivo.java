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
public abstract class Dispositivo{
    
        private String marca; 
	private String modelo; 
	private int dispositivoId;
	private static int count_dispositivos;
	private String estado; 

	public Dispositivo(String marca, String modelo){ //
		count_dispositivos++;
		this.marca = marca;
		this.modelo = modelo;
		this.dispositivoId = count_dispositivos;
		estado = "Off";
	}
	public void turnOff(){
		estado = "On";
	}

	public void turnOn(){
		estado = "Off";
	}

	public int getId(){
		return dispositivoId;
	}

	
	public String getMarca(){
		return marca;
	}

	public String getModelo(){
		return modelo;
	}
	
	public String getEstado(){
		return estado;
	}

	public abstract String getInfo();

}