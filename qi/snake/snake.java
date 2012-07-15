import java.awt.*;
import java.awt.event.*;
//import javax.swing.JOptionPane;
class MyFrame extends Frame implements ActionListener
{
	MyPanel mypanel;
	Button button;
	Panel panel;
	MyFrame(){
		super("贪食蛇");
		mypanel = new MyPanel();
		button = new Button("开始");
		panel = new Panel();
		button.addActionListener(this);
		panel.add(button);
        panel.add(new Label("请点击开始按钮后再按Tab键后开始游戏"));		
		add(panel,BorderLayout.NORTH);
		add(mypanel,BorderLayout.CENTER);
		setBounds(100,100,600,600);
		setVisible(true);
		validate();
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==button)
		{
			try{
				mypanel.thread.start();
				mypanel.validate();
			}
			catch(Exception ee){
			
			}
		}
	}
}
class MyPanel extends Panel implements KeyListener,Runnable{
	Button snake[];
	int length = 0;
	int food[];
	boolean result = true;	
	boolean t = true;
	Thread thread;
	int locx,locy;
	int direction = 0;
	int x=0,y=0;
	MyPanel(){
		setLayout(null);
		snake = new Button[100];
		food = new int [100];
		thread = new Thread(this);
		for(int i=0;i<100;i++){
			food[i]=(int)(Math.random()*99);
		}
		locx = (int)(food[0]/10)*50;
		locy = (int)(food[0]%10)*50;
		for(int i=0;i<100;i++)
		{
			snake[i]=new Button();
		}
		add(snake[0]);
		snake[0].setBackground(Color.red);
		snake[0].addKeyListener(this);
		snake[0].setBounds(0,0,10,10);
		setBackground(Color.cyan);
	}
	public void run()
	{
		while(t)
		{
			if(direction==0){
				try{
					x+=10;
					snake[0].setLocation(x,y);
					if(locx==x&&locy==y){
						length++;
						locx=(int)(food[length]/10)*50;
						locy=(int)(food[length]%10)*50;
						repaint();
						add(snake[length]);
						snake[length].setBounds(snake[length-1].getBounds());
					}
					thread.sleep(100);
				}
				catch(Exception e){
				}
			}
			else if(direction==1){
				try{
					x-=10;
					snake[0].setLocation(x,y);
					if(locx==x&&locy==y){
						length++;
						locx=(int)(food[length]/10)*50;
						locy=(int)(food[length]%10)*50;
						repaint();
						add(snake[length]);
						snake[length].setBounds(snake[length-1].getBounds());
					}
					thread.sleep(100);
				}
				catch(Exception e){
				}
			}
			else if(direction==2){
				try{
					y-=10;
					snake[0].setLocation(x,y);
					if(locx==x&&locy==y){
						length++;
						locx=(int)(food[length]/10)*50;
						locy=(int)(food[length]%10)*50;
						repaint();
						add(snake[length]);
						snake[length].setBounds(snake[length-1].getBounds());
					}
					thread.sleep(100);
				}
				catch(Exception e){
				}
			}
			else if(direction==3){
				try{
					y+=10;
					snake[0].setLocation(x,y);
					if(locx==x&&locy==y){
						length++;
						locx=(int)(food[length]/10)*50;
						locy=(int)(food[length]%10)*50;
						repaint();
						add(snake[length]);
						snake[length].setBounds(snake[length-1].getBounds());
					}
					thread.sleep(100);
				}
				catch(Exception e){
				}
			}
			int temp1=length;
			while(temp1>2){
				if(snake[temp1].getBounds().x==snake[0].getBounds().x&&snake[temp1].getBounds().y==snake[0].getBounds().y){
					t=false;
					result =false;
                    repaint();
				}
				temp1--;
			}
			if(x<0||x>=this.getWidth()||y<0||y>=getHeight())
			{
				t=false;
				result =false;
                repaint();
		    }
			int temp2=length;
			while(temp2>0){
				snake[temp2].setBounds(snake[temp2-1].getBounds());
				temp2--;
			}
			if(length==100)
			{
				t=false;
				result=true;
				repaint();
			}
	    }
    }
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			if(direction!=1)
			{
				direction=0;
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if(direction!=0)
			{
				direction=1;
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			if(direction!=3)
			{
				direction=2;
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			if(direction!=2)
			{
				direction=3;
			}
		}
	}
	public void keyTyped(KeyEvent e){
		
	}
	public void keyReleased(KeyEvent e){
		
	}
	public void paint(Graphics g){
		int x1=this.getWidth()-1;
		int y1=this.getHeight()-1;
		g.setColor(Color.black);
		g.fillOval(locx,locy,10,10);
		g.drawRect(0,0,x1,y1);
		if(t==false&&result==false){
			g.drawString("游戏结束!",200,200);
		}
		else if(t==false&&result==true){
			g.drawString("闯关成功!",200,200);
		}
	}
}

public class snake{	
	public static void main(String[] args){
	   new MyFrame();
	}
}