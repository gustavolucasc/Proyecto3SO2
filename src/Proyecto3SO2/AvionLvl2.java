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


public class AvionLvl2 extends Personaje{
    
    
    public AvionLvl2(){
        this(0);
    }
            
    public AvionLvl2(int equipo){
        nombrePersonaje = "AvionLvl2"; //getAtributo("nombre");
        vida = 25;//getAtributo("vida");
     
        nomIcono=path+"avionLvl2.png";//getAtributo("nomIcono");
 
        this.equipo = equipo;
        Icono = this.cargarImagenes(nomIcono); 
       
        
    }
    
    @Override
    public Personaje nuevoPersonaje(int equipo){
        return (new AvionLvl2(equipo));
    }
    public  void atacar(Personaje Contrincante){
        super.atacar(Contrincante);
    }
    
          
}
