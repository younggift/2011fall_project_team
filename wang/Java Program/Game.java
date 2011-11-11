import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Game extends JFrame implements ActionListener
{
	JButton jt[]=new JButton[100];
	JPanel p=new JPanel();
	public Game()
	{
		//setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		add(p);
		p.setLayout(new GridLayout(10,10,0,0));
		for(int i=0;i<100;i++)
		{
			jt[i]=new JButton();
	        p.add(jt[i]);
			jt[i].addActionListener(this);
		}
		this.pack();
		this.setTitle("·½¸ñ");
		this.setBounds(100,200,340,272);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		for(int i=0;i<100;i++)
		{
			if(e.getSource()==jt[i])
			{
				System.out.println("hello");
			}
			
		}
	}
	public static void main(String[] args)
	{
		new Game();
	}
}