/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


/**
 *
 * @author invitado
 */
public class Biblioteca {
    private HashMap libros;
    private HashMap clientes;
    private HashMap administradores;  
    private HashMap periodosOferta;    
    private HashMap librosAcademicos;
    private HashMap librosClasicos;
    private HashMap librosSuspenso;
    private HashMap librosRomance;
    private HashMap librosJuveniles;
    private HashMap librosFilosofia;
    private HashMap librosOtros;
    private Lectura lectura;
    private Escritura escritura;
    //---------------------------MÉTODO CONSTRUCTOR-----------------------------
    
    public Biblioteca(){
        this.clientes = new HashMap();
        this.libros = new HashMap();
        this.administradores = new HashMap();
        this.periodosOferta = new HashMap();
        this.librosAcademicos = new HashMap();
        this.librosClasicos = new HashMap();
        this.librosSuspenso = new HashMap();
        this.librosRomance = new HashMap();
        this.librosJuveniles = new HashMap();
        this.librosFilosofia = new HashMap();
        this.librosOtros = new HashMap();
        this.lectura= new Lectura();
        this.escritura = new Escritura();
        this.agregarLibrosAutomaticamente();
        this.clasificarLibrosCategoria();        
    }

   //----------------------------MÉTODOS GET------------------------------------

    public HashMap getLibros() {
        return libros;
    }

    public HashMap getClientes() {
        return clientes;
    }

    public HashMap getAdministradores() {
        return administradores;
    }

    public HashMap getPeriodosOferta() {
        return periodosOferta;
    }   

    public HashMap getLibrosAcademicos() {
        return librosAcademicos;
    }

    public HashMap getLibrosClasicos() {
        return librosClasicos;
    }

    public HashMap getLibrosSuspenso() {
        return librosSuspenso;
    }

    public HashMap getLibrosRomance() {
        return librosRomance;
    }

    public HashMap getLibrosJuveniles() {
        return librosJuveniles;
    }

    public HashMap getLibrosFilosofia() {
        return librosFilosofia;
    }

    public HashMap getLibrosOtros() {
        return librosOtros;
    }    
    
    //--------------------------MÉTODOS SET-------------------------------------    

    public void setLibros(HashMap libros) {
        this.libros = libros;
    }

    public void setClientes(HashMap clientes) {
        this.clientes = clientes;
    }

    public void setAdministradores(HashMap librosOferta) {
        this.administradores = librosOferta;
    }

    public void setPeriodosOferta(HashMap periodosOferta) {
        this.periodosOferta = periodosOferta;
    }    

    public void setLibrosAcademicos(HashMap librosAcademicos) {
        this.librosAcademicos = librosAcademicos;
    }

    public void setLibrosClasicos(HashMap librosClasicos) {
        this.librosClasicos = librosClasicos;
    }

    public void setLibrosSuspenso(HashMap librosSuspenso) {
        this.librosSuspenso = librosSuspenso;
    }

    public void setLibrosRomance(HashMap librosRomance) {
        this.librosRomance = librosRomance;
    }

    public void setLibrosJuveniles(HashMap librosJuveniles) {
        this.librosJuveniles = librosJuveniles;
    }

    public void setLibrosFilosofia(HashMap librosFilosofia) {
        this.librosFilosofia = librosFilosofia;
    }

    public void setLibrosOtros(HashMap librosOtros) {
        this.librosOtros = librosOtros;
    }
        
    //---------------------REFRESCAR COMPONENTES INTERFAZ-----------------------
    
    public ArrayList refrescarPeriodosOferta(){
        ArrayList periodos = new ArrayList(periodosOferta.size());
        Iterator it = periodosOferta.values().iterator();
        if(!periodosOferta.isEmpty()){
            for(int i=0; i<periodosOferta.size(); i++){
                Oferta oferta = (Oferta)it.next();
                periodos.add(oferta.getFechaInicial() + " - " + oferta.getFechaFinal() + "-" + oferta.getPorcentajeDescuento());               
            }
            }else{                
                periodos.add("No hay periodos de Oferta");
            }
        return periodos;
    }
    
    public ArrayList refrescarLibros(){
        ArrayList books = new ArrayList(libros.size());
        Iterator it = libros.values().iterator();
        if(!libros.isEmpty()){
            for(int i=0; i<libros.size(); i++){
                Libro libro = (Libro)it.next();
                books.add(libro.getTitulo().concat(";" + libro.getIsbn()));
            }
        }else{            
            books.add("No hay Libros en la biblioteca");
        }
        return books;
    }
    
