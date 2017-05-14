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
import Modelo.*;


/**
 *
 * @author invitado
 */
public class Servidor {
   private ServerSocket server; 
   private Socket cliente;
   private Biblioteca biblioteca;


    public Servidor(int puerto){
        try{
            this.server = new ServerSocket(puerto);
            System.out.println("se inicia el servidor\n");
            this.cliente  = server.accept();
            System.out.println("cliente recibido o conectado o lo que sea lok\n");
            this.biblioteca = new Biblioteca();
            conectar();
            //this.salida  = new ObjectOutputStream(cliente.getOutputStream());
            //System.out.println("se obtiene el flujo de salida\n");
            //this.entrada = new ObjectInputStream(cliente.getInputStream());
            //System.out.println("se obtiene elflujo de entrada\n");
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error en el flujo del servidor\n");
        }//catch(ClassNotFoundException e){
           // System.out.println("Class not foudn Exception en Servidor");
        //}
    }
    
    public void conectar(){
        Hilo hilo= new Hilo(cliente, biblioteca);
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
        Servidor servidor = new Servidor(27650);  
    }
//           this.objBiblioteca= new Biblioteca();
//    }
//    
//      public String[] refrescarPeriodosOferta(){
//          return objBiblioteca.refrescarPeriodosOferta();
//      }
//      
//      public String[] refrescarLibros(){
//          return objBiblioteca.refrescarLibros();
//      }
//      
//    public String agregarLibros(int numPaginas, String titulo, int precio, String categoria, boolean bestSeller, String rangoEdades, 
//                              String isbn, String calificacion, String resumen, String oferta, File nombreArchivo, File caratula, String autor){
//        try {
//            objBiblioteca.agregarLibros(numPaginas, titulo, precio, categoria, bestSeller, rangoEdades, isbn, calificacion, resumen, oferta, nombreArchivo, caratula, autor);
//            return "Libro agregado correctamente";
//            } 
//        catch (MyException ex) {
//            return ex.getMessage();
//            }
//      }
//    
//    public String eliminarLibros(String isbn){
//        try {
//            objBiblioteca.eliminarLibros(isbn);
//            return "Libro eliminado correctamente"; 
//        } catch (MyException ex) {
//            return ex.getMessage();
//        }
//    }
//    
//    public String consultarInfoLibros(String isbn){
//        try {
//            return objBiblioteca.consultarInfoLibros(isbn);
//        } catch (MyException ex) {
//            return ex.getMessage();
//        }
//        
//    }
//    
//    public String cargarInfoLibro(String isbn){
//        try {
//            String msn = "";
//            String[] aux;
//            aux = objBiblioteca.cargarInfoLibro(isbn);
//            for(int i=0; i <= aux.length ; i++){
//                msn += aux[i] + "\n";
//            }
//            return msn;
//        } catch (MyException ex) {
//            return ex.getMessage();
//        }
//    }
//    
//    public String modificarLibro(int numPaginas, String titulo, int precio, String categoria, boolean bestSeller, String rangoEdades, 
//                                  String isbn, String calificacion, String resumen, String oferta, File nombreArchivo, File caratula, String autor) { 
//        try{
//                objBiblioteca.modificarLibro(numPaginas, titulo, precio, categoria, bestSeller, rangoEdades, isbn, calificacion, resumen, oferta, nombreArchivo, caratula, autor);
//                return "Libro modificado correctamente";
//        }catch (MyException ex){
//            return ex.getMessage();
//        }
//    }  
//    
//    public String consultarCategoriaAcademico(){
//        String[] aux;
//        String mensaje = "";
//        try{
//            aux = objBiblioteca.consultarCategoriaAcademico();
//            for(int i = 0; i <= aux.length; i++){
//               mensaje += aux[i] + "\n"; 
//            }
//        return mensaje;
//        }catch(NullPointerException ex){
//            return "Null Pointer Exception en consultarCategoriaAcademico";
//        }
//    }
//    public String consultarCategoriaClasicos(){
//        String[] aux;
//        String mensaje = "";
//        try{
//            aux = objBiblioteca.consultarCategoriaClasicos();
//            for(int i = 0; i <= aux.length; i++){
//               mensaje += aux[i] + "\n"; 
//            }
//        return mensaje;
//        }catch(NullPointerException ex){
//            return "Null Pointer Exception en consultarCategoriaClasicos";
//        }
//    } 
//    
//    public String consultarCategoriaSuspenso(){
//        String[] aux;
//        String mensaje = "";
//        try{
//            aux = objBiblioteca.consultarCategoriaSuspenso();
//            for(int i = 0; i <= aux.length; i++){
//               mensaje += aux[i] + "\n"; 
//            }
//        return mensaje;
//        }catch(NullPointerException ex){
//            return "Null Pointer Exception en consultarCategoriaSuspenso";
//        }
//    }    
//
//    public String consultarCategoriaRomance(){
//        String[] aux;
//        String mensaje = "";
//        try{
//            aux = objBiblioteca.consultarCategoriaRomance();
//            for(int i = 0; i <= aux.length; i++){
//               mensaje += aux[i] + "\n"; 
//            }
//        return mensaje;
//        }catch(NullPointerException ex){
//            return "Null Pointer Exception en consultarCategoriaRomance";
//        }
//    } 
//    public String consultarCategoriaJuveniles(){
//        String[] aux;
//        String mensaje = "";
//        try{
//            aux = objBiblioteca.consultarCategoriaJuveniles();
//            for(int i = 0; i <= aux.length; i++){
//               mensaje += aux[i] + "\n"; 
//            }
//        return mensaje;
//        }catch(NullPointerException ex){
//            return "Null Pointer Exception en consultarCategoriaJuveniles";
//        }
//    } 
//    
//    public String consultarCategoriaFilosofia(){
//        String[] aux;
//        String mensaje = "";
//        try{
//            aux = objBiblioteca.consultarCategoriaFilosofia();
//            for(int i = 0; i <= aux.length; i++){
//               mensaje += aux[i] + "\n"; 
//            }
//        return mensaje;
//        }catch(NullPointerException ex){
//            return "Null Pointer Exception en consultarCategoriaFilosofia";
//        }
//    } 
//
//    public String consultarCategoriaOtros(){
//        String[] aux;
//        String mensaje = "";
//        try{
//            aux = objBiblioteca.consultarCategoriaOtros();
//            for(int i = 0; i <= aux.length; i++){
//               mensaje += aux[i] + "\n"; 
//            }
//        return mensaje;
//        }catch(NullPointerException ex){
//            return "Null Pointer Exception en consultarCategoriaOtros";
//        }
//    }     
//    public String AgregarLibrosAutomaticamente(){
//        try{
//        objBiblioteca.agregarLibrosAutomaticamente();
//            return "Libros agregados con Exito";
//        }catch(NullPointerException ex){
//            return "Error 01 Controladora AgregarLibros automaticamente";
//        }
//    }
//    public String clasificarLibrosCategoria(){
//        try{
//            objBiblioteca.clasificarLibrosCategoria();
//            return "Libros clasificados con exito";
//        }catch(NullPointerException ex){
//            return "Error Controladora Clasificar Libros Categoria";
//        }
//    }
}