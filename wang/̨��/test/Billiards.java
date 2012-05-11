import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
public class Billiards extends Canvas implements MouseListener ,Runnable{
	
	JLabel jl1,jl2;
	JFrame f;
	Font ft=new Font("Serif",Font.BOLD,25);
	double holeR;//球洞半径
	double holeX[],holeY[];//球洞外切矩形的左上角位置
	double tableX[],tableY[];//桌面四个顶点的坐标
	double ballX[],ballY[];//球的位置
	double nextballX[],nextballY[];//下一时刻球的位置
	double vX[],vY[];//当前球的速度
	double nextvX[],nextvY[];//下一时刻球的速度
	double vMax=8;//最大击球速度
	double v;
	double vx=8,vy=6;
	double a=0.01;//摩擦系数
	int sig=-1;
	
	Image backBuffer;
	Graphics gBuffer;
	
	public Billiards()
	{
		super();
		this.setBackground(new Color(46,226,122));
		f=new JFrame("2D桌球");
		
		    
        f.add(this);
        f.setBounds(50, 50, 1000, 600);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        addMouseListener(this);
        initTable();
	}
	
	public void initTable()
	{
		holeR=25;
		tableX=new double[]{70,930};
		tableY=new double[]{20,480};
		holeX=new double[]{100,500,900};
		holeY=new double[]{50,450};
		v=2.8;//一般水平 
		
		ballX=new double[23];
		ballY=new double[23];
		ballX[0]=258;
		ballY[0]=250.0;
		
		(new Thread(this)).start();
	}
	public void run()
	{
		long t1 = System.currentTimeMillis(), t2 = t1;
		
		    while(true)
		    try{

			    t2 = System.currentTimeMillis();
			    next(t2-t1);
			    //render();
		        repaint();
		        t2=t1;
                Thread.sleep(10);
	        }
			
		catch(Exception e){}
	}
	
	public void next(long t)
	{
		ballX[0]+=vx;
		ballY[0]+=vy;
		if(ballX[0]<=110)
		{
			ballX[0]=100+10;
			vx*=sig;
		}
		else if(ballX[0] + 10 >900 )
		{

			   ballX[0]=900-10;
	           vx *= sig;

	    }
		if(ballY[0]<=60)
		{
			ballY[0]=50+10;
			vy*=sig;
		}
		else if(ballY[0] + 10 >450 )
		{

	           ballY[0] =450-10 ;

	           vy *= sig;

	    }
		
	}
	
	public void paint(Graphics g)
	{
		g.setColor(new Color(200,100,50));
		g.fillRect((int)tableX[0],(int)tableY[0],860,460);
		g.setColor(new Color(0,150,0));
		g.fillRect(100, 50, 800, 400);
		g.setColor(Color.black);
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<2;j++)
			{
				g.fillOval((int)(holeX[i]-holeR/2), (int)(holeY[j]-holeR/2), (int)holeR, (int)holeR);
			}
		}
		g.setColor(Color.white);
		g.drawLine(260, 50, 260, 450);
		g.drawArc(194, 184,132,132, 90, 180);
		g.fillOval(258, 250, 4, 4);
		g.fillOval(258, 183,4,4);
		g.fillOval(258, 315,4,4);
		g.fillOval(498, 250,4,4);
		g.fillOval(698, 250,4,4);
		g.fillOval(826, 250,4,4);
		
		g.setColor(Color.magenta);
		g.setFont(ft);
		g.fill3DRect(435, 500, 200, 20, true);
		g.drawString("甲        "+"000",70,520);
		g.drawString("乙        "+"000",800,520);
		g.setColor(Color.orange);
		g.fill3DRect(435, 500, 70, 20, true);
		
		
		g.setColor(Color.white);
		g.fillOval((int)ballX[0]-10,(int)ballY[0]-10, 20, 20);
		
	}
	
	public void update(Graphics g)
	{
		if(backBuffer==null)
		{
			backBuffer=createImage(this.getSize().width, this.getSize().height);
			gBuffer=backBuffer.getGraphics();
		}
		gBuffer.setColor(getBackground());
		gBuffer.fillRect(0, 0, this.getSize().width, this.getSize().height);
		paint(gBuffer);
		g.drawImage(backBuffer,0,0,this);
	}
	
	public void  mouseClicked(MouseEvent e)
	{
		int x=e.getX();
		int y=e.getY();
		if(x<=435+200&&x>=435)
		{
			Graphics g=getGraphics();
			g.setColor(Color.orange);
			g.fill3DRect(435,500,x-435,20,true);
			g.setColor(Color.magenta);
			g.fillRect(x, 500, 200+435-x, 20);
		}
		//repaint();
		//backBuffer=createImage(this.getSize().width, this.getSize().height);
		//gBuffer=backBuffer.getGraphics();
		//repaint();
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){
	}
	public void mouseReleased(MouseEvent e){
	}
	
	public static void main(String[] args) {
		
		new Billiards();
	}

}