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
public class AdminUsuarios {
 public int total_Usuarios;
 public HashMap<Integer,Usuario> usuarios = new HashMap<>();
 
 public void añadirUsuario(String tipo,String nombre){
     Usuario usuario;
     if (tipo.equals("administrador")){
         usuario=new Administrador(nombre);
         
     }else if (tipo.equals("residente")){
         usuario=new Residente(nombre);     
     }else{
         usuario=new Invitado(nombre);
     }
     usuarios.put(usuario.getId(),usuario);
     
 }

    public Usuario getUsuario(int usuarioId) {
        return usuarios.get(usuarioId);
    }
 
 
}
