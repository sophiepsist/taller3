/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Cliente.*;
import java.util.*;
/**
 *
 * @author invitado
 */
public class Controladora {
    private Cliente cliente;
    
    public Controladora(){
        this.cliente = new Cliente(27650);
        }
    
        public ArrayList conectar(ArrayList mensaje){
            ArrayList msj = new ArrayList(0);          
            cliente.enviarDatos(mensaje);
            msj = cliente.procesarConexion();
            try{
                System.out.println(msj.get(0));
            }catch(ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
            return msj;
        }        
        
    }

