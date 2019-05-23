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

import  java.io.*;
public class Bitacora {
    FileWriter  archivo = null;
    PrintWriter pw = null;
    
    boolean agrega = false;
    private String nomArchivo ="c:\\Temp\\bitacora.log";
    
    public Bitacora (String msj){
        this.agrega = false;
        procesaMensaje(msj);
    }
            
    public Bitacora (String msj, boolean agrega){
        this.agrega = agrega;
        procesaMensaje(msj);
       
    }
    private void procesaMensaje (String msj){
         try
        {
            archivo = new FileWriter("c:/prueba.txt",agrega);
            pw = new PrintWriter(archivo);
            pw.println(msj);

            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != archivo)
              archivo.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
}
