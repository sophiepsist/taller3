/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.io.*;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;


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
    private double calificacionGlobal;
    private int calificacionPersonal;
    private String resumen;
    private Oferta oferta;
    private ArrayList paginasArray;
    private ImageIcon caratula;
    private String autor;
    private double porcentajeLectura;
    private ArrayList calificaciones;    
    private int paginasLeidas;
    
    //-------------------------MÉTODO CONSTRUCTOR-------------------------------

    public Libro(int numPaginas, String titulo, int precio, String categoria, boolean bestSeller, String rangoEdades, String isbn, int calificacion, String resumen, Oferta oferta, ArrayList paginasArray, ImageIcon caratula, String autor) {
        this.numPaginas = numPaginas;
        this.titulo = titulo;
        this.precio = precio;
        this.categoria = categoria;
        this.bestSeller = bestSeller;
        this.rangoEdades = rangoEdades;
        this.isbn = isbn;
        this.calificacionPersonal = calificacion;
        this.resumen = resumen;
        this.oferta = oferta;
        this.paginasArray = paginasArray;
        this.caratula = caratula;
        this.autor = autor;
        this.calificaciones = new ArrayList();
        this.paginasLeidas = 0;
        this.calificacionGlobal = 0;
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

    public double getCalificacionGlobal() {
        return calificacionGlobal;
    }

    public int getCalificacionPersonal() {
        return calificacionPersonal;
    }

    public String getResumen() {
        return resumen;
    }

    public Oferta getOferta() {
        return oferta;
    }   

    public ArrayList getPaginasArray() {
        return paginasArray;
    }

    public Icon getCaratula() {
        return caratula;
    }   

    public String getAutor() {
        return autor;
    } 

    public double getPorcentajeLectura() {
        return porcentajeLectura;
    }   
    
    public ArrayList getCalificaciones()  {
        return calificaciones;
    }

    public int getPaginasLeidas() {
        return paginasLeidas;
    }    
    
    public double getPrecioConDescuento(int porcentajeDescuento){
        return precio - precio*porcentajeDescuento/100;
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

    public void setCalificacionGlobal(double calificacionGlobal) {
        this.calificacionGlobal = calificacionGlobal;
    }

    public void setCalificacionPersonal(int calificacionPersonal) {
        this.calificacionPersonal = calificacionPersonal;
    }
    
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }    

    public void setPaginasArray(ArrayList paginasArray) {
        this.paginasArray = paginasArray;
    }

    public void setCaratula(ImageIcon caratula) {
        this.caratula = caratula;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }    

    public void setPorcentajeLectura(double porcentajeLectura) {
        this.porcentajeLectura = porcentajeLectura;
    }    
    
    public void setCalificaciones(ArrayList calificaciones){
        this.calificaciones = calificaciones;
    }

    public void setPaginasLeidas(int paginasLeidas) {
        this.paginasLeidas = paginasLeidas;
    }    
    
    //-----------------------------CONSULTAR------------------------------------
    
    public ArrayList infoLibro(){ 
        ArrayList mensaje = new ArrayList(3); 
        String info = "";
        info = "\nISBN: " + isbn + "\nTítulo: " + titulo + "\nAutor: " + autor + "\nCategoría: " + categoria + "\nNúmero de páginas: " + 
                numPaginas + "\nRango de edades: " + rangoEdades +  "\nPrecio: $" + precio;
        
        if(oferta!=null){
            info+= "\nPeriodo de oferta asociado:\n" + oferta.getFechaFinal() + "-" + oferta.getFechaFinal() +
                    " - " + oferta.getPorcentajeDescuento() + "% de descuento\nPrecio con descuento: " +
                    getPrecioConDescuento(oferta.getPorcentajeDescuento());
        }
        
        if(bestSeller){
             info += "\nLibro BestSeller";
        }        
        info += "\nResumen:\n" + resumen;
        mensaje.add(info);
        mensaje.add(caratula);
        Integer integer = (int) Math.round(this.getCalificacionGlobal());
        mensaje.add(integer);
        return mensaje;
    }    
}
