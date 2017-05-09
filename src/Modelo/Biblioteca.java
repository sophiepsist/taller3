/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.io.File;
import java.util.*;


/**
 *
 * @author invitado
 */
public class Biblioteca {
    private HashMap libros;
    private HashMap clientes;
    private HashMap administradores;  
    private HashMap periodosOferta;    
    private HashMap librosAcademicos;
    private HashMap librosClasicos;
    private HashMap librosSuspenso;
    private HashMap librosRomance;
    private HashMap librosJuveniles;
    private HashMap librosFilosofia;
    private HashMap librosOtros;
    
    //---------------------------MÉTODO CONSTRUCTOR-----------------------------
    
    public Biblioteca(){
        this.clientes = new HashMap();
        this.libros = new HashMap();
        this.administradores = new HashMap();
        this.periodosOferta = new HashMap();
        this.librosAcademicos = new HashMap();
        this.librosClasicos = new HashMap();
        this.librosSuspenso = new HashMap();
        this.librosRomance = new HashMap();
        this.librosJuveniles = new HashMap();
        this.librosFilosofia = new HashMap();
        this.librosOtros = new HashMap();
    }

   //----------------------------MÉTODOS GET------------------------------------

    public HashMap getLibros() {
        return libros;
    }

    public HashMap getClientes() {
        return clientes;
    }

    public HashMap getAdministradores() {
        return administradores;
    }

    public HashMap getPeriodosOferta() {
        return periodosOferta;
    }   

    public HashMap getLibrosAcademicos() {
        return librosAcademicos;
    }

    public HashMap getLibrosClasicos() {
        return librosClasicos;
    }

    public HashMap getLibrosSuspenso() {
        return librosSuspenso;
    }

    public HashMap getLibrosRomance() {
        return librosRomance;
    }

    public HashMap getLibrosJuveniles() {
        return librosJuveniles;
    }

    public HashMap getLibrosFilosofia() {
        return librosFilosofia;
    }

    public HashMap getLibrosOtros() {
        return librosOtros;
    }    
    
    //--------------------------MÉTODOS SET-------------------------------------    

    public void setLibros(HashMap libros) {
        this.libros = libros;
    }

    public void setClientes(HashMap clientes) {
        this.clientes = clientes;
    }

    public void setAdministradores(HashMap librosOferta) {
        this.administradores = librosOferta;
    }

    public void setPeriodosOferta(HashMap periodosOferta) {
        this.periodosOferta = periodosOferta;
    }    

    public void setLibrosAcademicos(HashMap librosAcademicos) {
        this.librosAcademicos = librosAcademicos;
    }

    public void setLibrosClasicos(HashMap librosClasicos) {
        this.librosClasicos = librosClasicos;
    }

    public void setLibrosSuspenso(HashMap librosSuspenso) {
        this.librosSuspenso = librosSuspenso;
    }

    public void setLibrosRomance(HashMap librosRomance) {
        this.librosRomance = librosRomance;
    }

    public void setLibrosJuveniles(HashMap librosJuveniles) {
        this.librosJuveniles = librosJuveniles;
    }

    public void setLibrosFilosofia(HashMap librosFilosofia) {
        this.librosFilosofia = librosFilosofia;
    }

    public void setLibrosOtros(HashMap librosOtros) {
        this.librosOtros = librosOtros;
    }
        
    //---------------------REFRESCAR COMPONENTES INTERFAZ-----------------------
    
    public String[] refrescarPeriodosOferta(){
        String[] periodos = new String[periodosOferta.size()];
        Iterator it = periodosOferta.values().iterator();
        for(int i=0; i<periodosOferta.size(); i++){
            Oferta oferta = (Oferta)it.next();
            periodos[i] = oferta.getFechaInicial() + " - " + oferta.getFechaFinal();            
        }
        return periodos;
    }
    
    public String[] refrescarLibros(){
        String[] books = new String[libros.size()];
        Iterator it = libros.values().iterator();
        for(int i=0; i<libros.size(); i++){
            Libro libro = (Libro)it.next();
            books[i] = libro.getTitulo();
        }
        return books;
    }
    
    //-------------------------GESTIÓN DE LIBROS--------------------------------
    
    //-----------------------AGREGAR LIBROS MANUALMENTE-------------------------    
    
    public void agregarLibros(int numPaginas, String titulo, int precio, String categoria, boolean bestSeller, String rangoEdades, 
                              String isbn, String calificacion, String resumen, String oferta, String nombreArchivo, String caratula, String autor) throws MyException{
        if(libros.containsKey(isbn)){
            throw new MyException("Ya se ha agregado un libro con ese ISBN");
        }else{       
            Libro libro = new Libro(numPaginas, titulo, precio, categoria, bestSeller, rangoEdades, isbn, calificacion, resumen, oferta, nombreArchivo, caratula, autor);
            libros.put(isbn, libro);   
        }
    }
    
    //-----------------------------ELIMINAR LIBROS------------------------------
    
    public void eliminarLibros(String isbn) throws MyException{
        if(libros.remove(isbn)==null){
            throw new MyException("No existe un libro con ese ISBN en la biblioteca");
        }else{
            throw new MyException("Libro eliminado exitosamente");
        }
    }
    
    //-----------------------------CONSULTAR LIBROS-----------------------------
    
