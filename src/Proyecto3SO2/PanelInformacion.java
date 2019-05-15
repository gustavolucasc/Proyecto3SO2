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


public class PanelInformacion extends JPanel {
    
    private JLabel textoPersonaje, textoArma, textoArmadura, textoFuerza, textoVida, textoMagia, textoElemento, textoAlcance, textoEquipo;
    private JTextField personaje, fuerza, arma, armadura, vida, magia, elemento, alcance, equipo;
    private JPanel panelinformacion, imagen;
    private JButton imagen2;
    private JScrollPane jScrollPane1;
    private JTable tabla;
    private DefaultTableModel modelo ;
    private int i;
    
    public PanelInformacion(){
        
        Component();
              
    }
    
    
    @SuppressWarnings("empty-statement")
    public void Component() {

        panelinformacion = new JPanel();
        
        
        
        
        
        
        imagen = new JPanel();
        
        textoPersonaje = new JLabel();
        textoArma = new JLabel();
        textoArmadura = new JLabel();
        textoFuerza = new JLabel();
        textoVida = new JLabel();
        textoMagia = new JLabel();
        textoElemento = new JLabel();
        textoAlcance = new JLabel();
        textoEquipo = new JLabel();
        
        imagen2 = new JButton();
        personaje = new JTextField();
       
        fuerza = new JTextField();
        arma = new JTextField();
        vida = new JTextField();
        armadura = new JTextField();
        magia = new JTextField();
        elemento = new JTextField();
        alcance = new JTextField();
        equipo = new JTextField();
        
        jScrollPane1 = new JScrollPane();
        
        modelo = new DefaultTableModel();
        tabla = new JTable(modelo);
        
        
         
         

        panelinformacion.setBackground(new Color(0,0,0,122));
        panelinformacion.setLayout(new AbsoluteLayout());
 

        imagen2.setPreferredSize( new java.awt.Dimension(100, 100)); 
        panelinformacion.add(imagen2, new AbsoluteConstraints(21, 25, -1, -1));

        //Información personaje
        textoPersonaje.setForeground(new Color(132,192,199));
        textoPersonaje.setText("Personaje");
        panelinformacion.add(textoPersonaje, new AbsoluteConstraints(210, 60, 129, -1));
        panelinformacion.add(personaje, new AbsoluteConstraints(179, 87, 129, -1));
        personaje.setEditable(false);
        
           
        
        //información arma
        textoArma.setForeground(new Color(132,192,199));
        textoArma.setText("Arma");
        panelinformacion.add(textoArma, new AbsoluteConstraints(250, 205, 65, -1));
        panelinformacion.add(arma, new AbsoluteConstraints(230, 235, 79, -1));
        arma.setEditable(false);
        
        
        //información armadura
        textoArmadura.setForeground(new Color(132,192,199));
        textoArmadura.setText("Armadura");
        panelinformacion.add(textoArmadura, new AbsoluteConstraints(142, 135, 65, -1));
        panelinformacion.add(armadura, new AbsoluteConstraints(130, 167, 76, -1));
        armadura.setEditable(false);
        
        
        //información fuerza
        textoFuerza.setForeground(new Color(132,192,199));
        textoFuerza.setText("Fuerza");
        panelinformacion.add(textoFuerza, new AbsoluteConstraints(249, 135, 65, -1));
        panelinformacion.add(fuerza, new AbsoluteConstraints(230, 167, 76, -1));
        fuerza.setEditable(false);


        //información vida
        textoVida.setForeground(new Color(132,192,199));
        textoVida.setText("Vida");
        panelinformacion.add(textoVida, new AbsoluteConstraints(55, 135, 65, -1));
        panelinformacion.add(vida, new AbsoluteConstraints(32, 167, 76, -1));
        vida.setEditable(false);

              
        //información elemento
        textoElemento.setForeground(new Color(132,192,199));
        textoElemento.setText("Elemento");
        panelinformacion.add(textoElemento, new AbsoluteConstraints(140, 205, 65, -1));
        panelinformacion.add(elemento, new AbsoluteConstraints(130, 235, 76, -1));
        elemento.setEditable(false);

        
        //información magia
        textoMagia.setForeground(new Color(132,192,199));
        textoMagia.setText("Magia");
        panelinformacion.add(textoMagia, new AbsoluteConstraints(50, 205, 65, -1));
        panelinformacion.add(magia, new AbsoluteConstraints(32, 235, 76, -1));
        magia.setEditable(false);
        
        
        //iformación alcance
        textoAlcance.setForeground(new Color(132,192,199));
        textoAlcance.setText("Alcance");
        panelinformacion.add(textoAlcance, new AbsoluteConstraints(95, 275, 65, -1));
        panelinformacion.add(alcance, new AbsoluteConstraints(82, 305, 76, -1));
        alcance.setEditable(false);
        
        
        
        //infomación equipo
        textoEquipo.setForeground(new Color(132,192,199));
        textoEquipo.setText("Equipo");
        panelinformacion.add(textoEquipo, new AbsoluteConstraints(210, 275, 65, -1));
        panelinformacion.add(equipo, new AbsoluteConstraints(192, 305, 76, -1));
        equipo.setEditable(false);

        

        //Creamos un scrollpanel y se lo agregamos a la tabla 
        JScrollPane scrollpane = new JScrollPane(tabla);
        
        //Agregamos el scrollpanel al contenedor 
        //panelinformacion.add(scrollpane, BorderLayout.CENTER);
            
        panelinformacion.add(scrollpane, new AbsoluteConstraints(20, 350, 310, 40));
        //table.setBackground(new Color(0,0,0,122));
        //scrollpane.setBackground(new Color(0,0,0,122));
        
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelinformacion, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelinformacion, GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

    
        
    }                      

    
    public void actualizaInformacion(int equipoActual,CasillasGUI casillaActual){
        // asignar la informacion del personaje seleccionado
        if (casillaActual.getPersonaje() != null){
            personaje.setText(casillaActual.getPersonaje().nombrePersonaje);
            personaje.setHorizontalAlignment(JTextField.CENTER);
            
            
            
            imagen2.setIcon(new ImageIcon(casillaActual.getPersonaje().Icono.getImage().getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH)));
            
            
            
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
               modelo.addColumn(nombre);
               col++;
           }
       String fila[] = new String[col];
       
       for (Estadistica estadistica: Equipo.estadisticas)   {
          if (estadistica.getEquipo()== equipoActual){   
             fila[i]=String.valueOf(estadistica.getCantidad());
             i++;
          }
       }
       modelo.addRow(fila);
   }
    
    public void actualizaInformacionEquipo(int equipoActual){
      String nombre;
      String cantidad;
      int i=0;
      for (Estadistica estadistica: Equipo.estadisticas)  {
          if (estadistica.getEquipo()== equipoActual){
              nombre= estadistica.getPersonaje().nombrePersonaje;
              cantidad=String.valueOf(estadistica.getCantidad());
              tabla.setValueAt(cantidad,0,i);
              i++;
              // asignacion a la posicion de la tabla; dejar los datos centrados
              //fila 0 Nombres
              //fila 1 Cantidad 
             // JOptionPane.showMessageDialog(null, "Mensaje");
          }
      }
        
    }
    
    public  void limpiaInformacionPersonaje(){
  
        personaje.setText(""); 
        fuerza.setText("");
        arma.setText("");
        armadura.setText("");
        vida.setText(""); 
        magia.setText(""); 
        elemento.setText("");
        alcance.setText("");
        imagen2.setIcon(new ImageIcon(Personaje.cargarFondo("iconos/nuevos/blanco.png").getImage().getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH)));
    }    
   
}
