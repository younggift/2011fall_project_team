import javax.swing.*;
import java.awt.*;
<applet code=Applet1 width=100 height=50>
</applet>
public class Applet1 extends JApplet
{
	public void init()
	{
		getContentPane().add(new JLabel("Hello Applet!"));
	}
}