    public ArrayList refrescarLibrosAcademicos(){
        ArrayList booksAcademicos = new ArrayList(librosAcademicos.size());
        Iterator it = librosAcademicos.values().iterator();
        if(!librosAcademicos.isEmpty()){
            for(int i=0; i<librosAcademicos.size(); i++){
                Libro libroAcademico = (Libro)it.next();
                booksAcademicos.add(libroAcademico.getTitulo().concat(";" + libroAcademico.getIsbn()));
            }
        }else{            
            booksAcademicos.add("No hay Libros Academicos en la biblioteca");
        }
        return booksAcademicos;
    }
    
    public ArrayList refrescarLibrosClasicos(){
        ArrayList booksClasicos = new ArrayList(librosClasicos.size());
        Iterator it = librosClasicos.values().iterator();
        if(!librosClasicos.isEmpty()){
            for(int i=0; i<librosClasicos.size(); i++){
                Libro libroClasicos = (Libro)it.next();
                booksClasicos.add(libroClasicos.getTitulo().concat(";" + libroClasicos.getIsbn()));
            }
        }else{            
            booksClasicos.add("No hay Libros Clasicos en la biblioteca");
        }
        return booksClasicos;
    }
    
    public ArrayList refrescarLibrosJuveniles(){
        ArrayList booksJuveniles = new ArrayList(librosJuveniles.size());
        Iterator it = librosJuveniles.values().iterator();
        if(!librosJuveniles.isEmpty()){
            for(int i=0; i<librosJuveniles.size(); i++){
                Libro libroJuveniles = (Libro)it.next();
                booksJuveniles.add(libroJuveniles.getTitulo().concat(";" + libroJuveniles.getIsbn()));
            }
        }else{           
            booksJuveniles.add("No hay Libros Juveniles en la biblioteca");
        }
        return booksJuveniles;
    }
    
    public ArrayList refrescarLibrosSuspenso(){
        ArrayList booksSuspenso = new ArrayList(librosSuspenso.size());
        Iterator it = librosSuspenso.values().iterator();
        if(!librosSuspenso.isEmpty()){
            for(int i=0; i<librosSuspenso.size(); i++){
                Libro libroSuspenso = (Libro)it.next();
                booksSuspenso.add(libroSuspenso.getTitulo().concat(";" + libroSuspenso.getIsbn()));
            }
        }else{            
            booksSuspenso.add("No hay Libros de Suspenso en la biblioteca");
        }
        return booksSuspenso;
    }
    
    public ArrayList refrescarLibrosRomance(){
        ArrayList booksRomance = new ArrayList(librosRomance.size());
        Iterator it = librosRomance.values().iterator();
        if(!librosRomance.isEmpty()){
            for(int i=0; i<librosRomance.size(); i++){
                Libro libroRomance = (Libro)it.next();
                booksRomance.add(libroRomance.getTitulo().concat(";" + libroRomance.getIsbn()));
            }
        }else{            
            booksRomance.add("No hay Libros de Romance en la biblioteca");
        }
        return booksRomance;
    }
    
    public ArrayList refrescarLibrosFilosofia(){
        ArrayList booksFilosofia = new ArrayList(librosFilosofia.size());
        Iterator it = librosFilosofia.values().iterator();
        if(!librosFilosofia.isEmpty()){
            for(int i=0; i<librosFilosofia.size(); i++){
                Libro libroFilosofia = (Libro)it.next();
                booksFilosofia.add(libroFilosofia.getTitulo().concat(";" + libroFilosofia.getIsbn()));
            }
        }else{            
            booksFilosofia.add("No hay Libros de Filosofía en la biblioteca");
        }
        return booksFilosofia;
    }
    
    public ArrayList refrescarLibrosOtros(){
        ArrayList booksOtros = new ArrayList(librosOtros.size());
        Iterator it = librosOtros.values().iterator();
        if(!librosOtros.isEmpty()){
            for(int i=0; i<librosOtros.size(); i++){
                Libro libroOtros = (Libro)it.next();
                booksOtros.add(libroOtros.getTitulo().concat(";" + libroOtros.getIsbn()));
            }
        }else{            
            booksOtros.add("No hay Libros de esta categoría en la biblioteca");
        }
        return booksOtros;
    }
    
    
    //-------------------------GESTIÓN DE LIBROS--------------------------------
    
    //-----------------------AGREGAR LIBROS MANUALMENTE-------------------------    
    
