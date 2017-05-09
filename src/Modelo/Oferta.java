/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.HashMap;

/**
 *
 * @author invitado
 */
public class Oferta {
     private String fechaInicial;
    private String fechaFinal;
    private int porcentajeDescuento;
    private HashMap librosOferta;
    
    //-------------------------MÉTODO CONSTRUCTOR-------------------------------

    public Oferta(String fechaInicial, String fechaFinal, int porcentajeDescuento, HashMap librosOferta) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.porcentajeDescuento = porcentajeDescuento;
        this.librosOferta = librosOferta;
    }

    //-----------------------------MÉTODOS GET----------------------------------

    public String getFechaInicial() {
        return fechaInicial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public HashMap getLibrosOferta() {
        return librosOferta;
    }
    
    //-----------------------------MÉTODOS SET----------------------------------

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public void setPorcentajeDescuento(int porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public void setLibrosOferta(HashMap librosOferta) {
        this.librosOferta = librosOferta;
    }
}
