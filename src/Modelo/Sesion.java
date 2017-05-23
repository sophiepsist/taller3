/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author invitado
 */
public class Sesion {
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

    public String getTiempoDeConexion() {
        return tiempoDeConexion;
    }

    public void setTiempoDeConexion(String tiempoDeConexion) {
        this.tiempoDeConexion = tiempoDeConexion;
    }
    
    
    
}
