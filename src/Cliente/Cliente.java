/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;
import java.io.*;
import java.net.*;
import java.util.*;

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

    public void enviarDatos(ArrayList mensaje){
        try{            
            salida.writeObject(mensaje);
            salida.flush();   
            System.out.println("cliente envió el mensaje");
        }catch(IOException e){
            System.out.println("Error en enviar mensaje");
        }
    }

    public ArrayList procesarConexion(){
        ArrayList mensaje = new ArrayList(0);
             try{
                 System.out.println("cuando igual el array");
                 mensaje= (ArrayList) entrada.readObject();
                 System.out.println("despues de igualar el array");
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
    
}