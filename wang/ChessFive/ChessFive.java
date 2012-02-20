import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ChessFive extends JFrame implements ActionListener, MouseListener {
	
	JButton jt;
	JLabel label1,label2;
	JPanel p;
	ImageIcon start=new ImageIcon("start.gif");
	int color=0;
	boolean flag[][]=new boolean[430][430];
	
	public ChessFive()
	{
		super("五子棋");
		
		addMouseListener(this);
		
		jt=new JButton(start);
		
		
		label1=new JLabel("对弈者",SwingConstants.CENTER);
		label2=new JLabel("对弈者",SwingConstants.CENTER);
		Font f=new Font("宋体",Font.BOLD,25);
		
		label1.setFont(f);
		label2.setFont(f);
		label1.setForeground(Color.red);
		label2.setForeground(Color.green);
		
		p=new JPanel();
		p.setLayout(new GridLayout(1,3,0,0));
		
		p.add(label1);
		p.add(jt);
		jt.addActionListener(this);
		p.add(label2);
		
		add(p,BorderLayout.NORTH);
		
		setBounds(400,150,400,460);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}
	
	public void start()
	{
		setVisible(true);
	}
	
	
	/*
	 * 棋盘大小320*120,方格边长20，棋盘左上角顶点位置(40,100);
	 */
	
	public void paint(Graphics g)
	{
		//g.clearRect(0, 0, this.getWidth(), this.getHeight()); //清除面板
		g.setColor(Color.BLACK); //设置网格颜色
		g.drawString("黑子先下", 40, 90);
		g.drawString("黑子先下", 317, 90);
		g.drawRect(40, 100, 320, 320); //网格大小
		for(int i=0;i<15;i++){
			g.drawLine(60+i*20,100,60+i*20,420);
			g.drawLine(40,120+i*20,360,120+i*20);
		}
		g.fillOval(97, 157, 6, 6);
		g.fillOval(297, 157, 6, 6);
		g.fillOval(197, 257, 6, 6);
		g.fillOval(97, 357, 6, 6);
		g.fillOval(297, 357, 6, 6);
		
	}
	
	public void setDown(int x,int y)    //落子
	{
		Graphics g=getGraphics();
		
		
		if(color==0&&!flag[x][y]){
			color=1;
			g.setColor(Color.black);
			g.fillOval(x-10, y-10, 20, 20);
			flag[x][y]=true;
		}
		if(color==1&&!flag[x][y]){
			color=0;
			g.setColor(Color.white);
			g.fillOval(x-10, y-10, 20, 20);
			flag[x][y]=true;
		}
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		new ChessFive().start();
	}

	public void mouseClicked(MouseEvent e)
	{
		int x1=e.getX();
		int y1=e.getY();
		if(x1<40||x1>360||y1<100||y1>420)
		{
			return;
		}
		if((x1-40)%20>10)
		{
			x1+=20;
		}
		if((y1-100)%20>10)
		{
			y1+=20;
		}
		x1=(x1-40)/20*20+40;
		y1=(y1-100)/20*20+100;
		setDown(x1,y1);
	}
	
	
	public void mousePressed(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	
	
	public static void main(String[] args) {
		new ChessFive().start();

	}

}