    public void agregarLibros(int numPaginas, String titulo, int precio, String categoria, boolean bestSeller, String rangoEdades, 
                              String isbn, String calificacion, String resumen, String oferta, String nombreArchivo, ImageIcon caratula, String autor) throws MyException, IOException{
        if(libros.containsKey(isbn)){
            throw new MyException("Ya se ha agregado un libro con ese ISBN");
        }else{       
            Libro libro = new Libro(numPaginas, titulo, precio, categoria, bestSeller, rangoEdades, isbn, calificacion, resumen, oferta, nombreArchivo, caratula, autor);
            libros.put(isbn, libro);  
            this.clasifcarCadaLibro(libro);
            escritura.serializarLibro(libro);
        }
    }
    
    //-----------------------------ELIMINAR LIBROS------------------------------
    
    public void eliminarLibros(String isbn) throws MyException, IOException, ClassNotFoundException{
        Libro libro = (Libro)libros.get(isbn);
        if(libro==null){
            throw new MyException("No existe un libro con ese ISBN en la biblioteca");
        }else{
            this.eliminarDeCategoria(libro);
            libros.remove(isbn);
            lectura.eliminarLibroSerializado(isbn);              
        }
    }
    
   public void eliminarDeCategoria(Libro libro){
       String categoria = libro.getCategoria();
       String isbn = libro.getIsbn();
        switch(categoria){
            case "Académico":
                librosAcademicos.remove(isbn);
                break;
            case "Clásico":
                librosClasicos.remove(isbn);
                break;
            case "Suspenso":
                librosSuspenso.remove(isbn);
            case "Romance":
                librosRomance.remove(isbn);
                break;
            case "Juveniles":
                librosJuveniles.remove(isbn);
                break;
            case "Filosofía":
                librosFilosofia.remove(isbn);
                break;  
            default:
                librosOtros.remove(isbn);                
        }
   }
    
    //-----------------------------CONSULTAR LIBROS-----------------------------
    
    public ArrayList consultarInfoLibros(String isbn) throws MyException{
        if(libros.containsKey(isbn)){
            Libro libro = (Libro)libros.get(isbn);
            return libro.infoLibro();
        }else{
            ArrayList resp = new ArrayList(1);
            resp.add("El libro no se encuentra en la biblioteca");
            return resp;
        }
    }
    
    //-----------------------------MODIFICAR LIBROS-----------------------------
    
    public ArrayList cargarInfoLibro(String isbn) throws MyException{
        if(libros.containsKey(isbn)){
            Libro libro = (Libro)libros.get(isbn);
            ArrayList datos = new ArrayList(12); 
            datos.add(libro.getNumPaginas());
            datos.add(libro.getTitulo());
            datos.add(libro.getPrecio());
            datos.add(libro.getCategoria());
            datos.add(libro.isBestSeller());
            datos.add(libro.getRangoEdades());  
            datos.add(libro.getIsbn());
            datos.add(libro.getCalificacion());
            datos.add(libro.getResumen());
            datos.add(libro.getOferta());
            datos.add(libro.getAutor());
            datos.add(libro.getCaratula());
            return datos;
        }else{
            throw new MyException("El libro no se encuentra en la biblioteca");
        }
    }
    
    public void modificarLibro(int numPaginas, String titulo, int precio, String categoria, boolean bestSeller, String rangoEdades,
                              String isbn, String calificacion, String resumen, String oferta, String nombreArchivo, ImageIcon caratula, String autor) throws MyException, IOException{
        if(libros.containsKey(isbn)){
            Libro libro = (Libro)libros.get(isbn);
            libro.setTitulo(titulo);
            libro.setAutor(autor);                      
            libro.setCalificacion(calificacion);
            libro.setNumPaginas(numPaginas);
            libro.setRangoEdades(rangoEdades);
            libro.setOferta(oferta);
            libro.setBestSeller(bestSeller);
            libro.setResumen(resumen);
            libro.setPrecio(precio);
            if(!nombreArchivo.equals("vacío")){                                        
                libro.setNombreArchivo(nombreArchivo);
            }
            if(caratula!=null){                                      
                libro.setCaratula(caratula);
            }             
            if(!libro.getCategoria().equals(categoria)){
                this.eliminarDeCategoria(libro);
                libro.setCategoria(categoria);
                this.clasifcarCadaLibro(libro);
            }  
            escritura.serializarLibro(libro);
        }else{
            throw new MyException("El libro no se encuentra en la biblioteca");
        }
    }
    
    //------------------------CONSULTAR POR CATEGORÍA---------------------------
    
    public void clasifcarCadaLibro(Libro libro){
        String categoria = libro.getCategoria();
            switch(categoria){
                case "Académico":
                    librosAcademicos.put(libro.getIsbn(), libro);
                    break;
                case "Clásico":
                    librosClasicos.put(libro.getIsbn(), libro);
                    break;
                case "Suspenso":
                    librosSuspenso.put(libro.getIsbn(), libro);
                    break;
                case "Romance":
                    librosRomance.put(libro.getIsbn(), libro);
                    break;
                case "Juveniles":
                    librosJuveniles.put(libro.getIsbn(), libro);
                    break;
                case "Filosofía":
                    librosFilosofia.put(libro.getIsbn(), libro);
                    break;  
                default:
                    librosOtros.put(libro.getIsbn(), libro);                    
            } 
        
    }
    
