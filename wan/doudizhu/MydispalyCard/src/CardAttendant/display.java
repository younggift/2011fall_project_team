/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CardAttendant;

/**
 *
 * @author Administrator
 */

import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Main.Main;

public class display extends JPanel{
    JLabel[] lab=new JLabel[20];
    int j=0;   
    
    public display() 
    {
            setLayout(null);
            setSize(600, 100);
            setLocation(0, 0);
            setVisible(true);        
      for(int i=0;i<20;i++)
      {
         lab[i]=new JLabel();
         lab[i].setText("lab "+i);
         this.add(lab[i]);
      }      
       new Thread(new Runnable() 
       {

            @Override
            public void run() 
            {
               while(true) 
               {

              if(!Main.Recodcard.isEmpty())    Cardpaint(Main.Recodcard);
                  pause(200);        
               }
            }
         }).start();  
     }
    
   public void Cardpaint(Vector v1) 
   {
    if(!v1.isEmpty())      
             for(int i=0;i<20;i++) 
               {
                 lab[i].setIcon(null);
               }
    
             for(int i=0;i<v1.size();i++) 
              {
                 lab[i].setIcon(new ImageIcon(getClass().getResource("/Panel/tupian/"+(Integer)v1.get(i)+".jpg")));
                 lab[i].setBounds(610-i*30, 0, 80, 100);
              }
   } 
   
    void pause(long time)
    {
       try 
       {
           Thread.sleep(time);
       }
       catch(InterruptedException e) 
       {
           
       }
    }
}
