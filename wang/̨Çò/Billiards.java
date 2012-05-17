import java.awt.*;
import javax.swing.*;
public class Billiards extends Canvas {
	
	JLabel jl1,jl2;
	JFrame f;
	
	public Billiards()
	{
		super();
		setBounds(50,50,700,350);
		this.setBackground(new Color(46,226,122));
		f=new JFrame("2D×ÀÇò");
		
		    
        f.add(this);
        f.setBounds(50, 50, 1000, 600);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        initTable();
	}
	
	public void initTable()
	{
		
	}
	
	public void paint(Graphics g)
	{
		g.setColor(new Color(200,100,50));
		g.fillRect(70,20,860,460);
		g.setColor(new Color(0,150,0));
		g.fillRect(100, 50, 800, 400);
		g.setColor(Color.black);
		g.fillOval(90, 40, 25, 25);
		g.fillOval(90, 435, 25, 25);
		g.fillOval(885,40,25,25);
		g.fillOval(885, 435, 25, 25);
		g.fillOval(488, 29, 25,25);
		g.fillOval(488, 446, 25, 25);
		g.setColor(Color.white);
		g.drawLine(260, 50, 260, 450);
		g.drawArc(194, 184,132,132, 90, 180);
		g.fillOval(258, 250, 4, 4);
		g.fillOval(258, 183,4,4);
		g.fillOval(258, 315,4,4);
		g.fillOval(498, 250,4,4);
		g.fillOval(698, 250,4,4);
		g.fillOval(826, 250,4,4);
		//g.drawOval(300 ,250, 50, 50);
	}
	
	public static void main(String[] args) {
		
		new Billiards();

	}

}
