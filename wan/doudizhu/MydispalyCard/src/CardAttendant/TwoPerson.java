
package CardAttendant;


import Panel.IconPanel;
import function.CreateCard;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class TwoPerson extends JInternalFrame{
          public static Vector TwoLeftCard;
          public static  IconPanel pa2;
                 int pos;
                 int[] card;
          public boolean  istuoguan=false;
    public TwoPerson(int[] card) {
                   super("TwoPerson");
                 this.pos=pos;
               this.card=card;
                   this.setLayout(null);
                pa2=new IconPanel(card);
                display dis=new display();
                pa2.setSize(640,320);
                pa2.setLocation(0,30);
                dis.setLocation(0,0);
                dis.setSize(700,200);
                dis.setVisible(true);
               add(pa2);
               add(dis);;
                this.setSize(650, 410);
                this.setLocation(0, 0);
                setVisible(true);
                 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