    public String consultarInfoLibros(String isbn) throws MyException{
        if(libros.containsKey(isbn)){
            Libro libro = (Libro)libros.get(isbn);
            return libro.infoLibro();
        }else{
            throw new MyException("El libro no se encuentra en la biblioteca");
        }
    }
    
    //-----------------------------MODIFICAR LIBROS-----------------------------
    
    public String[] cargarInfoLibro(String isbn) throws MyException{
        if(libros.containsKey(isbn)){
            Libro libro = (Libro)libros.get(isbn);
            String[] datos = new String[12];
            datos[0]= libro.getIsbn();
            datos[1]=libro.getTitulo();
            datos[2]=libro.getAutor();
            datos[3]=libro.getCategoria();
            datos[4]=libro.getCalificacion();
            datos[5]=Integer.toString(libro.getNumPaginas());
            datos[6]=libro.getRangoEdades();
            datos[7]=libro.getOferta();
            if(libro.isBestSeller()){
                datos[8]="BS";                
            }else{
                datos[8]="NBS";
            }
            datos[9]=libro.getResumen();
            datos[10]=libro.getNombreArchivo();
            datos[11]=libro.getCaratula();
            return datos;
        }else{
            throw new MyException("El libro no se encuentra en la biblioteca");
        }
    }
    
    public void modificarLibro(int numPaginas, String titulo, int precio, String categoria, boolean bestSeller, String rangoEdades, 
                              String isbn, String calificacion, String resumen, String oferta, String nombreArchivo, String caratula, String autor) throws MyException{
        if(libros.containsKey(isbn)){
            Libro libro = (Libro)libros.get(isbn);
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setCategoria(categoria);
            libro.setCalificacion(calificacion);
            libro.setNumPaginas(numPaginas);
            libro.setRangoEdades(rangoEdades);
            libro.setOferta(oferta);
            libro.setBestSeller(bestSeller);
            libro.setResumen(resumen);
            libro.setNombreArchivo(nombreArchivo);
            libro.setCaratula(caratula);
        }else{
            throw new MyException("El libro no se encuentra en la biblioteca");
        }
    }
    
    //------------------------CONSULTAR POR CATEGORÍA---------------------------
    
    public void clasificarLibrosCategoria(){
        Iterator it = libros.values().iterator();
        for(int i=0; i<libros.size(); i++){
            Libro libro = (Libro)it.next();
            String categoria = libro.getCategoria();
            switch(categoria){
                case "Académico":
                    librosAcademicos.put(libro.getIsbn(), libro);
                    break;
                case "Clásico":
                    librosClasicos.put(libro.getIsbn(), libro);
                    break;
                case "Suspenso":
                    librosSuspenso.put(libro.getIsbn(), libro);
                    break;
                case "Romance":
                    librosRomance.put(libro.getIsbn(), libro);
                    break;
                case "Juveniles":
                    librosJuveniles.put(libro.getIsbn(), libro);
                    break;
                case "Filosofía":
                    librosFilosofia.put(libro.getIsbn(), libro);
                    break;  
                case "Otro":
                    librosOtros.put(libro.getIsbn(), libro);
                    break;
            } 
        }
    }
    
        public String[] consultarCategoriaAcademico(){
        String[] books = new String[librosAcademicos.size()];
        Iterator it = librosAcademicos.values().iterator();
        for(int i=0; i<librosAcademicos.size(); i++){
            Libro libro = (Libro)it.next();
            books[i]=libro.getTitulo();
        }
        return books;
    }
    
    
    public String[] consultarCategoriaClasicos(){
        String[] books = new String[librosClasicos.size()];
        Iterator it = librosClasicos.values().iterator();
        for(int i=0; i<librosClasicos.size(); i++){
            Libro libro = (Libro)it.next();
            books[i]=libro.getTitulo();
        }
        return books;
    }
    
    
    public String[] consultarCategoriaSuspenso(){
        String[] books = new String[librosSuspenso.size()];
        Iterator it = librosSuspenso.values().iterator();
        for(int i=0; i<librosSuspenso.size(); i++){
            Libro libro = (Libro)it.next();
            books[i]=libro.getTitulo();
        }
        return books;
    }
    
    public String[] consultarCategoriaRomance(){
        String[] books = new String[librosRomance.size()];
        Iterator it = librosRomance.values().iterator();
        for(int i=0; i<librosRomance.size(); i++){
            Libro libro = (Libro)it.next();
            books[i]=libro.getTitulo();
        }
        return books;
    }
    
    public String[] consultarCategoriaJuveniles(){
        String[] books = new String[librosJuveniles.size()];
        Iterator it = librosJuveniles.values().iterator();
        for(int i=0; i<librosJuveniles.size(); i++){
            Libro libro = (Libro)it.next();
            books[i]=libro.getTitulo();
        }
        return books;
    }
    
    public String[] consultarCategoriaFilosofia(){
        String[] books = new String[librosFilosofia.size()];
        Iterator it = librosFilosofia.values().iterator();
        for(int i=0; i<librosFilosofia.size(); i++){
            Libro libro = (Libro)it.next();
            books[i]=libro.getTitulo();
        }
        return books;
    }
    
    
    public String[] consultarCategoriaOtros(){
        String[] books = new String[librosOtros.size()];
        Iterator it = librosOtros.values().iterator();
        for(int i=0; i<librosOtros.size(); i++){
            Libro libro = (Libro)it.next();
            books[i]=libro.getTitulo();
        }
        return books;
    }
   
}
    
    
    

