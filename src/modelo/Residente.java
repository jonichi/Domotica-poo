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
public class Residente extends Usuario{
    private String permisos[]= new String [10];
    private int totalPermisos;
    public Residente(String nombre) {
        super(nombre);
    }
    public void añadirPermiso(String permiso){
        permisos[totalPermisos]=permiso;  
    }
    public void elimnarPermiso(String permiso){
        for(int i=0;i<totalPermisos;i++){
            if (permisos[i].equals(permiso)){
                for(int j=i;j<totalPermisos;j++){
                    permisos[j]=permisos[j+1];
                }
            }
        }
    }
    
    
}

