/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.io.*;

/**
 *
 * @author invitado
 */
public class Escritura {
    
    public Escritura(){        
    }
    
    public void serializarLibro(Libro libro) throws IOException{
        File file = new File(libro.getIsbn() + ".txt");        
        ObjectOutputStream escritor= new ObjectOutputStream(new FileOutputStream(file,false));       
        escritor.writeObject(libro);
        escritor.close();
    }
    
}
