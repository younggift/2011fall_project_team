
package CardAttendant;
import Panel.IconPanel;
import java.awt.Component;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mydispalycard.MydispalyCard;
public class ThreePerson extends JFrame implements ActionListener  {
                JButton b1=new JButton("开始");
                JButton b2=new JButton("出牌");
                JButton b3=new JButton("不出");
                JButton b4=new JButton("托管");
                 int pos;
                 int[] card;
    public ThreePerson(int pos,int[] card) {
                   super("ThreePerson");
                   this.pos=pos;
                   this.card=card;
                   this.setLayout(null);
                 JPanel pa1=new JPanel();
                 //MyPanel pa2=new MyPanel();
                 IconPanel pa2=new IconPanel(pos ,card);
                 
                 TimeCount pa3=new TimeCount();
                 
                 pa1.setLayout(new FlowLayout());
                  pa1.setSize(200,200);
                  pa2.setSize(660,400);
                pa1.setLocation(150, 500);
                pa2.setLocation(0,150);
                pa3.setLocation(100, 100);
                 pa1.setVisible(true);

                 //b1.setFont(new Font("宋书",3,40));//50为文字大小
                b1.setFocusable(false);
                b2.setFocusable(false);
                b3.setFocusable(false);
                b4.setFocusable(false);
                b1.addActionListener(this);
                b2.addActionListener(this);
                b3.addActionListener(this);
                b4.addActionListener(this);
              // b1.setText("kaishi");
                b1.setBounds(200, 0, 60,30);
               // b2.setBounds(160, 220, 60, 30);
                //b3.setBounds(230, 220, 60, 30);
                //b4.setBounds(300, 220, 60, 30);
                
                add(b1);
                pa1.add(b2);
                pa1.add(b3);
                pa1.add(b4);
                add(pa1);
                add(pa2);
               add(pa3);
                this.setSize(650, 700);
                this.setLocation(0, 0);
                setVisible(true);
                 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b2){                           
                           // new TwoPerson();
		}
	}
    public static void main(String[] args){
        new ThreePerson(35,new MydispalyCard().card);
    }
}
