package Proyecto3SO2;

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
/**
 *
 * @author glucas & rperez
 */
public class Estadistica {
    private int equipo;
    private Personaje personaje;
    private int cantidad;    
    public  Estadistica (Personaje personaje){
        this.equipo = personaje.getEquipo();
        this.personaje = personaje;
        cantidad = 1;
        
        //crear una columna en PanelInformacion en el elemento tabla.
    }
    public void addPersonaje (){
        cantidad++;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    

}
