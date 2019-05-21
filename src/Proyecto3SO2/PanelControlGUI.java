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
//
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;


public class PanelControlGUI extends JPanel {
    
    private JPanel panelinformacion;
    private JComboBox x,y;
    private JComboBox seleccionaPersonaje;
    private JLabel lblip, lblPuerto, lblx, lbly, lblNombre;
    private JTextField ip, puerto, nombreJugador;
    private JButton enlace;
    private AmbienteGUI ambiente;
    
    int tamTabX,tamTabY;

    private Servidor s=null;
    private Thread t=null;
    
    private static final String[] TAMTABLERO = {"5","6","7","8","9"};
    private static final String[] TIPOPERSONAJES = {"Aviones","Barcos"};
    
    public PanelControlGUI(AmbienteGUI ambiente){
        this.ambiente = ambiente;
        Component();
              
    }
    
    public String getIPRemoto (){
        String ipString = ip.getText();
        return (ipString);
    }

    public int getPuerto(){
        return Integer.parseInt(puerto.getText());
    }    
    @SuppressWarnings("empty-statement")
    public void Component() {

        panelinformacion = new JPanel();
        panelinformacion.setBackground(new Color(0,0,0,122));
        panelinformacion.setLayout(new AbsoluteLayout());
 
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelinformacion, GroupLayout.DEFAULT_SIZE, 1325, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelinformacion, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

      // Creacion del Combo Box de las posiciones X y Y
        String tempoX=Inicial.archivoParam.readPropertie("TamanoTableroX");
        tamTabX =Integer.parseInt(tempoX );
        String tempoY=Inicial.archivoParam.readPropertie("TamanoTableroY");
        tamTabY = Integer.parseInt(tempoY);
        x = new JComboBox(TAMTABLERO);
        y = new JComboBox(TAMTABLERO);
        x.setSelectedItem(tempoX);
        y.setSelectedItem(tempoY);
        x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });
        y.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });
        
        // Seleccion de Personaje
        String tempoPersonaje=Inicial.archivoParam.readPropertie("TipoPersonaje");
        seleccionaPersonaje = new JComboBox(TIPOPERSONAJES);
        seleccionaPersonaje.setSelectedItem(tempoPersonaje);
        
        
        
        
        
        //label ip
        lblip = new JLabel();
        Font tipoLetra = lblip.getFont();
        lblip.setText("IP remoto:");
        lblip.setForeground(Color.WHITE);
        lblip.setFont(new Font(tipoLetra.getName(),Font.PLAIN,18));
        panelinformacion.add(lblip, new AbsoluteConstraints(165, 18, 220, -1));
        
        //TextField ip
        ip = new JTextField("",20);
        ip.setText(Inicial.archivoParam.readPropertie("ip_contrincante"));
        panelinformacion.add(ip, new AbsoluteConstraints(300, 20, 100, -1));
        
        //label puerto
        lblPuerto = new JLabel();
        tipoLetra = lblPuerto.getFont();
        lblPuerto.setText("Puerto comunicación:");
        lblPuerto.setForeground(Color.WHITE);
        lblPuerto.setFont(new Font(tipoLetra.getName(),Font.PLAIN,18));
        panelinformacion.add(lblPuerto, new AbsoluteConstraints(165, 48, 220, -1));
        
        //TextField puerto
        puerto = new JTextField("",20);
        puerto.setText(Inicial.archivoParam.readPropertie("puerto_comunicacion"));
        panelinformacion.add(puerto, new AbsoluteConstraints(330, 50, 70, -1));
        
        //TextField ip
        //ip = new JTextField("",20);
        //panelinformacion.add(ip, new AbsoluteConstraints(300, 20, 100, -1));
        
        //textBox
        lblx = new JLabel();
        lblx.getFont();
        lblx.setText("X");
        lblx.setForeground(Color.WHITE);
        lblx.setFont(new Font(tipoLetra.getName(),Font.PLAIN,18));
        panelinformacion.add(lblx, new AbsoluteConstraints(25, 20, 40, -1));
        panelinformacion.add(x, new AbsoluteConstraints(40, 50, 40, -1));
        
        lbly = new JLabel();
        lbly.getFont();
        lbly.setText("Y");
        lbly.setForeground(Color.WHITE);
        lbly.setFont(new Font(tipoLetra.getName(),Font.PLAIN,18));
        panelinformacion.add(lbly, new AbsoluteConstraints(25, 50, 40, -1));
        panelinformacion.add(y, new AbsoluteConstraints(40, 20, 40, -1));
        
        //nombre del jugador
        lblNombre = new JLabel();
        lblNombre.getFont();
        lblNombre.setText("Nombre jugador:");
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setFont(new Font(tipoLetra.getName(),Font.PLAIN,18));
        panelinformacion.add(lblNombre, new AbsoluteConstraints(448, 20, 200, -1));
        nombreJugador = new JTextField("",20);
        panelinformacion.add(nombreJugador, new AbsoluteConstraints(600, 23, 120, -1));
        
        //
        enlace = new JButton();
        panelinformacion.add(enlace, new AbsoluteConstraints(1207, 20, 90, -1));
        enlace.setText("Conectar");
         enlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnlacePerformed(evt);
            }
        });
    }                      

    
    public void actualizaInformacion(int equipoActual,CasillasGUI casillaActual){
    }
    
   public void creaespacioInformacionEquipo( int equipoActual ){
   }
    
    public void actualizaInformacionEquipo(int equipoActual){
    }
    
    public  void limpiaInformacionPersonaje(){
  
    }    
   private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt){
       Inicial.archivoParam.writePropertie("TamanoTableroX",(String) x.getSelectedItem());
       Inicial.archivoParam.writePropertie("TamanoTableroY",(String) y.getSelectedItem());
   }
   
    private void jButtonEnlacePerformed(java.awt.event.ActionEvent evt) { 
       
       
       
       
       if (enlace.getText()=="Conectar"){
        s = new Servidor(getPuerto());
        s.addObserver(ambiente);
         t  = new Thread(s);
        t.start(); 
        enlace.setText("Desconectar");
       } else {
        s.cierraEnlaceCliente(s.getEnlaceCliente());
        t.interrupt();
        enlace.setText("Conectar");
       }
    }  
}
