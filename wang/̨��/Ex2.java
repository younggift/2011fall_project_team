import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Ex2 extends JFrame implements MouseListener {

	
	JButton jt;
	long t1,t2;
	
	public Ex2()
	{
		super("鼠标单击时间测试");
		
		setBounds(100, 100, 800, 600);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.green);
		jt=new JButton("开始");
		add(jt);
		jt.addMouseListener(this);
		init();
		
	}
	
	public void init()
	{
		setBackground(Color.green);
	}

	
	public void  mouseClicked(MouseEvent e)
	{
		
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){
		 t1 = System.currentTimeMillis();
	}
	public void mouseReleased(MouseEvent e){
		 t2 = System.currentTimeMillis();
		 System.out.println(t2-t1);
	}
	public static void main(String[] args) {
		new Ex2();

	}

}
