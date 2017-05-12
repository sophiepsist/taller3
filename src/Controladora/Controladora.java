/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;
import Modelo.*;
import Vista.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author invitado
 */
public class Controladora {
    private Biblioteca objBiblioteca;
    
    public Controladora(){
        this.objBiblioteca= new Biblioteca();
    }
    
      public String[] refrescarPeriodosOferta(){
          return objBiblioteca.refrescarPeriodosOferta();
      }
      
      public String[] refrescarLibros(){
          return objBiblioteca.refrescarLibros();
      }
      
    public String agregarLibros(int numPaginas, String titulo, int precio, String categoria, boolean bestSeller, String rangoEdades, 
                              String isbn, String calificacion, String resumen, String oferta, File nombreArchivo, File caratula, String autor){
        try {
            objBiblioteca.agregarLibros(numPaginas, titulo, precio, categoria, bestSeller, rangoEdades, isbn, calificacion, resumen, oferta, nombreArchivo, caratula, autor);
            return "Libro agregado correctamente";
            } 
        catch (MyException ex) {
            return ex.getMessage();
            }
      }
    
    public String eliminarLibros(String isbn){
        try {
            objBiblioteca.eliminarLibros(isbn);
            return "Libro eliminado correctamente"; 
        } catch (MyException ex) {
            return ex.getMessage();
        }
    }
    
    public String consultarInfoLibros(String isbn){
        try {
            return objBiblioteca.consultarInfoLibros(isbn);
        } catch (MyException ex) {
            return ex.getMessage();
        }
        
    }
    
    public String cargarInfoLibro(String isbn){
        try {
            String msn = "";
            String[] aux;
            aux = objBiblioteca.cargarInfoLibro(isbn);
            for(int i=0; i <= aux.length ; i++){
                msn += aux[i] + "\n";
            }
            return msn;
        } catch (MyException ex) {
            return ex.getMessage();
        }
    }
    
    public String modificarLibro(int numPaginas, String titulo, int precio, String categoria, boolean bestSeller, String rangoEdades, 
                                  String isbn, String calificacion, String resumen, String oferta, File nombreArchivo, File caratula, String autor) { 
        try{
                objBiblioteca.modificarLibro(numPaginas, titulo, precio, categoria, bestSeller, rangoEdades, isbn, calificacion, resumen, oferta, nombreArchivo, caratula, autor);
                return "Libro modificado correctamente";
        }catch (MyException ex){
            return ex.getMessage();
        }
    }  
    
    public String consultarCategoriaAcademico(){
        String[] aux;
        String mensaje = "";
        try{
            aux = objBiblioteca.consultarCategoriaAcademico();
            for(int i = 0; i <= aux.length; i++){
               mensaje += aux[i] + "\n"; 
            }
        return mensaje;
        }catch(NullPointerException ex){
            return "Null Pointer Exception en consultarCategoriaAcademico";
        }
    }
    public String consultarCategoriaClasicos(){
        String[] aux;
        String mensaje = "";
        try{
            aux = objBiblioteca.consultarCategoriaClasicos();
            for(int i = 0; i <= aux.length; i++){
               mensaje += aux[i] + "\n"; 
            }
        return mensaje;
        }catch(NullPointerException ex){
            return "Null Pointer Exception en consultarCategoriaClasicos";
        }
    } 
    
    public String consultarCategoriaSuspenso(){
        String[] aux;
        String mensaje = "";
        try{
            aux = objBiblioteca.consultarCategoriaSuspenso();
            for(int i = 0; i <= aux.length; i++){
               mensaje += aux[i] + "\n"; 
            }
        return mensaje;
        }catch(NullPointerException ex){
            return "Null Pointer Exception en consultarCategoriaSuspenso";
        }
    }    

    public String consultarCategoriaRomance(){
        String[] aux;
        String mensaje = "";
        try{
            aux = objBiblioteca.consultarCategoriaRomance();
            for(int i = 0; i <= aux.length; i++){
               mensaje += aux[i] + "\n"; 
            }
        return mensaje;
        }catch(NullPointerException ex){
            return "Null Pointer Exception en consultarCategoriaRomance";
        }
    } 
    public String consultarCategoriaJuveniles(){
        String[] aux;
        String mensaje = "";
        try{
            aux = objBiblioteca.consultarCategoriaJuveniles();
            for(int i = 0; i <= aux.length; i++){
               mensaje += aux[i] + "\n"; 
            }
        return mensaje;
        }catch(NullPointerException ex){
            return "Null Pointer Exception en consultarCategoriaJuveniles";
        }
    } 
    
    public String consultarCategoriaFilosofia(){
        String[] aux;
        String mensaje = "";
        try{
            aux = objBiblioteca.consultarCategoriaFilosofia();
            for(int i = 0; i <= aux.length; i++){
               mensaje += aux[i] + "\n"; 
            }
        return mensaje;
        }catch(NullPointerException ex){
            return "Null Pointer Exception en consultarCategoriaFilosofia";
        }
    } 

    public String consultarCategoriaOtros(){
        String[] aux;
        String mensaje = "";
        try{
            aux = objBiblioteca.consultarCategoriaOtros();
            for(int i = 0; i <= aux.length; i++){
               mensaje += aux[i] + "\n"; 
            }
        return mensaje;
        }catch(NullPointerException ex){
            return "Null Pointer Exception en consultarCategoriaOtros";
        }
    }     
    public String AgregarLibrosAutomaticamente(){
        try{
        objBiblioteca.agregarLibrosAutomaticamente();
            return "Libros agregados con Exito";
        }catch(NullPointerException ex){
            return "Error 01 Controladora AgregarLibros automaticamente";
        }
    }
    public String clasificarLibrosCategoria(){
        try{
            objBiblioteca.clasificarLibrosCategoria();
            return "Libros clasificados con exito";
        }catch(NullPointerException ex){
            return "Error Controladora Clasificar Libros Categoria";
        }
    }
    
}
