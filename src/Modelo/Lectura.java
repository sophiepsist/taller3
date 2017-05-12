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
        File file = new File(dirProyecto + "\\InfoLibros");                    
        File[] bookFiles = file.listFiles();
        for(File bookFile : bookFiles){
            ObjectInputStream lector = new ObjectInputStream(new FileInputStream(bookFile));
            Libro libro = (Libro)lector.readObject();
            librosBase.put(libro.getIsbn(), libro);           
        }       
        return librosBase;          
    }
    
     /**-----------------------------------------------------------------------**
     * Revisa los archivos del directorio para eliminar el txt del libro que ha 
     * sido eliminado de la biblioteca 
     */     
    public void eliminarLibroSerializado(String isbn) throws IOException, ClassNotFoundException, MyException{        
        File dirProyecto = new File(System.getProperty("user.dir"));
        File file = new File(dirProyecto + "\\InfoLibros");                    
        File[] bookFiles = file.listFiles();
        for(File bookFile : bookFiles){
            if(bookFile.getName().equals(isbn + ".txt")){
                  bookFile.delete();
                  break;
            }
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
