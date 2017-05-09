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
     * Hace la carga inicial de los libros que existen en la biblioteca 
     */    
    public HashMap cargarLibrosBiblioteca() throws IOException, ClassNotFoundException, MyException{          
        File dir = new File(System.getProperty("user.dir"));
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
          for (File child : directoryListing) {
            ObjectInputStream lector = new ObjectInputStream(new FileInputStream(child));
            Libro libro = (Libro)lector.readObject();
            librosBase.put(libro.getIsbn(), libro);
          }
        } else {
            throw new MyException("Ocurrió un problema al cargar los libros de la biblioteca\nERROR: CLASS LECTURA");     
        }
        return librosBase;          
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
