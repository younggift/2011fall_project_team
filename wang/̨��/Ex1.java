import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
public class Ex1 extends JFrame implements Runnable{
	
	//JButton jt=new JButton("¿ªÊ¼");
	//JPanel p;
	double X,Y;
	//double Nx,Ny;
	public Ex1()
	{
		super("ÒÆ¶¯");
		
		//p=new JPanel();
		
		setBounds(100,50,800,600);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
	}
	public void init()
	{
		setBackground(Color.green);
		//add(p);
		X=150.0;
		Y=150.0;
		(new Thread(this)).start();
	}
	
	public void run()
	{
		long t1 = System.currentTimeMillis(), t2 = t1;
		
		    while(true)
		    try{

			    t2 = System.currentTimeMillis();
			    next(t2-t1);
			    render();
		    repaint();
		    t2=t1;
            Thread.sleep(10);
	    }
			
		catch(Exception e){}
	}
	
	public void render()
	{
		Graphics g=this.getGraphics();
		g.setColor(this.getBackground());
		g.fillOval((int)(X-1), (int)(Y-1), 20, 20);
		g.setColor(Color.red);
		g.fillOval((int)X, (int)Y, 20, 20);
	}
	public void next(long t)
	{
		X+=1;
		Y+=1;
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		g.fillOval((int)X,(int)Y, 20, 20);
	}

	public static void main(String[] args) {
		new Ex1();

	}

}
