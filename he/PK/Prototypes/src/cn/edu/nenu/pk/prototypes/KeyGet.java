package cn.edu.nenu.pk.prototypes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

/**
 *
 * @author Administrator
 */
public class KeyGet  implements KeyListener{
     private boolean isRunning;
     
    public static void main(String[] args) {
        new KeyGet().run();
        
        //KeyGet keyget =new KeyGet();
        //KeyEvent KeyEvent;
       
    }
    private LinkedList messages = new LinkedList();

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        // exit the program
        if (keyCode == KeyEvent.VK_ESCAPE) {
             System.exit(0);
        }
        else {
             addMessage("Pressed: " + KeyEvent.getKeyText(keyCode));
             System.out.println(keyCode);
            // make sure the key isn't processed for anything else
            e.consume();
        }
    }
    
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        addMessage("Released: " + KeyEvent.getKeyText(keyCode));
        // make sure the key isn't processed for anything else
        e.consume();
    }
    
     public void keyTyped(KeyEvent e) {
        e.consume();
    }

     public void addMessage(String message) {
       // messages.add(message);
        System.out.println(message);
    }
     
    public void run() {
      // this.keyPressed(KeyEvent e);
    }

}
