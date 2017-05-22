/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *Cuando	se	crea	el	usuario,	se	debe	inicializar	un	saldo	dependiendo	del	
dinero	entregado	por	el	UL.	El	UL	en	el	 futuro	podrá	realizar	 todas	las	
recargas	 que	 él	 quiera,	 afectando	 así	 su	 saldo.	 De	 estas	 recargas	 es	
importante	conocer:	consecutivo	único	por	recarga,	la	 fecha,	la	hora,	el	
valor
 * @author invitado
 */
public class Recargas {
    private String idRecarga;
    private String fecha;
    private String hora;
    private int valor;
    
    public Recargas(String idRecarga, String fecha, int valor){
        this.idRecarga = idRecarga;
        this.fecha = fecha;
        this.hora = hora;
        this.valor = valor;
    }
    
    // ----------------------------MÉTODOS GET----------------------------------
    
    public String getIdRecarga() {
        return idRecarga;
    }    

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }
    
    public int getValor() {
        return valor;
    }
    
    // ----------------------------MÉTODOS SET----------------------------------
    
    public void setHora(String hora) {
        this.hora = hora;
    }    

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public void setIdRecarga(String idRecarga) {
        this.idRecarga = idRecarga;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
