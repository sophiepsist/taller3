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
    String mensaje2 = "";
        do{
            try{
                //Lee El objeto que ha sido enviado por el cliente
                mensaje = (String[]) entrada.readObject();
                mensaje2 = mensaje[0];
                switch (mensaje2)
                {
                    case "agregarLibros": 
                        File aux = new File(mensaje[11]);
                        File aux2 = new File(mensaje[12]);
                        String[] respuestaAg = new String[1];
                        this.biblioteca.agregarLibros(Integer.parseInt(mensaje[1]), (String) mensaje[2], Integer.parseInt(mensaje[3]), (String) mensaje[4], Boolean.valueOf(mensaje[5]), (String) mensaje[6], (String) mensaje[7], (String) mensaje[8], (String) mensaje[9], (String) mensaje[10], aux , aux2, (String) mensaje[13]);
                        respuestaAg[0] = "Se ha agregado el libro exitosamente";
                        enviarDatos(respuestaAg);
                        break;
                    case "eliminarLibros": 
                        String[] respuestaEl = new String[1];
                        this.biblioteca.eliminarLibros((String)mensaje[1]);
                        respuestaEl[0] = "Libro eliminado exitosamente";
                        enviarDatos(respuestaEl);
                        break;                    
                    case "consultarInfoLibros": 
                        enviarDatos(this.biblioteca.consultarInfoLibros((String) mensaje[1]));
                        break;
                    case "cargarInfoLibro": 
                        enviarDatos(this.biblioteca.cargarInfoLibro((String) mensaje[1]));
                        break;
                    case "modificarLibro": 
                        File aux3 = new File(mensaje[11]);
                        File aux4 = new File(mensaje[12]);
                        String[] respuestaMod = new String[1];
                        this.biblioteca.modificarLibro(Integer.parseInt(mensaje[1]), (String) mensaje[2], Integer.parseInt(mensaje[3]), (String) mensaje[4], Boolean.valueOf(mensaje[5]), (String) mensaje[6], (String) mensaje[7], (String) mensaje[8], (String) mensaje[9], (String) mensaje[10], aux3 , aux4, (String) mensaje[13]);
                        respuestaMod[0] = "Libro modificado exitosamente";
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

                //System.out.println("\n" + mensaje[0]);
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
                e.printStackTrace();
            }catch (MyException e){
                String[] exception = new String[1];
                exception[0] = e.toString();
                enviarDatos(exception);
            }
        } while (mensaje[0]!="Salir");
    }
    
    public void enviarDatos(String[] mensaje){
        try
        {
            salida.writeObject(mensaje);
            // Vacia el puerto 
            salida.flush();
            System.out.println("El cliente envia el mensaje al servidor");
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
