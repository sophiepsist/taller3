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
import Modelo.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author invitado
 */

        
public class Hilo extends Thread{
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private Biblioteca biblioteca;
    private Socket cliente;

    public Hilo(Socket conexion, Biblioteca biblio)
    {
        try{
            this.cliente = conexion;
            this.salida = new ObjectOutputStream(cliente.getOutputStream());
            this.salida.flush();
            this.entrada = new ObjectInputStream(cliente.getInputStream());
            this.biblioteca = biblio;
            }
        catch(IOException e)
            {
                System.out.println("IOException en Hilo.java");
            }

    }
    public synchronized void procesarConexion(){
    ArrayList mensaje = new ArrayList(0);   
    String mensaje2 = "";
        do{
            try{
                //Lee El objeto que ha sido enviado por el cliente
                mensaje = (ArrayList) entrada.readObject();
                mensaje2 = (String) mensaje.get(0);
                switch (mensaje2)
                {
                    case "agregarLibros":                        
                        this.biblioteca.agregarLibros((int) mensaje.get(1), (String) mensaje.get(2), (int) mensaje.get(3), (String) mensaje.get(4), (boolean) mensaje.get(5), (String) mensaje.get(6), (String) mensaje.get(7), (String) mensaje.get(8), (String) mensaje.get(9), (String) mensaje.get(10), (String) mensaje.get(11) , (ImageIcon)  mensaje.get(12), (String) mensaje.get(13));
                        ArrayList respuestaAg = new ArrayList(1);
                        respuestaAg.add("Se ha agregado el libro exitosamente");
                        enviarDatos(respuestaAg);
                        break;
                    case "eliminarLibros": 
                        this.biblioteca.eliminarLibros((String)mensaje.get(1));      
                        ArrayList respuestaEl = new ArrayList(1);
                        respuestaEl.add("Libro eliminado exitosamente");
                        enviarDatos(respuestaEl);
                        break;                                        
                    case "consultarInfoLibros": 
                        enviarDatos(this.biblioteca.consultarInfoLibros((String)mensaje.get(1)));
                        break;
                    case "cargarInfoLibro": 
                        enviarDatos(this.biblioteca.cargarInfoLibro((String) mensaje.get(1)));
                        break;
                    case "modificarLibro": 
                        this.biblioteca.modificarLibro((int) mensaje.get(1), (String) mensaje.get(2), (int) mensaje.get(3), (String) mensaje.get(4), (boolean) mensaje.get(5), (String) mensaje.get(6), (String) mensaje.get(7), (String) mensaje.get(8), (String) mensaje.get(9), (String) mensaje.get(10), (String) mensaje.get(11) , (ImageIcon)  mensaje.get(12), (String) mensaje.get(13));
                        ArrayList respuestaMod = new ArrayList(1);
                        respuestaMod.add("Libro eliminado exitosamente");
                        enviarDatos(respuestaMod);
                        break;
                    case "refrescarLibros":
                        enviarDatos(this.biblioteca.refrescarLibros());
                        break;
                    case "refrescarLibrosAcademicos":
                        enviarDatos(this.biblioteca.refrescarLibrosAcademicos());
                        break;
                    case "refrescarLibrosClasicos":
                        enviarDatos(this.biblioteca.refrescarLibrosClasicos());
                        break;
                    case "refrescarLibrosJuveniles":
                        enviarDatos(this.biblioteca.refrescarLibrosJuveniles());
                        break;
                    case "refrescarLibrosRomance":
                        enviarDatos(this.biblioteca.refrescarLibrosRomance());
                        break;
                    case "refrescarLibrosSuspenso":
                        enviarDatos(this.biblioteca.refrescarLibrosSuspenso());
                        break;
                    case "refrescarLibrosFilosofia":
                        enviarDatos(this.biblioteca.refrescarLibrosFilosofia());
                        break;
                    case "refrescarLibrosOtros":
                        enviarDatos(this.biblioteca.refrescarLibrosOtros());
                        break;
                    case "refrescarPeriodoDeOferta":
                        System.out.println("hola estoy en el case");
                        enviarDatos(biblioteca.refrescarPeriodosOferta());
                        break;                   
                    case "Salir":
                        this.cerrarConexion();
                }

            }catch(ClassNotFoundException e){
                ArrayList exception = new ArrayList(1);
                exception.add("Error asigando el tipo de variable\n" + e.toString());
                enviarDatos(exception);
            }catch (IOException e){
                ArrayList exception = new ArrayList(1);
                exception.add( "Error con los flujos de datos\n" +e.toString());
                enviarDatos(exception);
            }catch(ArrayIndexOutOfBoundsException e){
                ArrayList exception = new ArrayList(1);
                exception.add("Falla en el orden de envio de los datos\n" + e.toString());
                enviarDatos(exception);
                e.printStackTrace();
            }catch (MyException e){
                ArrayList exception = new ArrayList(1);
                exception.add(e.toString());
                enviarDatos(exception);
            }
        } while (mensaje.get(0)!="Salir");
    }
    
    public void enviarDatos(ArrayList mensaje){
        try
        {
            salida.writeObject(mensaje);
            // Vacia el puerto 
            salida.flush();
            System.out.println("El hilo envia el mensaje al cliente");
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
