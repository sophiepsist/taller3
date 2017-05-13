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
    String[] mensaje = null;   
        do{
            try{
                //Lee El objeto que ha sido enviado por el cliente
                mensaje = (String[]) entrada.readObject();
                System.out.println(mensaje);
                switch ((String)mensaje[0])
                {
                    case "agregarLibros": 
                        File aux = new File(mensaje[11]);
                        File aux2 = new File(mensaje[12]);
                        String[] respuestaAg = new String[1];
                        biblioteca.agregarLibros(Integer.parseInt(mensaje[1]), (String) mensaje[2], Integer.parseInt(mensaje[3]), (String) mensaje[4], Boolean.valueOf(mensaje[5]), (String) mensaje[6], (String) mensaje[7], (String) mensaje[8], (String) mensaje[9], (String) mensaje[10], aux , aux2, (String) mensaje[13]);
                        respuestaAg[0] = "Se ha agregado el libro exitosamente";
                        enviarDatos(respuestaAg);
                        break;
                    case "eliminarLibros": 
                        String[] respuestaEl = new String[1];
                        biblioteca.eliminarLibros((String)mensaje[1]);
                        respuestaEl[0] = "Libro eliminado exitosamente";
                        enviarDatos(respuestaEl);
                        break;                    
                    case "consultarInfoLibros": 
                        enviarDatos(biblioteca.consultarInfoLibros((String) mensaje[1]));
                        break;
                    case "cargarInfoLibro": 
                        enviarDatos(biblioteca.cargarInfoLibro((String) mensaje[1]));
                        break;
                    case "modificarLibro": 
                        File aux3 = new File(mensaje[11]);
                        File aux4 = new File(mensaje[12]);
                        String[] respuestaMod = new String[1];
                        biblioteca.modificarLibro(Integer.parseInt(mensaje[1]), (String) mensaje[2], Integer.parseInt(mensaje[3]), (String) mensaje[4], Boolean.valueOf(mensaje[5]), (String) mensaje[6], (String) mensaje[7], (String) mensaje[8], (String) mensaje[9], (String) mensaje[10], aux3 , aux4, (String) mensaje[13]);
                        respuestaMod[0] = "Libro modificado exitosamente";
                        enviarDatos(respuestaMod);
                        break;
                    case "refrescarLibros":
                        enviarDatos(biblioteca.refrescarLibros());
                        break;
                    case "refrescarLibrosAcademicos":
                        enviarDatos(biblioteca.refrescarLibrosAcademicos());
                        break;
                    case "refrescarLibrosClasicos":
                        enviarDatos(biblioteca.refrescarLibrosClasicos());
                        break;
                    case "refrescarLibrosJuveniles":
                        enviarDatos(biblioteca.refrescarLibrosJuveniles());
                        break;
                    case "refrescarLibrosRomance":
                        enviarDatos(biblioteca.refrescarLibrosRomance());
                        break;
                    case "refrescarLibrosSuspenso":
                        enviarDatos(biblioteca.refrescarLibrosSuspenso());
                        break;
                    case "refrescarLibrosFilosofia":
                        enviarDatos(biblioteca.refrescarLibrosFilosofia());
                        break;
                    case "refrescarLibrosOtros":
                        enviarDatos(biblioteca.refrescarLibrosOtros());
                        break;
                    case "refrescarPeriodoDeOferta":
                        enviarDatos(biblioteca.refrescarPeriodosOferta());
                        break;                   
                    case "Salir":
                        cerrarConexion();
                    default: 
                        procesarConexion();
                }

                System.out.println("\n" + mensaje);
                mensaje = null;
            }catch(ClassNotFoundException e){
                String[] exception = new String[1];
                exception[0] = "Error asigando el tipo de variable\n" + e.toString();
                enviarDatos(exception);
            }catch (IOException e){
                String[] exception = new String[1];
                exception[0] = "Error con los flujos de datos\n" +e.toString();
                enviarDatos(exception);
            }catch(ArrayIndexOutOfBoundsException e){
                String[] exception = new String[1];
                exception[0] = "Falla en el orden de envio de los datos\n" + e.toString();
                enviarDatos(exception);
            }catch (MyException e){
                String[] exception = new String[1];
                exception[0] = e.toString();
                enviarDatos(exception);
            }
        } while (mensaje[0]!="Salir");
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
