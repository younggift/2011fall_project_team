
package CardAttendant;

import Panel.IconPanel;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class OnePerson extends JInternalFrame {           
                 int pos;
                 int[] card;
          public static  IconPanel pa2;
           public boolean  istuoguan=false;
    public OnePerson(int[] card) {
                 super("OnePerson");
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
               add(dis);
                this.setSize(650, 410);
                this.setLocation(0, 0);
                setVisible(true);
                 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
