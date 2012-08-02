import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.AudioClip; 
import java.io.*; 
import java.applet.Applet;  
import java.net.MalformedURLException; 
import java.net.URL; 
public class ZhiPai extends JFrame
{
	public JPanel pane = null;           //定义主面板
	private JLabel pileone[] = null;     //PileOne   表示纸牌堆         此堆要有7个标签
	private JLabel piletwo[] = null;     //PileTwo   表示回收堆         此堆要有4个标签
	private JLabel pilethree = null;     //PileThree 表示点击堆         此堆要有1个标签
	private JLabel pilefour = null;      //PIleFour  表示点击显示堆     此堆要有1个标签
    private JButton ply_music = null;
	private JButton stp_music = null;
	private Card cards[] = new Card[52];
	Hashtable<Point,Card> hashone = null;
	Hashtable<Integer, Card> hashtwo=null;
	private int c = 0;
	private int remind=24;
	PileOne pile = null;
	public ZhiPai()
	{
		setTitle("齐嘉亮_纸牌");
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		setSize(870,640);
		setResizable(false);
		setLocationRelativeTo(getOwner());  //窗口中间显示；
		
		/*
		以下开始定义菜单栏
		*/
		
		JMenuBar bar =  new JMenuBar();
		JMenu game = new JMenu("游戏");
		JMenu help = new JMenu("帮助");
		JMenuItem start = new JMenuItem("新游戏");
		JMenuItem exit = new JMenuItem("退出");
		JMenuItem about = new JMenuItem("关于");
		game.setFont(new Font("楷体",java.awt.Font.BOLD,16));
		help.setFont(new Font("楷体",java.awt.Font.BOLD,16));
		start.setFont(new Font("楷体",java.awt.Font.BOLD,16));
		exit.setFont(new Font("楷体",java.awt.Font.BOLD,16));
		about.setFont(new Font("楷体",java.awt.Font.BOLD,16));
		game.add(start);
		game.add(exit);
		help.add(about);
		bar.add(game);
		bar.add(help);

		start.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				dispose();
				ZhiPai zhipai = new ZhiPai();
				zhipai.setVisible(true);
			}
		});

		exit.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				System.exit(0);
			}
		});

		about.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				About a = new About();
				a.setVisible(true);
			}
		});
		setJMenuBar(bar);

		/*
		以下定义面板和各个堆
		*/
		
		pane = new ImagePanel();
		getContentPane().add(pane);
		pane.setLayout(null);
		
		//点击堆
		pilethree =  new JLabel();
		pilethree.setBounds(625,25,71,96);
		pilethree.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		pane.add(pilethree);
		pilethree.addMouseListener(new MouseAdapter()
		{
			public void mouseReleased(MouseEvent m)
			{
				turn();				
				//System.out.println("haha");
			}
		});

		ply_music = new JButton("点击播放背景音乐");
		ply_music.setFont(new Font("楷体",java.awt.Font.BOLD,16));
		ply_music.setBounds(250,500,170,35);
		ply_music.setBackground(Color.cyan);
		pane.add(ply_music);

		stp_music = new JButton("点击停止背景音乐");
		stp_music.setFont(new Font("楷体",java.awt.Font.BOLD,16));
		stp_music.setBounds(450,500,170,35);
		stp_music.setBackground(Color.cyan);
		pane.add(stp_music);

		ply_music.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				try{
					URL url;
					File f = new File("C:\\Users\\GAY\\Desktop\\齐嘉亮纸牌\\src\\别了夏天.wav"); 
					url = f.toURL();
					AudioClip au;
					au = Applet.newAudioClip(url);
					au.loop();
				}catch(MalformedURLException ee)
				{
					ee.printStackTrace();
				}
			}
		});



		stp_music.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				try{
					URL url;
					File f = new File("C:\\Users\\GAY\\Desktop\\齐嘉亮纸牌\\src\\别了夏天.wav");
					url = f.toURL();
					AudioClip au;
					au = Applet.newAudioClip(url);
					au.stop();
				}catch(MalformedURLException ee)
				{
					ee.printStackTrace();
				}
			}
		});

		//初始化
		this.init();
		this.setCardsLocation();
		pile = new PileOne(this);
		
		//纸牌堆
		pileone =  new JLabel[7];
		int x = 50;
		for(int i=0;i<7;i++)
		{
			pileone[i] = new JLabel();
			pileone[i].setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			pileone[i].setBounds(x,155,71,96);
			x += 115;
			pane.add(pileone[i]);
		}
		
		//回收堆
		piletwo = new JLabel[4];
		x = 50;
		for(int i=0;i<4;i++)
		{
			piletwo[i] = new JLabel();
			piletwo[i].setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			piletwo[i].setBounds(x,25,71,96);
			x += 115;
			pane.add(piletwo[i]);
		}

		//点击堆
		pilethree =  new JLabel();
		pilethree.setBounds(625,25,71,96);
		pilethree.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		pane.add(pilethree);
		pilethree.addMouseListener(new MouseAdapter()
		{
			public void mouseReleased(MouseEvent m)
			{
				turn();
				//System.out.println("haha");
			}
		});

		//点击显示堆
		pilefour = new JLabel();
		pilefour.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		pilefour.setBounds(740,25,71,96);
		pane.add(pilefour);
			
		//运行游戏
		setVisible(true);
		this.run();
		
	}
	public void init()
	{
		if (cards[0] != null)
		{
            for (int i = 0; i < 52; i++)
            {
                pane.remove(cards[i].label);
            }
        }

		for (int i = 1; i <= 4; i++)
		{
            for (int j = 1; j <= 13; j++)
            {
                cards[(i - 1) * 13 + j - 1] = new Card((i % 4+ 1) + "-" + j,this);
            }
        }
        
		this.random();
	}
	public void random()
	{
		Card temp = null;
		for (int i = 0; i < 52; i++)
		{
            int a = (int) (Math.random() * 52);
            int b = (int) (Math.random() * 52);
            temp = cards[a];
            cards[a] = cards[b];
            cards[b] = temp;
        }
	}
	
	public void setCardsLocation()
	{
        hashone = new Hashtable<Point, Card>();
        hashtwo = new Hashtable<Integer, Card>();
        int x = 625;
        int y = 25;
        /**
    	 **初始化待用堆24张纸牌
    	 */
        for (int i = 0; i <24; i++)
        {
			pane.add(cards[i].label);	
			cards[i].turnRear();
			cards[i].label.moveto(new Point(x, y));	
			hashone.put(new Point(x, y),cards[i]);	
			hashtwo.put(i,cards[i]);
        }
        /**
    	 **初始化桌面堆28张纸牌
    	 */
		x = 50;
        y = 155;
        int n=23;
		for (int i = 0; i<7; i++)
		{
			for (int j = 0; j <i+1; j++)
			{
                n++;
                pane.add(cards[n].label);
                cards[n].turnRear();
                cards[n].label.moveto(new Point(x, y));
                hashone.put(new Point(x, y), cards[n]);
                y-= 5;
            }
            x += 115;
            y=155+i*5+5;
        }
    }
	public void turn()
	{
		Card pocard=null;
		boolean bool=false;
		for(int i=0;i<remind;i++)
		{
			pocard=(Card)hashtwo.get(i);
			if(pocard.label.getLocation().x==625&&pocard.label.getLocation().y==25)
			{
				bool = true;
				pocard.turnFront();
				hashone.remove(pocard.label.getLocation());
                pocard.label.moveto(new Point(740, 25));
                pocard.setCanMove(true);               
                hashone.put(new Point(740, 25),pocard);
                pane.setComponentZOrder(pocard.label, 1);
                i=30;
			}
		}
		if(!bool)
		{
			for(int i=0;i<remind;i++)
			{
				pocard=(Card)hashtwo.get(i);
				if(pocard.label.getLocation().x==740&&pocard.label.getLocation().y==25)
				{
					pocard.turnRear();
					hashone.remove(pocard.label.getLocation());
	                pocard.label.moveto(new Point(625, 25));
	                pocard.setCanMove(false);	                
	                hashone.put(new Point(625, 25),pocard);
	                pane.setComponentZOrder(pocard.label, 1);
				}
			}
		}
	}

	public void run()
	{
		c=24;
        for(int i = 0;i < 7;i++)
		{
			c += i;
            Point lastPoint = pile.getLastLoc(i);
			hashone.remove(cards[c].label.getLocation());
            cards[c].label.moveto(lastPoint);
            hashone.put(new Point(lastPoint),cards[c]);
            cards[c].turnFront();
            cards[c].setCanMove(true); 
			this.pane.setComponentZOrder(cards[c].label, 1);
        }
	}

	public Point getPileOneLoc(int col)
	{
		return new Point(pileone[col].getLocation());
	}
	public Point getPileTwoLoc(int col)
	{
		return new Point(piletwo[col].getLocation());
	}



	public static void main(String[] args)
	{
		ZhiPai zhipai = new ZhiPai();
		zhipai.setVisible(true);
	}

}
class ImagePanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		ImageIcon icon = new ImageIcon("../images/pink.jpg");
		g.drawImage(icon.getImage(),0,0,null);
	}
}

