/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.HashMap;

/**
 *
 * @author ciber
 */
public class AdminCasa {
    public static int total_areas;
    
    
    public void agregarArea(Casa casa,String areaName){
        Area area= new Area(areaName);
        casa.addArea(area);
        total_areas++;
    }
    public void agregarHabitacion(Casa casa,String areaName,String habitacionName){
        Habitacion habitacion = new Habitacion(habitacionName);
        casa.getArea(areaName).addHabitacion(habitacion);
      
       
    }
    public boolean removerArea(Casa casa,int areaId){
        return casa.removeArea(areaId);
    }
    public boolean removerHabitacion(Casa casa,int areaId,int habitacionId){
        return casa.getArea(areaId).removeHabitacion(habitacionId);
    }
    
}
