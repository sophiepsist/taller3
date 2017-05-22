/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    /**-----------------------------------------------------------------------**
     * Escribe cada usuario administrador en un archivo txt con el email como nombre
     */ 
    public void serializarUAL(UsuarioAdministrador ual) throws IOException{        
        File dirProyecto = new File(System.getProperty("user.dir"));
        File file = new File(dirProyecto + "/UAL" + "/" + ual.getEmail() + ".txt");        
        ObjectOutputStream escritor= new ObjectOutputStream(new FileOutputStream(file, false));            
        escritor.writeObject(ual);
        escritor.close();
    }  
    
     /**-----------------------------------------------------------------------**
     * Escribe cada usuario lector en un archivo txt con el email como nombre
     */ 
    public void serializarUL(UsuarioLector ul) throws IOException{        
        File dirProyecto = new File(System.getProperty("user.dir"));
        File file = new File(dirProyecto + "/UL" + "/" + ul.getEmail() + ".txt");        
        ObjectOutputStream escritor= new ObjectOutputStream(new FileOutputStream(file, false));            
        escritor.writeObject(ul);
        escritor.close();
    }
    
    /**-----------------------------------------------------------------------**
     * Crea el primer usuario administrador del programa
     */ 

    public void serializarPrimerUAL() {        
        ObjectOutputStream escritor = null;
        try {
            File dirProyecto = new File(System.getProperty("user.dir"));
            UsuarioAdministrador ual = new UsuarioAdministrador("Usuario automático", "Administrador inicial", "3004569016", "vamianpi@gmail.com", "administrador", "vamianpi123", true);
            File file = new File(dirProyecto + "/UAL" + "/vamianpi@gmail.com.txt");
            escritor = new ObjectOutputStream(new FileOutputStream(file, false));
            escritor.writeObject(ual);
            escritor.close();
        } catch (IOException ex) {
            System.out.println("Error en método SerializarPrimerUAL de clase Escritura");
            ex.getMessage();
        } 
    } 
}
