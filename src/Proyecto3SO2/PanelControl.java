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


public class PanelControl extends JPanel {
    
    private JPanel panelinformacion;
    private JComboBox x,y;
    private JLabel lblip, lblPuerto, lblx, lbly;
    private JTextField ip, puerto;
    
    int tamTabX,tamTabY;

    private String[] tamTablero = {"5","6","7","8","9"};
    
    public PanelControl(){
        
        Component();
              
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
        String tempoX=Inicial.archivo.readPropertie("TamanoTableroX");
        tamTabX =Integer.parseInt(tempoX );
        String tempoY=Inicial.archivo.readPropertie("TamanoTableroY");
        tamTabY = Integer.parseInt(tempoY);
        x = new JComboBox(tamTablero);
        y = new JComboBox(tamTablero);
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
        
        //label ip
        lblip = new JLabel();
        Font tipoLetra = lblip.getFont();
        lblip.setText("IP remoto:");
        lblip.setForeground(Color.WHITE);
        lblip.setFont(new Font(tipoLetra.getName(),Font.PLAIN,18));
        panelinformacion.add(lblip, new AbsoluteConstraints(165, 18, 220, -1));
        
        //TextField ip
        ip = new JTextField("",20);
        ip.setText(Inicial.archivo.readPropertie("ip_contrincante"));
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
        puerto.setText(Inicial.archivo.readPropertie("puerto_comunicacion"));
        panelinformacion.add(puerto, new AbsoluteConstraints(330, 50, 70, -1));
        
        //TextField ip
        ip = new JTextField("",20);
        panelinformacion.add(ip, new AbsoluteConstraints(300, 20, 100, -1));
        
        //textBox
        lblx = new JLabel();
        tipoLetra = lblx.getFont();
        lblx.setText("X");
        lblx.setForeground(Color.WHITE);
        lblx.setFont(new Font(tipoLetra.getName(),Font.PLAIN,18));
        panelinformacion.add(lblx, new AbsoluteConstraints(25, 20, 40, -1));
        panelinformacion.add(x, new AbsoluteConstraints(40, 50, 40, -1));
        
        lbly = new JLabel();
        tipoLetra = lbly.getFont();
        lbly.setText("Y");
        lbly.setForeground(Color.WHITE);
        lbly.setFont(new Font(tipoLetra.getName(),Font.PLAIN,18));
        panelinformacion.add(lbly, new AbsoluteConstraints(25, 50, 40, -1));
        panelinformacion.add(y, new AbsoluteConstraints(40, 20, 40, -1));
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
       Inicial.archivo.writePropertie("TamanoTableroX",(String) x.getSelectedItem());
       Inicial.archivo.writePropertie("TamanoTableroY",(String) y.getSelectedItem());
   }
   
    
}
