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

/**
 *
 * @author glucas & rperez
 */
import javax.swing.JFrame;
public class Inicial {

    
    public static ArchivoConfiguracion archivo; 
    
    
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        archivo = new ArchivoConfiguracion();
        
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AmbienteGUI ventana;
                ventana= new AmbienteGUI();
                ventana.setVisible(true);
                ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);   
                ventana.setResizable(false);
            }
        });
    }

    
    
}
