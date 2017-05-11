/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;
import java.io.*;
import java.net.*;
import java.util.*;
import Modelo.*;

/**
 *
 * @author invitado
 */
public class Cliente {
    private Socket cliente;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;

    public Cliente(int puerto) {
        
        try{            
            InetAddress localHost = InetAddress.getLocalHost();
            this.cliente = new Socket (localHost.getHostAddress(), puerto);
            this.salida = new ObjectOutputStream(cliente.getOutputStream());
            this.entrada = new ObjectInputStream(cliente.getInputStream());;
        }catch(UnknownHostException e){
            System.out.println("Servidor no Encontrado\n");
        }catch(IOException e){
            System.out.println("Error en flujos de cliente\n");
        }
    }
    
    public void enviarDatos(ArrayList mensaje){
        try{
            System.out.println((String)mensaje.iterator().next());
            salida.writeObject(mensaje);
            salida.flush();       
        }catch(IOException e){
            System.out.println("Error en enviar mensaje");
        }
    }
    
    public String procesarConexion(){
        String mensaje= "Conectado <3";  
        
        do{
             try{
                 mensaje= (String) entrada.readObject();
             }catch(ClassNotFoundException e){
                 System.out.println("Class not found\n");
             }catch(IOException e){
                 System.out.println("Error en los flujos de lectura del cliente\n");
             }
                 System.out.println("hola :3");
         }while(!mensaje.equals("Exit"));
        return mensaje;
    }
    
    public static void main(String[] args) throws UnknownHostException {
        Cliente cliente = new Cliente(28795);
        ArrayList hola = new ArrayList();
        hola.add("consultarLibrosNombre");
        hola.add("nombre");
        cliente.enviarDatos(hola);
        System.out.println(cliente.procesarConexion());
        
        
    }
}