/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.*;
import java.util.HashMap;

/**
 *
 * @author invitado
 */
public class Lectura {
    private HashMap librosBase;
    
    public Lectura(){  
        this.librosBase = new HashMap();
    }
    
    /**-----------------------------------------------------------------------**
     * Hace la carga inicial de los libros que existen en la carpeta "InfoLibros"
     * en el directorio del proyecto y los mete a un HashMap
     */    
    public HashMap cargarLibrosBiblioteca() throws IOException, ClassNotFoundException{        
        File dirProyecto = new File(System.getProperty("user.dir"));
        File[] filesProyecto = dirProyecto.listFiles();
        for(File file : filesProyecto){
            if(file.getName().equals("InfoLibros")){
                File infoLibros = new File(file.getPath());
                File[] bookFiles = infoLibros.listFiles();
                for(File bookFile : bookFiles){
                    ObjectInputStream lector = new ObjectInputStream(new FileInputStream(bookFile));
                    Libro libro = (Libro)lector.readObject();
                    librosBase.put(libro.getIsbn(), libro);
                }
                break;
            } 
        }       
        return librosBase;          
    }
    
     /**-----------------------------------------------------------------------**
     * Revisa los archivos del directorio para eliminar el txt del libro que ha 
     * sido eliminado de la biblioteca 
     */ 
    
    public void eliminarLibroSerializado(String isbn) throws IOException, ClassNotFoundException, MyException{
        File dir = new File(System.getProperty("user.dir"));
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
          for (File child : directoryListing){
              if(child.getName().equals(isbn + ".txt")){
                  child.delete();
                  break;
              }
          }            
        } else {
            throw new MyException("Ocurrió un problema al eliminar el archivo .txt de un libro previamente serializado\nERROR: CLASS LECTURA");     
        }
    }    
    
    /**-----------------------------------------------------------------------**
     * Retorna el libro que el cliente ha pedido leer
     */     
   /* public Libro retornarLibro(String isbn) throws MyException{
        try{
            ObjectInputStream lector = new ObjectInputStream(new FileInputStream(isbn + ".txt"));
            }catch(IOException io){
                throw new MyException("Error de lectura, no se ha encontrado el libro que busca");
            }
        }
    }*/
 
    

}