class About extends JDialog
{
	JPanel pane = new ImagePanel();
	private JTextArea jt = new JTextArea("作者：东北师范大学计算机学院10级 齐嘉亮\n " + "\n备注：该游戏是根据对windows下的纸牌游戏研究及相关资料的学习完成的");

	public About()
	{
		setTitle("关于我们");
		setSize(250,200);
		setResizable(false);
		setLocationRelativeTo(getOwner());
		jt.setSize(250,200);
		jt.setEditable(false);
		jt.setLineWrap(true);
		jt.setFont(new Font("楷体",java.awt.Font.BOLD,16));
		jt.setForeground(Color.black);
		pane.add(jt);
		add(pane);
		pack();
		this.setVisible(true);
	}
}

//Pile类，为了以后四个类继承
class Pile
{
	ZhiPai zhipai = null;
	public Pile(ZhiPai zhipai)
	{
		this.zhipai = zhipai;
	}
}

//纸牌堆类
class PileOne extends Pile
{
	public PileOne(ZhiPai zhipai)
	{
		super(zhipai);
	}
	/*
	判断位于纸牌堆的那一列
	*/
	public int whichCol(Point point)
	{
		int x = point.x;
		int y = point.y;
		int m = (x-50)/115;
		int n = (x-50)%115;
		if(m<6)
		{		
			if(n>44&&n<=71)
			{
				m=-1;
			}
			else if(n>71)
			{
				m+=1;
			}
		}
		else if(n>71||m>6)
		{
			m=-1;
		}
		if(m!=-1)
		{
			Point p = getLastLoc(m);
			if(p==null) p = zhipai.getPileOneLoc(m);
			n = y-p.y;
			if(n<=0||n>=96)
			{
				m=-1;
			}
		}
		return m;
	}

