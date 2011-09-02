import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Container;
public class ShowGridLayout extends JFrame{
    public ShowGridLayout(){
           Container container = getContentPane();
           container.setLayout(new GridLayout(4,3,5,5));
           for(int i=1;i<=10;i++)
               container.add(new JButton("Component "+i));
}
public static void main(String[] args){
    ShowGridLayout frame = new ShowGridLayout();
    frame.setTitle("ShowGridLayout");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200,300);
    frame.setVisible(true);
}
}