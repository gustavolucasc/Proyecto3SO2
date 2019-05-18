/*
 * UNIVERSIDAD MARIANO GALVEZ
 * INGENIERIA DE SISTEMAS DE INFORMACION
 * SISTEMAS OPERATIVOS 2
 * Gustavo Adolfo Lucas Cifuentes
 * 7690-17-2810
 * Ronal Geovani Perez Atz
 * 7690-14-11506
 * Proyecto 3 
 * Primer  Semestre 2019
 */
package Proyecto3SO2;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author glucas & rperez
 */
public class Servidor extends Observable implements Runnable{
    
    private ServerSocket servidor = null;
    private Socket   enlaceCliente = null;

    private int puerto;
    
    
    
    private ObjectInputStream entrada;
    
    
    public Servidor (int puerto){
        this.puerto = puerto;
    }


    public Socket getEnlaceCliente() {
        return enlaceCliente;
    }
    
    
    private  void IniciaServidor (){
        try {
            this.servidor = new ServerSocket(puerto);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    private void AceptaCliente (){
        try {
            enlaceCliente = servidor.accept();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  void cierraEnlaceCliente(Socket enlaceCliente){
        try {
            if (enlaceCliente==null){
                servidor.close();
            } else {
                enlaceCliente.close();
                servidor.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private Mensaje esperaMensaje (){
        Mensaje respuesta = null;
        try {
            entrada = new ObjectInputStream(enlaceCliente.getInputStream());
            respuesta = (Mensaje) entrada.readObject();
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return respuesta; 
    }
   

    @Override
    public void run() {
        boolean nosalir = true;
        IniciaServidor();
        while (nosalir){
            
            AceptaCliente();
            if (servidor!=null){
            Mensaje MensajeEntrante = esperaMensaje();
            
            this.setChanged();
            this.notifyObservers(MensajeEntrante);
            this.clearChanged();
            } else {
                nosalir = false;
            }
            
        }
    }
    
}
