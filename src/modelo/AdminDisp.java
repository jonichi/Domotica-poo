/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ciber
 */
public class AdminDisp {
    private static int total_devices;
    private HashMap<Integer,Dispositivo> dispositivos = new HashMap<>();
    
    public void agregarDisposp(Casa casa,String areaName,String habitacionName,Dispositivo dispositivo){
        casa.getArea(areaName).getHabitacion(habitacionName).addDevice(dispositivo);
        dispositivos.put(dispositivo.getId(), dispositivo);
        total_devices++;
    }
    public void removerDispositivo(Casa casa,int areaId,int habiatacionId,int dispositivoId){
        casa.getArea(areaId).getHabitacion(habiatacionId).removeDispositivo(dispositivoId);
        if(dispositivos.get(dispositivoId) != null){
    		dispositivos.remove(dispositivoId);
                total_devices--;
		}
    }
    public Map getListaDisp(){
        return dispositivos;
    }

    public static int getTotal_devices() {
        return total_devices;
    }
    
    
}
