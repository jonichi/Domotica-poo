/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controiador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Casa;
import vista.AgregarDisp;
import vista.domotica;

/**
 *
 * @author ciber
 */
public class controladorD implements ActionListener {
    AgregarDisp dialogoD;
    private Casa casa;
    public controladorD (AgregarDisp dialogoD,Casa casa){
       this.dialogoD = dialogoD;
       this.casa= casa;
       this.dialogoD.boxA.addActionListener(this);
       this.dialogoD.agregar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==dialogoD.boxA){
            dialogoD.cargarHabitaciones(casa.getArea(dialogoD.boxA.getSelectedItem().toString()).getHNames());
        }
        if(e.getSource()==dialogoD.agregar){
            dialogoD.setVisible(false);
            
        }
        
    }
    
}
