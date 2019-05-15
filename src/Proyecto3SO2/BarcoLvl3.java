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
public class BarcoLvl3 extends Personaje{

    public BarcoLvl3(){
        this(0);
    }
            
    public BarcoLvl3(int equipo){
        nombrePersonaje = "Barco Grande"; //getAtributo("nombre");
        vida = 100;//getAtributo("vida");
        nomIcono=path+"barcoLvl3.png";//getAtributo("nomIcono");
    
        
        this.equipo = equipo;
        Icono = this.cargarImagenes(nomIcono);

    }
    
    @Override
    public Personaje nuevoPersonaje(int equipo){
        return (new BarcoLvl3(equipo));
    }
    public  void atacar(Personaje Contrincante){
        super.atacar(Contrincante);
    }
    
    
}
