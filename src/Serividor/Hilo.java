/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serividor;

import Controladora.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.*;

/**
 *
 * @author invitado
 */

        
public class Hilo extends Thread{
    ObjectOutputStream salida;
    ObjectInputStream entrada;
    Socket cliente;
    Controladora control;

    public Hilo(Socket conexion)
    {
        try{
            this.cliente = conexion;
            this.salida = new ObjectOutputStream(cliente.getOutputStream());
            this.salida.flush();
            this.entrada = new ObjectInputStream(cliente.getInputStream());
            this.control = new Controladora();
            }
        catch(IOException e)
            {
                System.out.println("IOException en Hilo.java");
            }

    }
    public synchronized void procesarConexion(){
    ArrayList mensaje = null;   
        do{
            try{
                //Lee El objeto que ha sido enviado por el cliente
                mensaje = (ArrayList) entrada.readObject();
                System.out.println(mensaje);
                switch ((String)mensaje.get(0))
                {
                    case "agregarLibros": 
                        control.agregarLibros((int) mensaje.get(1), (String) mensaje.get(2), (int) mensaje.get(3), (String) mensaje.get(4), (boolean) mensaje.get(5), (String) mensaje.get(6), (String) mensaje.get(7), (String) mensaje.get(8), (String) mensaje.get(9), (String) mensaje.get(10), (File) mensaje.get(11), (File) mensaje.get(12), (String) mensaje.get(13));
                        break;
                    case "eliminarLibros": 
                        control.eliminarLibros((String)mensaje.get(1));
                        break;                    
                    case "consultarInfoLibros": 
                        enviarDatos(control.consultarInfoLibros((String) mensaje.get(1)));
                        break;
                    case "cargarInfoLibro": 
                        enviarDatos(control.cargarInfoLibro((String) mensaje.get(1)));
                        break;
                    case "modificarLibro": 
                        control.modificarLibro((int) mensaje.get(1), (String) mensaje.get(2), (int) mensaje.get(3), (String) mensaje.get(4), (boolean) mensaje.get(5), (String) mensaje.get(6), (String) mensaje.get(7), (String) mensaje.get(8), (String) mensaje.get(9), (String) mensaje.get(10), (File) mensaje.get(11), (File) mensaje.get(12), (String) mensaje.get(13));
                        break;
                    case "Salir":
                        cerrarConexion();
                    default: 
                        procesarConexion();
                }

                System.out.println("\n" + mensaje);
                mensaje = null;
            }catch(ClassNotFoundException e){
                System.out.println("\n Se recibio un tipo de objeto desconocido");
            }catch (IOException e){
                System.out.println("\n Error en el flujo de datos");
            }catch (NullPointerException e){
                //e.printStackTrace();
                System.out.println("\n No se envio nada al servidor, no se ha podido generar una respuesta");
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("\n Error al enviar archivos... archivos de mas... mal ordenados... archivos de menos");
            }
        } while (mensaje.get(0)!="Salir");
    }
    
    public void enviarDatos(Object mensaje){
        try
        {
            salida.writeObject(mensaje);
            // Vacia el puerto 
            salida.flush();
            System.out.println(mensaje);
        }
        catch (IOException e)
        {
            System.out.println("\n Error al escribir el Objeto");
        }
    }    
    
    public void cerrarConexion(){
        System.out.println("\n Cerrando Conexion");
        
        try{
            salida.close();
            entrada.close();
            cliente.close();
        }
        catch(IOException e)
        {
            System.out.println("IOException en cerrar conexion en Hilo.java");
        }
    }    
    
    @Override
    public void run ()
    {
        while (true)
        {
            procesarConexion();
        }   
    }    

}
