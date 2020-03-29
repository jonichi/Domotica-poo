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
public class Usuario {
    private String nombre;
    private static int usuarioId;
    private int id;
    
    public Usuario(String nombre){
        usuarioId++;
        this.id=usuarioId;
        
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }
    public void apagarDisp(Casa casa,int areaId,int habiatacionId,int dispositivoId){
        casa.getArea(areaId).getHabitacion(habiatacionId).getDispositivo(dispositivoId).turnOff();
    }
    public void encenderDisp(Casa casa,int areaId,int habiatacionId,int dispositivoId){
        casa.getArea(areaId).getHabitacion(habiatacionId).getDispositivo(dispositivoId).turnOn();
    }
    public void apagarCasa(Casa casa){
        casa.apagar();
    }
    public void encenderCasa(Casa casa){
       casa.encender();
    }
    public void apagarArea(Casa casa,int areaId){
        casa.getArea(areaId).apagar();
    }
    public void encenderArea(Casa casa,int areaId){
        casa.getArea(areaId).encender();
    }
}
