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
import javax.swing.*;
public class TableroGUI extends javax.swing.JPanel {

 
    public static final int SELECCIONAR = 1;
    public static final int SELECCIONARDESTINO = 2;
    public static final int ATACAR = 3;
    private final int LADOCASILLA=50;
    //private final int INTEGRANTESEQUIPO=10;
    
    private int casillasTablerox=0;
    private int casillasTableroy=0;
 
    private CasillasGUI [][] casillas ;
    private int ladoTablerox,ladoTableroy;
    
    private AmbienteGUI ambienteGUI;
    
    private ImageIcon nomarcado, marcado;
    
    private CasillasGUI casillaOrigen;
    public  int turnoDe =1;
    public  int accion = SELECCIONAR;
    
    public int equipo =1 ;


 
    
    
    
    
    
    public TableroGUI(int equipo) {
        this.equipo = equipo;
        initComponents();
    }
    public TableroGUI(int sizex,int sizey, int equipo, AmbienteGUI a) {
        this.equipo = equipo;
        turnoDe=equipo;
        ambienteGUI = a;
        casillasTablerox = sizex;
        casillasTableroy = sizey;
        initComponents();
        int x,y;
        setLayout(new java.awt.GridLayout(sizex, sizey));
        
        cargarImagenes();
        casillas = new CasillasGUI[sizex][sizey];
        for (int i = 0; i < sizex; i++){
            for (int j = 0; j < sizey; j++){
                casillas[i][j] = new CasillasGUI(this);
                /*
                 * Asignación Inicial de imagen de 
                */                
                casillas[i][j].setFondo(nomarcado);
                x = (i * LADOCASILLA);
                y = (j * LADOCASILLA);
                casillas[i][j].setBounds(x, y, LADOCASILLA-1, LADOCASILLA-1);
                
                /*
                  Crea cada casilla en el tablero
                */
                this.add(casillas[i][j]);
            }
        }
        posicionaEquipos();
    }
    private void initComponents() {
        ladoTablerox =  casillasTablerox * LADOCASILLA;
        ladoTableroy =  casillasTableroy * LADOCASILLA;
        
        setLayout(null);
        setBackground(new java.awt.Color(254, 254, 254));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(ladoTableroy+1, ladoTablerox+1));
        
        if (equipo == 1 ){
            Personaje.creaListadePersonajes1();
            Personaje.creaEquipo(1);
            ambienteGUI.setPanelInformacionEquipo(1);
               
        } else {
            Personaje.creaListadePersonajes2();
            Personaje.creaEquipo(2);
            ambienteGUI.setPanelInformacionEquipo(2); 
        }
    }           
    
/* Atributos de Personajes */
    //public ArrayList <Personaje> personajesDisponibles = new ArrayList<Personaje>();    
    //public static ArrayList <Personaje> equipos = new ArrayList<Personaje>();

    public AmbienteGUI getAmbienteGUI() {
        return ambienteGUI;
    }

    
    
    public int getAccion() {
        return accion;
    }

    public void setAccion(int accion) {
        this.accion = accion;
    }
    
    /*public static ArrayList<Personaje> getEquipos() {
        return equipos;
    }*/
    
    public int getTurnoDe() {
        return turnoDe;
    }

    public void setTurnoDe(int turnoDe) {
        this.turnoDe = turnoDe;
    }

    public ImageIcon getNoMarcado() {
        return nomarcado;
    }

    public ImageIcon getMarcado() {
        return marcado;
    }

    public CasillasGUI getCasillaOrigen() {
        return casillaOrigen;
    }

    public void setCasillaOrigen(CasillasGUI casillaOrigen) {
        this.casillaOrigen = casillaOrigen;
    }

    

    
    public void pintar(int x, int y,ImageIcon Imagen){
        this.casillas[x][y].setFondo(Imagen); 
        this.repaint();
    }
    
    private void cargarImagenes() {
        this.nomarcado = this.cargarFondo("iconos/suelo1.png");
        this.marcado = this.cargarFondo("iconos/marcado.gif");
    }
    private ImageIcon cargarImagenes(String nomImagen) {
        return this.cargarFondo(nomImagen);
        
    }
    protected static ImageIcon cargarFondo(String ruta) {
        java.net.URL localizacion = TableroGUI.class.getResource(ruta);
        if (localizacion != null) {
            return new ImageIcon(localizacion);
        } else {
            System.err.println("No se ha encontrado el archivo: " + ruta);
            return null;
        }
    }
    
    public int[] getCoordenadas(CasillasGUI casilla) {
        int [] coordenadas = new int[2];
        for (int i=0; i < casillasTablerox; i++) {
            for (int j=0; j < casillasTableroy; j++) {
                if (this.casillas[i][j] == casilla) {
                    coordenadas[0] = i;
                    coordenadas[1] = j;
                }
            }
        }
        return coordenadas;
    }
    
    public CasillasGUI[][] getCasillas() {
        return casillas;
    }
    
    public void setCasillas(CasillasGUI[][] casillas) {
        this.casillas = casillas;
    }
    
 
/*
* Metodos de Personajes    
*/    
public void cambiarTurno(){
    
    
    if (turnoDe == 1)
        turnoDe = 2;
    else turnoDe =1;
    
    turnoDe=this.equipo;
}


private void posicionaEquipos(){
    for (int i=0;i < Equipo.equipos.size();i++){
        if (Equipo.equipos.get(i).equipo ==equipo){
           Personaje personaje=Equipo.equipos.get(i);
        int x =  (int) (Math.random()*casillasTablerox);
        int y =  (int) (Math.random()*casillasTableroy);
        if (casillas[x][y].getPersonaje()==null){
            casillas[x][y].setPersonaje(personaje);
            casillas[x][y].setFondo(casillas[x][y].getPersonaje().Icono);
        }
        else 
            i--; 
        }
        
    }
}


}
