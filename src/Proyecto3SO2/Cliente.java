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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author glucas & rperez
 */
public class Cliente implements Runnable {
    
    private Socket   enlaceServidor = null;
    
   
    private ObjectOutputStream salida;
    
    private Mensaje mensaje;

    
    public Cliente (String ipServidor, int puerto,Mensaje mensaje){
        this.mensaje = mensaje;
        try {
            enlaceServidor = new Socket(ipServidor,puerto);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
        public void cierraEnlaceServidor(){
        try {
            enlaceServidor.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
    public void  enviarMensaje (Mensaje mensajeSaliente){
        Mensaje respuesta = null;
        try {
            salida = new ObjectOutputStream(enlaceServidor.getOutputStream());
            salida.writeObject(mensajeSaliente);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void run() {
     
        
        enviarMensaje(mensaje);
        cierraEnlaceServidor();
    }
    
}
