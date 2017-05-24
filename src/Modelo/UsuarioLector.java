/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.io.Serializable;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
/**
 *
 * @author invitado
 */
public class UsuarioLector implements Serializable {
    private String nombreCompleto;
    private String celular;
    private String diaNacimiento;
    private String mesNacimiento;
    private String anioNacimiento;
    private int edad;
    private String email;
    private String nombreUsuario;
    private String contrasenia;    
    private int saldo;
    private HashMap <String, Recargas> recargas;
    private HashMap <String, Libro> librosLeidos;
    private HashMap librosComprados;
    private boolean isMyBirthday;
    private int contLibroCumpleanios;
    private ArrayList <Sesion> sesionesIniciadas;

    public UsuarioLector(String nombreCompleto, String celular, String diaNacimiento, String mesNacimiento, int edad, String email, String nombreUsuario, String contrasenia, int saldo) {
        this.nombreCompleto = nombreCompleto;
        this.celular = celular;
        this.diaNacimiento = diaNacimiento;
        this.mesNacimiento = mesNacimiento;
        this.edad = edad;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;        
        this.recargas = new HashMap();
        this.saldo = saldo;
        this.librosComprados = new HashMap();
        this.contLibroCumpleanios = 0;
    }

    
    // ----------------------------MÉTODOS GET----------------------------------

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
    
    public int getSaldo(){
        return saldo;
    }

    public HashMap<String, Recargas> getRecargas() {
        return recargas;
    }

    public HashMap getLibrosComprados() {
        return librosComprados;
    }   

    public boolean isMyBirthdayGetter() {
        return isMyBirthday;
    }   

    public ArrayList<Sesion> getSesionesIniciadas() {
        return sesionesIniciadas;
    }
    
    
    
    // ---------------------------MÉTODOS SET-----------------------------------     

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
    
    public void setSaldo(int saldo){
        this.saldo = saldo;
    }

    public void setRecargas(HashMap<String, Recargas> recargas) {
        this.recargas = recargas;
    }

    public void setLibrosComprados(HashMap librosComprados) {
        this.librosComprados = librosComprados;
    }     

    public void setIsMyBirthday(boolean isMyBirthday) {
        this.isMyBirthday = isMyBirthday;
    }       

    public void setSesionesIniciadas(ArrayList<Sesion> sesionesIniciadas) {
        this.sesionesIniciadas = sesionesIniciadas;
    }

    public void setContLibroCumpleanios(int contLibroCumpleanios) {
        this.contLibroCumpleanios = contLibroCumpleanios;
    }        
    
    //-----------------------INFORMES DE USUARIO--------------------------------
    /**-----------------------------------------------------------------------**
     * Retorna el porcentaje de libros leídos respecto a los libros comprados
     */ 
    
    public double porcentajeLectura(){
        return (librosLeidos.size()/librosComprados.size())*100;
    }
    
    //-----------------------OPERACIONES DE USUARIO-----------------------------    
       
    /**-----------------------------------------------------------------------**
     * Actualiza el saldo del usuario lector y agrega una recarga a su historial
     * de recargas
     */ 
    
    public void recargar(int valor, String idRecarga){               
        Recargas aux = new Recargas(idRecarga, valor);
        recargas.put(idRecarga, aux);
        saldo += valor;
    }
    
    /**-----------------------------------------------------------------------**
     * Verifica que el usuario pueda realizar la compra (según su edad y saldo)
     * y de ser posible, agrega el libro al hashmap de librosComprados
     * Si el usuarios se encuentra de cumpleaños, le regala un libro
     */     
    
    public String comprarLibro(Libro libro) throws MyException{        
        if(edad<Integer.parseInt(libro.getRangoEdades().split("-")[0])){
            throw new MyException("Compra no efectuada. El libro está dirigido a una audiencia entre los " + libro.getRangoEdades() + " años");
        }else if(isMyBirthday && contLibroCumpleanios==0){
            contLibroCumpleanios = 1;                 
            librosComprados.put(libro.getIsbn(), libro);
            return "La biblioteca le ha regalado el libro por ser su cumpleaños.\nFelicidades :)";
        }else if(saldo<libro.getPrecio()){
            throw new MyException("Compra no efectuada. Su saldo es inferior al precio del libro");          
        }else{
            librosComprados.put(libro.getIsbn(), libro);
            saldo -= libro.getPrecio();
            return "Compra exitosa";                
        }
    }
    
    public void agregarSesion(Sesion sesion){
        sesionesIniciadas.add(sesion);
    }
    
    public void checkBirthday (){
        LocalDateTime time = LocalDateTime.now();
        int mesActual = time.getMonthValue();
        int diaActual = time.getDayOfMonth();
        int diaLector = Integer.parseInt(diaNacimiento);
        int mesLector = Integer.parseInt(mesNacimiento);
        
        if(diaActual == diaLector && mesActual == mesLector){
            this.isMyBirthday = true;
            this.contLibroCumpleanios = 0;
        }else{
            this.isMyBirthday = false;
            this.contLibroCumpleanios = 1;
        }      
    }    
}
