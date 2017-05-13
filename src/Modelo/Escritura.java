/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.io.*;

/**
 *
 * @author invitado
 */
public class Escritura {
    
    public Escritura(){        
    }
    /**-----------------------------------------------------------------------**
     * Escribe cada libro en un archivo txt con el ISBN como nombre
     */ 
    public void serializarLibro(Libro libro) throws IOException{        
        File dirProyecto = new File(System.getProperty("user.dir"));
        File file = new File(dirProyecto + "/InfoLibros" + "/" + libro.getIsbn() + ".txt");        
        ObjectOutputStream escritor= new ObjectOutputStream(new FileOutputStream(file, false));            
        escritor.writeObject(libro);
        escritor.close();
    }  
    
}
