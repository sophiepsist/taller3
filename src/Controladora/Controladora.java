/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Cliente.*;
/**
 *
 * @author invitado
 */
public class Controladora {
    private Cliente cliente;
    
    public Controladora(){
        }
    
        public String[] conectar(String[] mensaje){
            String[] msj = null;            
            cliente.enviarDatos(mensaje);
            msj = cliente.procesarConexion();
            return msj;
        }
    }

