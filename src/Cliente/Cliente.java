/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;
import java.io.*;
import java.net.*;

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
            this.entrada = new ObjectInputStream(cliente.getInputStream());
        }catch(UnknownHostException e){
            System.out.println("Servidor no Encontrado\n");
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error en flujos de cliente\n");
        }
    }
    
    public void enviarDatos(String[] mensaje){
        try{            
            salida.writeObject(mensaje);
            salida.flush();   
            System.out.println("cliente envió el mensaje");
        }catch(IOException e){
            System.out.println("Error en enviar mensaje");
        }
    }
    
    public String[] procesarConexion(){ 
        String[] mensaje = new String[0];
             try{
                 mensaje= (String[]) entrada.readObject();
             }catch(ClassNotFoundException e){
                 System.out.println("Class not found\n");
             }catch(IOException e){
                 System.out.println("Error en los flujos de lectura del cliente\n");
             }catch(NullPointerException e){
                 System.out.println("Null Pointer Exception En cliente Al Procesar Conexion \n");
             }
                 System.out.println("procesar coneccion cliente exitosa");
        return mensaje;
    }
    
//    public static void main(String[] args) throws UnknownHostException {
//        Cliente cliente = new Cliente(28795);
//        ArrayList hola = new ArrayList();
//        hola.add("consultarLibrosNombre");
//        hola.add("nombre");
//        cliente.enviarDatos(hola);
//        System.out.println(cliente.procesarConexion());
//        
//        
//    }
}