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

import javax.swing.ImageIcon;
import static Proyecto3SO2.Inicial.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author glucas & rperez
 */


public abstract class  Personaje implements Equipo, Serializable{
    protected String nombrePersonaje;
    protected int vida=1;
    protected String path="iconos/";
    protected String nomIcono;
    
    protected int equipo;
    
    protected ImageIcon Icono;
    private final static  int CANTIDADPERSONAJES[]=  {3,4,5};
    
    


    
    public abstract Personaje nuevoPersonaje(int Equipo);
    public void atacar(Personaje Contrincante){
    };
    
    
    public String getAtributo(String atributo){
        /* recorrer el arreglo de atributos de Personajes y buscar el atributo*/
        String valor = "" ;
        return valor ;
    }
    
    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }
     public int getEquipo() {
        return equipo;
    }
    
    protected static ImageIcon cargarFondo(String ruta) {
        java.net.URL localizacion = Personaje.class.getResource(ruta);
        if (localizacion != null) {
            return new ImageIcon(localizacion);
        } else {
            System.err.println("No se ha encontrado el archivo: " + ruta);
            return null;
        }
    }
    protected ImageIcon cargarImagenes(String nomImagen) {
        return this.cargarFondo(nomImagen);
        
    }
    
    
    public static void  creaListadePersonajes1() {
        
        Equipo.personajesDisponibles1.add(new AvionLvl1());
        Equipo.personajesDisponibles1.add(new AvionLvl2());
        Equipo.personajesDisponibles1.add(new AvionLvl3());
 
        
    }
    
    public static void  creaListadePersonajes2() {
        

        Equipo.personajesDisponibles2.add(new BarcoLvl1());
        Equipo.personajesDisponibles2.add(new BarcoLvl2());
        Equipo.personajesDisponibles2.add(new BarcoLvl3());
        

        
    }
    
    private static Personaje agregaPersonajeAEquipo(int equipo,int personaje){
        
        int tipoPersonaje = (equipo==AmbienteGUI.EQUIPOLOCAL)?TipoPersonajeLocal:TipoPersonajeRemoto;
        ArrayList <Personaje> personajesDisponibles =(tipoPersonaje==AVIONES)?Equipo.personajesDisponibles1:Equipo.personajesDisponibles2;
        
        int cantidadPersonajes = personajesDisponibles.size();
        

        return personajesDisponibles.get(personaje).nuevoPersonaje(equipo);
        
             
    }
    
    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Personaje))return false;
        Personaje oPersonaje = (Personaje)o;
        if (this.nombrePersonaje.equals(oPersonaje.nombrePersonaje))
          if(this.equipo == oPersonaje.equipo)
              return true;
        return false;
    };
    
    private static void agregaAEstadistica(Personaje nuevoPersonaje){
        boolean encontrado = false;
        for (Estadistica estadistica:Equipo.estadisticas)
            if (nuevoPersonaje.equals(estadistica.getPersonaje())){
                encontrado = true;
                estadistica.addPersonaje();
            }
               
        if (!encontrado)        
            Equipo.estadisticas.add(new Estadistica(nuevoPersonaje));
        
    }
    
    public static void deduceAEstadistica(Personaje nuevoPersonaje){
        for (Estadistica estadistica:Equipo.estadisticas)
            if (nuevoPersonaje.equals(estadistica.getPersonaje())){
                
                estadistica.setCantidad(estadistica.getCantidad()-1);
            }
        
    }
    
    
    public static void creaEquipo(int equipo) {
        Personaje nuevoPersonaje; 
        int contador=1;
        int indice=0;
    
        for (int i=0; i <Equipo.INTEGRANTESEQUIPO; i++){
          nuevoPersonaje =agregaPersonajeAEquipo(equipo,indice);
          Equipo.equipos.add(nuevoPersonaje);
          agregaAEstadistica(nuevoPersonaje);
          
          if (contador==CANTIDADPERSONAJES[indice]){
              indice++;
              contador = 0;
          }
          contador++;
        }
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    

    public String getNomIcono() {
        return nomIcono;
    }
    
    public String getNomIconoEliminado(){
        String resultado=null;
        String valores[];
        
        if (!nomIcono.contains("X")){
        valores = nomIcono.split(Pattern.quote("."));
        
        resultado  = valores[0]+"X."+valores[1];
        } else {
            resultado = nomIcono;
        }
            
        return resultado;
    }

    public void setNomIcono(String nomIcono) {
        this.nomIcono = nomIcono;
    }


    public ImageIcon getIcono() {
        return Icono;
    }

    public void setIcono(ImageIcon Icono) {
        this.Icono = Icono;
    }
    
    
    
}
