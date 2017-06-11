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
                    case "refrescarBestSellers":
                        enviarDatos(this.biblioteca.refrescarBestSellers());
                        break;
                    case "refrescarPeriodoDeOferta":
                        System.out.println("hola estoy en el case");
                        enviarDatos(biblioteca.refrescarPeriodosOferta());
                        break;  
                    case "consultarPeriodoOferta":
                        enviarDatos(this.biblioteca.consultarPeriodoOferta((String) mensaje.get(1)));
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
                    case "modificarUAL":
                        ArrayList mensajeModUAL = new ArrayList(1);
                        biblioteca.modificarUAL((String)mensaje.get(1),(String)mensaje.get(2), (String)mensaje.get(3), (String)mensaje.get(4), (String)mensaje.get(5),
                                                (boolean)mensaje.get(6), (String) mensaje.get(7), (String)mensaje.get(8));
                        mensajeModUAL.add("Usuario Administrador Modificado Correctamente");
                        enviarDatos(mensajeModUAL);
                        break;
                    case "loginUsuarioAdministrador":
                        ArrayList mensajeLoginUAL = new ArrayList();
                        this.UAL = biblioteca.verificarLoginUAL((String)mensaje.get(1), (String)mensaje.get(2));
                        biblioteca.setActualUAL(UAL);
                        mensajeLoginUAL.add("todo ok");
                        mensajeLoginUAL.add(this.UAL.isAutorizado());
                        enviarDatos(mensajeLoginUAL);
                        LocalDateTime timeUAL = LocalDateTime.now();
                        fecha = Integer.toString(timeUAL.getDayOfMonth()) + "/" + Integer.toString(timeUAL.getMonthValue()) +"/"+ Integer.toString(timeUAL.getYear());
                        this.horaInicial = Integer.toString(timeUAL.getHour()) + ":" + Integer.toString(timeUAL.getMinute()) + ":" + Integer.toString(timeUAL.getSecond());
                        break; 
                    case "loginUsuarioLector":
                        ArrayList mensajeLoginUL = new ArrayList(1);                        
                        this.UL = biblioteca.verificarLoginUL((String)mensaje.get(1), (String)mensaje.get(2));  
                        biblioteca.setActualUL(UL);
                        mensajeLoginUL.add("todo ok");
                        enviarDatos(mensajeLoginUL);
                        LocalDateTime timeUL = LocalDateTime.now();
                        fecha = Integer.toString(timeUL.getDayOfMonth()) + "/" + Integer.toString(timeUL.getMonthValue()) +"/"+ Integer.toString(timeUL.getYear());
                        this.horaInicial = Integer.toString(timeUL.getHour()) + ":" + Integer.toString(timeUL.getMinute()) + ":" + Integer.toString(timeUL.getSecond());
                        break;
                    case "comprarlibrosUL":
                        ArrayList msj = new ArrayList();                        
                        String isbn = (String)mensaje.get(1);                      
                        Libro libroComprar = (Libro)biblioteca.getLibros().get(isbn);   
                        UsuarioLector actualUL = biblioteca.getActualUL();
                        msj.add(actualUL.comprarLibro(libroComprar));                         
                        enviarDatos(msj);
                        break;
                    case "recargar":
                        UsuarioLector actualUL5 = biblioteca.getActualUL();
                        ArrayList respuestaRecarga = new ArrayList();
                        respuestaRecarga.add(biblioteca.recargar(actualUL5.getEmail(),(int) mensaje.get(1)));
                        enviarDatos(respuestaRecarga);
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
                        UsuarioLector actualUL2 = biblioteca.getActualUL();
                        enviarDatos(actualUL2.refrescarLibrosComprados());
                        break;
                    case "consultarLibrosComprados":
                        UsuarioLector actualUL3 = biblioteca.getActualUL();
                        enviarDatos(actualUL3.consultarLibrosComprados((String)mensaje.get(1)));
                        break;
                    case "crearPeriodosOferta":
                        ArrayList mensajeCrearPeriodoOferta = new ArrayList(1);
                        biblioteca.crearPeriodosOferta((String)mensaje.get(1),(String)mensaje.get(2),(int)mensaje.get(3),(ArrayList)mensaje.get(4));
                        mensajeCrearPeriodoOferta.add("Periodo de oferta creado");
                        enviarDatos(mensajeCrearPeriodoOferta);
                        break;
                    case "informeMejoresLibros":
                        enviarDatos(biblioteca.informeTopBooks());
                        break;
                    case "informePorcentajeLectura":
                        enviarDatos(biblioteca.informePorcentajeLectura());
                        break;
                    case "informePeoresLibros":
                        enviarDatos(biblioteca.informeBottomBooks());
                        break;
                    case "informeSesionesUL":
                        enviarDatos(biblioteca.informeSesionesUL((String)mensaje.get(1)));
                        break;
                    case "leer":
                        UsuarioLector actualUL4 = biblioteca.getActualUL();
                        enviarDatos(actualUL4.getLibroLectura((String)mensaje.get(1)));
                        break;           
                    case "refrescarNotas":
                        UsuarioLector actualUL7 = biblioteca.getActualUL();
                        Libro libroLectura = (Libro)actualUL7.getLibrosComprados().get((String)mensaje.get(1));
                        enviarDatos(libroLectura.getNotas());
                        break;   
                    case "recomendarLibros":
                        ArrayList librosRecomendados = new ArrayList();
                        ArrayList respuesta = new ArrayList(1);
                        if(biblioteca.getActualUL()!= null){
                            librosRecomendados = biblioteca.refrescarLibrosRecomendados();
                            enviarDatos(librosRecomendados);
                        }else{
                            respuesta.add("No existe el usuario en la biblioteca");
                            enviarDatos(respuesta);
                        }   
                        break;
                    case "setCambiosLectura":
                        ArrayList respuestaCambios = new ArrayList();
                        UsuarioLector actualUL8 = biblioteca.getActualUL();
                        actualUL8.setCambiosLectura((String)mensaje.get(1),(int)mensaje.get(2), (ArrayList)mensaje.get(3), (ArrayList)mensaje.get(4));
                        respuestaCambios.add("Libro guardado");
                        enviarDatos(respuestaCambios);
                        break;   
                    case "calificarLibro":
                        ArrayList respuestaCalificar = new ArrayList();
                        UsuarioLector actualUL9 = biblioteca.getActualUL();
                        biblioteca.hacerCalificacion((String)mensaje.get(1),(int)mensaje.get(2), actualUL9);
                        respuestaCalificar.add("Calificación hecha");
                        enviarDatos(respuestaCalificar);
                        break;
                        
                }

            }catch(ClassNotFoundException e){
                ArrayList exception = new ArrayList(1);
                exception.add("Error asigando el tipo de variable\n" + e.getMessage());
                enviarDatos(exception);
                System.out.println("Cerrar Conexion dentro del switch Exception ClassNotFoundExcpetion");
            }catch (IOException e){
                ArrayList exception = new ArrayList(1);
                exception.add( "Error con los flujos de datos\n" +e.getMessage());
                enviarDatos(exception);
                cerrarConexion();
                mensaje = new ArrayList();
                System.out.println("Cerrar Conexion dentro del switch Exception IOException");
            }catch(ArrayIndexOutOfBoundsException e){
                ArrayList exception = new ArrayList(1);
                exception.add("Falla en el orden de envio de los datos\n" + e.getMessage());
                enviarDatos(exception);
                System.out.println("Cerrar Conexion dentro del switch Exception ArrayIndexOfBoundException");
            }catch(NoSuchElementException e){
                ArrayList exception = new ArrayList(1);
                exception.add("No hay libros en el TOP\n");
                enviarDatos(exception);
            }catch(ArithmeticException ex){
                ArrayList exception = new ArrayList(1);
                exception.add("No hay libros Leidos\n");
                enviarDatos(exception);
            }catch(NullPointerException ex){
                ArrayList exception = new ArrayList(1);
                exception.add("No se ingresaron datos\n");
                ex.printStackTrace();
                enviarDatos(exception);    
            }catch(IndexOutOfBoundsException e){
                ArrayList exception = new ArrayList(1);
                exception.add("No hay nada abranse\n");
                enviarDatos(exception);
            }catch (MyException e){
                ArrayList exception = new ArrayList(1);
                exception.add(e.toString());
                enviarDatos(exception);
            }
        } while (!mensaje.isEmpty());
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
            UsuarioLector actualUL6 = biblioteca.getActualUL();
            UsuarioAdministrador actualUAL6 = biblioteca.getActualUAL();
            if(actualUL6 != null){
                System.out.println(actualUL6.getEmail());
                LocalDateTime time = LocalDateTime.now();
                this.horaFinal = Integer.toString(time.getHour()) + ":" + Integer.toString(time.getMinute()) + ":" + Integer.toString(time.getSecond());
                Sesion sesion = new Sesion(horaInicial, horaFinal, fecha);
                System.out.println(sesion.getFecha());
                System.out.println(sesion.getHoraInicial());
                System.out.println(sesion.getHoraFinal());
                actualUL6.agregarSesion(sesion);
                biblioteca.serializarUL(actualUL6);
            }else{
                if(actualUAL6 != null){
                    System.out.println(actualUAL6.getEmail());
                    LocalDateTime time = LocalDateTime.now();
                    this.horaFinal = Integer.toString(time.getHour()) + ":" + Integer.toString(time.getMinute()) + ":" + Integer.toString(time.getSecond());
                    Sesion sesion = new Sesion(horaInicial, horaFinal, fecha);
                    actualUAL6.agregarSesion(sesion);
                    biblioteca.serializarUAL(actualUAL6);
                }else{                    
                    System.out.println("cerrar conexion dentro de enviar datos(Dentro del if)");
                    }
            }
            System.out.println("\n Error al escribir el Objeto, Cliente Desconectado");
            System.out.println("Cerrar Conexion dentro de enviar datos");
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
            procesarConexion();
            System.out.println("El estado de conexion del cliente es :"+cliente.isClosed());  
    }    

}