	public Point getLastLoc(int col)
	{
		Point point = new Point(50+col*115,155);
		Card card = (Card)zhipai.hashone.get(point);
		if(card==null)
		{
			return null;
		}
		while(card!=null)
		{
			point = card.label.getLocation();
			card = getNext(card);
		}
		return point;
	}

	public Card getPrevious(Card card)
	{
		Point point = new Point(card.label.getLocation());
		point.y -= 5;
		card = (Card)zhipai.hashone.get(point);
		if(card!=null)
		{
			return card;
		}
		point.y -= 15;
		card = (Card)zhipai.hashone.get(point);
		return card;
	}
	public Card getNext(Card card)
	{
        Point point = new Point(card.label.getLocation());
        point.y += 5;
        card = (Card)zhipai.hashone.get(point);
        if(card != null)
		{
			return card;
		}
        point.y += 15;
        card = (Card)zhipai.hashone.get(point);
        return card;
    }
	public void setNextLoc(Point point,Card card)
	{
		Card c = getNext(card);
		if(c != null)
		{
			if(point == null)
			{
				setNextLoc(null,c);
				zhipai.hashone.remove(c.label.getLocation());
				c.label.setLocation(c.label.init);
				zhipai.hashone.put(c.label.init,c);
			}
			else
			{
				point = new Point(point);
				point.y += 20;
				setNextLoc(point,c);
				point.y -= 20;
				zhipai.hashone.remove(c.label.getLocation());
				c.label.setLocation(point);
				zhipai.hashone.put(c.label.getLocation(),c);
				c.label.init = c.label.getLocation();
			}
		}
	}
	
}

//回收堆类
class PileTwo extends Pile
{
	public PileTwo(ZhiPai zhipai)
	{
		super(zhipai);
	}

