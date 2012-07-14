/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.nenu.pk.prototypes;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Administrator
 */
public class PicShow extends JFrame{
    public PicShow(String bmpFile){
super("PicShow");
Image image =null;
System.out.println(bmpFile);
try{
    image=ImageIO.read(new File(bmpFile));
}
catch(IOException ex)
{
}
    
JLabel label =new JLabel(new ImageIcon(image));
add(label);
setDefaultCloseOperation(EXIT_ON_CLOSE);
pack();
}
public static void main(String[] args){
final String fileName ="src/pic.jpg"; 
      
SwingUtilities.invokeLater(new Runnable(){
    public void run(){
    new PicShow(fileName).setVisible(true);
            }
        });
    }
    
}
