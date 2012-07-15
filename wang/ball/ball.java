import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;

import sun.audio.*;
public class ball extends JPanel implements Runnable,MouseListener,MouseMotionListener {

	final int START=0;//开始
	final int HIT=1;//击球
	final int MOVING=2;//移动
	final int END=3;//结束
	
	int state=0;
	int sig=-1;
	
	double holeR;
	double tableX[],tableY[];
	double holeX[],holeY[];
	
	int balls;//球的数目
	int ballsOn;
	double ballX[],ballY[];
	double vX[],vY[];//当前球速
	double nextballX[],nextballY[];//下时刻球的位置
	double nextvX[],nextvY[];//下时刻球速
	boolean borderColl[];
	boolean collision[][];
	boolean on[];
	double r=10;//球的半径
	
	Image backBuffer;
	Image backGround;
	
	int mX,mY;
	boolean clicked;
	
	int actualStep;
	
	InHoles in=new InHoles();
	
	
	double cx,cy;
	double vMax=2500;
	
	
	int score;//得分
	String s="000";
	
	
	double x=80;//速度条指示长度
	
	Font ft=new Font("Serif",Font.BOLD,25);
	
	
	public ball()
	{
		super();
		this.setBackground(new Color(46,226,122));
		JFrame f=new JFrame("2D桌球");
		f.add(this);
        f.setBounds(50, 50, 1000, 600);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.requestFocus();
        
        init();
	}
	
	
	public void init()
	{
		score=0;
		initTable();
		initBalls();
		backBuffer=createImage(this.getWidth(),this.getHeight());
		createBackGround();
		
		this.addMouseListener(this);
        this.addMouseMotionListener(this);
		start();
	}
	
	
	
	/*桌面初始化*/
	public void initTable()
	{
		holeR=32;
		tableX=new double[]{70,930};
		tableY=new double[]{20,480};
		holeX=new double[]{100,500,900};
		holeY=new double[]{50,450};
	}
	
	
	/*球 初始化*/
	public void initBalls()
	{
		balls=16;
		ballX=new double[balls];
		ballY=new double[balls];
		vX=new double[balls];
		vY=new double[balls];
		nextballX=new double[balls];
		nextballY=new double[balls];
		nextvX=new double[balls];
		nextvY=new double[balls];
		borderColl=new boolean[balls];
		collision=new boolean[balls][balls];
		on=new boolean[balls];
		
		setBalls();
	}
	
	
	
	
	/*看是否在放置白球的区域*/
	boolean isInWhiteArea(double x,double y)
	{
		return x<=260&&((x-260)*(x-260)+(y-250)*(y-250)<=66*66);
	}
	
	
	/*放置白球*/
	public void setWhiteBall()
	{
		vX[0]=0;
		vY[0]=0;
		if(isInWhiteArea(cx,cy)&&on[0]==false)
		{
			boolean set=false;
			while(!set)
			{
				for(int i=1;i<balls;++i)
				{
					if(isBallsCollisionPre(0,i)==false) set=true;
				}
			}
			if(set==true)
			{
				ballX[0]=cx;
				ballY[0]=cy;
			}
			on[0]=true;
		}
		
	}
	
	
	
	/*判断球x与球y是否要发生碰撞*/
	public boolean isBallsCollisionPre(int x,int y)
	{
		return Math.hypot(ballX[x]-ballX[y], ballY[x]-ballY[y])<2*r;
	}
	
	
	