    public void clasificarLibrosCategoria(){
        Iterator it = libros.values().iterator();
        for(int i=0; i<libros.size(); i++){
            Libro libro = (Libro)it.next();
            this.clasifcarCadaLibro(libro);
        }
    }
    
    public void agregarLibrosAutomaticamente() {        
        try{            
            HashMap librosBase = new HashMap();            
            librosBase = lectura.cargarLibrosBiblioteca();            
            Iterator it = librosBase.values().iterator();
            for(int i=0; i<librosBase.size(); i++){
                Libro libro = (Libro)it.next();
                libros.put(libro.getIsbn(), libro);                
            }
        }catch(ClassNotFoundException ex){
            System.out.println("ClassNotFoundException en Biblioteca, Metodo: AgregarLibrosAutomaticamente\n" + ex.getMessage());
        }catch(NullPointerException ex){
            System.out.println("NullPointerException en Bibliotedan Metodo: AgregarLibrosAutomaticamente\n" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException en Biblioteca, Metodo: AgregarLibrosAutomaticamente\n" + ex.getMessage());
        }
    }
    
    public void agregarUAL(String nombreCompleto, String cargo, String celular, String email, String nombreUsuario, String contrasenia, boolean autorizado) throws MyException{
        UsuarioAdministrador usuario = new UsuarioAdministrador(nombreCompleto, cargo, celular, email, nombreUsuario, contrasenia, autorizado);
        if(administradores.containsKey(email)){
            throw new MyException("EL Usuario con ese E-mail ya existe");
        }else{administradores.put(usuario.getEmail(), usuario);}
    }
    
    public void agregarUL(String nombreCompleto, String celular, String diaNacimiento, String mesNacimiento, int edad, String email, String nombreUsuario, String contrasenia, int saldo) throws MyException{
        UsuarioLector usuario = new UsuarioLector(nombreCompleto, celular, diaNacimiento, mesNacimiento, edad, email, nombreUsuario, contrasenia, saldo);
        if(clientes.containsKey(email)){
            throw new MyException("El Usuario con ese E-mail ya existe");
        }else{clientes.put(usuario.getEmail(), usuario);}
    }
   
    public UsuarioAdministrador verificarLoginUAL (String email, String contrasenia) throws MyException{
        UsuarioAdministrador aux;
        String contraseniaaux;
        aux = (UsuarioAdministrador)administradores.get(email);
        contraseniaaux = aux.getContrasenia();
        if(contraseniaaux.equals(contrasenia)){
            return aux;
        }else{throw new MyException("Contraseña incorrecta");}
    }
    
    public UsuarioLector verificarLoginUL(String email, String contrasenia)throws MyException{
        UsuarioLector aux;
        String contraseniaaux;
        aux = (UsuarioLector) clientes.get(email);
        contraseniaaux = aux.getContrasenia();
        if(contraseniaaux.equals(contrasenia)){
            return aux;
        }else{throw new MyException("Contraseña incorrecta");}      
    }
    
    public ArrayList consultarUAL(String isbn) throws MyException{
        ArrayList infoUsuario = new ArrayList(5);
        if(administradores.containsKey(isbn)){
            UsuarioAdministrador aux;
            aux = (UsuarioAdministrador) administradores.get(isbn);
            infoUsuario.add(aux.getNombreCompleto());
            infoUsuario.add(aux.getCargo());
            infoUsuario.add(aux.getCelular());
            infoUsuario.add(aux.getEmail());
            infoUsuario.add(aux.isAutorizado());
            return infoUsuario;
        }else{
            throw new MyException("Usuario No encontrado");
        }
    }
    
    public ArrayList consultarUL(String isbn) throws MyException{
        ArrayList infoUsuario = new ArrayList(5);
        if(clientes.containsKey(isbn)){
            UsuarioAdministrador aux;
            aux = (UsuarioAdministrador) clientes.get(isbn);
            infoUsuario.add(aux.getNombreCompleto());
            infoUsuario.add(aux.getCargo());
            infoUsuario.add(aux.getCelular());
            infoUsuario.add(aux.getEmail());
            infoUsuario.add(aux.isAutorizado());
            return infoUsuario;
        }else{
            throw new MyException("Usuario No encontrado");
        }
    }    
    
}