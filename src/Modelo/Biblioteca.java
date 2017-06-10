/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import java.math.*;
import com.sun.mail.smtp.SMTPTransport;
import java.io.*;
import java.security.Security;
import java.util.*;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;

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
    private HashMap librosOferta;
    private HashMap librosSinOferta; 
    private ArrayList mejoresLibros;
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
        this.librosOferta = new HashMap();
        this.librosSinOferta = new HashMap();
        this.lectura= new Lectura();
        this.escritura = new Escritura();
        this.mejoresLibros = new ArrayList();
        escritura.serializarPrimerUAL();
        this.agregarLibrosAutomaticamente();
        this.agregarUsuariosAdministradoresAutomaticamente();
        this.agregarUsuariosLectoresAutomaticamente();
        this.inicializarHashMapsOfertas();
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

    public HashMap getLibrosOferta() {
        return librosOferta;
    }
    
    public HashMap getLibrosSinOferta() {
        return librosSinOferta;
    }

    public ArrayList getMejoresLibros() {
        return mejoresLibros;
    }        
        
    //--------------------------MÉTODOS SET-------------------------------------    

    public void setLibros(HashMap libros) {
        this.libros = libros;
    }

    public void setClientes(HashMap clientes) {
        this.clientes = clientes;
    }

    public void setAdministradores(HashMap administradores) {
        this.administradores = administradores;
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

    public void setLibrosOferta(HashMap librosOferta) {
        this.librosOferta = librosOferta;
    }   
    
    public void setLibrosSinOferta(HashMap librosSinOferta) {
        this.librosSinOferta = librosSinOferta;
    }

    public void setMejoresLibros(ArrayList mejoresLibros) {
        this.mejoresLibros = mejoresLibros;
    }   
        
    //---------------------REFRESCAR COMPONENTES INTERFAZ-----------------------
    
    public ArrayList refrescarPeriodosOferta(){
        ArrayList periodos = new ArrayList(periodosOferta.size());
        Iterator it = periodosOferta.values().iterator();
        if(!periodosOferta.isEmpty()){
            for(int i=0; i<periodosOferta.size(); i++){
                Oferta oferta = (Oferta)it.next();
                periodos.add(oferta.getFechaInicial() + " - " + oferta.getFechaFinal() + " - " + oferta.getPorcentajeDescuento());               
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
    
    public ArrayList refrescarLibrosOferta(){
        ArrayList booksOferta = new ArrayList(librosOferta.size());
        Iterator it = librosOferta.values().iterator();
        if(!librosOferta.isEmpty()){
            for(int i=0; i<librosOferta.size(); i++){
                Libro libroOferta = (Libro)it.next();
                booksOferta.add(libroOferta.getTitulo().concat(";" + libroOferta.getIsbn()));
            }
        }else{            
            booksOferta.add("No hay en oferta en la biblioteca");
        }
        return booksOferta;
    }
    
    public ArrayList refrescarLibrosSinOferta(){
        ArrayList booksSinOferta = new ArrayList(librosSinOferta.size());       
        Iterator it = librosSinOferta.values().iterator();
        if(!librosSinOferta.isEmpty()){
            for(int i=0; i<librosSinOferta.size(); i++){
                Libro libroSinOferta = (Libro)it.next();
                booksSinOferta.add(libroSinOferta.getTitulo().concat(";" + libroSinOferta.getIsbn()));
            }
        }else{            
            booksSinOferta.add("Todos los libros de la biblioteca ya se encuentran asociados a un periodo de oferta");
        }
        return booksSinOferta;
    }    
    
    public ArrayList refrescarBestSellers(){
        ArrayList bestSellers = new ArrayList();
        Iterator it = libros.values().iterator();
        for(int i=0; i<libros.size(); i++){
            Libro libro = (Libro)it.next();
            if(libro.isBestSeller()){
                bestSellers.add(libro.getTitulo().concat(";" + libro.getIsbn()));
            }
        }
        return bestSellers;
    }    
    
//    public ArrayList refrescarMejoresLibros(){
//        ArrayList mejores = new ArrayList(mejoresLibros.size());       
//        Iterator it = mejoresLibros.values().iterator();
//        if(!mejoresLibros.isEmpty()){
//            for(int i=0; i<mejoresLibros.size(); i++){
//                Libro libro = (Libro)it.next();
//                mejores.add(libro.getTitulo().concat(";" + libro.getIsbn()));
//            }
//        }else{            
//            mejores.add("No se han realizado calificaciones sobre los libros de la biblioteca");
//        }
//        return mejores;
//    } 
    
    //-------------------------GESTIÓN DE LIBROS--------------------------------
    
    //-----------------------AGREGAR LIBROS MANUALMENTE-------------------------    
    
    public void agregarLibros(int numPaginas, String titulo, int precio, String categoria, boolean bestSeller, String rangoEdades, 
                              String isbn, int calificacion, String resumen, String oferta, ArrayList paginasArray, ImageIcon caratula, String autor) throws MyException, IOException{
        if(libros.containsKey(isbn)){
            throw new MyException("Ya se ha agregado un libro con ese ISBN");
        }else{
            Oferta of = (Oferta)periodosOferta.get(oferta);            
            Libro libro = new Libro(numPaginas, titulo, precio, categoria, bestSeller, rangoEdades, isbn, calificacion, resumen, of, paginasArray, caratula, autor);
            if(of!=null){
                librosOferta.put(isbn, libro);
            }else{
                librosSinOferta.put(isbn, libro);
            }
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
            librosOferta.remove(isbn);
            librosSinOferta.remove(isbn);
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
            case "Juvenil":
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
            Libro libro = (Libro)libros.get(isbn);//          
            ArrayList datos = new ArrayList(); 
            datos.add(libro.getNumPaginas());
            datos.add(libro.getTitulo());
            datos.add(libro.getPrecio());
            datos.add(libro.getCategoria());
            datos.add(libro.isBestSeller());
            datos.add(libro.getRangoEdades());  
            datos.add(libro.getIsbn());            
            datos.add(libro.getResumen());          
            datos.add(libro.getAutor());
            datos.add(libro.getCaratula());
            return datos;
        }else{
            throw new MyException("El libro no se encuentra en la biblioteca");
        }
    }
    
    public void modificarLibro(int numPaginas, String titulo, int precio, String categoria, boolean bestSeller, String rangoEdades,
                              String isbn, String resumen, ArrayList paginasArray, ImageIcon caratula, String autor) throws MyException, IOException{
        if(libros.containsKey(isbn)){
            Libro libro = (Libro)libros.get(isbn);            
            libro.setTitulo(titulo);
            libro.setAutor(autor);             
            libro.setNumPaginas(numPaginas);
            libro.setRangoEdades(rangoEdades);           
            libro.setBestSeller(bestSeller);
            libro.setResumen(resumen);
            libro.setPrecio(precio);
            if(!paginasArray.get(0).equals("vacío")){                                        
                libro.setPaginasArray(paginasArray);
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
    
    //------------------------CLASIFICAR POR CATEGORÍA--------------------------
    
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
                case "Juvenil":
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
    
    //---------------------CARGAR LIBROS SERVIDOR-------------------------------
    
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
    
    //---------------------CARGAR USUARIOS SERVIDOR-------------------------------
    
    public void agregarUsuariosAdministradoresAutomaticamente() {        
        try{            
            HashMap usuariosBase = new HashMap();            
            usuariosBase = lectura.cargarUalBiblioteca();            
            Iterator it = usuariosBase.values().iterator();
            for(int i=0; i<usuariosBase.size(); i++){
                UsuarioAdministrador  ual = (UsuarioAdministrador)it.next();
                administradores.put(ual.getEmail(), ual);                            
            }
        }catch(ClassNotFoundException ex){
            System.out.println("ClassNotFoundException en Biblioteca, Metodo: AgregarUsuariosAdministradoresAutomaticamente\n" + ex.getMessage());
        }catch(NullPointerException ex){
            System.out.println("NullPointerException en Bibliotedan Metodo: AgregarUsuariosAdministradoresAutomaticamente\n" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException en Biblioteca, Metodo: AgregarUsuariosAdministradoresAutomaticamente\n" + ex.getMessage());
        }
    }   
    
    public void agregarUsuariosLectoresAutomaticamente() {        
        try{            
            HashMap usuariosBase = new HashMap();            
            usuariosBase = lectura.cargarUlBiblioteca();            
            Iterator it = usuariosBase.values().iterator();
            for(int i=0; i<usuariosBase.size(); i++){
                UsuarioLector  ul = (UsuarioLector)it.next();
                clientes.put(ul.getEmail(), ul);                            
            }
        }catch(ClassNotFoundException ex){
            System.out.println("ClassNotFoundException en Biblioteca, Metodo: AgregarUsuariosLectoresAutomaticamente\n" + ex.getMessage());
        }catch(NullPointerException ex){
            System.out.println("NullPointerException en Bibliotedan Metodo: AgregarUsuariosLectoresAutomaticamente\n" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException en Biblioteca, Metodo: AgregarUsuariosLectoresAutomaticamente\n" + ex.getMessage());
        }
    } 
    
    //-------------------------GESTIÓN DE USUARIOS------------------------------
    
    public void agregarUAL(String nombreCompleto, String cargo, String celular, String email, String nombreUsuario, String contrasenia, boolean autorizado) throws MyException, IOException{
        UsuarioAdministrador usuario = new UsuarioAdministrador(nombreCompleto, cargo, celular, email, nombreUsuario, contrasenia, autorizado);
        if(administradores.containsKey(email)){
            throw new MyException("EL Usuario con ese E-mail ya existe");
        }else{
            administradores.put(email, usuario);
            escritura.serializarUAL(usuario);
        }
    }
    
    public void agregarUL(String nombreCompleto, String celular, String diaNacimiento, String mesNacimiento, int edad, String email, String nombreUsuario, String contrasenia, int saldo) throws MyException, IOException{
        UsuarioLector usuario = new UsuarioLector(nombreCompleto, celular, diaNacimiento, mesNacimiento, edad, email, nombreUsuario, contrasenia, saldo);
        if(clientes.containsKey(email)){
            throw new MyException("El Usuario con ese E-mail ya existe");
        }else{
            clientes.put(email, usuario);
            escritura.serializarUL(usuario);
        }
    }
   
    public UsuarioAdministrador verificarLoginUAL (String email, String contrasenia) throws MyException{
        try{
            UsuarioAdministrador aux;
            String contraseniaaux;
            aux = (UsuarioAdministrador)administradores.get(email);
            contraseniaaux = aux.getContrasenia();
                if(contraseniaaux.equals(contrasenia)){
                    return aux;
                }else{throw new MyException("Contraseña incorrecta");}
        }catch(NullPointerException ex){
            throw new MyException("Usuario Incorrecto");
        }
    }
    
    public UsuarioLector verificarLoginUL(String email, String contrasenia)throws MyException{
        try{
            UsuarioLector aux;
            String contraseniaaux;
            aux = (UsuarioLector) clientes.get(email);
            contraseniaaux = aux.getContrasenia();
            if(contraseniaaux.equals(contrasenia)){
                return aux;
            }else{throw new MyException("Contraseña incorrecta");}      
        }catch(NullPointerException ex){
            throw new MyException("Usuario Incorrecto");
        }
    }
    
    public ArrayList consultarUAL(String email) throws MyException{
        ArrayList infoUsuario = new ArrayList(6);
        if(administradores.containsKey(email)){
            UsuarioAdministrador aux;
            aux = (UsuarioAdministrador) administradores.get(email);
            infoUsuario.add(aux.getNombreCompleto());
            infoUsuario.add(aux.getCargo());
            infoUsuario.add(aux.getCelular());
            infoUsuario.add(aux.getEmail());
            infoUsuario.add(aux.getNombreUsuario());
            infoUsuario.add(aux.isAutorizado());
            return infoUsuario;
        }else{
            throw new MyException("Usuario No encontrado");
        }
    }
    
    public ArrayList consultarUL(String email) throws MyException{
        ArrayList infoUsuario = new ArrayList();
        if(clientes.containsKey(email)){
            UsuarioLector aux;
            aux = (UsuarioLector) clientes.get(email);
            
            infoUsuario.add(aux.getNombreCompleto());            
            infoUsuario.add(aux.getCelular());
            infoUsuario.add(aux.getDiaNacimiento());
            infoUsuario.add(aux.getMesNacimiento());           
            infoUsuario.add(aux.getEmail());
            infoUsuario.add(aux.getEdad());
            infoUsuario.add(aux.getSaldo());
            infoUsuario.add(aux.getNombreUsuario());
            
            return infoUsuario;
        }else{
            throw new MyException("Usuario No encontrado");
        }
    }    
    
    public void modificarUL(String email, String nombreCompleto, String celular, String diaNacimiento,
                            String mesNacimiento, int edad, String nombreUsuario, String contraseniaAnterior, String contraseniaNueva)throws MyException, IOException{
        if(clientes.containsKey(email)){
            UsuarioLector aux = (UsuarioLector) clientes.get(email);
        
            aux.setNombreCompleto(nombreCompleto);
            aux.setCelular(celular);
            aux.setDiaNacimiento(diaNacimiento);
            aux.setMesNacimiento(mesNacimiento);
            aux.setEdad(edad);
            aux.setNombreUsuario(nombreUsuario);

            if(aux.getContrasenia().equals(contraseniaAnterior)){
                aux.setContrasenia(contraseniaNueva);
                escritura.serializarUL(aux);
            }else{
                throw new MyException("La contraseña anterior no coincide");  
            }
        }else{
            throw new MyException("El usuario lector no se encuentra registrado");
        }
                
    }
    
    
    public void modificarUAL(String email, String nombreCompleto, String celular, String nombreUsuario, String cargo, boolean autorizado,
                             String contraseniaAnterior, String contraseniaNueva)throws MyException, IOException{
        if(administradores.containsKey(email)){
            UsuarioAdministrador aux = (UsuarioAdministrador) administradores.get(email);
        
            aux.setNombreCompleto(nombreCompleto);
            aux.setCelular(celular);
            aux.setNombreUsuario(nombreUsuario);
            aux.setNombreUsuario(cargo);
            aux.setAutorizado(autorizado);

            if(aux.getContrasenia().equals(contraseniaAnterior)){
                aux.setContrasenia(contraseniaNueva);
                escritura.serializarUAL(aux);
            }else{
                throw new MyException("La contraseña anterior no coincide");  
            }
        }else{
            throw new MyException("El usuario Administrador no se encuentra registrado");
        }
                
    }
    
    //-------------------CARGAR LIBROS PARA EL USUARIO LECTOR-------------------  
    
    public ArrayList getArrayPaginasLibro(String isbn){
        ArrayList resp = new ArrayList();
        if(libros.containsKey(isbn)){
            Libro libro = (Libro)libros.get(isbn);
            resp.add(libro.getTitulo());
            resp.add(libro.getPaginasArray());
            return resp;
        }else{
           
            resp.add("El libro no se encuentra en la biblioteca");
            return resp;
        }
    }
    
    //-----------------------CREAR PERIODOS DE OFERTA---------------------------
    
    public void crearPeriodosOferta(String fechaInicial, String fechaFinal, int porcentajeDescuento, ArrayList librosOferta) throws MyException{
        String key = fechaInicial + " - " + fechaFinal + " - " + porcentajeDescuento;
        if(periodosOferta.containsKey(key)){
            throw new MyException("Ya existe un periodo de oferta con el mismo porcentaje de descuento en esa fecha");
        }else{                      
            Oferta oferta = new Oferta(fechaInicial, fechaFinal, porcentajeDescuento);
            periodosOferta.put(key, oferta);    
            asociarPeriodosConLibros(librosOferta, oferta);
        }
    }
    
    //--------------INICIALIZAR HASHMAPS ASOCIADOS A OFERTAS---------------------  
    
    public void inicializarHashMapsOfertas(){
        Iterator it = libros.values().iterator();
        for(int i=0; i<libros.size(); i++){
            Libro libro = (Libro)it.next();
            Oferta oferta = (Oferta)libro.getOferta();
            if(oferta!=null){                
                periodosOferta.put(oferta.getKey(), oferta);
                librosOferta.put(libro.getIsbn(), libro);
            }else{
                librosSinOferta.put(libro.getIsbn(), libro);
            }
        }
    }
    
    //----------------ASOCIAR PERIODOS DE OFERTA CON LOS LIBROS-----------------
    
    public void asociarPeriodosConLibros(ArrayList librosEnOferta, Oferta oferta){
        for(int i=0; i<librosEnOferta.size(); i++){
            Libro libro = (Libro)libros.get(librosEnOferta.get(i));
            librosOferta.put(libro.getIsbn(), libro);            
            libro.setOferta(oferta);
            try {
                escritura.serializarLibro(libro);
            } catch (IOException ex) {
                System.out.println("Error al serializar oferta de libro");
            }
            librosSinOferta.remove(libro.getIsbn());
        }                        
    }
    
    //---------------TERMINAR PERIODO DE OFERTA POR HILOWATCHER-----------------
    
    public void terminarPeriodoOferta(){
        LocalDateTime time = LocalDateTime.now();
        int mesActual = time.getMonthValue();
        int diaActual = time.getDayOfMonth();
        int anioActual = time.getYear();  
        ArrayList periodosPorEliminar = new ArrayList();
        
        Iterator it = periodosOferta.values().iterator();
        for(int i=0; i<periodosOferta.size(); i++){
            Oferta oferta = (Oferta)it.next();
            int diaOferta = Integer.parseInt(oferta.getFechaFinal().split("/")[0]);
            int mesOferta = Integer.parseInt(oferta.getFechaFinal().split("/")[1]);
            int anioOferta = Integer.parseInt(oferta.getFechaFinal().split("/")[2]);
            
            if(diaActual==diaOferta && mesActual==mesOferta && anioActual==anioOferta){
                periodosPorEliminar.add(oferta.getKey());               
            }            
        }
        if(!periodosPorEliminar.isEmpty()){
            for(int i=0; i<periodosPorEliminar.size(); i++){
                periodosOferta.remove(periodosPorEliminar.get(i));   

                Iterator libroIt = librosOferta.values().iterator();
                for(int j=0; j<librosOferta.size(); j++){
                    Libro libroEnOferta = (Libro)libroIt.next();
                    if(libroEnOferta.getOferta().getKey().equals(periodosPorEliminar.get(i))){
                        libroEnOferta.setOferta(null);
                        try {
                            escritura.serializarLibro(libroEnOferta);
                        } catch (IOException ex) {
                            System.out.println("Hoy termina un periodo de oferta que no puede ser eliminado por el hilo");
                        }
                        librosOferta.remove(libroEnOferta.getIsbn(), libroEnOferta);
                        librosSinOferta.put(libroEnOferta.getIsbn(), libroEnOferta);
                    }
                }
            }
        }
    }
    
    //----------------CONSULTAR LA OFERTA ASOCIADA A UN LIBRO-------------------
    
    public ArrayList consultarPeriodoOferta(String isbn){
        Iterator it = librosOferta.values().iterator();
        ArrayList periodoOferta= new ArrayList();
        for(int i=0; i<librosOferta.size(); i++){
            Libro libroEnOferta = (Libro)it.next();
            if(libroEnOferta.getIsbn().equals(isbn)){
               periodoOferta.add(libroEnOferta.getCaratula());
               periodoOferta.add(libroEnOferta.getOferta().getKey());
               Integer integer = (int) Math.round(libroEnOferta.getCalificacionGlobal());
               periodoOferta.add(integer);
            }else{
            ArrayList resp = new ArrayList(1);
            resp.add("El libro no se encuentra en la biblioteca");
            return resp;
            }
        }
        return periodoOferta;                     
    }
    
    //-------------------------GESTIÓN DE RECARGAS------------------------------
    
    public String generarIdAleatorio(String email){
        String[] splitemail;
        splitemail = email.split("@");
        String idRecarga ="";
        
        int randomNum;        
        for(int i=0; i< splitemail[0].length(); i++){
            randomNum = 0 + (int)(Math.random() * 9); 
            idRecarga = String.valueOf(splitemail[0].charAt(i)) + String.valueOf(randomNum);
        }       
        return idRecarga;
    }
    
    public void recargar(String email, int valor){
        Iterator it = clientes.values().iterator();
        String idRecarga = "";
        if(clientes.containsKey(email)){
            while(it.hasNext()){
                UsuarioLector ul = (UsuarioLector)it.next();
                do{idRecarga = generarIdAleatorio(email);
                }while(ul.getRecargas().containsKey(idRecarga));
            }
        }
        UsuarioLector aux = (UsuarioLector)clientes.get(email);
        aux.recargar(valor, idRecarga);
    }
    
    //-----------------------VERIFICAR CUMPLEAÑOS UL----------------------------   
    
    public static void Send(String recipientEmail) throws AddressException, MessagingException {
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

            // Obeteniendo propiedades
            Properties props = System.getProperties();
            System.out.println(props);
            props.setProperty("mail.smtps.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.socketFactory.port", "465");
            props.setProperty("mail.smtps.auth", "true");
            System.out.println(props);
            props.put("mail.smtps.quitwait", "false");
            Session session = Session.getInstance(props, null);

            //Archivo De la imagen
            File file = new File(System.getProperty("user.dir"));
            File fileAux = new File(file + "/cumple.jpg");
            FileDataSource fds = new FileDataSource(fileAux);
            //PARTES DEL MENSAJE

            String message = "Feliz Cumpleaños " + recipientEmail + "\n Recuerde que hoy por ser un día tan especial, podrá obtener alguno de los libros disponibles en nuestra tienda TOTALMENTE GRATIS";

            MimeBodyPart p1 = new MimeBodyPart();
            p1.setText(message);

            MimeBodyPart p2 = new MimeBodyPart();
            p2.setDataHandler(new DataHandler(fds));
            p2.setFileName(fds.getName());
    //----------------------------------------------------------//


            // -- Create a new message --
            MimeMessage msg = new MimeMessage(session);
            final String username = "vamianpi@gmail.com";
            final String password = "proyectoprogramacion2017";

            // -- Set the FROM and TO fields --
            msg.setFrom(new InternetAddress(username));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

            Multipart mltprt = new MimeMultipart();
            String title = "Feliz Cumpleaños";

            mltprt.addBodyPart(p1);
            mltprt.addBodyPart(p2);
            //msg.setFileName(p2.toString());
            msg.setSubject(title);
            msg.setFrom();
            msg.setContent(mltprt);


            msg.setSentDate(new Date());

            SMTPTransport t = (SMTPTransport)session.getTransport("smtps");

            t.connect("smtp.gmail.com", username, password);
            t.sendMessage(msg, msg.getAllRecipients());      
            t.close();
        }    

    public void verificarCumpleaniosUsuario() throws MessagingException{
        Iterator it = clientes.values().iterator();
        UsuarioLector cliente;
            for(int i=0; i < clientes.size(); i++){
                cliente = (UsuarioLector) it.next();
                cliente.checkBirthday();
                if(cliente.isMyBirthdayGetter()){                    
                    Send(cliente.getEmail());                    
                }
            }
        }
    
    /**-----------------------------------------------------------------------**
     * Genera el informe del porcentaje de lectura de todos los usuarios lectores
     */
    
    public ArrayList informePorcentajeLectura(){
        ArrayList informe = new ArrayList();
        String info = "PORCENTAJE DE LIBROS LEÍDOS POR USUARIO";
        Iterator it = clientes.values().iterator();
        for(int i=0; i<clientes.size(); i++){
            UsuarioLector ul = (UsuarioLector)it.next();
            info += "\n-" + ul.getNombreUsuario() + ": " + ul.porcentajeLectura();
        }
        informe.add(info);
        return informe;
    }
    
    
//    public ArrayList revisarArriba(ArrayList reviso, double calificacion, int i){
//        if(reviso.isEmpty()){
//            reviso.add(calificacion);
//            return reviso;
//        }else{
//            if((int)reviso.get(i) <= calificacion){
//                reviso.add(i, calificacion);
//            }else{
//                i++;
//                revisarArriba(reviso, calificacion, i);
//            }
//        }
//        return reviso;
//    }   
//    
//    public ArrayList topTen(){
//        Iterator it = libros.values().iterator();
//        Libro libro;
//        ArrayList calificacionesLibro;
//        ArrayList orden = new ArrayList(10);
//        //RECORRE LIBRO POR LIBRO CALIFICANDOLO MEDIANTE TODAS LAS CALIFICACIONES RECIBIDAS
//        while(it.hasNext()){
//            double j = 0;
//            libro = (Libro) it.next();
//            calificacionesLibro = libro.getCalificaciones();
//                for(int i=0; i<=calificacionesLibro.size(); i++){
//                    j += (double) calificacionesLibro.get(i);
//                }
//                j = j/calificacionesLibro.size();
//                libro.setCalificacion(j);
//            orden = revisarArriba(orden, j, 0);
//        //sigo dentro del while   
//        }
//        return orden;
//    }
//    
    
     /*---------------------------CALIFICAR LIBROS -----------------------------
    ** Agrega la calificacion que da un usuario lector al arrayList de calificaciones
    ** que tiene cada libro de la Biblioteca, también agrega la calificación al libro
    ** que existe en la clase Usuario Administrador
    */
    
    public void hacerCalificacion(String isbn, double calificacion, UsuarioLector ul) throws MyException{
        Libro libroBiblioteca = (Libro)libros.get(isbn);
        Libro libroUsuario = (Libro)ul.getLibrosComprados().get(isbn);
        if(ul.calificarLibro(libroUsuario)){
            libroBiblioteca.getCalificaciones().add(calificacion);
            libroUsuario.setCalificacionPersonal((int) calificacion);
            setearCalificacionLibroBiblioteca(libroBiblioteca);             
           // (librosArray());
        }else{
            throw new MyException("El usuario debe haber leido por lo menos el 80% del libro para poder calificarlo");
        }
    }
       
    /**-----------------------------------------------------------------------**
     * Setea la calificación de un libro según la calificación global dada por los 
     * usuarios lectores, (agrega la calificación al libro de la biblioteca)
     */   
    
    public void setearCalificacionLibroBiblioteca(Libro libro){
        double calificacionGlobal = 0;
        for(int i=0; i<libro.getCalificaciones().size(); i++){
            calificacionGlobal += (int)libro.getCalificaciones().get(i);
        }                
        libro.setCalificacionGlobal((int) (calificacionGlobal/libro.getCalificaciones().size()));
    }
    
    /*
    ** Convierte el hashMap de libros en un arrayList
    */
    
    public ArrayList librosArray(){
        ArrayList newArray = new ArrayList();
        Iterator it = libros.values().iterator();
        for(int i=0; i<libros.size(); i++){
            Libro lib = (Libro)it.next();
            newArray.add(lib);
        }
        return newArray;
    }
    
    /**-----------------------------------------------------------------------**
     * Itera el hashMap de libros de la biblioteca para actualizar los top 10 con 
     * mejores calificaciones 
     */ 
    
    public ArrayList juanCamiloSort (ArrayList libros, boolean isTop) throws NoSuchElementException{  
        ArrayList topBooks = new ArrayList();
        ArrayList bottomBooks = new ArrayList();    
        ArrayList resultado = new ArrayList();
        Iterator<Libro> it = libros.iterator();
        Libro pivote = it.next();         
        if(libros.isEmpty()){
            return new ArrayList();
        }
        if(isTop){
            while(it.hasNext()){
                Libro lib = it.next();
                if(pivote.getCalificacionGlobal() <= lib.getCalificacionGlobal()){
                    topBooks.add(lib);
                }else{
                    bottomBooks.add(lib);
                }
            }
        }else{
            while(it.hasNext()){
                Libro lib = it.next();
                if(pivote.getCalificacionGlobal() >= lib.getCalificacionGlobal()){
                    topBooks.add(lib);
                }else{
                    bottomBooks.add(lib);
                }
            }
        }        
        // isTop=true entonces mayor calificacion else menor calificacion :v
        resultado.addAll(juanCamiloSort(topBooks, isTop));
        resultado.add(pivote);
        resultado.addAll(juanCamiloSort(bottomBooks, isTop));     
        return resultado;
    }
    
    /**-----------------------------------------------------------------------**
     * De la lista ordenada de mejores a peores libros se genera un informe con 
     * los primeros 10 libros (los mejores)
     */ 
    
    public ArrayList informeTopBooks(){
        ArrayList librosBiblioteca = librosArray();
        ArrayList topBooks = juanCamiloSort(librosBiblioteca, true);
        ArrayList answer = new ArrayList();
        String informe = "MEJORES LIBROS";
        Iterator it = topBooks.iterator();
        for(int i=0; i<topBooks.size(); i++){
            Libro lib = (Libro)it.next();
            informe += "\n" + i + ". " + lib.getTitulo();
            if(i==9){
                break;
            }
        }
        answer.add(informe);
        return answer;
    }
    
    /**-----------------------------------------------------------------------**
     * De la lista ordenada de mejores a peores libros se genera un informe con 
     * los últimos 10 libros (peores)
     */ 
    
    public ArrayList informeBottomBooks(){
        ArrayList librosBiblioteca = librosArray();
        ArrayList bottomBooks = juanCamiloSort(librosBiblioteca, false);
        ArrayList answer = new ArrayList();
        String informe = "LIBROS DE MENOR CALIFICACIÓN";
        Iterator it = bottomBooks.iterator();
        for(int i=0; i<bottomBooks.size(); i++){
            Libro lib = (Libro)it.next();
            informe += "\n" + i + ". " + lib.getTitulo();
            if(i==10){
                break;
            }
        }
        answer.add(informe);
        return answer;
    }
    
    /**-----------------------------------------------------------------------**
     * Consulta las sesiones de un usuario lector específico
     */ 
    
    public ArrayList informeSesionesUL(String email){
        if(clientes.containsKey(email)){
            UsuarioLector ul = (UsuarioLector)clientes.get(email);
            return ul.getInformeSesiones();
        }else{
            ArrayList resp = new ArrayList(1);
            resp.add("No existe un usuario lector con ese email");
            return resp;
        }
    }


    }