	/*放置非白球*/
	public void setBalls()
	{
		int k=1;
		ballsOn=balls-1;
		final double ps=Math.sqrt(3.5);
		for(int i=0;i<5;i++)
		{
			double px=720+i*ps*r;
			double py=252-i*r;
			for(int j=0;j<=i;j++)
			{
				ballX[k]=px;
				ballY[k]=py;
				vX[k]=0;
				vY[k]=0;
				on[k]=true;
				
				py+=2*r;
				k++;
			}
		}
	}
	
	
	/*画背景桌面*/
	public void createBackGround()
	{
		backGround=this.createImage(this.getWidth(),this.getHeight());
		Graphics g=backGround.getGraphics();
		g.setColor(new Color(46,226,122));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(new Color(200,100,50));
		g.fillRect((int)tableX[0],(int)tableY[0],860,460);
		g.setColor(new Color(0,150,0));
		g.fillRect(100, 50, 800, 400);
		g.setColor(Color.black);
		for(int i=0;i<3;i++)
		{
			if(i!=1)
			{
				for(int j=0;j<2;j++)
				{
					g.fillOval((int)(holeX[i]-holeR/2), (int)(holeY[j]-holeR/2), (int)holeR, (int)holeR);
				}
			}
			else
			{
				g.fillArc((int)(holeX[i]-16), (int)(holeY[0]-16), (int)holeR, (int)holeR, 0, 180);
				g.fillArc((int)(holeX[i]-16),(int)(holeY[0]-10),(int)holeR,20,0,-180);
				g.fillArc((int)(holeX[i]-16), (int)(holeY[1]-16), (int)holeR, (int)holeR, 0, -180);
				g.fillArc((int)(holeX[i]-16),(int)(holeY[1]-10),(int)holeR,20,0,180);
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
		
	}
	
	
	
	public boolean intable(double x,double y)
	{
		return (x>=holeX[0]+10&&x<=holeX[2]-10&&y>=holeY[0]+10&&y<=holeY[1]-10);
	}
	
	public void drawStick(Graphics g)
	{
		if(intable(mX,mY))
		{
			g.setColor(Color.white);
			g.drawLine((int)ballX[0], (int)ballY[0], mX, mY);
			g.setColor(Color.blue);
			g.drawOval(mX-10, mY-10, 20,20);
		}
	}
	
    
    
    
    
    public double setV(double px) 
    {
        if (clicked) 
        {
        	return vMax*(px/200.0);
        }
        else 
        {
        	return 0;
        }
    }
    
    
	
	public void start()
	{
		new Thread(this).start();
	}
	
	
	
	public void run()
	{
		long t1 = System.currentTimeMillis(), t2 = t1;
		
	    while(true)
	    {
	    	try
	    	{
	    		t2 = System.currentTimeMillis();
	    		
	    		switch(state){
			    case HIT:
			    	next(t2-t1);
			    	collisions();
			    	update();
			    	break;
			    case MOVING:
			    	next(t2-t1);
			    	collisions();
			    	update();
			    	boolean allStopped=true;
			    	for(int i=0;allStopped&&i<balls;i++)
			    	{
			    		allStopped=(vX[i]==0)&&(vY[i]==0);
			    	}
			    	if(allStopped)
			    	{
			    		state=HIT;
			    		if(!on[0])
			    		{
			    			setWhiteBall();
			    		}
			    	}
			    	if(ballsOn==0) state=END;
			    	break;
			    case  END:
			    	setBalls();
			    	setWhiteBall();
			    	state=START;
			    	break;
			    }
	    		
	    		render();
	    		repaint();
	    		t1=t2;
	    		Thread.sleep(30);
            }
		    catch(Exception e)
		    {
		        e.printStackTrace();
		    }
	    }
	}
	
	
	
	public void paint(Graphics g)
	{
		g.drawImage(backBuffer,0,0,null);
	}
	
	
	
	
	public void render()
	{
		Graphics g=backBuffer.getGraphics();
		g.drawImage(backGround, 0, 0, null);
		
		if(on[0])
		{
			g.setColor(Color.white);
			g.fillOval((int)ballX[0]-10,(int)ballY[0]-10, 20, 20);
		}
		
		g.setColor(Color.red);
		for(int i=1;i<balls;i++)
		{
			if(on[i])
			{
				g.fillOval((int)(ballX[i]-r), (int)(ballY[i]-r), 20, 20);
			}
		}
		
		g.setColor(Color.black);
		for(int i=0;i<balls;i++)
		{
			if(on[i])
			{
				g.drawOval((int)(ballX[i]-r), (int)(ballY[i]-r), 20, 20);
			}
		}
		if (state==HIT&&on[0]) drawStick(g);
		if (state == START) 
		{            
            int mX = this.getWidth()/2-85;
            int mY = this.getHeight()/2;
             
            g.setFont(ft);
            g.setColor(Color.BLACK);
            g.drawString("Click to start", mX+2, mY+2);
            
            if (((System.currentTimeMillis()/1000)&1)==0) 
            {
            	g.setColor(Color.YELLOW);
            }
            else 
            {
                g.setColor(Color.CYAN);
            }
            g.drawString("Click to start", mX, mY);
        }
		
		g.setColor(Color.magenta);
		g.setFont(ft);
		g.fill3DRect(435, 500, 200, 20, true);
		g.drawString("甲       "+s,70,520);
		g.drawString("乙       "+s,800,520);
		g.setColor(Color.orange);
		g.fill3DRect(435, 500, (int)x, 20, true);

	}
	
	
	
	public void collisions()
	{
		borderCollision();
		inHoles();
		ballsCollision();
	}
	
	
	
	public void next(long t)
	{
		double pt=t*1.0/1500.0;
            
		for(int i=0;i<balls;i++)
		{
			if(on[i])
			{
				
				nextballX[i]=ballX[i]+vX[i]*pt;
				nextballY[i]=ballY[i]+vY[i]*pt;
			
				vX[i]*=0.99;
				vY[i]*=0.99;
				if (Math.abs(Math.hypot(vX[i], vY[i]))<5)
				{
					vX[i]=vY[i]=0;
				}
			}
		}
        
	}
	
	public void getScore(int i,int x)
	{
		if(i!=0)
		{
			x++;
			score=x;
			if(score<10)  s="00"+score;
			else if(score>=10&&score<=99)  s="0"+score;
			else if(score>99)   s=""+score;
		}
		
		try{
        	InputStream in2=new FileInputStream("Pocket1.wav");
            AudioStream inholes=new AudioStream(in2);
            AudioPlayer.player.start(inholes);
        }
		catch(FileNotFoundException e){}
        catch(IOException e){}
	}
	
	public void inHoles()
	{
		for(int i=0;i<balls;i++)
		{
			in.init();
			if(on[i])
			{
				in.inHole(ballX[i],ballY[i]);
				for(int j=1;j<=6;j++)
				{
					if(in.inHoleNo[j]==true)
					{
						on[i]=false;
						getScore(i,score);
						
						
						if(i!=0) --ballsOn;
						vX[i]=vY[i]=0;
						break;
					}
				}
			}
		}
	}
	
	public void ballsCollision()
	{
		for (int i=0; i<balls; i++) if (on[i])
		{
            for (int j=i+1; j<balls; j++) if (on[j])
            {
                boolean collision;
               
                if(collision = isBallsCollision(i,j))
                {
                    int count = 0;
                    while (count <10 && collision)
                    {
                        nextballX[i] = (nextballX[i] + ballX[i]) / 2;
                        nextballY[i] = (nextballY[i] + ballY[i]) / 2;
                        
                        nextballX[j] = (nextballX[j] + ballX[j]) / 2;
                        nextballY[j] = (nextballY[j] + ballY[j]) / 2;
                        
                        collision = isBallsCollision(i, j);
                        ++count;
                    }
                   /* try{
                    	InputStream in1=new FileInputStream("Collide.wav");
                    	AudioStream coll=new AudioStream(in1);
                    	AudioPlayer.player.start(coll);
                    }
            		catch(FileNotFoundException e){}
                    catch(IOException e){System.out.println("hello");}
                    */
                    
                    if (collision) 
                    {
                    	
                        nextballX[i] = ballX[i];
                        nextballY[i] = ballY[i];
                        
                        nextballX[j] = ballX[j];
                        nextballY[j] = ballY[j];
                        
                    }
                    

                    double dx = nextballX[j] - nextballX[i];
                    double dy = nextballY[j] - nextballY[i];
                    double dist = Math.hypot(nextballX[i]-nextballX[j], nextballY[i]-nextballY[j]);
                    
                    double cos = dx/dist;
                    double sin = dy/dist;
                    
                    nextvX[j] = vX[j] - vX[j] * cos * cos;
                    nextvX[j] -= vY[j] * cos * sin;
                    nextvX[j] += vX[i] * cos * cos;
                    nextvX[j] += vY[i] * cos * sin;       
                    
                    
                    nextvY[j] = vY[j] - vY[j] * sin * sin;
                    nextvY[j] -= vX[j] * cos * sin;
                    nextvY[j] += vX[i] * cos * sin;
                    nextvY[j] += vY[i] * sin * sin;
                    
                    nextvX[i] = vX[i] - vX[i] * cos * cos;
                    nextvX[i] -= vY[i] * cos * sin;
                    nextvX[i] += vX[j] * cos * cos;
                    nextvX[i] += vY[j] * cos * sin;
                    
                    nextvY[i] = vY[i] - vY[i] * sin * sin;
                    nextvY[i] -= vX[i] * cos * sin;
                    nextvY[i] += vX[j] * cos * sin;
                    nextvY[i] += vY[j] * sin * sin;
                                               
                    vX[i] = nextvX[i];
                    vY[i] = nextvY[i];
                    
                    vX[j] = nextvX[j];
                    vY[j] = nextvY[j];
                    
                    
                }
            }
        }
	}
	
	public boolean isBallsCollision(int i,int j)
	{
		return Math.hypot(nextballX[i]-nextballX[j], nextballY[i]-nextballY[j])<2*r;
	}
	
	public void update()
	{
		for(int i=0;i<balls;i++)
		{
			if(on[i])
			{
				ballX[i]=nextballX[i];
				ballY[i]=nextballY[i];
			}
		}
	}
	
	public void borderCollision()
	{
		
		for (int i=0; i<balls; ++i) 
		if (on[i]) 
		{
	           
            if (nextballX[i]-r<holeX[0]) 
            {
                nextballX[i] = holeX[0] + r;
                vX[i] *= -1;
                playBorderColl();
            }
            else if (nextballX[i]+r>holeX[2])
            {
                nextballX[i] = holeX[2]-r;
                vX[i] *= -1;
                playBorderColl();
            }
           
            if (nextballY[i]-r<holeY[0]) 
            {
                nextballY[i] = holeY[0] + r;
                vY[i] *= -1;
                playBorderColl();
            } 
            else if (nextballY[i]+r>holeY[1]) 
            {
                nextballY[i] = holeY[1] - r;
                vY[i] *= -1;
                playBorderColl();
                
            }
            
        }
		
		
	}
	
	public void playBorderColl()
	{
		try{
        	InputStream in3=new FileInputStream("CollideEdge.wav");
        	AudioStream collBorder=new AudioStream(in3);
        	AudioPlayer.player.start(collBorder);
        }
		catch(FileNotFoundException e){}
        catch(IOException e){System.out.println("hello");}
	}
	
	
	/*事件处理*/
	public void  mouseClicked(MouseEvent e)
	{	
		double px,py;
		px=e.getX();
		py=e.getY();
		if(px>=435&&px<=635&&py>=500&&py<=520)
		{
			x=px-435;
		}
		
		if (state == START&&intable(px,py)) {
            state = HIT;
        }
	}
	
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	
	
	public void mousePressed(MouseEvent e)
	{
		if(on[0]&&intable(e.getX(),e.getY())) clicked=true;
	}
	
	
	public void mouseReleased(MouseEvent e)
	{
		cx=e.getX();
		cy=e.getY();
		if(on[0]==false)
		{
			setWhiteBall();
		}
		if (state==HIT) 
		{
	        double dStickBall = Math.hypot(ballX[0]-mX, ballY[0]-mY);
	        double dXNormalized = -(ballX[0]-mX)/dStickBall;
	        double dYNormalized = -(ballY[0]-mY)/dStickBall;
	        double v = setV(x);
	            
	        if (v>0&&intable(cx,cy))
	        {
	            state = MOVING;
	            vX[0] = v * dXNormalized;
	            vY[0] = v * dYNormalized;
	        }
	    }
	        
	    clicked = false;
	}
	
	public void mouseDragged(MouseEvent e){}
	public void mouseMoved(MouseEvent e)
    {        
		   mX = e.getX();
	       mY = e.getY();
	}
	
	public static void main(String[] args) {
		
		new ball();
	}

}