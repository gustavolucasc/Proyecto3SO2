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


public class AvionLvl1 extends Personaje{
    
    
    public AvionLvl1(){
        this(0);
    }
            
    public AvionLvl1(int equipo){
        nombrePersonaje = "Avion Liviano"; //getAtributo("nombre");
        vida = 10;//getAtributo("vida");
        nomIcono=path+"AvionLvl1.png";//getAtributo("nomIcono");

        
        this.equipo = equipo;
        Icono = this.cargarImagenes(nomIcono);
        
       
    }
    
    @Override
    public Personaje nuevoPersonaje(int equipo){
        return (new AvionLvl1(equipo));
    }
    public  void atacar(Personaje Contrincante){
        super.atacar(Contrincante);
    }
    
          
}
