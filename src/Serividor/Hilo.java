/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serividor;

import Modelo.Biblioteca;
import Modelo.MyException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
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
    Biblioteca biblioteca;

    public Hilo(Socket conexion)
    {
        try{
            this.cliente = conexion;
            this.salida = new ObjectOutputStream(cliente.getOutputStream());
            this.salida.flush();
            this.entrada = new ObjectInputStream(cliente.getInputStream());
            this.biblioteca = new Biblioteca();
            }
        catch(IOException e)
            {
                System.out.println("IOException en Hilo.java");
            }

    }
    public void procesarConexion(){
    ArrayList mensaje = null;   
        do{
            try{
                //Lee El objeto que ha sido enviado por el cliente
                mensaje = (ArrayList) entrada.readObject();

                switch ((String)mensaje.get(0))
                {
                    case "agregarLibros": 
                        biblioteca.agregarLibros((int) mensaje.get(1), (String) mensaje.get(2), (int) mensaje.get(3), (String) mensaje.get(4), (boolean) mensaje.get(5), (String) mensaje.get(6), (String) mensaje.get(7), (String) mensaje.get(8), (String) mensaje.get(9), (String) mensaje.get(10), (String) mensaje.get(11), (String) mensaje.get(12), (String) mensaje.get(13));
                        break;
                    case "eliminarLibros": 
                        biblioteca.eliminarLibros((String)mensaje.get(1));
                        break;                    
                    case "consultarInfoLibros": 
                        enviarDatos(biblioteca.consultarInfoLibros((String) mensaje.get(1)));
                        break;
                    case "cargarInfoLibro": 
                        enviarDatos(biblioteca.cargarInfoLibro((String) mensaje.get(1)));
                        break;
                    case "modificarLibro": 
                        biblioteca.modificarLibro((int) mensaje.get(1), (String) mensaje.get(2), (int) mensaje.get(3), (String) mensaje.get(4), (boolean) mensaje.get(5), (String) mensaje.get(6), (String) mensaje.get(7), (String) mensaje.get(8), (String) mensaje.get(9), (String) mensaje.get(10), (String) mensaje.get(11), (String) mensaje.get(12), (String) mensaje.get(13));
                        break;
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
            }catch(MyException e){
                System.out.println(e.getMessage());
            }
        } while (mensaje!=null);
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
