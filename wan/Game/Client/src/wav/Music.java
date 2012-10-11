/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package cn.test001;

import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.IOException; 
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioPlayer; 



public class Music { 
public void play(String music) { 
        try {
            AudioPlayer.player.start( new FileInputStream(new File(music+".wav")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }
} 

public static void main(String[] args) { 

         new Thread(new Runnable() {
               public void run() {
                        int i=3;                 
                         while(true){          
                         new Music().play(String.valueOf(i)); 
                           i++;
                           if(i>17) i=3;
                     try{
                   Thread.sleep(2000);
               }
               catch(Exception e) {
                   
               }
                        }

                                    }
                                }).start();


} 
} 