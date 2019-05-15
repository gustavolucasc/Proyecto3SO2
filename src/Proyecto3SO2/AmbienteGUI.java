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

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.RED;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author glucas & rperez
 */


public class AmbienteGUI extends JFrame implements Observer{
    
    public  String TAMANIOTABLEROX = Inicial.archivo.readPropertie("TamanoTableroX");
    public  String TAMANIOTABLEROY = Inicial.archivo.readPropertie("TamanoTableroY");

    private final JPanel PanelTitulares    = new JPanel();
    private final JPanel PanelPrincipal = new JPanel();
    private final JPanel PanelInformativo = new JPanel();
    private final JPanel PanelControles    = new JPanel();
    @SuppressWarnings("FieldMayBeFinal")
    private PanelTitulos panelTitulos;
    @SuppressWarnings("FieldMayBeFinal")
    private PanelChat panelChat;
    @SuppressWarnings("FieldMayBeFinal")
    private PanelControl panelControl;
    private TableroGUI tableroGUI,tableroGUI2;
    
    
    String IPContrincante ="";
    
    @SuppressWarnings("FieldMayBeFinal")
    private PanelInformacion panelEquipo1 = new PanelInformacion();
    @SuppressWarnings("FieldMayBeFinal")
    private   PanelInformacion panelEquipo2 = new PanelInformacion();

    
    
    public AmbienteGUI() {
        
        setContentPane(new JLabel(new ImageIcon("src/Proyecto3SO2/iconos/nuevos/fondo.png")));
        setLayout(new FlowLayout());
        initComponents();
        
        Servidor s = new Servidor(5000);
        s.addObserver(this);
        Thread t  = new Thread(s);
        t.start();
   
    }
    
      @Override
    public Dimension size() {
        return super.size(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private void initComponents() {
        
        IPContrincante= Inicial.archivo.readPropertie("ip_contrincante");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        Toolkit mipantalla = Toolkit.getDefaultToolkit();
	setTitle("Proyecto 3 Sistemas Operativos 2");
    
        // Setea el icono de la ventana
        Image miicono = mipantalla.getImage("src/Proyecto3SO2/iconos/nuevos/XYZ.png");
	setIconImage(miicono);
        
        
        panelTitulos= new PanelTitulos();
        panelChat = new PanelChat(IPContrincante);
        panelControl = new PanelControl();
        tableroGUI = new TableroGUI(Integer.parseInt(TAMANIOTABLEROX),Integer.parseInt(TAMANIOTABLEROY),1,this);
        tableroGUI2 = new TableroGUI(Integer.parseInt(TAMANIOTABLEROX),Integer.parseInt(TAMANIOTABLEROY),2,this);
         
                
        FlowLayout layout = new FlowLayout();
        
        getContentPane().setLayout(layout);  
        
        layout.setAlignment(FlowLayout.CENTER);
             
        PanelPrincipal.setBackground(new Color(0,0,0,150));
        PanelInformativo.setBackground(new Color(254,0,0,0));
        PanelControles.setBackground(new Color(254,0,0,0));
        PanelTitulares.setBackground(new Color(254,0,0,0));
        
        getContentPane().add(PanelTitulares); 
        getContentPane().add(PanelPrincipal);
        getContentPane().add(PanelInformativo);
        getContentPane().add(PanelControles);
        
        PanelTitulares.add(panelTitulos);
        PanelPrincipal.add(tableroGUI);
        PanelPrincipal.add(tableroGUI2);
        PanelInformativo.add(panelChat);
        PanelControles.add(panelControl);
       
        pack();
        //setResizable(false);
        setLocationRelativeTo(null);
        
    }
  
    public  void setPanelInformacion(int equipoActual,CasillasGUI casillaActual){
        if (equipoActual==0){
            panelEquipo1.actualizaInformacionEquipo(1);
            panelEquipo2.actualizaInformacionEquipo(2);
        }
        else if (equipoActual == 1){
            panelEquipo1.actualizaInformacion(equipoActual,casillaActual);
            panelEquipo2.limpiaInformacionPersonaje();
            panelEquipo1.actualizaInformacionEquipo(equipoActual);
        }
        else {
            panelEquipo2.actualizaInformacion(equipoActual,casillaActual);
            panelEquipo1.limpiaInformacionPersonaje();
            panelEquipo2.actualizaInformacionEquipo(equipoActual);
            
        }
    }
    public void setPanelInformacionEquipo (int equipoActual){
        if (equipoActual == 1){
            panelEquipo1.creaespacioInformacionEquipo(equipoActual);
        }
        else {
            panelEquipo2.creaespacioInformacionEquipo(equipoActual);
        }
    }
    public  void clearPanelInformacionPersonaje(){
        panelEquipo1.limpiaInformacionPersonaje();
        panelEquipo2.limpiaInformacionPersonaje();
    }

    @Override
    public void update(Observable o, Object arg) {
        Mensaje mensaje = (Mensaje) arg;
        switch (mensaje.getTipo()){
            case 2: // tipo chat
                panelChat.setFldHistorial(panelChat.getFldHistorial()+ mensaje.getMensaje());
                break;
            default: 
                break;
        }
    }
                
   
}