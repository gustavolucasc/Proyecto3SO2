/*
 * UNIVERSIDAD MARIANO GALVEZ
 * INGENIERIA DE SISTEMAS DE INFORMACION
 * SISTEMAS OPERATIVOS 2
 *
 * Gustavo Adolfo Lucas Cifuentes
 * 7690-17-2810
 * Ronal Geovani Perez Atz
 * 7690-14-11506
 *
 * Proyecto 3 
 * Primer  Semestre 2019
 */
package Proyecto3SO2;

import java.io.Serializable;
import static Proyecto3SO2.Inicial.AleatorioLocal;

/**
 *
 * @author glucas & rperez
 */
class MensajeInicial implements Serializable{
       
    private String nombre;
    private int columnas;
    private int filas;
    private int tipoEquipo;
    private int aleatorio;

    public MensajeInicial( String nombre, int columnas, int filas,int tipoEquipo) {
        
        this.nombre     = nombre;
        this.columnas   = columnas;
        this.filas      = filas;
        this.tipoEquipo = tipoEquipo;
        this.aleatorio = (int) (Math.random()* 100);
        AleatorioLocal = this.aleatorio;
        
        
    }
    
    public int getColumnas() {
        return columnas;
    }

    public int getFilas() {
        return filas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTipoEquipo() {
        return tipoEquipo;
    }
    

    
        
    
}
