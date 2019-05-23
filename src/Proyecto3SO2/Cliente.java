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
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Proyecto3SO2.Inicial.*;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author glucas & rperez
 */
public class Cliente implements Runnable {

    private Socket enlaceServidor = null;
    private int puerto = 0;
    private String ipServidor = "";

    private ObjectOutputStream salida;

    private Object mensaje;

    public Cliente(String ipServidor, int puerto, Object mensaje) {
        this.mensaje = mensaje;
        this.ipServidor = ipServidor;
        this.puerto = puerto;

        enlaceServidor = new Socket();

    }

    public void cierraEnlaceServidor() {
        try {
            enlaceServidor.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarMensaje(Object mensajeSaliente) {
        boolean salir=false;

        do {
            try {
                System.out.println("Enviando mensaje: "+NombreLocal);
                enlaceServidor.connect(new InetSocketAddress(ipServidor, puerto), 10000);
                salida = new ObjectOutputStream(enlaceServidor.getOutputStream());
                salida.writeObject(mensajeSaliente);
                if (mensajeSaliente instanceof MensajeInicial) {
                    mensajeInicialEnviado = true;
                }
                Bitacora bitacora = new Bitacora(mensajeSaliente.toString(),true);
            } catch (SocketTimeoutException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.INFO, "No Pudo conectarse con el Servidor");
                enlaceServidor = new Socket();
                
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                enlaceServidor = new Socket();
            }
            try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException ex1) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex1);
                }
        } while (!mensajeInicialEnviado && (mensajeSaliente instanceof MensajeInicial));

    }

    @Override
    public void run() {

        enviarMensaje(mensaje);
        cierraEnlaceServidor();
    }

}
