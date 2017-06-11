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
    private HashMap librosComprados; //incluye libros sin leer y libros en proceso de lectura
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
        this.sesionesIniciadas = new ArrayList();
    }
    
    public UsuarioLector(){}
    
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
        int cont = 0;        
        Iterator it = librosComprados.values().iterator();       
        for(int i=0; i<librosComprados.size(); i++){
            Libro libro = (Libro)it.next();
            if(libro.getPorcentajeLectura()==100){
                cont ++;
            }
        }
        return (cont/librosComprados.size())*100;
    }
    
    //-----------------------OPERACIONES DE USUARIO-----------------------------    
       
    /**-----------------------------------------------------------------------**
     * Actualiza el saldo del usuario lector y agrega una recarga a su historial
     * de recargas
     */ 
    
    public String recargar(int valor, String idRecarga){               
        Recargas aux = new Recargas(idRecarga, valor);
        recargas.put(idRecarga, aux);
        saldo += valor;
        return "Recarga efectuada\nNuevo saldo: " + saldo;
    }
    
    /**-----------------------------------------------------------------------**
     * Verifica que el usuario pueda realizar la compra (según su edad y saldo)
     * y de ser posible, agrega el libro al hashmap de librosComprados
     * Si el usuarios se encuentra de cumpleaños, le regala un libro
     * Se revisa que el precio ya contenga el descuento si el libro está asociado
     * a un periodo de oferta
     */     
    
    public String comprarLibro(Libro libro) throws MyException{          
        double precio = 0;
        if(libro.getOferta()!=null){
            precio = libro.getPrecioConDescuento(libro.getOferta().getPorcentajeDescuento());
        }else{
            precio = libro.getPrecio();
        }               
                
        if(edad<Integer.parseInt(libro.getRangoEdades().split("-")[0])){
            System.out.println(edad);            
            throw new MyException("Compra no efectuada. El libro está dirigido a una audiencia entre los " + libro.getRangoEdades() + " años");
        }else if(isMyBirthday && contLibroCumpleanios==0){            
            contLibroCumpleanios = 1;                 
            librosComprados.put(libro.getIsbn(), libro);
            return "La biblioteca le ha regalado el libro por ser su cumpleaños.\nFelicidades :)";        
        }else if(saldo<precio){           
            throw new MyException("Compra no efectuada. Su saldo es inferior al precio del libro");          
        }else{           
            librosComprados.put(libro.getIsbn(), libro);            
            saldo -= libro.getPrecio();           
            return "Compra exitosa";                
        }
    }
    
    
    /*-----------------------REFERENTE A SESIONES-------------------------------    
     /**-----------------------------------------------------------------------**
     * Agrega una sesión al array de sesiones del usuario
     */   
    
    public void agregarSesion(Sesion sesion){       
        sesionesIniciadas.add(sesion);        
    }
    
    /**-----------------------------------------------------------------------**
     * Genera un informe de las sesiones del usuario
     */  
    
    public ArrayList getInformeSesiones(){        
        ArrayList informe = new ArrayList();
        String info = "INFORME DE SESIONES DEL USUARIO";
        Iterator it = sesionesIniciadas.iterator();
        for(int i=0; i<sesionesIniciadas.size(); i++){
            Sesion sesion =  (Sesion)it.next();
            info += "\n" + i + ". " + sesion.getInforme();
        }
        informe.add(info);
        return informe;    
    }
    
    
    /**-----------------------------------------------------------------------**
     * Revisa si el usuario está cumpliendo años, si lo está, actualiza su contador
     * de libros de regalo a 0, indicando que durante el día puede tomar un libro gratis
     */ 
    
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
    
    /**-----------------------------------------------------------------------**
     * Por cada libro comprado, retorna un ArrayList con el título e isbn para
     * refrescar vista
     */ 
    public ArrayList refrescarLibrosComprados(){
        ArrayList books = new ArrayList(librosComprados.size());
        Iterator it = librosComprados.values().iterator();
        if(!librosComprados.isEmpty()){
            for(int i=0; i<librosComprados.size(); i++){
                Libro libro = (Libro)it.next();
                books.add(libro.getTitulo().concat(";" + libro.getIsbn()));
            }
        }else{            
            books.add("No hay libros comprados");
        }
        return books;
    }
    
    /*--------------------CONSULTAR MIS LIBROS UL-------------------------------
    ** Para refrescar ventana MisLibros, retorna la carátula, el resumen, porcentaje
    ** de lectura y calificación
    */
    
    public ArrayList consultarLibrosComprados(String isbn){
        ArrayList resp = new ArrayList();
        int roundedNumber;
        if(librosComprados.containsKey(isbn)){
            Libro libro = (Libro)librosComprados.get(isbn);
            resp.add(libro.getResumen());
            resp.add(libro.getCaratula());
            resp.add(libro.getCalificacionPersonal());
            roundedNumber = (int) Math.round(libro.getPorcentajeLectura());
            resp.add(roundedNumber);
        }else{            
            resp.add("Error, el usuario no cuenta con ese libro");
            return resp;
        }
        return resp;
    }
    
     /*--------------------CALIFICAR LIBROS COMPRADOS---------------------------
    ** Busca el libro que quiere calificar y verifica que haya leido el 80% de este.
    ** Retorna un verdadero para indicar que la calificación que quiere hacer es válida.
    */
    public boolean calificarLibro(Libro libro){
        Libro libroDelLector = (Libro)librosComprados.get(libro.getIsbn());
        if(libroDelLector.getPorcentajeLectura() >= 80){
            return true;
        }else{
            return false;
        }
    }
    
     /*--------------------ACCEDER A LIBROS COMPRADOS---------------------------
    ** Retorna el libro que se quiere leer como un array de strings
    */
    
    public ArrayList getLibroLectura(String isbn){
        ArrayList libroArray = new ArrayList();
        Libro libro = (Libro)librosComprados.get(isbn);
        libroArray.add(libro.getTitulo());
        libroArray.add(libro.getPaginasArray());
        return libroArray;
    }
    
     /*--------------------ALGORITMO DE REFCOMENDACION---------------------------
    ** Asigna un punto a cada categoria del libro al que pertenece una mayor calififacion
    cada vez que un libro le gane a otro en calificacion personal se anadira un punto a la categoria del libro ganador 
    */    
    public ArrayList HashMapToArrayList () throws NoSuchElementException{  
        Iterator it = librosComprados.values().iterator();
        ArrayList LibrosAAnalizar = new ArrayList();
        while (it.hasNext()){
            Libro libro = (Libro) it.next();
            LibrosAAnalizar.add(libro);
        }
        return LibrosAAnalizar;
    }
    
    public static String eliminarAcentos(String str) {
        String ORIGINAL = "ÁáÉéÍíÓóÚúÑñÜü";
        String REPLACEMENT = "AaEeIiOoUuNnUu";
        if (str == null) {
            return null;
        }
        char[] array = str.toCharArray();
        for (int index = 0; index < array.length; index++) {
            int pos = ORIGINAL.indexOf(array[index]);
            if (pos > -1) {
                array[index] = REPLACEMENT.charAt(pos);
            }
        }
        return new String(array);
}
    
    
    public HashMap algoritmoDeRecomendacionCategorias(){
        int academico = 0;
        int clasico = 0;
        int suspenso = 0;
        int romance = 0;
        int filosofia = 0;
        int juvenil = 0;
        int otros = 0;
        HashMap categorias = new HashMap();
        ArrayList aux = HashMapToArrayList();
        for(int i=0; i<=aux.size(); i++){
            Libro libro = (Libro) aux.get(i);
            for(int j=i+1; j <=aux.size(); i++){
                Libro libro2 = (Libro) aux.get(j);
                if(libro.equals(libro2)){                    
                    switch (eliminarAcentos(libro.getCategoria()))
                    {
                        case "Academico":
                            academico++;
                            break;
                        case "Clasico":
                            clasico++;
                            break;
                        case "Suspenso":
                            suspenso++;
                            break;
                        case "Romance":
                            romance++;
                            break;
                        case "Filosofia":
                            filosofia++;
                            break;
                        case "Juvenil":
                            juvenil++;
                            break;
                        case "Otros":
                            otros++;
                            break;
                    }
                }else{
                    switch (eliminarAcentos(libro2.getCategoria()))
                    {
                        case "Academico":
                            academico++;
                            break;
                        case "Clasico":
                            clasico++;
                            break;
                        case "Suspenso":
                            suspenso++;
                            break;
                        case "Romance":
                            romance++;
                            break;
                        case "Filosofia":
                            filosofia++;
                            break;
                        case "Juvenil":
                            juvenil++;
                            break;
                        case "Otros":
                            otros++;
                            break;
                    }
                }
            }
        }
        categorias.put("Academico", academico);
        categorias.put("Clasico", clasico);
        categorias.put("Suspenso",suspenso);
        categorias.put("Romance", romance);
        categorias.put("Filosofia", filosofia);
        categorias.put("Juvenil", juvenil);
        categorias.put("Otros", otros);
        
    return categorias;
    }
    
     /*-----------------GUARDAR CAMBIOS EN EL LIBRO LEÍDO-----------------------
    ** Realiza los cambios del ul sobre el objeto libro en su hashmap de libros
    */
    public void setCambiosLectura(String isbn, int contador, ArrayList paginasArray, ArrayList notas){
        Libro libro = (Libro)librosComprados.get(isbn);
        libro.setPaginasLeidas(contador);
        libro.setPorcentajeLectura(contador/libro.getNumPaginas()*100);
        libro.setPaginasArray(paginasArray);
        libro.setNumPaginas(paginasArray.size());
        libro.setNotas(notas);
    }
    
    
}
