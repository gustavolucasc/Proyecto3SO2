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

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;


public class PanelTitulosGUI extends JPanel {
    
    private JPanel panelinformacion;
    private JLabel lblNombre1, lblAccion1,lblPunteo1;
    private JLabel lblNombre2, lblAccion2,lblPunteo2;
    private JLabel lblTituloChat;
    
    
    
    public PanelTitulosGUI(){
        
        Component();
              
    }
    
    
    @SuppressWarnings("empty-statement")
    public void Component() {

        panelinformacion = new JPanel();  
        lblNombre1= new JLabel(); lblAccion1= new JLabel();lblPunteo1= new JLabel();
        lblNombre2= new JLabel(); lblAccion2= new JLabel();lblPunteo2= new JLabel();   
        lblTituloChat= new JLabel(); 
 
        Font tipoLetra = lblNombre1.getFont();
        
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
                .addComponent(panelinformacion, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        
        
        lblNombre1.setText("Jugador 1");
        lblNombre1.setForeground(Color.WHITE);
        lblNombre1.setFont(new Font(tipoLetra.getName(),Font.PLAIN,18));
        panelinformacion.add(lblNombre1, new AbsoluteConstraints(20, 10, 80, -1));
        
        
        lblNombre1.setFont(new Font(tipoLetra.getName(),Font.PLAIN,18));
        
        lblAccion1.setText("Acción 1");
        lblAccion1.setForeground(Color.WHITE);
        lblAccion1.setFont(new Font(tipoLetra.getName(),Font.PLAIN,18));
        panelinformacion.add(lblAccion1,new AbsoluteConstraints(250, 10, 80, -1));
        
        lblPunteo1.setText("Punteo 1");
        lblPunteo1.setForeground(Color.WHITE);
        lblPunteo1.setFont(new Font(tipoLetra.getName(),Font.BOLD,18));
        panelinformacion.add(lblPunteo1,new AbsoluteConstraints(350, 10, 80, -1));
        
         panelinformacion.setBackground(new Color(254,0,0,0));
         

        //panelinformacion.setBackground(new Color(0,0,0,122));

        //jugador 2
        lblNombre2.setText("Jugador 2");
        lblNombre2.setForeground(Color.WHITE);
        lblNombre2.setFont(new Font(tipoLetra.getName(),Font.PLAIN,18));
        panelinformacion.add(lblNombre2, new AbsoluteConstraints(500, 10, 80, -1));
        
        
        lblNombre1.setFont(new Font(tipoLetra.getName(),Font.PLAIN,18));
        
        lblAccion2.setText("Acción 2");
        lblAccion2.setForeground(Color.WHITE);
        lblAccion2.setFont(new Font(tipoLetra.getName(),Font.PLAIN,18));
        panelinformacion.add(lblAccion2,new AbsoluteConstraints(700, 10, 80, -1));
        
        lblPunteo2.setText("Punteo 2");
        lblPunteo2.setForeground(Color.WHITE);
        lblPunteo2.setFont(new Font(tipoLetra.getName(),Font.BOLD,18));
        panelinformacion.add(lblPunteo2,new AbsoluteConstraints(850, 10, 80, -1));
        
         panelinformacion.setBackground(new Color(0,0,0,100));
    
        
    }                      

    
    public void actualizaInformacion(int equipoActual,CasillasGUI casillaActual){
        // asignar la informacion del personaje seleccionado
        if (casillaActual.getPersonaje() != null){
            
            
            
        }
        
        // recorer el ArrayList de equipos y sacar estadisticas de equipo
    }
    
   public void creaespacioInformacionEquipo( int equipoActual ){
       int col =0;
       int i=0;
       String nombre;
  
   
       for (Estadistica estadistica: Equipo.estadisticas)  
           if (estadistica.getEquipo()== equipoActual){
               nombre= estadistica.getPersonaje().nombrePersonaje;
               ;
               col++;
           }
       String fila[] = new String[col];
       
       for (Estadistica estadistica: Equipo.estadisticas)   {
          if (estadistica.getEquipo()== equipoActual){   
             fila[i]=String.valueOf(estadistica.getCantidad());
             i++;
          }
       }
}
    
    public void actualizaInformacionEquipo(int equipoActual){
        
    }
    
    public  void limpiaInformacionPersonaje(){
  }    
   
}
