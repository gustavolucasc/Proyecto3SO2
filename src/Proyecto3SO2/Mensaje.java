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

import java.io.Serializable;

/**
 *
 * @author glucas & rperez
 */
class Mensaje implements Serializable{
    
    private int tipo;
     /*
      -1 FALLO
      0  exito 
      1  disparo
      2  mensaje chat
    */
    private String mensaje;
    private int x;
    private int y;
    private Personaje personaje=null;

    public Mensaje(int tipo, String mensaje, int x, int y) {
        this.tipo = tipo;
        this.mensaje = mensaje;
        this.x = x;
        this.y = y;
    }
    public Mensaje (int tipo, int x,int y){
        this.tipo = tipo;
        this.x = x;
        this.y = y;
    }
     public Mensaje(int tipo, String mensaje) {
        this.tipo = tipo;
        this.mensaje = mensaje;
  
    }

    public Mensaje(int tipo, int x, int y, Personaje personaje) {
        this.tipo = tipo;
        this.x = x;
        this.y = y;
        this.personaje = personaje;
    }
    

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Personaje getPersonaje() {
        return personaje;
    }
        
    
}
