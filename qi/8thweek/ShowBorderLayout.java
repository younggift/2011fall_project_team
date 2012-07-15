import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Container;
public class ShowBorderLayout extends JFrame{
    public ShowBorderLayout(){
           Container container = getContentPane();
           container.setLayout(new BorderLayout(5,10));
           container.add(new JButton("East"),BorderLayout.EAST);
           container.add(new JButton("South"),BorderLayout.SOUTH);
           container.add(new JButton("West"),BorderLayout.WEST);
           container.add(new JButton("North"),BorderLayout.NORTH);
           container.add(new JButton("Center"),BorderLayout.CENTER);
}
public static void main(String[] args){
    ShowBorderLayout frame = new ShowBorderLayout();
    frame.setTitle("ShowBorderLayout");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300,300);
    frame.setVisible(true);
}
}