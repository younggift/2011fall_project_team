import javax.swing.*;
import java.awt.*;
public class ShowFlowLayout extends JFrame{
    public ShowFlowLayout(){
           Container container = getContentPane();
           container.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
           for(int i=1;i<=10;i++)
               container.add(new JButton("Component "+i));
}
public static void main(String[] args){
    ShowFlowLayout frame = new ShowFlowLayout();
    frame.setTitle("ShowFlowLayout");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200,300);
    frame.setVisible(true);
}
}