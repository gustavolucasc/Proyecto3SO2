/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto3SO2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class ArchivoConfiguracion {
    public Properties config = new Properties();
    InputStream configInput = null;
    
    public ArchivoConfiguracion(){
        
    }
    public String  readPropertie(String field){
        try{
            configInput = new FileInputStream("C:\\TEMP\\config.properties");
            config.load(configInput);
           
            System.out.println(config.getProperty(field));
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error cargando configuración\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
         return config.getProperty(field);
    }
    
    public void writePropertie(String field, String value){
        try{
            FileOutputStream configOutput = new FileOutputStream("C:\\TEMP\\config.properties");
            config.setProperty(field, value);
            config.store(configOutput, "Comentario");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error guardando configuración\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
