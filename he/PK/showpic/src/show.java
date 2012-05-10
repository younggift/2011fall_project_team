import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
	 
public class show extends JFrame{
public show(String bmpFile){
super("show");
Image image =null;
System.out.println(bmpFile);
try{
    image=ImageIO.read(new File(bmpFile));
}
catch(IOException ex)
{
}
    
JLabel label =new JLabel(new ImageIcon(image));
add(label);
setDefaultCloseOperation(EXIT_ON_CLOSE);
pack();
}
public static void main(String[] args){
final String fileName ="src/pic.jpg"; 
      
SwingUtilities.invokeLater(new Runnable(){
    public void run(){
    new show(fileName).setVisible(true);
            }
        });
    }
}