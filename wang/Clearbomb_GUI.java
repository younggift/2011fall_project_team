import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Clearbomb_GUI extends JFrame implements ActionListener,MouseListener
{
	int row=15,line=18,num=50;//定义雷区大小和雷数
	JButton bt[][]=new JButton[row+10][line+10];
	JLabel label[][]=new JLabel[row+10][line+10];
	JButton time=new JButton("开始");
	JTextField counter=new JTextField("099",3);
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
	char bomb[][]=new char[row+10][line+10];
	int show[][]=new int[row+10][line+10];
	Font f1=new Font("Serif",0,20);


	
	
	public Clearbomb_GUI()
	{
		super("扫雷");
        add(p);
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
		
		p.setLayout(null);
		
		
		Font f=new Font("宋体",Font.BOLD,25);
		counter.setFont(f);
		text.setFont(f);
		counter.setBackground(Color.red);
		text.setBackground(Color.green);
		p.add(counter);
		counter.setBounds(100, 0, 50, 20);
		
		p.add(time);
		time.addActionListener(this);
		time.setBounds(240, 0, 60,20);
		p.add(text);
		text.setBounds(300,0,60,20);
		
		timer =new Timer(1000,(ActionListener) this);
	
        for(int i=0;i<row;i++)
        {
        	for(int j=0;j<line;j++)
        	{
        		bt[i][j]=new JButton();
        		p.add(bt[i][j]);
        		bt[i][j].addMouseListener(this);
        		bt[i][j].setBounds(30*j,25*(i+1),30,25);
        	}
        }
        
        
        setBounds(100,200,540+9,460);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
					if(i==0&&j==0)
					{
						if(bomb[i+1][j]=='*') show[i][j]++;
						if(bomb[i+1][j+1]=='*') show[i][j]++;
						if(bomb[i][j+1]=='*')   show[i][j]++;
					}
					
					if(i==row-1&&j==0)
					{
						if(bomb[i-1][j]=='*') show[i][j]++;
						if(bomb[i-1][j+1]=='*')  show[i][j]++;
						if(bomb[i][j+1]=='*')    show[i][j]++;
					}
					
					if(i==0&&j==line-1)
					{
						if(bomb[i][j-1]=='*')   show[i][j]++;
						if(bomb[i+1][j-1]=='*')  show[i][j]++;
						if(bomb[i+1][j]=='*')    show[i][j]++;
					} 
					if(i==row-1&&j==line-1)
					{
						if(bomb[i][j-1]=='*')    show[i][j]++;
						if(bomb[i-1][j]=='*')    show[i][j]++;
						if(bomb[i-1][j-1]=='*')  show[i][j]++;
						
					}
					if(i==0&&j>0&&j<line-1)
					{
						if(bomb[i][j-1]=='*')   show[i][j]++;
						if(bomb[i][j+1]=='*')   show[i][j]++;
						if(bomb[i+1][j-1]=='*') show[i][j]++;
						if(bomb[i+1][j]=='*')   show[i][j]++;
						if(bomb[i+1][j+1]=='*') show[i][j]++;
					}
					if(i==row-1&&j>0&&j<line-1)
					{
						if(bomb[i][j-1]=='*')   show[i][j]++;
						if(bomb[i][j+1]=='*')   show[i][j]++;
						if(bomb[i-1][j-1]=='*') show[i][j]++;
						if(bomb[i-1][j]=='*')   show[i][j]++;
						if(bomb[i-1][j+1]=='*') show[i][j]++;
					}
					if(i>0&&i<row-1&&j==0)
					{
						if(bomb[i-1][j]=='*')   show[i][j]++;
						if(bomb[i+1][j]=='*')   show[i][j]++;
						if(bomb[i][j+1]=='*') show[i][j]++;
						if(bomb[i-1][j+1]=='*')   show[i][j]++;
						if(bomb[i+1][j+1]=='*') show[i][j]++;
						
					}
					if(i>0&&i<row-1&&j==line-1)
					{
						if(bomb[i-1][j]=='*')   show[i][j]++;
						if(bomb[i+1][j]=='*')   show[i][j]++;
						if(bomb[i][j-1]=='*')    show[i][j]++;
						if(bomb[i-1][j-1]=='*')   show[i][j]++;
						if(bomb[i+1][j-1]=='*')   show[i][j]++;
					}
					if(i>0&&i<row-1&&j>0&&j<line-1)
					{
						if(bomb[i-1][j]=='*')    show[i][j]++;
						if(bomb[i-1][j-1]=='*')  show[i][j]++;
						if(bomb[i+1][j-1]=='*')  show[i][j]++;
						if(bomb[i][j-1]=='*')    show[i][j]++;
						if(bomb[i+1][j]=='*')    show[i][j]++;
						if(bomb[i][j+1]=='*')    show[i][j]++;
						if(bomb[i-1][j+1]=='*')  show[i][j]++;
						if(bomb[i+1][j+1]=='*')  show[i][j]++;
						
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
			for(int i=0;i<15;i++)
			{
				for(int j=0;j<18;j++)
				{
					bt[i][j]=new JButton();
				}
			}
				
		}
		if(e.getSource()==item2)
		{
			
			row=7;
			line=8;
			num=10;
		}
		if(e.getSource()==item3)
		{
			row=10;
			line=12;
			num=30;
			
		}
		if(e.getSource()==item4)
		{
			row=20;
			line=20;
			num=99;
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
			timer.start();
			rand();
			setBomb();
			showBombNum();
			print();
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
	public void print()
	{
		for(int i=0;i<num;i++)
		{
			System.out.println(a[i]+" "+b[i]);
			
		}
	}
	
	
	
	public void mouseClicked(MouseEvent e)
	{
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
				for(int i=0;i<num;i++)
				{
					
						p.remove(bt[x][y]);
						if(show[x][y]!=9)
						{
						    label[x][y]=new JLabel(String.valueOf(show[x][y]),SwingConstants.CENTER);//★
						    label[x][y].setFont(f1);
						    label[x][y].setForeground(Color.blue);
						}
						else
						{
							label[x][y]=new JLabel("⊙",SwingConstants.CENTER);
						    
						}
						p.add(label[x][y]);
						label[x][y].setBounds(30*y,25*(x+1),30,25);
				}
				
			}
			else if(e.getModifiers()==MouseEvent.BUTTON3_MASK)
			{
				p.remove(bt[x][y]);
				label[x][y]=new JLabel("★",SwingConstants.CENTER);//⊙
				p.add(label[x][y]);
				label[x][y].setBounds(30*y,25*(x+1),30,25);
			}
	}
	
	public void mousePressed(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	
	
	public static void main(String[] args)
	{
		new Clearbomb_GUI();
		
	}
	
}