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


import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;


public class PanelChat extends JPanel {
    
    private JTextArea fldMensaje;
    private JTextArea  fldHistorial;


    private JButton btnEnviar;
    private String ipDestino;
  
   

    
    public PanelChat(String ip){
        
        Component();
        
        this.ipDestino = ip;
              
    }

    public void setFldHistorial(String fldHistorial) {
        this.fldHistorial.setText( fldHistorial);
    }
    public String getFldHistorial() {
        return fldHistorial.getText();
    }
    
    @SuppressWarnings("empty-statement")
    public void Component() {
      JPanel panelinformacion;
      panelinformacion = new JPanel();
        
      fldMensaje  = new JTextArea();
      fldHistorial = new JTextArea();
      btnEnviar = new JButton();

        panelinformacion.setBackground(new Color(0,0,0,122));
        panelinformacion.setLayout(new AbsoluteLayout());
 
        fldHistorial.setEditable(false);
        JScrollPane scrollpane = new JScrollPane(fldHistorial);
        panelinformacion.add(scrollpane, new AbsoluteConstraints(30, 20, 350, 350));
        
        JScrollPane scrollpane1 = new JScrollPane(fldMensaje);
        panelinformacion.add(scrollpane1, new AbsoluteConstraints(30, 400, 250, 50));
        
        panelinformacion.add(btnEnviar, new AbsoluteConstraints(300, 410, 75, 30));
        
        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });
        
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelinformacion, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelinformacion, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

    
        
    }   
    
    
    
    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {                                               
       String mensajetxt = fldMensaje.getText()+"\n";
       
       fldHistorial.append(mensajetxt);
       
       Mensaje mensaje = new Mensaje(2,mensajetxt);
       
       Cliente c = new Cliente(ipDestino,5000,mensaje);
       Thread t  = new Thread(c);
       t.start();
       
    }    
          
   
}
