import javax.swing.*;
import java.awt.*;
<applet code=Appletlc width=200 height=100>
</applet>
public class Appletlc extends JApplet
{
	public void init()
	{
		getContentPane().add(new JLabel("Hello,wangtuizhi"));
	}
public static void main(String[] args)
{
	JApplet applet= new Appletlc();
	JFrame frame=new JFrame("Appletlc");

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(applet);
	frame.setSize(100,20);
	applet.init();
	applet.start();
	frame.setVisible(true);
}
}