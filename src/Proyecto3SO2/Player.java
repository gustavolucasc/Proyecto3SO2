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

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Player implements Runnable  {

    private final String sonido;
    
    public Player (String sonido){
        this.sonido = sonido;
    }
    @Override
    public void run() {

     InputStream path = Player.class.getResourceAsStream("sonidos/"+sonido+".wav");
     try
  { Clip sonido1;
   sonido1=AudioSystem.getClip();
   InputStream bufferedIn = new BufferedInputStream(path);
   sonido1.open(AudioSystem.getAudioInputStream(bufferedIn));
   sonido1.start();

  }catch(IOException | LineUnavailableException | UnsupportedAudioFileException fallo){
   System.out.println(fallo);
  }
    }
    
}
