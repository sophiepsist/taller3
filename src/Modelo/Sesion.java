/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author invitado
 */
public class Sesion implements Serializable{
    private String horaInicial;
    private String horaFinal;
    private String fecha;
    private String tiempoDeConexion;
    
    public Sesion(String horaInicial, String horaFinal, String fecha){
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.fecha = fecha;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void tiempoDeConexion() {
        String[] aux1 = horaInicial.split(":");
        String[] aux2 = horaFinal.split(":");
        String horas = Integer.toString(Integer.parseInt(aux2[0].toString()) - Integer.parseInt(aux1[0].toString()));
        String minutos = Integer.toString(Integer.parseInt(aux2[1].toString()) - Integer.parseInt(aux1[1].toString()));
        String segundos = Integer.toString(Integer.parseInt(aux2[2].toString()) - Integer.parseInt(aux1[2].toString()));
        String tiempoDeConexion = horas + ":" + minutos + ":" + segundos;
        this.tiempoDeConexion = tiempoDeConexion;
    }

    public void setTiempoDeConexion(String tiempoDeConexion) {
        this.tiempoDeConexion = tiempoDeConexion;
    }
    
    public String getInforme(){
        return "Fecha: " + fecha + "\nHora inicial: " + horaInicial + "\nHora final: " 
                + horaFinal + "\nTiempo de conexion: " + tiempoDeConexion;
    }
    
    
    
}
