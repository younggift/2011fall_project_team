import javax.swing.*;
import java.awt.*;
public class CenterFrame{

	public static void main(String[] args) {
		JFrame frame = new JFrame("CenterFrame");
		frame.setSize(400,300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int screenWidth = screenSize.width;
                int screenHeight = screenSize.height;
                int x = (screenWidth-frame.getWidth())/2;
                int y = (screenHeight-frame.getHeight())/2;
                frame.setLocation(x,y);
		frame.setVisible(true);
		

	}

}
