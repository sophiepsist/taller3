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
import java.time.LocalDateTime;
//import javafx.util.converter.LocalDateTimeStringConverter;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author invitado
 */

        
public class HiloServidor extends Thread{
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private Biblioteca biblioteca;
    private Socket cliente;
    private UsuarioAdministrador UAL;
    private UsuarioLector UL;
    private String fecha;
    private String horaInicial;
    private String horaFinal;
    private Sesion sesion;
    public HiloServidor(Socket conexion, Biblioteca biblio)
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
    String mensaje2;
        do{
            try{
                //Lee El objeto que ha sido enviado por el cliente
                mensaje = (ArrayList) entrada.readObject();
                mensaje2 = (String) mensaje.get(0);
                System.out.println(mensaje2);
                switch (mensaje2)
                {
                    case "agregarLibros":                        
                        this.biblioteca.agregarLibros((int) mensaje.get(1), (String) mensaje.get(2),
                                (int) mensaje.get(3), (String) mensaje.get(4), (boolean) mensaje.get(5),
                                (String) mensaje.get(6), (String) mensaje.get(7), (int) mensaje.get(8),
                                (String) mensaje.get(9), (String) mensaje.get(10), (ArrayList) mensaje.get(11) ,
                                (ImageIcon)  mensaje.get(12), (String) mensaje.get(13));
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
                        this.biblioteca.modificarLibro((int) mensaje.get(1), (String) mensaje.get(2), 
                                (int) mensaje.get(3), (String) mensaje.get(4), (boolean) mensaje.get(5), 
                                (String) mensaje.get(6), (String) mensaje.get(7), (String) mensaje.get(8), 
                                (ArrayList)mensaje.get(9), (ImageIcon)mensaje.get(10), (String)mensaje.get(11));
                        ArrayList respuestaMod = new ArrayList(1);
                        respuestaMod.add("Libro modificado exitosamente");
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
                    case "refrescarLibrosOferta":
                        enviarDatos(this.biblioteca.refrescarLibrosOferta());
                         break;
                    case "refrescarLibrosSinOferta":
                        enviarDatos(this.biblioteca.refrescarLibrosSinOferta());
                         break;
                    case "refrescarPeriodoDeOferta":
                        System.out.println("hola estoy en el case");
                        enviarDatos(biblioteca.refrescarPeriodosOferta());
                        break;  
                    case "consultarPeriodoOferta":
                        enviarDatos(this.biblioteca.consultarPeriodoOferta((String) mensaje.get(1)));
                         break;
                    case "Salir":
                        this.cerrarConexion();
                        break;
                    case "agregarUAL":
                        ArrayList mensajeAgUAL = new ArrayList(1);
                        biblioteca.agregarUAL((String)mensaje.get(1), (String)mensaje.get(2), (String)mensaje.get(3), (String)mensaje.get(4), (String)mensaje.get(5), (String)mensaje.get(6), (boolean)mensaje.get(7));
                        mensajeAgUAL.add("Usuario Administrador Agregado Correctamente");
                        enviarDatos(mensajeAgUAL);
                        break;
                    case "agregarUL":    
                        ArrayList mensajeAgUL = new ArrayList(1);
                        biblioteca.agregarUL((String)mensaje.get(1), (String)mensaje.get(2), (String)mensaje.get(3), (String)mensaje.get(4), (int)mensaje.get(5), (String)mensaje.get(6), (String)mensaje.get(7), (String)mensaje.get(8), (int)mensaje.get(9));
                        mensajeAgUL.add("Usuario Lector Agregado Correctamente");
                        enviarDatos(mensajeAgUL);
                        break;
                    case "modificarUL":    
                        ArrayList mensajeModUL = new ArrayList(1);
                        biblioteca.modificarUL((String)mensaje.get(1),(String)mensaje.get(2), (String)mensaje.get(3), (String)mensaje.get(4), (String)mensaje.get(5),
                                                (int) mensaje.get(6), (String)mensaje.get(7), (String)mensaje.get(8), (String)mensaje.get(9));
                        mensajeModUL.add("Usuario Lector Modificado Correctamente");
                        enviarDatos(mensajeModUL);
                        break;
                    case "loginUsuarioAdministrador":
                        ArrayList mensajeLoginUl = new ArrayList(1);
                        this.UAL = biblioteca.verificarLoginUAL((String)mensaje.get(1), (String)mensaje.get(2));
                        mensajeLoginUl.add("todo ok");
                        enviarDatos(mensajeLoginUl);
                        LocalDateTime timeUAL = LocalDateTime.now();
                        fecha = Integer.toString(timeUAL.getMonthValue()) + Integer.toString(timeUAL.getYear())+ Integer.toString(timeUAL.getDayOfMonth());
                        this.horaInicial = Integer.toString(timeUAL.getHour()) + ":" + Integer.toString(timeUAL.getMinute()) + ":" + Integer.toString(timeUAL.getSecond());
                        break; 
                    case "loginUsuarioLector":
                        ArrayList mensajeLoginUAL = new ArrayList(1);
                        this.UL = biblioteca.verificarLoginUL((String)mensaje.get(1), (String)mensaje.get(2));
                        mensajeLoginUAL.add("todo ok");
                        enviarDatos(mensajeLoginUAL);
                        LocalDateTime timeUL = LocalDateTime.now();
                        fecha = Integer.toString(timeUL.getMonthValue()) + Integer.toString(timeUL.getYear())+ Integer.toString(timeUL.getDayOfMonth());
                        this.horaInicial = Integer.toString(timeUL.getHour()) + ":" + Integer.toString(timeUL.getMinute()) + ":" + Integer.toString(timeUL.getSecond());
                        break;
                    case "comprarlibrosUL":
                        ArrayList msj = new ArrayList(1);
                        msj.add(UL.comprarLibro((Libro)biblioteca.getLibros().get((String) mensaje.get(1)))); 
                        enviarDatos(msj);
                        break;
                    case "recargar":
                        biblioteca.recargar(UL.getEmail(),(int) mensaje.get(1));
                        break;
                    case "consultarUL":
                        enviarDatos(biblioteca.consultarUL((String) mensaje.get(1)));
                        break;
                    case "consultarUAL":
                        enviarDatos(biblioteca.consultarUAL((String) mensaje.get(1)));
                        break;
                    case "getPaginas":
                        enviarDatos(biblioteca.getArrayPaginasLibro((String)mensaje.get(1)));
                        break;   
                    case "refrescarLibrosComprados":
                        enviarDatos(this.UL.refrescarLibrosComprados());
                        break;
                    case "consultarLibrosComprados":
                        enviarDatos(this.UL.consultarLibrosComprados((String)mensaje.get(1)));
                        break;
                    case "crearPeriodosOferta":
                        ArrayList mensajeCrearPeriodoOferta = new ArrayList(1);
                        biblioteca.crearPeriodosOferta((String)mensaje.get(1),(String)mensaje.get(2),(int)mensaje.get(3),(ArrayList)mensaje.get(4));
                        System.out.println("periodo de oferta creado");
                        mensajeCrearPeriodoOferta.add("Periodo de oferta creado");
                        enviarDatos(mensajeCrearPeriodoOferta);
                        break;
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
            if(UL != null){
                LocalDateTime time = LocalDateTime.now();
                this.horaFinal = Integer.toString(time.getHour()) + ":" + Integer.toString(time.getMinute()) + ":" + Integer.toString(time.getSecond());
                this.sesion = new Sesion(horaInicial, horaFinal, fecha);
                UL.agregarSesion(sesion);
            }else{
                if(UAL != null){
                    LocalDateTime time = LocalDateTime.now();
                    this.horaFinal = Integer.toString(time.getHour()) + ":" + Integer.toString(time.getMinute()) + ":" + Integer.toString(time.getSecond());
                    this.sesion = new Sesion(horaInicial, horaFinal, fecha);
                    UAL.agregarSesion(sesion);
                }else{cerrarConexion();}
            }
            System.out.println("\n Error al escribir el Objeto, Cliente Desconectado");
            cerrarConexion();
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
