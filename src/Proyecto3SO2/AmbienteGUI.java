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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static Proyecto3SO2.Inicial.*;
/**
 *
 * @author glucas & rperez
 */


public class AmbienteGUI extends JFrame implements Observer{
    
    
    
    public static final int EQUIPOREMOTO = 1;
    public static final int EQUIPOLOCAL = 2;
    
    // TIPOS DE MENSAJE 
    public static final int DISPARO=1;
    public static final int CHAT =2;
    public static final int ACERTADO =3;
    public static final int FALLO=-1;
    
    public  static int turnoDe =0;
    
    private final JPanel PanelPrincipal1 = new JPanel();
    private final JPanel PanelPrincipal2 = new JPanel();
    private final JPanel PanelInformativo = new JPanel();
    private final JPanel PanelControles    = new JPanel();
    @SuppressWarnings("FieldMayBeFinal")
    
    private PanelTituloGUI panelTitulos1;
    private PanelTituloGUI panelTitulos2;
    
    @SuppressWarnings("FieldMayBeFinal")
    private PanelChatGUI panelChat;
    @SuppressWarnings("FieldMayBeFinal")

    private TableroGUI tableroRemoto,tableroLocal;

    
    
    public AmbienteGUI() {
        
        setContentPane(new JLabel(new ImageIcon(AmbienteGUI.class.getResource("iconos/fondo.png"))));
        setLayout(new FlowLayout());
        
        initComponents();

        servidor.deleteObservers();
        servidor.addObserver(this);
        
        AsignadatosLocalesyRemotos();

    }
    
      @Override
    public Dimension size() {
        return super.size(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private void initComponents() {
        
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        Toolkit mipantalla = Toolkit.getDefaultToolkit();
	setTitle("Proyecto 3 Sistemas Operativos 2");
    
        // Setea el icono de la ventana
        Image miicono = mipantalla.getImage("iconos/logo.png");
	setIconImage(miicono);
        
        
        
        panelChat = new PanelChatGUI(this);
       
        panelTitulos1 = new PanelTituloGUI();
        panelTitulos2 = new PanelTituloGUI();
        tableroRemoto = new TableroGUI(TamanioTableroXRemoto,TamanioTableroYRemoto,EQUIPOREMOTO,this);
        tableroLocal = new TableroGUI(TamanioTableroXLocal,TamanioTableroYLocal,EQUIPOLOCAL,this);
         
                
        FlowLayout layout = new FlowLayout();
        
        getContentPane().setLayout(layout);  
        
        
        panelTitulos1.setBackground(new Color(254,0,0,0));     
        panelTitulos2.setBackground(new Color(254,0,0,0));
        PanelPrincipal1.setBackground(new Color(0,0,0,150));
        PanelPrincipal2.setBackground(new Color(0,0,0,150));
        PanelInformativo.setBackground(new Color(254,0,0,0));
        PanelControles.setBackground(new Color(254,0,0,0));
        
        PanelPrincipal1.setPreferredSize(new java.awt.Dimension(460,510));
        PanelPrincipal2.setPreferredSize(new java.awt.Dimension(460,510));
        
        
        getContentPane().add(PanelPrincipal1);
        getContentPane().add(PanelPrincipal2);
        getContentPane().add(PanelInformativo);
        
        PanelPrincipal1.add(panelTitulos1);
        PanelPrincipal1.add(tableroRemoto);
        
        PanelPrincipal2.add(panelTitulos2);
        PanelPrincipal2.add(tableroLocal);
        
        PanelInformativo.add(panelChat);
        
        pack();
        //setResizable(false);
        setLocationRelativeTo(null);
        
    }
  
    public static  void transmitirMensaje (Mensaje m){
       Cliente c = new Cliente(IPContrincante,PuertoSaliente,m);
       Thread t  = new Thread(c);
       t.start();
    }

    private void ImprimeTurno(){
        if (turnoDe == EQUIPOLOCAL){
            panelTitulos1.setAccion("Espera");
            panelTitulos2.setAccion("Atacando");
            
        } else {
            panelTitulos2.setAccion("Espera");
            panelTitulos1.setAccion("Atacando");
        }
    }
    
    private void AsignadatosLocalesyRemotos(){
        // Remoto
        panelTitulos1.setNombre(NombreRemoto);
        // Local
        panelTitulos2.setNombre(NombreLocal);
        
        //Define el turno
        turnoDe = (AleatorioLocal>AleatorioRemoto)?EQUIPOLOCAL:EQUIPOREMOTO;
        
        ImprimeTurno();
        
    }
    public void CambiarTurno(){


        if (turnoDe == 1)
            turnoDe = 2;
        else turnoDe =1;

        ImprimeTurno();

    }
    
    private String FondoLibre(){
      String resultado="";
           resultado = (TipoPersonajeRemoto==BARCOS)?"iconos/fondoMar.png":"iconos/fondoAire.png";
      return resultado;
    };
    
    @Override
    public void update(Observable o, Object arg) {
        Mensaje mensaje = (Mensaje) arg;
        Personaje personaje = null;
        switch (mensaje.getTipo()){
            case DISPARO:
                    personaje = tableroLocal.validaDisparo(mensaje.getX(),mensaje.getY());
                    if (personaje != null){
                        transmitirMensaje(new Mensaje(ACERTADO,mensaje.getX(),mensaje.getY(),personaje));
                        tableroLocal.eliminaPersonaje(mensaje.getX(),mensaje.getY());
                    } else {
                        transmitirMensaje(new Mensaje(FALLO,mensaje.getX(),mensaje.getY()));
                        
                    }
                    CambiarTurno();
                break;
            case CHAT: // tipo chat
                panelChat.setFldHistorial(panelChat.getFldHistorial()+"Remoto: "+ mensaje.getMensaje());
                break;
            case ACERTADO:
                personaje = mensaje.getPersonaje();
                tableroRemoto.getCasillas()[mensaje.getX()][mensaje.getY()].setPersonaje(personaje);
                tableroRemoto.getCasillas()[mensaje.getX()][mensaje.getY()].setBloqueada(true);
                tableroRemoto.eliminaPersonaje(mensaje.getX(),mensaje.getY());
                tableroRemoto.setAccion(TableroGUI.SELECCIONAR);
                CambiarTurno();
                break;
            case FALLO:
                tableroRemoto.sonido("fallo");
                ImageIcon fondo=tableroRemoto.cargarFondo(FondoLibre());
                tableroRemoto.pintar(mensaje.getX(),mensaje.getY(),fondo);
                tableroRemoto.getCasillas()[mensaje.getX()][mensaje.getY()].setBloqueada(true);
                tableroRemoto.setAccion(TableroGUI.SELECCIONAR);
                CambiarTurno();
                break;
            default: 
                break;
        }
        
        
    }
                
   
}
