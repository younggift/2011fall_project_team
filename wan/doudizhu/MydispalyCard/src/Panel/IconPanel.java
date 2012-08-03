
package Panel;

import function.Compare;
import function.Comparecard;
import function.CreateCard;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Main.Main;
import Main.TimeCount;
import Music.VectorCard;

public class IconPanel extends JPanel implements MouseListener,Runnable{
 Vector PlayCard=new Vector();//记录要出的牌
public static Vector RecordCard=new Vector();//记录要出的牌
Vector LeftCard=new Vector();//记录剩下的牌
Compare compare=new Compare();
VectorCard music=new VectorCard();
TestLabel[] labelPic=new TestLabel[21];
public int loc=560;
//产生随机数并存在card中
int[] card;
    private ImageIcon[] img=new ImageIcon[21];
     JLabel lab;
     Thread th=new Thread(this);
    public IconPanel(int[]card) {
        this.setLayout(null);
       
        this.card=card;
      
         init();
    }
//初始化
 void init() {
     if(card[card.length-1]==0) loc=560;
     else loc=640;
 for(int i=0;i<20;i++) 
  {
     labelPic[i]=new TestLabel();
 if(card[i]!=0)   
 {
     labelPic[i].setIcon(new ImageIcon(getClass().getResource("/Panel/tupian/"+card[i]+".jpg")));
     LeftCard.add(i);//向量从0个位置开始记录
     labelPic[i].setBounds(loc-(i+1)*30, 220, 80, 100);

 }
   labelPic[i].setFocusable(false);
     labelPic[i].sign=false;
     
     labelPic[i].number=card[i];
     labelPic[i].addMouseListener(this);

      this.add(labelPic[i]);
    }

 }
 
 public static void main(String[] args){
     CreateCard creat = new CreateCard();
    int[] card=creat.imgPath;
    IconPanel p=new IconPanel(card);
    JFrame f=new JFrame();
    f.add(p);
     f.setSize(640, 600);
      f.setVisible(true);
    f. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

    @Override
    public void mouseClicked(MouseEvent e) { 
 
     if(!e.isMetaDown()) 
     {//鼠标没有右击,已经左击
       if(!PlayCard.isEmpty())  PlayCard.removeAllElements();
        for(int i=0;i<LeftCard.size();i++) {
                 Integer p=(Integer)(LeftCard.get(i));
                 int k=p.intValue();
          if(e.getSource()==labelPic[k]) {
           if(!labelPic[k].sign) {
              labelPic[k].setBounds(loc-(i+1)*30, 200, 80, 100);
              labelPic[k].sign=true;
             }
           else if(labelPic[k].sign) {
              labelPic[k].setBounds(loc-(i+1)*30, 220, 80, 100);
              labelPic[k].sign=false;
             }
          }
      }
     }
     if(e.isMetaDown()){
 
         for(int i=0;i<LeftCard.size();i++){
            Integer p1=(Integer)(LeftCard.get(i));
//            Integer p2=(Integer)(LeftCard.get(i+1));
                 int k1=p1.intValue();
//                 int k2=p2.intValue();
         if(labelPic[k1].sign)   {
           //  labelPic[k1].setVisible(false);
             PlayCard.add(labelPic[k1].number);
//              LeftCard.removeElementAt(i);
//                 i--;
                  
         }
             
         }
        boolean hefa=Comparecard.run(Main.Recodcard,PlayCard); 
        
      if(compare.run(PlayCard)[0]==0||!hefa) {
            PlayCard.removeAllElements();
            for(int i=0;i<LeftCard.size();i++) {
                 Integer p=(Integer)(LeftCard.get(i));
                 int k2=p.intValue();
              labelPic[k2].setBounds(loc-(i+1)*30, 220, 80, 100);
              labelPic[k2].sign=false;
      }
               JOptionPane.showMessageDialog(null,"你出的牌不合法","警告", JOptionPane.WARNING_MESSAGE);

      }
   else
      {

          music.run(PlayCard);
        for(int i=0;i<LeftCard.size();i++){
            
          Integer p=(Integer)(LeftCard.get(i));
                 int k=p.intValue();
                          if(labelPic[k].sign)   {
             labelPic[k].setVisible(false);

              LeftCard.removeElementAt(i);
                 i--;
                  
         }
              
           labelPic[k].setBounds(loc-(i+1)*30, 220, 80, 100);
        }
//         for(int i=0;i<PlayCard.size();i++){
//          
//            Integer p=(Integer)(PlayCard.get(i));
//                 int k=p.intValue();        
                  // t.dispose();  
                 Main.Recodcard=PlayCard;
                 
//         }
                    
     }
     } 
                
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
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

    @Override
    public void run() {
      if(Thread.currentThread()==th)  
        while(true){
      if(TimeCount.isTimeout) {
                       PlayCard.removeAllElements();
            for(int i=0;i<LeftCard.size();i++) {
                 Integer p=(Integer)(LeftCard.get(i));
                 int k2=p.intValue();
              labelPic[k2].setBounds(loc-(i+1)*30, 220, 80, 100);
              labelPic[k2].sign=false;
               break;
           }
          }
            }
    }
    public Vector getLeftCard() {
        return LeftCard;
    }

    public void setPlayCard(Vector PlayCard) {
        this.PlayCard = PlayCard;
    }

}