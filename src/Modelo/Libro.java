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
public class Libro implements Serializable{
    private int numPaginas;
    private String titulo;
    private int precio;
    private String categoria;
    private boolean bestSeller;
    private String rangoEdades;
    private String isbn;
    private String calificacion;
    private String resumen;
    private String oferta;
    private File nombreArchivo;
    private File caratula;
    private String autor;
    
    //-------------------------MÉTODO CONSTRUCTOR-------------------------------

    public Libro(int numPaginas, String titulo, int precio, String categoria, boolean bestSeller, String rangoEdades, String isbn, String calificacion, String resumen, String oferta, File nombreArchivo, File caratula, String autor) {
        this.numPaginas = numPaginas;
        this.titulo = titulo;
        this.precio = precio;
        this.categoria = categoria;
        this.bestSeller = bestSeller;
        this.rangoEdades = rangoEdades;
        this.isbn = isbn;
        this.calificacion = calificacion;
        this.resumen = resumen;
        this.oferta = oferta;
        this.nombreArchivo = nombreArchivo;
        this.caratula = caratula;
        this.autor = autor;
    }   
    
    //----------------------------MÉTODOS GET-----------------------------------
    
    public int getNumPaginas() {
        return numPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isBestSeller() {
        return bestSeller;
    }

    public String getRangoEdades() {
        return rangoEdades;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public String getResumen() {
        return resumen;
    }

    public String getOferta() {
        return oferta;
    }   

    public File getNombreArchivo() {
        return nombreArchivo;
    }

    public File getCaratula() {
        return caratula;
    }   

    public String getAutor() {
        return autor;
    } 
    
    
    //----------------------------MÉTODOS SET-----------------------------------

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setBestSeller(boolean bestSeller) {
        this.bestSeller = bestSeller;
    }

    public void setRangoEdades(String rangoEdades) {
        this.rangoEdades = rangoEdades;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public void setOferta(String oferta) {
        this.oferta = oferta;
    }    

    public void setNombreArchivo(File nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void setCaratula(File caratula) {
        this.caratula = caratula;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }    
    
    
    
    public String infoLibro(){ 
        String info;
        info = "\nISBN: " + isbn + "\nTítulo: " + titulo + "\nAutor: " + autor + "\nCategoría: " + categoria + "\nCalificación: " + calificacion
                + "\nNúmero de páginas: " + numPaginas + "\nRango de edades: " + rangoEdades + "\nPeriodo de oferta asociado: " + oferta +
                "\nPrecio: " + precio;
         
        if(bestSeller){
             info += "\nLibro BestSeller";
        }        
        info += "\nResumen:\n" + resumen;
        return info;
    }    
}
