/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto3SO2;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 *
 * @author gusta
 */
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
