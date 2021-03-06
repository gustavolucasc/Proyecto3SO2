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
    
    public static Servidor servidor=null;
    public static Thread   threadServidor=null;
    
    public static MensajeInicial mensajeInicial;
    public static boolean  mensajeInicialEnviado=false;
    
    public static final  int AVIONES = 1;
    public static final  int BARCOS = 2;
    
    public static int TamanioTableroYLocal = 0;
    public static int TamanioTableroXLocal = 0;
    public static String IPContrincante ="";
    public static int PuertoEntrante = 0;
    public static int PuertoSaliente = 0;
    public static String NombreLocal = "";
    public static int TipoPersonajeLocal = 0;
    public static int TipoPersonajeRemoto = 0;
    public static String NombreRemoto="";    
    public static int TamanioTableroYRemoto = 0;
    public static int TamanioTableroXRemoto = 0;
    
    public static int AleatorioLocal=0;
    public static int AleatorioRemoto=0;
    
    
  
    
    public static void main(String args[]) {
        
        archivoParam = new ArchivoConfiguracion();
        String encabezado = "/*\n" +
        " * UNIVERSIDAD MARIANO GALVEZ\n" +
        " * INGENIERIA DE SISTEMAS DE INFORMACION\n" +
        " * SISTEMAS OPERATIVOS 2\n" +
        " * Gustavo Adolfo Lucas Cifuentes\n" +
        " * 7690-17-2810\n" +
        " * Ronal Geovani Perez Atz\n" +
        " * 7690-14-11506\n" +
        " * Proyecto 3 \n" +
        " * Primer  Semestre 2019\n" +
        " */\n\n" ;
        Bitacora bitacora = new Bitacora(encabezado + "Iniciamos el Juego\n"); 
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

    public static void LeeArchivoConfiguracion (){
        IPContrincante=archivoParam.readPropertie("ip_contrincante");
        PuertoEntrante=Integer.parseInt(archivoParam.readPropertie("PuertoEntrante"));
        PuertoSaliente=Integer.parseInt(archivoParam.readPropertie("PuertoSaliente"));
        TamanioTableroYLocal=Integer.parseInt(archivoParam.readPropertie("TamanoTableroX"));
        TamanioTableroXLocal=Integer.parseInt(archivoParam.readPropertie("TamanoTableroY"));
        TipoPersonajeLocal="Barcos".equals(archivoParam.readPropertie("TipoPersonaje"))?BARCOS:AVIONES;
        NombreLocal=archivoParam.readPropertie("NombreCapitan");
        
        // Eliminar cuando se tenga el paquete remoto de configuracion
//        TamanioTableroYRemoto= TamanioTableroXLocal;//mensajeInicial.getFilas();
//        TamanioTableroXRemoto=TamanioTableroXLocal;
//        TipoPersonajeRemoto=TipoPersonajeLocal;
    }
    
    
}
