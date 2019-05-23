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
import static Proyecto3SO2.Inicial.*;


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

    public int getAleatorio() {
        return aleatorio;
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
    
    public String toString(){
        String resultado = "";
        resultado = "Has enviado un mensaje de Inicio de Juego con la siguiente información:\n";
        resultado += "Tu nombre:"+nombre+"\n";
        resultado += "Columnas: "+columnas+"\n";
        resultado += "Filas: "+filas+"\n";
        resultado += "Tipo Equipo"+((tipoEquipo==BARCOS)?"Barcos":"Aviones")+"\n";
        resultado += "Número Aleatorio:"+aleatorio+"\n";
  
        return resultado;
    }
    
        
    
}
