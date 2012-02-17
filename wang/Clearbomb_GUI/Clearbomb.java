import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Clearbomb extends JFrame implements ActionListener,MouseListener
{
	int row,line,num;//定义雷区大小和雷数
	int t,T;
	String s;
	JButton bt[][]=new JButton[110][110];
	JButton bt1=new JButton("是");
	JButton bt2=new JButton("否");
	JLabel label[][]=new JLabel[110][110];
	JButton time=new JButton("开始");
	JTextField counter;
	JTextField text=new JTextField("0",4);
	JMenuBar menubar;
	JMenu menu1,menu2;
	JMenuItem item1,item2,item3,item4,item5,item6;
	JPanel p=new JPanel();
	Timer timer;
	int h=0;
	int a[]=new int[100];
	int b[]=new int[100];
	int x,y;
	int X[]={-1,0,1,-1,1,-1,0,1};
	int Y[]={-1,-1,-1,0,0,1,1,1};
	char bomb[][]=new char[110+10][110+10];
	int show[][]=new int[110][110];
	boolean flag[][]=new boolean[110][110]; 
	Font f1=new Font("Serif",0,20);
	boolean tt;//判断是否是第一次挖或标记

	ImageIcon lei=new ImageIcon("lei.gif");
	ImageIcon qi=new ImageIcon("qi.gif");
    ImageIcon blank=new ImageIcon("blank.gif");
	ImageIcon wrongmine=new ImageIcon("wrongmine.gif");
    
    JComponent pp[][]=new JComponent[110][110];
    JLabel l=new JLabel(qi);
    int t1=0,t2=0;

	
	
	public Clearbomb(int prow,int pline,int pnum,int a,int b,int c)
	{
		super("扫雷");
		tt=true;
		T=0;
		s="0"+pnum;
		counter=new JTextField(s,3);
		row=prow;
		line=pline;
		num=pnum;
		t=pnum;
		menubar=new JMenuBar();
		menu1=new JMenu("扫雷");
		menu2=new JMenu("帮助");
		item1=new JMenuItem("开始");
		item2=new JMenuItem("初级");
		item3=new JMenuItem("中级");
		item4=new JMenuItem("高级");
		item5=new JMenuItem("自定义");
		item6=new JMenuItem("退出");
		
		menu1.add(item1);
		menu1.insertSeparator(1);
		menu1.add(item2);
		
		menu1.add(item3);
		menu1.add(item4);
		menu1.add(item5);
		menu1.insertSeparator(5);
		menu1.add(item6);
		menubar.add(menu1);
		menubar.add(menu2);
		setJMenuBar(menubar);
		
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		item5.addActionListener(this);
		item6.addActionListener(this);

        frameDesign(a,b,c);
		p.setBackground(Color.cyan);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}


	public void frameDesign(int a,int b,int c)
	{
		add(p);
		p.setLayout(null);
		
		
		Font f=new Font("宋体",Font.BOLD,25);
		counter.setFont(f);
		text.setFont(f);
		counter.setBackground(Color.red);
		text.setBackground(Color.green);
		p.add(counter);
		setCounterBounds(a);
		
		p.add(time);
		time.addActionListener(this);
		setTimeBounds(b);

		p.add(text);
		setTextBounds(c);
		
		timer =new Timer(1000,(ActionListener) this);
	
        for(int i=0;i<row;i++)
        {
        	for(int j=0;j<line;j++)
        	{
        		bt[i][j]=new JButton();
        		
        		pp[i][j]=bt[i][j];
        		
        		p.add(bt[i][j]);
        		bt[i][j].addMouseListener(this);
        		bt[i][j].setBounds(30*j,25*(i+1),30,25);
				bt[i][j].setEnabled(true);
        	}
        }
	}

	public void setCounterBounds(int a)
	{
		counter.setBounds(a,0,50,20);
	}

	public void setTextBounds(int b)
	{
		text.setBounds(b,0,60,20);
	}

	public void setTimeBounds(int c)
	{
		time.setBounds(c,0,60,20);
	}


	public void go(int w,int l)
	{
		setVisible(true);
		setBounds(100,100,w,l);
	}

	public void ungo()
	{
		setVisible(false);
	}

	public void rand()//产生随机数
	{
		while(h<num)
		{
			a[h]=(int)(Math.random()*row);
			b[h]=(int)(Math.random()*line);
			for(int i=0;i<h;i++)
			{
				if(a[h]==a[i]&&b[h]==b[i])
				{
					h--;
					break;
				}
			}
			h++;
		}
	}
	public void setBomb()//布雷
	{
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<line;j++)
			{
				bomb[i][j]='\0';
			}
		}
		
		for(int i=0;i<num;i++)
		{
			bomb[a[i]][b[i]]='*';
		}

	}
	public void showBombNum()//展示非雷位置处的数字
	{
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<line;j++)
			{
				if(bomb[i][j]!='*')
				{
				    for(int k=0;k<8;k++)
				    {
				    	if(f(i+X[k],j+Y[k])&&bomb[i+X[k]][j+Y[k]]=='*')  show[i][j]++;
				    }
				}
				else show[i][j]=9;//是雷的位置处标记为1
			}
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==item1)
		{
			this.ungo();
			new Clearbomb(15,18,20,100,240,300).go(549,460);
		}
		
		if(e.getSource()==item2)
		{
			this.ungo();
			row=10;
			line=10;
			num=10;
			new Clearbomb(row,line,num,30,120,180).go(305,335);
		}
		if(e.getSource()==item3)
		{
			this.ungo();
			row=15;
			line=18;
			num=50;
			new Clearbomb(row,line,num,100,240,300).go(549,460);

			
		}
		if(e.getSource()==item4)
		{
			this.ungo();
			row=20;
			line=20;
			num=99;
			new Clearbomb(row,line,num,150,320,380).go(610,585);
		}
		if(e.getSource()==item5)
		{
			
		}
		if(e.getSource()==item6)
		{
			System.exit(0);
		}
		if(e.getSource()==time)
		{
			this.ungo();
			if(row==10) new Clearbomb(row,line,num,30,120,180).go(305,335);
            else if(row==15) new Clearbomb(row,line,num,100,240,300).go(549,460);
		    else new Clearbomb(row,line,num,150,320,380).go(610,585);

			timer.start();
			rand();
			setBomb();
			showBombNum();
		}

		if(e.getSource()==timer)
		{
			String time=text.getText().trim();
			int t=Integer.parseInt(time);
			if(t>1000)  timer.stop();
			else
			{
				t++;
				text.setText(t+"");
			}	
		}

	}



	
	public boolean f(int x,int y)
	{
		if(x<0||x>=row||y<0||y>=line) return false;
		return true;
	}
	public void show(int x,int y)
	{
		
		if(!f(x,y))  return ;
		if(flag[x][y]) return ;
		if(show[x][y]==0)
		{
			p.remove(bt[x][y]);
			label[x][y]=new JLabel(blank);
			p.add(label[x][y]);
			
			pp[x][y]=label[x][y];
			
			label[x][y].setBounds(30*y,25*(x+1),30,25);
			T++;
			flag[x][y]=true;
		}
		if(show[x][y]>0&&show[x][y]<9)
		{
			p.remove(bt[x][y]);
			label[x][y]=new JLabel(String.valueOf(show[x][y]),SwingConstants.CENTER);//★
		    label[x][y].setFont(f1);
		    label[x][y].setForeground(Color.blue);
		    p.add(label[x][y]);
		    
		    pp[x][y]=label[x][y];
		    
			label[x][y].setBounds(30*y,25*(x+1),30,25);
			flag[x][y]=true;
			T++;
			return;
		}

		for(int i=0;i<8;i++)
		{
			show(x+X[i],y+Y[i]);
		}
	}

	public void isWin()
	{
		timer.stop();
		int result=JOptionPane.showConfirmDialog(this,"您赢了，是否继续？","恭喜",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
		if(result==JOptionPane.YES_OPTION)
		{
			this.ungo();
			new Clearbomb(15,18,20,100,240,300).go(549,460);
		}
		else
		{
			//System.exit(0);
		}
	}
	
	public void isFail()
	{
		timer.stop();
		for(int i=0;i<num;i++)
		{
			if(bomb[a[i]][b[i]]=='*'&&pp[a[i]][b[i]]==bt[a[i]][b[i]])
			{
				p.remove(bt[a[i]][b[i]]);
				label[a[i]][b[i]]=new JLabel(lei);
				p.add(label[a[i]][b[i]]);
				label[a[i]][b[i]].setBounds(30*b[i], 25*(a[i]+1), 30, 25);
			}
			
		}

		for(int i=0;i<row;i++)
		{
			for(int j=0;j<line;j++)
			{
				if(pp[i][j]==label[i][j]&&label[i][j].getIcon()==qi&&show[i][j]!=9)
				{
				    p.remove(label[i][j]);
				    label[i][j]=new JLabel(wrongmine);
				    p.add(label[i][j]);
				    label[i][j].setBounds(30*j, 25*(i+1), 30, 25);
				}

			}
		}

		int result=JOptionPane.showConfirmDialog(this,"您输了，是否重新来过？","很遗憾",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
		if(result==JOptionPane.YES_OPTION)
		{
			this.ungo();
			if(row==10) new Clearbomb(row,line,num,30,120,180).go(305,335);
            else if(row==15) new Clearbomb(row,line,num,100,240,300).go(549,460);
		    else new Clearbomb(row,line,num,150,320,380).go(610,585);
		}
		else
		{
			//System.exit(0);
		}
				
	}
	
	public void mouseClicked(MouseEvent e)
	{
		    if(tt==true)
		    {
				timer.start();
				rand();
			    setBomb();
			    showBombNum();

				tt=false;
			}


		    for(int i=0;i<row;i++)
		    {
		    	for(int j=0;j<line;j++)
		    	{
		    		if(e.getSource()==bt[i][j])
		    		{
		    			x=i;
		    			y=j;
		    			break;
		    		}
		    	}
		    }


			if(e.getModifiers()==MouseEvent.BUTTON1_MASK)
			{
				if(e.getSource()==bt[x][y])
				{
						if(show[x][y]!=9)
						{
						    show(x,y);
						}

						else
						{
							isFail();
						}
							
				}
				
				
			}


			else if(e.getModifiers()==MouseEvent.BUTTON3_MASK)
			{
				if(e.getSource()==bt[x][y])
				{
				   p.remove(bt[x][y]);
				   label[x][y]=new JLabel(qi);
				   p.add(label[x][y]);
				   
				   pp[x][y]=label[x][y];
				   
				   label[x][y].setBounds(30*y,25*(x+1),30,25);
				   label[x][y].addMouseListener(this);

				   T++;

                   t--;
				   counter.setText(null);
				   s="0"+t;
				   counter.setText(s);
				}
				if(e.getSource()==label[x][y])
				{
					p.remove(label[x][y]);
					bt[x][y]=new JButton();
					p.add(bt[x][y]);
					
					pp[x][y]=bt[x][y];
					
					bt[x][y].setBounds(30*y,25*(x+1),30,25);
					bt[x][y].addMouseListener(this);
					
					T--;
					t++;
					counter.setText(null);
					s="0"+t;
					counter.setText(s);
				}
			}
			if(T==row*line) isWin();
	}


	public void mousePressed(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	
	
	public static void main(String[] args)
	{
		new Clearbomb(15,18,20,100,240,300).go(549,460);
	}
	
}