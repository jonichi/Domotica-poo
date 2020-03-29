/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controiador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JOptionPane;
import modelo.AC;
import modelo.AdminCasa;
import modelo.AdminDisp;
import modelo.AdminUsuarios;
import modelo.Bocina;
import modelo.Casa;
import modelo.Dispositivo;
import modelo.Foco;
import modelo.TV;
import modelo.Error;
import modelo.Usuario;
import vista.AgregarArea;
import vista.AgregarDisp;
import vista.AgregarHabitacion;
import vista.AgregarUsuario;
import vista.domotica;

/**
 *
 * @author ciber
 */
public class Controlador implements ActionListener {
    private Casa casa;
    private domotica vista;
    private AdminCasa adminCasa;
    private AdminDisp adminDisp;
    private AdminUsuarios adminUsuarios;
    private String areasName[]= new String[0];
    private String habName[]= new String[0];
    AgregarDisp dialogoD = new AgregarDisp(vista,true);
    private Error error = new Error();

     public Controlador(Casa casa, domotica vista,AdminCasa adminCasa,AdminDisp adminDisp,AdminUsuarios adminUsuarios) {
        this.casa=casa;
        this.vista= vista;
        this.adminCasa=adminCasa;
        this.adminDisp=adminDisp;
        this.adminUsuarios=adminUsuarios;
        this.vista.offArea.addActionListener(this);
        this.vista.boxArea.addActionListener(this);
        this.vista.boxDispositivo.addActionListener(this);
        this.vista.boxHabitacion.addActionListener(this);
        this.vista.menuArea.addActionListener(this);
        this.vista.menuDispositivo.addActionListener(this);
        this.vista.menuHabitacion.addActionListener(this);
        this.vista.menuUsuario.addActionListener(this);
        this.vista.offCasa.addActionListener(this);
        this.vista.offDispositivo.addActionListener(this);
        this.vista.onArea.addActionListener(this);
        this.vista.offHabitacion.addActionListener(this);
        this.vista.onCasa.addActionListener(this);
        this.vista.onDispositivo.addActionListener(this);
        this.vista.onHabitacion.addActionListener(this);
        this.dialogoD.boxA.addActionListener(this);
        vista.setVisible(true);
        
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==vista.menuArea ){
        AgregarArea dialogo = new AgregarArea(vista,true);
        dialogo.setVisible(true);
        if(error.comprobar(dialogo.area)){
        int i = areasName.length+1;
        String[] newArray = new String[i];  
        System.arraycopy(areasName, 0, newArray, 0, areasName.length);  
        newArray[i-1]=dialogo.area;
        areasName = newArray;
        vista.cargarAreas(areasName);
        adminCasa.agregarArea(casa,dialogo.area);
        }else{
            JOptionPane.showMessageDialog(null,"area no agregada ingrese los datos completos");
        }
    }
    if(e.getSource()==vista.menuHabitacion){
        AgregarHabitacion dialogoH = new AgregarHabitacion(vista,true);
        dialogoH.cargarAreas(areasName);
        dialogoH.setVisible(true);
        if(error.comprobar(dialogoH.text.getText())){
        adminCasa.agregarHabitacion(casa,dialogoH.boxAreas.getSelectedItem().toString(), dialogoH.text.getText());
        }else{
        JOptionPane.showMessageDialog(null,"habitacion no agregada ingrese los datos completos");

        }
    }
    if(e.getSource()==vista.boxArea){
      vista.cargarHabitaciones(casa.getArea(vista.boxArea.getSelectedItem().toString()).getHNames());
    }
    if(e.getSource()== vista.menuDispositivo){
     dialogoD.cargarAreas(areasName);
     controladorD cont = new controladorD(dialogoD,casa);
     dialogoD.setVisible(true);
     String model, marca;
     model=dialogoD.modelo.getText();
     marca=dialogoD.marca.getText();
     if(error.comprobar(marca)&&error.comprobar(model)&&error.comprobar(dialogoD.boxh.getItemCount())){
     Dispositivo disp = null;
     if(dialogoD.boxd.getSelectedItem().toString().equals("AC")){
         disp = new AC(marca,model);
     }else if(dialogoD.boxd.getSelectedItem().toString().equals("TV")){
        disp = new TV(marca,model);
     }else if(dialogoD.boxd.getSelectedItem().toString().equals("Bocina")){
          disp = new Bocina (marca,model);
     }else if(dialogoD.boxd.getSelectedItem().toString().equals("Foco")){
         disp = new Foco(marca,model);
     }
   
    adminDisp.agregarDisposp(casa,dialogoD.boxA.getSelectedItem().toString(),dialogoD.boxh.getSelectedItem().toString(),disp);
     }else{
       JOptionPane.showMessageDialog(null,"Dispositivo no agregado seleccione los datos completos");

     }
    }
    if(e.getSource()==vista.boxHabitacion){
     vista.cargarDispositivos(casa.getArea(vista.boxArea.getSelectedItem().toString()).getHabitacion(vista.boxHabitacion.getSelectedItem().toString()).getNames());
    }
    if(e.getSource()==vista.offCasa){
        casa.apagar();
        JOptionPane.showMessageDialog(null,"Dispositivos de casa apagados");
    }
    if(e.getSource()==vista.onCasa){
        casa.encender();
        JOptionPane.showMessageDialog(null,"Dispositivos de casa encendidos");
    }
    if(e.getSource()==vista.offArea){
        if(error.comprobar(vista.boxArea.getItemCount())){
        casa.getArea(vista.boxArea.getSelectedItem().toString()).apagar();
        JOptionPane.showMessageDialog(null,"Dispositivos del area apagados");
        }else{
            JOptionPane.showMessageDialog(null,"selecione o agregue una area antes");
        }
    }
    if(e.getSource()==vista.onArea){
         if(error.comprobar(vista.boxArea.getItemCount())){
        casa.getArea(vista.boxArea.getSelectedItem().toString()).encender();
        JOptionPane.showMessageDialog(null,"Dispositivos del area encendidos");
        }else{
            JOptionPane.showMessageDialog(null,"selecione o agregue una area antes");
        }
    }
    if(e.getSource()==vista.offHabitacion){
        if(error.comprobar(vista.boxHabitacion.getItemCount())){
           casa.getArea(vista.boxArea.getSelectedItem().toString()).getHabitacion(vista.boxHabitacion.getSelectedItem().toString()).apagar();
           JOptionPane.showMessageDialog(null,"Dispositivos de la habiatacion apagados");
        }else{
            JOptionPane.showMessageDialog(null,"selecione o agregue una area y una habitacion antes");
        }
    }
    if(e.getSource()==vista.onHabitacion){
        
        if(error.comprobar(vista.boxHabitacion.getItemCount())){
           casa.getArea(vista.boxArea.getSelectedItem().toString()).getHabitacion(vista.boxHabitacion.getSelectedItem().toString()).encender();
           JOptionPane.showMessageDialog(null,"Dispositivos de la habitacion encendidos");
        }else{
            JOptionPane.showMessageDialog(null,"selecione o agregue una area y una habitacion antes");
        }
    }
    if(e.getSource()==vista.offDispositivo){
        if(error.comprobar(vista.boxDispositivo.getItemCount())){
          casa.getArea(vista.boxArea.getSelectedItem().toString()).getHabitacion(vista.boxHabitacion.getSelectedItem().toString()).getDispositivo(vista.boxDispositivo.getSelectedItem().toString()).turnOff();
          JOptionPane.showMessageDialog(null,"dispositivo apagado");
        }else{
            JOptionPane.showMessageDialog(null,"selecione o agregue un area , una habitacion y un dispositivo antes");
        }
    }
    if(e.getSource()==vista.onDispositivo){
         if(error.comprobar(vista.boxDispositivo.getItemCount())){
          casa.getArea(vista.boxArea.getSelectedItem().toString()).getHabitacion(vista.boxHabitacion.getSelectedItem().toString()).getDispositivo(vista.boxDispositivo.getSelectedItem().toString()).turnOn();
                    JOptionPane.showMessageDialog(null,"dispositivo apagado");

        }else{
            JOptionPane.showMessageDialog(null,"selecione o agregue un area , una habitacion y un dispositivo antes");
        }
    }
    if(e.getSource()==vista.menuUsuario){
       AgregarUsuario dialogoU = new AgregarUsuario(vista,true);
       dialogoU.setVisible(true);
       if(error.comprobar(dialogoU.nombre.getText())){
           adminUsuarios.añadirUsuario(dialogoU.tipo.getSelectedItem().toString(),dialogoU.nombre.getText());
           
       }else{
           JOptionPane.showMessageDialog(null,"Usuario no agregado ingrese un nombre ");
       }
       
       
    }
    }
    
    
    }
    
    

