/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author invitado
 */
public class Oferta implements Serializable{
    private String fechaInicial;
    private String fechaFinal;
    private int porcentajeDescuento;    
    
    //-------------------------MÉTODO CONSTRUCTOR-------------------------------

    public Oferta(String fechaInicial, String fechaFinal, int porcentajeDescuento) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.porcentajeDescuento = porcentajeDescuento;       
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
    
    public String getKey(){
        return fechaInicial + " - " + fechaFinal + " - " + porcentajeDescuento;
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
}
