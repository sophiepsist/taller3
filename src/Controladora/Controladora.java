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
        this.cliente = new Cliente(27650);
        }
    
        public String[] conectar(String[] mensaje){
            String[] msj;          
            cliente.enviarDatos(mensaje);
            msj = cliente.procesarConexion();
            try{
                System.out.println(msj[0]);
            }catch(ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
            return msj;
        }
    }