	public int whichCol(Point point)
	{
		int x = point.x;
		int y = point.y;
		int m = (x-50)/115;
		int n = (x-50)%115;
		if(m<3)
		{
			if(n>44&&n<=71)
			{
				m=-1;
			}
			else if(n>71)
			{
				m+=1;
			}
		}
		else if(n>71||m>3)
		{
			m=-1;
		}
		if(m!=-1)
		{
			Point p = zhipai.getPileTwoLoc(m);
			n = y-p.y;
			if(n<0||n>96)
			{
				m=-1;
			}
		}
		return m;
	}
	public Card getPrevious(Card card)
	{
        if(card.value==-1||card==null)
        {
        	return null;
        }
        int value=card.value-1;
        String name=card.type+"-"+value;
        Card c=new Card(name,zhipai);
        return c;
    }
	public Point getLastLoc(int col)
	{
		int x=0;
        switch(col)
        {
        case 1:
        	x=50;
        case 2:
        	x=165;
        case 3:
        	x=280;
        case 4:
        	x=395;
        }
		Point point=new Point(x,25);
		return point;
    }
}

//点击堆类
class PileThree extends Pile
{
	public PileThree(ZhiPai zhipai)
	{
		super(zhipai);
	}
	public Point getLastLoc(int col)
	{
		Point point=new Point(625,25);
		return point;
    }
}

//点击显示堆类
class PileFour extends Pile
{
	public PileFour(ZhiPai zhipai)
	{
		super(zhipai);
	}
	public Point getLastLoc(int col)
	{
		Point point=new Point(740,25);
		return point;
    }
}

class Card
{
	ZhiPai zhipai = null;
	JPanel pane = null;
	int value = 0;
	int type = 0;
	String name = null;
	boolean canMove = false;
	boolean isFront = false;
	Card previous = null;
	PileOne pile = null;
	CardLabel label = null;
	public Card(String name,ZhiPai zhipai)
    {
        this.type = new Integer(name.substring(0, 1)).intValue();
        this.value = new Integer(name.substring(2)).intValue();
        this.name = name;
        this.zhipai = zhipai;
        this.pane = (JPanel)this.zhipai.getContentPane();
        pile = new PileOne(this.zhipai);
        this.label = new CardLabel(Card.this);
    }
	public void turnFront()
	{
        this.label.setIcon(new ImageIcon("../images/" + name + ".gif"));
        this.isFront = true;
    }

	public void turnRear()
	{
        this.label.setIcon(new ImageIcon("../images/rear.gif"));
        this.isFront = false;
        this.canMove = false;
    }

	public void setCanMove(boolean can)
	{
        this.canMove = can;
        Card card = pile.getPrevious(this);
        if (card != null && card.isCardFront())
        {
            if (!can)
            {
                if (!card.isCardCanMove())
                {
                    return;
				}
                else{
					card.setCanMove(can);
				}
			}
            else
            {
                if (this.value + 1 == card.getCardValue()&& this.type%2 != card.getCardType()%2)
                {
					card.setCanMove(can);
				}
				else
				{
					card.setCanMove(false);
				}
            }
        }
    }

	public boolean isCardFront()
	{
        return this.isFront;
    }

	public boolean isCardCanMove(){
        return this.canMove;
    }

	public int getCardValue(){
        return value;
    }

	public int getCardType(){
        return type;
    }
	
}

class CardLabel extends JLabel implements MouseListener,MouseMotionListener
{
    Card car=null;
    Point point=null;
    Point init=null;
    PileOne po=null;
    PileTwo pt=null;
    Card previousCard=null;
    public CardLabel(Card ca)
    {
    	this.car=ca;
    	po=new PileOne(car.zhipai);
    	pt=new PileTwo(car.zhipai);
    	this.setIcon(new ImageIcon("images/rear.gif"));
        this.setSize(71, 96);
        this.setVisible(true);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}

    public void moveto(Point point) 
    {
        this.setLocation(point);
        this.init = point;
    }

    public void moving(int x, int y) 
    {
        Card card = po.getNext(this.car);
        Point p = this.getLocation(); 
        car.zhipai.pane.setComponentZOrder(this, 1);
        car.zhipai.hashone.remove(p);
        p.x += x;
        p.y += y;
        this.setLocation(p);
        car.zhipai.hashone.put(p, this.car);
        if (card != null) card.label.moving(x, y);
    }

    public void mouseDragged(MouseEvent e) 
    {
        if (car.canMove)
        {
            int x = 0;
            int y = 0;
            Point p = e.getPoint();
            x = p.x - point.x;
            y = p.y - point.y;
            this.moving(x, y);
        }
    }

