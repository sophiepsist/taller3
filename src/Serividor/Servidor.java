/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serividor;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction.*;
import Controladora.*;


/**
 *
 * @author invitado
 */
public class Servidor {
   ServerSocket server; 
   Socket cliente;
   Controladora control;


    public Servidor(int puerto){
        try{
            this.server = new ServerSocket(puerto);
            System.out.println("se inicia el servidor\n");
            this.cliente  = server.accept();
            System.out.println("cliente recibido o conectado o lo que sea lok\n");
            this.control = new Controladora();
            //biblioteca.
            //lectura.cargarLibrosBiblioteca();
            control.AgregarLibrosAutomaticamente();
            control.clasificarLibrosCategoria();
            conectar();
            //this.salida  = new ObjectOutputStream(cliente.getOutputStream());
            //System.out.println("se obtiene el flujo de salida\n");
            //this.entrada = new ObjectInputStream(cliente.getInputStream());
            //System.out.println("se obtiene elflujo de entrada\n");
        }catch(IOException e){
            System.out.println("Error en el flujo del servidor\n");
        }//catch(ClassNotFoundException e){
           // System.out.println("Class not foudn Exception en Servidor");
        //}
    }
    
    public void conectar(){
        Hilo hilo= new Hilo(cliente);
        hilo.start();
    }
    
//        public void procesarConexion(){
//        String mensaje = null;
//        
//        do{
//            try{
//                //Lee El objeto que ha sido enviado por el cliente
//                mensaje = (String) entrada.readObject();
//                
//                switch (mensaje)
//                {
//                    case "agregarlibro":
//                        
//                }
//                
//                System.out.println("\n" + mensaje);
//                mensaje = null;
//            } catch(ClassNotFoundException e){
//                System.out.println("\n Se recibio un tipo de objeto desconocido");
//            }catch (IOException e){
//                System.out.println("\n Error en el flujo de datos");
//            }catch (NullPointerException e){
//                System.out.println("\n No se envio nada al servidor, no se ha podido generar una respuesta");
//            }
//        } while (mensaje!=null);
//    }
    
//    public void enviarDatos(Object mensaje){
//        try{
//            salida.writeObject(mensaje);
//            // Vacia el puerto 
//            salida.flush();
//            System.out.println(mensaje);
//        }catch (IOException e){
//            System.out.println("\n Error al escribir el Objeto");
//        }
//    }
    
//    public void cerrarConexion(){
//        System.out.println("\n Cerrando Conexion");
//        
//        try{
//            salida.close();
//            entrada.close();
//            cliente.close();
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//    }

    
    public static void main(String[] args){
        String localHost=null;
       try {
           localHost = InetAddress.getLocalHost().getHostAddress();
       } catch (UnknownHostException ex) {
           Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
       }
        System.out.println(localHost);
        Servidor servidor = new Servidor(28795);  
    }
   
}