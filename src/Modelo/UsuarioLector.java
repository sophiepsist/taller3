/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.*;
/**
 *
 * @author invitado
 */
public class UsuarioLector {
    private String nombreCompleto;
    private String celular;
    private String diaNacimiento;
    private String mesNacimiento;
    private String anioNacimiento;
    private int edad;
    private String email;
    private String nombreUsuario;
    private String contrasenia;
    private ArrayList librosul;
    private int saldo;
    private HashMap <String, Libro> librosLeidos;

    public UsuarioLector(String nombreCompleto, String celular, String diaNacimiento, String mesNacimiento, int edad, String email, String nombreUsuario, String contrasenia, int saldo) {
        this.nombreCompleto = nombreCompleto;
        this.celular = celular;
        this.diaNacimiento = diaNacimiento;
        this.mesNacimiento = mesNacimiento;
        this.edad = edad;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.librosLeidos = new HashMap();
        this.saldo = saldo;
    }

    
    // ------------------------------------------MÉTODOS GET--------------------------------------------------------------

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCelular() {
        return celular;
    }

    public String getDiaNacimiento() {
        return diaNacimiento;
    }

    public String getMesNacimiento() {
        return mesNacimiento;
    }

    public String getAnioNacimiento() {
        return anioNacimiento;
    }

    public int getEdad() {
        return edad;
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

    public HashMap<String, Libro> getLibrosLeidos() {
        return librosLeidos;
    }
    
    public ArrayList getLibrosul(){
        return librosul;
    }
    
    
    
    // ------------------------------------------MÉTODOS SET--------------------------------------------------------------    
    

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setDiaNacimiento(String diaNacimiento) {
        this.diaNacimiento = diaNacimiento;
    }

    public void setMesNacimiento(String mesNacimiento) {
        this.mesNacimiento = mesNacimiento;
    }

    public void setAnioNacimiento(String anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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

    public void setLibrosLeidos(HashMap<String, Libro> librosLeidos) {
        this.librosLeidos = librosLeidos;
    }
     public void setLibrosul(ArrayList libros){
         this.librosul = libros;
     }
    
    
    
}
