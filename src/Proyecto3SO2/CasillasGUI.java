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

import static Proyecto3SO2.AmbienteGUI.*;

public class CasillasGUI extends javax.swing.JPanel implements MouseListener {

    /* 
     * Constantes:
     */

    private TableroGUI tablero;
    private ImageIcon fondo;
    private ImageIcon nuevoFondo;

    private int[] casillaMarcada = new int[2];
    private boolean estaMarcada;
    public int clicks = 0;
    private boolean bloqueada = false;

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

    public boolean isBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
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

    public void setFondo(ImageIcon fondo) {
        this.fondo = fondo;
    }

    public ImageIcon getFondo() {
        return this.fondo;
    }

    private void setMarco() {
        int gruesoBorde = 2;

        if (this.isEstaMarcada()) {
            gruesoBorde = 5;
        }
        //this.setBorder(BorderFactory.createLoweredBevelBorder());

        if (personaje != null) {

            if (personaje.getEquipo() == 1) {
                this.setBorder(BorderFactory.createMatteBorder(
                        gruesoBorde, gruesoBorde, gruesoBorde, gruesoBorde, Color.blue));
            } else {
                this.setBorder(BorderFactory.createMatteBorder(
                        gruesoBorde, gruesoBorde, gruesoBorde, gruesoBorde, Color.RED));
            }
        } else if (this.isEstaMarcada()) {
            this.setBorder(BorderFactory.createLineBorder(Color.green));
        } else {
            this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setMarco();
        g.drawImage(fondo.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }

    public void mousePressed(MouseEvent e) {
        int[] casillaSeleccionada = tablero.getCoordenadas((CasillasGUI) e.getComponent());
        this.setCasillaMarcada(casillaSeleccionada);
        nuevoFondo = fondo; //fondo de tipo de terreno
        
            if (tablero.tablero == EQUIPOLOCAL) {
                if (!tableroLocalBloqueado)
                  ejecutaAccionLocal(casillaSeleccionada);
            } else {
                if (AmbienteGUI.turnoDe != tablero.tablero) {
                    
                    ejecutaAccionRemota(casillaSeleccionada);
                }
        }

        this.tablero.pintar(casillaMarcada[0], casillaMarcada[1], nuevoFondo);
    }

    private void ejecutaAccionRemota(int[] casillaSeleccionada) {
        
        //Acciones en el tablero Remoto 
        int x = casillaSeleccionada[0];
        int y = casillaSeleccionada[1];

        switch (tablero.accion) {
            case TableroGUI.SELECCIONAR:
                if (personaje == null) {
                    if (!bloqueada) {
                        tablero.setAccion(TableroGUI.ESPERARESPUESTA);
                        tableroLocalBloqueado = true;
                        transmitirMensaje(new Mensaje(DISPARO, x, y));
                    }
                }
                break;
            case TableroGUI.ESPERARESPUESTA:
                break;
            default:
                break;

        }
    }

    private void ejecutaAccionLocal(int[] casillaSeleccionada) {
        
        // Acciones en el tablero Local

        switch (tablero.accion) {
            case TableroGUI.SELECCIONAR:
                if (personaje != null) {
                    
                        if (estaMarcada) {
                            estaMarcada = false;
                            tablero.setCasillaOrigen(null);
                        } else {
                            estaMarcada = true;
                            tablero.setCasillaOrigen(this);
                            tablero.setAccion(TableroGUI.SELECCIONARDESTINO);
                            this.setCasillaMarcada(casillaSeleccionada);
                        }
                    
                }
                break;
            case TableroGUI.SELECCIONARDESTINO:
                if (this.equals(tablero.getCasillaOrigen())) {
                    tablero.setAccion(TableroGUI.SELECCIONAR);
                    ejecutaAccionLocal(casillaSeleccionada);
                    //mousePressed(e);
                } else if (personaje != null) {
                    
                    if (personaje.getEquipo() != tablero.getTurnoDe()) {
                        // No hace nada por que la casilla esta ocupada
                    }
                } else {
                    
                    personaje = tablero.getCasillaOrigen().personaje;
                    estaMarcada = false;
                    nuevoFondo = tablero.getCasillaOrigen().fondo;

                    tablero.getCasillaOrigen().personaje = null;
                    tablero.getCasillaOrigen().estaMarcada = false;

                    this.tablero.pintar(tablero.getCasillaOrigen().casillaMarcada[0], tablero.getCasillaOrigen().casillaMarcada[1],
                            fondo);

                    tablero.setCasillaOrigen(this);

                    tablero.setAccion(TableroGUI.SELECCIONAR);

                }

                break;
        }
    }

    public int[] getCasillaMarcada() {
        return casillaMarcada;
    }

    public void setCasillaMarcada(int[] aCasillaMarcada) {
        casillaMarcada = aCasillaMarcada;
    }

    public boolean validaCasilla(int[] casilla) {
        return (true);
    }

    public boolean equals(Object objeto) {
        boolean sonIguales = false;

        if ((objeto == null) || (getClass() != objeto.getClass())) {
            sonIguales = false;
        } else {
            CasillasGUI casilla = (CasillasGUI) objeto;
            if ((this.casillaMarcada[0] == casilla.getCasillaMarcada()[0])
                    && (this.casillaMarcada[1] == casilla.getCasillaMarcada()[1])) {
                sonIguales = true;
            } else {
                sonIguales = false;
            }

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
