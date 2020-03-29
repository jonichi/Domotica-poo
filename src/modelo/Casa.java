/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ciber
 */
public class Casa {
    
 private String nombreCasa;
    private static int houseId;
    private int id;
    private HashMap<Integer,Area> areas = new HashMap<>();
    private HashMap<Integer,Usuario> usuarios = new HashMap<>();

    public Casa(String houseName){
        houseId++;
    	this.nombreCasa=houseName;
        id = houseId;
    }

    public void setName(String areaName){
    	this.nombreCasa=areaName;
    }

    public String getName(){
    	return nombreCasa;
    }

    public Area getArea(int areaId){
        return areas.get(areaId);
    }
    public Area getArea(String areaName){
        Set<Integer> keys = areas.keySet();
         for(Integer key:keys){
             if(areaName.equals(getArea(key).getAreaName())){
                 return getArea(key);
             }
            
        }
     return null;
    }

    public int getId(){
    	return id;
    }

    public void addArea(Area area){
    	areas.put(area.getId(), area);
    }

    public boolean removeArea(int areaId){
    	if(areas.get(areaId) != null){
            areas.remove(areaId);
            return true;
        }else{
            return false;
        }
    }
     public void addUsuario(Usuario usuario){
    	usuarios.put(usuario.getId(), usuario);
    }
    public void apagar(){
       Set<Integer> keys = areas.keySet();
         for(Integer key:keys){
            getArea(key).apagar();
        }
        System.out.println("casa apagada");
    }
    public void encender(){
        Set<Integer> keys = areas.keySet();
         for(Integer key:keys){
            getArea(key).encender();
        }
         System.out.println("casa encendida");
    }
}