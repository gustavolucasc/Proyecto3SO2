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
import javax.swing.*;

public class CasillasGUI extends javax.swing.JPanel implements MouseListener {
    /* 
     * Constantes:
    */
    
    
    private TableroGUI tablero;
    private ImageIcon fondo;
    private ImageIcon nuevoFondo;
    
    private int [] casillaMarcada = new int[2];
    private boolean estaMarcada;
    public  int clicks = 0;
    

    
    private Personaje personaje; 
    
    
    public CasillasGUI() {        
        // este constructor no se usará, se deja para poder crear el bean.        
    }

    
    
    public CasillasGUI(TableroGUI t) {
        initComponents();        
        this.tablero = t;
        this.addMouseListener(this);
        
    }
    
    private void initComponents() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGap(0, 193, Short.MAX_VALUE)
        );
    }               

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }
    
    
    
    
    public boolean isEstaMarcada() {
        return estaMarcada;
    }
    
    public void setFondo(ImageIcon fondo){
        this.fondo = fondo;
    }
    
    public ImageIcon getFondo(){        
        return this.fondo;
    }
    
                          
            
    
    private void setMarco(){
    int gruesoBorde = 2;
    
    if (this.isEstaMarcada() )
        gruesoBorde = 5;
            //this.setBorder(BorderFactory.createLoweredBevelBorder());
    
    if (personaje!=null){
      
          if (personaje.getEquipo()== 1) 
            this.setBorder(BorderFactory.createMatteBorder(
                                    gruesoBorde,gruesoBorde ,gruesoBorde, gruesoBorde, Color.blue));
          else 
            this.setBorder(BorderFactory.createMatteBorder(
                                    gruesoBorde, gruesoBorde, gruesoBorde, gruesoBorde,Color.RED));
    }
    else 
        if (this.isEstaMarcada())
            this.setBorder(BorderFactory.createLineBorder(Color.green));
        else 
            this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    
        

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setMarco();
        g.drawImage(fondo.getImage(), 0,0,this.getWidth(),this.getHeight(),this);
    }
    

    public void mousePressed  (MouseEvent e){
        int [] casillaSeleccionada = tablero.getCoordenadas((CasillasGUI)e.getComponent());
        this.setCasillaMarcada(casillaSeleccionada);
        nuevoFondo = fondo; //fondo de tipo de terreno
              
        ejecutaAccion(casillaSeleccionada); 
        
        this.tablero.pintar(casillaMarcada[0],casillaMarcada[1],nuevoFondo);
    }
    
    
    private void ejecutaAccion (int [] casillaSeleccionada){
        
        switch (tablero.accion){
            case TableroGUI.SELECCIONAR:
                if (personaje != null) 
                    if (personaje.getEquipo() == tablero.getTurnoDe())
                        if (estaMarcada){
                            estaMarcada = false;
                            tablero.setCasillaOrigen(null);
                            tablero.getAmbienteGUI().clearPanelInformacionPersonaje();
                        } else {
                            estaMarcada = true;
                            tablero.setCasillaOrigen(this);
                            tablero.setAccion(TableroGUI.SELECCIONARDESTINO);
                            this.setCasillaMarcada(casillaSeleccionada);
                            tablero.getAmbienteGUI().setPanelInformacion(tablero.getTurnoDe(),this);
                        }
                break;
            case TableroGUI.SELECCIONARDESTINO: 
                if (this.equals (tablero.getCasillaOrigen())){
                    tablero.setAccion(TableroGUI.SELECCIONAR);
                    ejecutaAccion(casillaSeleccionada);
                    //mousePressed(e);
                }
                else
                   if (personaje != null) {
                       tablero.sonido("acerto");
                     if (personaje.getEquipo() != tablero.getTurnoDe()){
                         tablero.getCasillaOrigen().personaje.atacar(personaje);
                         if (personaje.getVida()== 0){
                             this.fondo = tablero.getNoMarcado();
                             this.nuevoFondo =tablero.getNoMarcado();
                             tablero.getCasillaOrigen().getPersonaje().deduceAEstadistica(personaje);
                             JOptionPane.showMessageDialog(null,tablero.getCasillaOrigen().getPersonaje().getNombrePersonaje()
                             +" a Eliminado a "+ personaje.getNombrePersonaje());
                             personaje = null;
                             
                         } else{
                             JOptionPane.showMessageDialog(null,tablero.getCasillaOrigen().getPersonaje().getNombrePersonaje()
                             +" a Atacado a "+ personaje.getNombrePersonaje() + " lo a herido dejando "+
                              personaje.getVida()+ "% de vida");
                         }
                         
                         tablero.getAmbienteGUI().setPanelInformacion(0,null);
                         
                         tablero.getCasillaOrigen().estaMarcada= false;
                         this.tablero.pintar(tablero.getCasillaOrigen().casillaMarcada[0],tablero.getCasillaOrigen().casillaMarcada[1],
                               tablero.getCasillaOrigen().fondo);
                         
                         tablero.cambiarTurno();
                         tablero.setAccion(TableroGUI.SELECCIONAR);
                     }
                   }
                   else {
                       tablero.sonido("fallo");
                       personaje = tablero.getCasillaOrigen().personaje;
                       estaMarcada = false;
                       nuevoFondo=tablero.getCasillaOrigen().fondo;
                       
                       tablero.getCasillaOrigen().personaje = null;
                       tablero.getCasillaOrigen().estaMarcada= false;
                       

                       this.tablero.pintar(tablero.getCasillaOrigen().casillaMarcada[0],tablero.getCasillaOrigen().casillaMarcada[1],
                               fondo);
                       
                       tablero.setCasillaOrigen(this);
                       
                       
                       tablero.setAccion(TableroGUI.SELECCIONAR);
                       
                   }
                         
                   
                break;
        }
    }
    
    
    
    public  int[] getCasillaMarcada() {
        return casillaMarcada;
    }
    public  void setCasillaMarcada(int[] aCasillaMarcada) {
        casillaMarcada = aCasillaMarcada;
    }                  
    
    
    public boolean validaCasilla (int [] casilla){
        return(true);
    }
    
    
    public boolean equals(Object objeto){
        boolean sonIguales  = false;
        
        if((objeto == null) || (getClass() != objeto.getClass()))
            sonIguales = false;
    
        else{
           CasillasGUI casilla = (CasillasGUI)objeto;
           if ( (this.casillaMarcada[0]== casilla.getCasillaMarcada()[0])&&
                (this.casillaMarcada[1]== casilla.getCasillaMarcada()[1])  )
            sonIguales=true;
           else
            sonIguales=false;
        
        }
        
    return sonIguales;    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

 
    
}