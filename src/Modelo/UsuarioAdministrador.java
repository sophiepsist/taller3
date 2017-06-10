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
public class UsuarioAdministrador implements Serializable {
    private String nombreCompleto;
    private String cargo;
    private String celular;
    private String email;
    private String nombreUsuario;
    private String contrasenia;
    private boolean autorizado;
    private ArrayList <Sesion> sesionesIniciadas;

    public UsuarioAdministrador(String nombreCompleto, String cargo, String celular, String email, String nombreUsuario, String contrasenia, boolean autorizado) {
        this.nombreCompleto = nombreCompleto;
        this.cargo = cargo;
        this.celular = celular;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.autorizado = autorizado;
        this.sesionesIniciadas = new ArrayList();
        
    }
    
    public UsuarioAdministrador(){}
    
    //---------------------------- MÉTODOS GET----------------------------------
    
 
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCargo() {
        return cargo;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public boolean isAutorizado() {
        return autorizado;
    }
    
//-------------------------------- MÉTODOS SET----------------------------------
    

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }
 
    public void agregarSesion(Sesion sesion){
        sesionesIniciadas.add(sesion);
    }

    
}
