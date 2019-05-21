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

    
    public static ArchivoConfiguracion archivoParam; 
    public static AmbienteGUI ventana;
    public static boolean abrirAmbienteGUI =false;   
    
    public Servidor servidor=null;
    public Thread   treadServidor=null;
    
    public static MensajeInicial mensajeInicial;
    
    public static int TamanioTableroYLocal = 0;
    public static int TamanioTableroXLocal = 0;
    public static int TamanioTableroYRemoto = 0;
    public static int TamanioTableroXRemoto = 0;
    public static String IPContrincante ="";
    public static String PuertoComunicacion = "";
    public static String NombreLocal = "";
    public static String NombreRemoto="";
    public static int TipoPersonajeLocal = 0;
    public static int TipoPersonajeRemoto = 0;
    
    
    
    /**
     * @param args the command line arguments
     */
    
    
    /*public static void main(String[] args) {

        
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AmbienteGUI ventana;
                ventana= new AmbienteGUI();
                ventana.setVisible(true);
                ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);   
                ventana.setResizable(false);
            }
        });
    }*/
    
    public static void main(String args[]) {
        
        archivoParam = new ArchivoConfiguracion();
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ParametrosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParametrosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParametrosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParametrosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ParametrosGUI().setVisible(true);
            }
        });
       
        
        
    }

    
    
}
