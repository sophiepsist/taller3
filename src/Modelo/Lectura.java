/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

/**
 *
 * @author invitado
 */
public class Lectura {
    private HashMap librosBase;
    private HashMap usuariosAdministradores;
    private HashMap usuariosLectores;
    
    public Lectura(){  
        this.librosBase = new HashMap();
        this.usuariosAdministradores = new HashMap();
        this.usuariosLectores = new HashMap();
    }
    
    /**-----------------------------------------------------------------------**
     * Hace la carga inicial de los libros que existen en la carpeta "InfoLibros"
     * en el directorio del proyecto y los mete a un HashMap
     */    
    public HashMap cargarLibrosBiblioteca() throws IOException, ClassNotFoundException{         
        File dirProyecto = new File(System.getProperty("user.dir"));        
        File file = new File(dirProyecto + "/InfoLibros");
                
        Path path = file.toPath();
        DirectoryStream<Path> dirStream = Files.newDirectoryStream(path);
        for(Path entry: dirStream){
            ObjectInputStream lector = new ObjectInputStream(new FileInputStream(entry.toFile()));
            Libro libro = (Libro)lector.readObject();
            librosBase.put(libro.getIsbn(), libro); 
        }        
        
//        WINDOWS        
//        File[] bookFiles = file.listFiles();        
//        System.out.println(bookFiles[0]);
//        for(File bookFile : bookFiles){
//            ObjectInputStream lector = new ObjectInputStream(new FileInputStream(bookFile));
//            Libro libro = (Libro)lector.readObject();
//            librosBase.put(libro.getIsbn(), libro);                   
//        }
        
        return librosBase;          
    }
    
     /**-----------------------------------------------------------------------**
     * Revisa los archivos del directorio para eliminar el txt del libro que ha 
     * sido eliminado de la biblioteca 
     */     
    public void eliminarLibroSerializado(String isbn) throws IOException, ClassNotFoundException{   
        File dirProyecto = new File(System.getProperty("user.dir"));        
        File file = new File(dirProyecto + "/InfoLibros");                
        Path path = file.toPath();
        DirectoryStream<Path> dirStream = Files.newDirectoryStream(path);
        for(Path entry: dirStream){
            File fileToDelete = entry.toFile();
            if(fileToDelete.getName().equals(isbn + ".txt")){
                fileToDelete.delete();
            }
        }        
        
//        File dirProyecto = new File(System.getProperty("user.dir"));
//        File file = new File(dirProyecto + "/InfoLibros");                    
//        File[] bookFiles = file.listFiles();
//        for(File bookFile : bookFiles){
//            if(bookFile.getName().equals(isbn + ".txt")){
//                bookFile.delete();
//            }
//        }   
    }
    
    /**-----------------------------------------------------------------------**
     * Hace la carga inicial de los usuarios administradores que existen en la 
     * carpeta "UAL" en el directorio del proyecto y los mete a un HashMap
     */    
    public HashMap cargarUalBiblioteca() throws IOException, ClassNotFoundException{         
        File dirProyecto = new File(System.getProperty("user.dir"));        
        File file = new File(dirProyecto + "/UAL");
                
        Path path = file.toPath();
        DirectoryStream<Path> dirStream = Files.newDirectoryStream(path);
        for(Path entry: dirStream){
            ObjectInputStream lector = new ObjectInputStream(new FileInputStream(entry.toFile()));
            UsuarioAdministrador  ual = (UsuarioAdministrador)lector.readObject();
            usuariosAdministradores.put(ual.getEmail(), ual);            
        }                
        return usuariosAdministradores;          
    }
    
     /**-----------------------------------------------------------------------**
     * Hace la carga inicial de los usuarios lectores que existen en la 
     * carpeta "UL" en el directorio del proyecto y los mete a un HashMap
     */    
    public HashMap cargarUlBiblioteca() throws IOException, ClassNotFoundException{         
        File dirProyecto = new File(System.getProperty("user.dir"));        
        File file = new File(dirProyecto + "/UL");
                
        Path path = file.toPath();
        DirectoryStream<Path> dirStream = Files.newDirectoryStream(path);
        for(Path entry: dirStream){
            ObjectInputStream lector = new ObjectInputStream(new FileInputStream(entry.toFile()));
            UsuarioLector  ul = (UsuarioLector)lector.readObject();
            usuariosLectores.put(ul.getEmail(), ul);            
        }                
        return usuariosLectores;          
    }
}
