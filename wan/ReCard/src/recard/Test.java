/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recard;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

    
/**
 *
 * @author Administrator
 */

public class Test extends JFrame{
    private final TestLabel[] labelPic=new TestLabel[21];

    public Test() {
      setLayout(null);
    for(int i=1;i<18;i++) 
  {
     labelPic[i]=new TestLabel();
     
    labelPic[i].setIcon(new ImageIcon(getClass().getResource("/recard/tupian/"+i+".jpg")));
    System.out.println(i);
     labelPic[i].setBounds(640-i*30, 420, 80, 100);
     labelPic[i].setVisible(true);
  // labelPic[i].setFocusable(false);
   
     this.setVisible(true);
      this.add(labelPic[i]);
    }
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
    public static void main(String[] args)
    {
       new Test();
    }
    }

