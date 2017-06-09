/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.mail.MessagingException;

/**
 *
 * @author invitado
 */
public class HiloWatcher extends Thread{
    private Biblioteca biblioteca;
    
    public HiloWatcher(Biblioteca biblioteca){     
        this.biblioteca = biblioteca;
    }  
    
    @Override
    public void run(){
        do{
            try {
                biblioteca.terminarPeriodoOferta();
                biblioteca.verificarCumpleaniosUsuario();
                sleep(24*3600000);              
            } catch (InterruptedException ex) {
                System.out.println("Error en la ejecución del HiloWatcher encargado de revisar la duración de los periodos de oferta y cumpleaños");
            } catch (MessagingException ex){
                System.out.println("Messaging Exception en HiloWatcher... Direccion de E-mail no válida");
            }
        }while(isAlive()); 
    }
      
    
}
