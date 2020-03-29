/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domotica;

import controiador.Controlador;
import modelo.AC;
import modelo.AdminCasa;
import modelo.AdminDisp;
import modelo.AdminUsuarios;
import modelo.Area;
import modelo.Casa;
import modelo.Foco;
import modelo.Habitacion;
import modelo.TV;
import modelo.Usuario;
import vista.domotica;

/**
 *
 * @author ciber
 */
public class Domotica {
    
    public static void main(String[] args) {
    Casa casa = new Casa("prueba");
    AdminCasa adminCasa = new AdminCasa();
    domotica vista = new domotica();
    AdminUsuarios adminUsuario = new AdminUsuarios();
    AdminDisp adminDisp = new AdminDisp();
    Controlador ctr = new Controlador(casa,vista,adminCasa,adminDisp,adminUsuario);
    adminCasa.agregarArea(casa, "planta alta");
    
    adminCasa.agregarHabitacion(casa,"planta alta", "recamara");
        
    
    TV tvSala = new TV ("samsung","huawei");
    Foco focoSala = new Foco("S/N","S/N");
    adminDisp.agregarDisposp(casa,"planta alta","recamara",tvSala);
    
   
    
    adminUsuario.añadirUsuario("residente", "usuario");
    Usuario usuario=adminUsuario.getUsuario(1);
    
    usuario.apagarArea(casa,casa.getArea("planta alta").getId());
    }
    
}