    public void mousePressed(MouseEvent e) 
    {
        point = e.getPoint();
        this.previousCard = po.getPrevious(this.car);
    }
    public void mouseReleased(MouseEvent e) 
    {
        Point point = ((JLabel) e.getSource()).getLocation();
        if(point.y>90)
        {
            int n = po.whichCol(point);
            if (n == -1 || n == po.whichCol(this.init))
            {
                ((PileOne)po).setNextLoc(null,this.car);
                car.zhipai.hashone.remove(this.getLocation());
                this.setLocation(this.init);
                car.zhipai.hashone.put(this.init, this.car);
                return;
            }
		
            point = po.getLastLoc(n);
            boolean isEmpty = false;
            Card card = null;
            if (point == null)
            {
                point = car.zhipai.getPileOneLoc(n);
                isEmpty = true;
            }
            else
            {
                card = (Card) car.zhipai.hashone.get(point);
            }
            if ((isEmpty&&this.car.value==13)||(!isEmpty)&&(this.car.value + 1 == card.getCardValue())&&this.car.type%2!=card.type%2)
            {
                point.y += 40;
                if (isEmpty) point.y -= 20;
                ((PileOne)po).setNextLoc(point,this.car);
                car.zhipai.hashone.remove(this.getLocation());
                point.y -= 20;
                this.setLocation(point);
                car.zhipai.hashone.put(point, this.car);
                this.init = point;
                if (this.previousCard != null)
                {
                    this.previousCard.turnFront();
                    this.previousCard.setCanMove(true);
                }
                this.car.setCanMove(true);
            }
            else
            {
                ((PileOne)po).setNextLoc(null,this.car);
                car.zhipai.hashone.remove(this.getLocation());
                this.setLocation(this.init);
                car.zhipai.hashone.put(this.init, this.car);
                return;
            }
        }
        else
        {
            Card tcard = po.getNext(this.car);
            if(tcard!=null) 
            {
                ((PileOne)po).setNextLoc(null,this.car);
                car.zhipai.hashone.remove(this.getLocation());
                this.setLocation(this.init);
                car.zhipai.hashone.put(this.init, this.car);
                return;
            }
            int n = pt.whichCol(point);

            if (n == -1 || n == pt.whichCol(this.init))
            {
                car.zhipai.hashone.remove(this.getLocation());
                this.setLocation(this.init);
                car.zhipai.hashone.put(this.init, this.car);
                return;
            }
            boolean isEmpty = false;
            point = car.zhipai.getPileTwoLoc(n);
            Card scard = (Card) car.zhipai.hashone.get(point);
            if(scard==null)
            {
                isEmpty=true;
            }
            if ((isEmpty&&this.car.value==1)||
            (!isEmpty)&&(this.car.value - 1 == scard.getCardValue())&&this.car.type==scard.type)
            {
                car.zhipai.hashone.remove(this.getLocation());
                this.setLocation(point);
                car.zhipai.hashone.put(point, this.car);
                this.init = point;
                if (this.previousCard != null)
                {
                    this.previousCard.turnFront();
                    this.previousCard.setCanMove(true);
                }
                this.car.setCanMove(true);
            }
            else
            {
                car.zhipai.hashone.remove(this.getLocation());
                this.setLocation(this.init);
                car.zhipai.hashone.put(this.init, this.car);
                return;
            }
            Point p1 = car.zhipai.getPileTwoLoc(0);
            Card ca1=(Card)car.zhipai.hashone.get(p1);
            Point p2 = car.zhipai.getPileTwoLoc(1);
            Card ca2=(Card)car.zhipai.hashone.get(p2);
            Point p3 = car.zhipai.getPileTwoLoc(2);
            Card ca3=(Card)car.zhipai.hashone.get(p3);
            Point p4 = car.zhipai.getPileTwoLoc(3);
            Card ca4=(Card)car.zhipai.hashone.get(p4);
            if(ca1==null||ca2==null||ca3==null||ca4==null)
            {
                return;
            }
            else if(ca1.value==13&&ca2.value==13&&ca3.value==13&&ca4.value==13)
            {
                JOptionPane.showMessageDialog(car.zhipai.pane, "恭喜，完成游戏！", "恭喜",	JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}