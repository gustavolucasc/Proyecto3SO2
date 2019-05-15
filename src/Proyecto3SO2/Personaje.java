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

/**
 *
 * @author glucas & rperez
 */


public abstract class  Personaje implements Equipo{
    protected String nombrePersonaje;
    protected int vida;
    protected String path="iconos/img/";
    protected String nomIcono;
    
    protected int equipo;
    
    protected ImageIcon Icono;
    


    
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
        

        Equipo.personajesDisponibles2.add(new BarcoLvl2());
        Equipo.personajesDisponibles2.add(new BarcoLvl3());
        Equipo.personajesDisponibles2.add(new BarcoLvl1());

        
    }
    
    private static Personaje agregaPersonajeAEquipo(int equipo){
        
        int cantidadPersonajes = (equipo==1)?Equipo.personajesDisponibles1.size():Equipo.personajesDisponibles2.size();
        int numeroAleatorio = (int) (Math.random()*cantidadPersonajes);

        return (equipo==1)?Equipo.personajesDisponibles1.get(numeroAleatorio).nuevoPersonaje(equipo):
                Equipo.personajesDisponibles2.get(numeroAleatorio).nuevoPersonaje(equipo);
             
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
    
        for (int i=0; i <Equipo.INTEGRANTESEQUIPO; i++){
          nuevoPersonaje =agregaPersonajeAEquipo(equipo);
          Equipo.equipos.add(nuevoPersonaje);
          agregaAEstadistica(nuevoPersonaje);
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