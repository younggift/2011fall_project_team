package Panel;

import function.CreateCard;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mydispalycard.MydispalyCard;

public class IconPanel extends JPanel implements MouseListener{

 Icon img1;
 Icon img2 =new ImageIcon(getClass().getResource("/Panel/tupian/"+52+".jpg"));
 Icon  img3 = new ImageIcon(getClass().getResource("/Panel/tupian/"+53+".jpg"));
 Icon  img4 = new ImageIcon(getClass().getResource("/Panel/tupian/"+54+".jpg"));
 //(new javax.swing.ImageIcon(getClass().getResource("/test/1.png")))

 int pos;
 int k=16;
 int i;
 //public JButton[] button=new JButton[55];
 public MyJlabel[] button=new MyJlabel[55];
int[] card;
 public IconPanel(int pos,int[] card){
  this.pos=pos;
  this.card=card;
  this.setSize(0,0);
  this.run();
  //this.k=16;
 }

 public void paint1(){
     this.setLayout(null);
          button[52]=new MyJlabel();
          button[53]=new MyJlabel();
          button[54]=new MyJlabel();
    button[52].setIcon(img2);
    button[53].setIcon(img3);
    button[54].setIcon(img4);
   button[52].setFocusable(false);
   button[53].setFocusable(false);
   button[54].setFocusable(false);
      button[52].setBounds(320-(52-51)*30, 0, 80, 100);
      button[53].setBounds(320-(53-51)*30, 0, 80, 100);
      button[54].setBounds(320-(54-51)*30, 0, 80, 100);
        this.add(button[52]);
      this.add(button[53]);
       this.add(button[54]);

  if(pos==35) k=19;
  for(i=pos;i<=pos+k;i++) 
  {
  img1 = new ImageIcon(getClass().getResource("/Panel/tupian/"+card[i]+".jpg"));

 //if(i<=17) 
   //JButton button1=new JButton();
     
    //button[i]=new JButton();
     button[i]=new MyJlabel();
    button[i].setIcon(img1);
   button[i].setFocusable(false);
   if(i<=17)  button[i].setBounds(560-i*30, 220, 80, 100);
   else if(i>17&&i<=34) button[i].setBounds(560-(i-17)*30, 220, 80, 100);
 else if(i>34&&i<=54) button[i].setBounds(600-(i-34)*30, 220, 80, 100);

     button[i].record=0;
     button[i].addMouseListener(this);

      this.add(button[i]);
       
// else if(i>17&&i<=34) button[i].setIcon(img1);
 //else if(i>34&&i<=51) button[i].setIcon(img1);
 //else if(i>51&&i<=54)button[i].setIcon(img1);
  } 

 
}
public void run() {
this.paint1();
 
 }
public static void main(String[] args){
    IconPanel i=new IconPanel(1,new MydispalyCard().card);
    
    JFrame f=new JFrame();
    f.add(i);
     f.setSize(640, 600);
      f.setVisible(true);
    f. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

    @Override
    public void mouseClicked(MouseEvent e) {
       
    }
   int record=0;
    @Override
    public void mousePressed(MouseEvent e) {
        //int clickTimes = e.getClickCount();
        
        for(int j=pos;j<=pos+k;j++) 
               if(e.getSource()==button[j]) {
           if(!e.isMetaDown()){
                if(button[j].record==0) 
                 {
      if(j<=17)  button[j].setBounds(560-j*30, 200, 80, 100);
   else if(j>17&&j<=34) button[j].setBounds(560-(j-17)*30, 200, 80, 100);
 else if(j>34&&j<=54) button[j].setBounds(600-(j-34)*30,200, 80, 100);
  
                       button[j].record=1;
                      // System.out.println(e.getClickCount());
                        //JOptionPane.showMessageDialog(null, e.getClickCount()+"");
                       //JOptionPane.showMessageDialog(null, "超时!\n启动托管", e.getClickCount()+"" , JOptionPane.OK_OPTION);
                  }
                 else  if(button[j].record==1)
                 {
                         if(j<=17)  button[j].setBounds(560-j*30, 220, 80, 100);
                        else if(j>17&&j<=34) button[j].setBounds(560-(j-17)*30, 220, 80, 100);
                        else if(j>34&&j<=54) button[j].setBounds(600-(j-34)*30, 220, 80, 100);
                       
                         // button[j].setVisible(false);
                           button[j].record=0;
                           System.out.println(e.getClickCount());
                           //JOptionPane.showMessageDialog(null, "超时!\n启动托管", e.getClickCount()+"" , JOptionPane.OK_OPTION);
                 }
           }
        else if(e.isMetaDown()){
             for(int p=pos;p<=pos+k;p++) 
                  if(button[p].record==1)
                     button[p].setVisible(false);
                 }
               }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

                   
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    
    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
class MyJlabel extends JLabel {
       public int record;
}