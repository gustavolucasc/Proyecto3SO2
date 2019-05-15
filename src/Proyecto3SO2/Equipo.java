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

import java.util.ArrayList;
/**
 *
 * @author glucas & rperez
 */


public interface Equipo {
    public static final int INTEGRANTESEQUIPO=12;
    
    public static ArrayList <Personaje> personajesDisponibles1 = new ArrayList<>(); 
    public static ArrayList <Personaje> personajesDisponibles2 = new ArrayList<>(); 
    public static ArrayList <Personaje> equipos = new ArrayList<Personaje>();
    public static ArrayList <Estadistica> estadisticas = new ArrayList<Estadistica>();
    
    public abstract Personaje nuevoPersonaje(int Equipo);
    public abstract void atacar(Personaje Contrincante);
    
    
    
}
