import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Clearbomb_GUI extends JFrame implements ActionListener,MouseListener
{
	int row=15,line=18,num=99;//定义雷区大小和雷数
	JButton bt[][]=new JButton[row+10][line+10];
	JButton time=new JButton("计时");
	JTextField counter=new JTextField("099",3);
	JTextField text=new JTextField("0",4);
	JMenuBar menubar;
	JMenu menu1,menu2;
	JMenuItem item1,item2,item3,item4,item5,item6;
	JPanel p=new JPanel();
	Timer timer;
	
	
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
	public void actionPerformed(ActionEvent e)
	{
		//JMenuItem s=(JMenuItem)(e.getSource());
		//System.out.println(s.getText());
		
		if(e.getSource()==item1)
		{
			//setVisible(false);
			//new Clearbomb();
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
			row=10;
			line=10;
		}
		if(e.getSource()==time)
		{
			timer.start();
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
	
	public void mouseClicked(MouseEvent e)
	{
			if(e.getModifiers()==MouseEvent.BUTTON1_MASK)
			{
				System.out.println("dig");
			}
			else if(e.getModifiers()==MouseEvent.BUTTON3_MASK)
			{
				System.out.println("mark");
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