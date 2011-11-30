import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Huarongdao extends JFrame implements KeyListener,MouseListener,ActionListener
{
	JMenuBar jMenuBar1 = new JMenuBar();
	JMenu jMenu1 = new JMenu();
	JMenu jMenuhelp = new JMenu();
	JMenuItem jMenubegin = new JMenuItem();
	JMenuItem jMenuabout = new JMenuItem();
	JMenuItem jMenuexit =  new JMenuItem();

	Person person[]=new Person[10];
	JButton left,right,above,below;
	JPanel contentPane;
	public Huarongdao()
	{
		init();
		setBounds(300,200,320,420);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void init()
	{
		this.setTitle("华容道_By:齐嘉亮");
		jMenuBar1.add(jMenu1);
		jMenu1.add(jMenubegin);
		jMenu1.add(jMenuexit);
		jMenuBar1.add(jMenuhelp);
		jMenuhelp.add(jMenuabout);
		jMenu1.setActionCommand("文件");
		jMenu1.setText("文件");
		jMenuhelp.setActionCommand("帮助");
		jMenuhelp.setText("帮助");
		jMenubegin.setActionCommand("开始游戏/重新开始");
		jMenubegin.setText("开始游戏/重新开始");
		jMenubegin.addActionListener(this);
		jMenuexit.setActionCommand("退出");
		jMenuexit.setText("退出");
		jMenuexit.addActionListener(new ExitAction());
		jMenuabout.setActionCommand("关于");
		jMenuabout.addActionListener(new AboutAction(this));
		jMenuabout.setSelected(false);
		jMenuabout.setText("关于");
		setJMenuBar(jMenuBar1);

		contentPane=(JPanel)getContentPane();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.pink);
		String name[] = {"曹操","关羽","飞","超","忠","云","卒","卒","卒","卒"};
		for(int i=0;i<name.length;i++)
		{
			person[i]=new Person(i,name[i]);
			person[i].addKeyListener(this);
			person[i].addMouseListener(this);
			contentPane.add(person[i]);
		}
		person[0].setBounds(100,50,100,100);
		person[1].setBounds(100,200,100,50);
		person[2].setBounds(50,50,50,100);
		person[3].setBounds(200,50,50,100);
		person[4].setBounds(50,150,50,100);
		person[5].setBounds(200,150,50,100);
		person[6].setBounds(50,250,50,50);
		person[7].setBounds(100,250,50,50);
		person[8].setBounds(150,250,50,50);
		person[9].setBounds(200,250,50,50);
		person[1].requestFocus();
		left=new JButton();  
		right=new JButton();
		above=new JButton();
		below=new JButton();
		contentPane.add(left);
		contentPane.add(right);
		contentPane.add(above);
		contentPane.add(below);
		left.setBounds(45,45,5,260);
		left.setBackground(Color.red);
		right.setBounds(250,45,5,260);
		right.setBackground(Color.red);
		above.setBounds(45,45,210,5);
	    above.setBackground(Color.red);
		below.setBounds(45,300,210,5);
		below.setBackground(Color.red);

	}
	public void keyPressed(KeyEvent e){  
		Person man=(Person)e.getSource();  
		if(e.getKeyCode()==KeyEvent.VK_DOWN){             
			goDown(man); 
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){              
			goUp(man);
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){              
		     goLeft(man);
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){            
			goRight(man);    
		}
	}
	public void keyTyped(KeyEvent e){
	}
    public void keyReleased(KeyEvent e){
	}
	public void mousePressed(MouseEvent e){
		Person man=(Person)e.getSource();      
		int x=1,y=1;
		x=e.getX();
		y=e.getY();
		int w=man.getBounds().width;
		int h=man.getBounds().height;
		if(y>h/2)
			goDown(man); 
		if(y<h/2)
			goUp(man);
		if(x<w/2)
			goLeft(man);
		if(x>w/2)
			goRight(man);
	}
	public void mouseReleased(MouseEvent e){
	}
	public void mouseEntered(MouseEvent e){
	}
	public void mouseExited(MouseEvent e){
	}
	public void mouseClicked(MouseEvent e){
	}
	public void goDown(Person man){
		boolean move=true;
		Rectangle manRect=man.getBounds();
		int x=man.getBounds().x;
		int y=man.getBounds().y;
		y=y+50;
		manRect.setLocation(x,y);
		Rectangle belowRect=below.getBounds();
		for(int i=0;i<10;i++){ 
			Rectangle personRect=person[i].getBounds();
			if((manRect.intersects(personRect))&&(man.number!=i))
				move=false;
			}
		if(manRect.intersects(belowRect))
			move=false;
		if(move==true)
			man.setLocation(x,y);
	}
	public void goUp(Person man) {
		boolean move=true;
		Rectangle manRect=man.getBounds();
		int x=man.getBounds().x;
		int y=man.getBounds().y;
		y=y-50;
		manRect.setLocation(x,y);
		Rectangle aboveRect=above.getBounds();
		for(int i=0;i<10;i++) { 
			Rectangle personRect=person[i].getBounds();
			if((manRect.intersects(personRect))&&(man.number!=i))
				move=false;
		}
		if(manRect.intersects(aboveRect))
			move=false;
		if(move==true)
			man.setLocation(x,y);
	}
	public void goLeft(Person man) {
      boolean move=true;
      Rectangle manRect=man.getBounds();
      int x=man.getBounds().x;
      int y=man.getBounds().y;
      x=x-50;
      manRect.setLocation(x,y);
      Rectangle leftRect=left.getBounds();
      for(int i=0;i<10;i++) { 
         Rectangle personRect=person[i].getBounds();
         if((manRect.intersects(personRect))&&(man.number!=i))
              move=false;
      }
      if(manRect.intersects(leftRect))
         move=false;
      if(move==true)
         man.setLocation(x,y);
	}
	public void goRight(Person man)  {
		boolean move=true;
		Rectangle manRect=man.getBounds();
		int x=man.getBounds().x;
		int y=man.getBounds().y;
		x=x+50;
		manRect.setLocation(x,y);
		Rectangle rightRect=right.getBounds();
		for(int i=0;i<10;i++) { 
			Rectangle personRect=person[i].getBounds();
			if((manRect.intersects(personRect))&&(man.number!=i))
				move=false;
			}
		if(manRect.intersects(rightRect))
			move=false;
		if(move==true)
			man.setLocation(x,y);
	}
	public void actionPerformed(ActionEvent e){  
		contentPane.removeAll();
		init();
	} 
	public static void main(String args[])
	{
		new Huarongdao();
	}
}
class Person extends JButton implements FocusListener
{
	int number;
	Color c;
	Person(int number,String s)
	{
		super(s);
		this.number=number;
		setForeground(Color.black);
		setBackground(Color.cyan);
		c=getBackground();
		setFont(new Font("楷体",Font.CENTER_BASELINE,14));
		addFocusListener(this);
	}
	public void focusGained(FocusEvent e)
	{
		setBackground(Color.green);
	}
	public void focusLost(FocusEvent e)
	{
		setBackground(c);
	}
}
class ExitAction implements ActionListener{
	public ExitAction() {
    }
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
class AboutDialog extends JDialog implements ActionListener
{
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel insetsPanel1 = new JPanel();
	JPanel insetsPanel2 = new JPanel();
	JPanel insetsPanel3 = new JPanel();
	JButton button1 = new JButton();
	JLabel imageLabel = new JLabel(new ImageIcon("C:/Users/GAY/Desktop/华容道游戏/wolf.jpg"));
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	BorderLayout borderLayout1 = new BorderLayout();
	BorderLayout borderLayout2 = new BorderLayout();
	FlowLayout flowLayout1 = new FlowLayout();
	GridLayout gridLayout1 = new GridLayout();
	String product="made by 齐嘉亮";
	String version="version 1.0";
	String copyright="Copyright (c) 2011-11";
	String comments="欢迎您的批评与指正";

	public AboutDialog(Huarongdao parent)
	{
		super(parent);
		try{
			init();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void init() throws Exception{
		this.setTitle("关于");
		panel1.setLayout(borderLayout1);
		panel2.setLayout(borderLayout2);
		insetsPanel1.setLayout(flowLayout1);
		insetsPanel2.setLayout(flowLayout1);
		insetsPanel2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		gridLayout1.setRows(4);
		gridLayout1.setColumns(1);
		label1.setText(product);
		label2.setText(copyright);
		label3.setText(version);
		label4.setText(comments);
		insetsPanel3.setLayout(gridLayout1);
		insetsPanel3.setBorder(BorderFactory.createEmptyBorder(10,60,10,10));
		button1.setText("确定");
		button1.addActionListener(this);
		insetsPanel2.add(imageLabel);
		panel2.add(insetsPanel2,BorderLayout.WEST);
		this.getContentPane().add(panel1);
		insetsPanel3.add(label1);
		insetsPanel3.add(label2);
		insetsPanel3.add(label3);
		insetsPanel3.add(label4);
		panel2.add(insetsPanel3,BorderLayout.CENTER);
		insetsPanel1.add(button1);
		panel1.add(insetsPanel1,BorderLayout.SOUTH);
		panel1.add(panel2,BorderLayout.NORTH);
		setResizable(true);
		
	}  
	protected void processWindowEvent(WindowEvent e)
	{
		if(e.getSource()==WindowEvent.WINDOW_CLOSING){
			dispose();
		}
		super.processWindowEvent(e);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==button1)
		{
			dispose();
		}
	}
}
class AboutAction implements ActionListener{
	private Huarongdao huarongdao;
	public AboutAction(Huarongdao huarongdao){
		this.huarongdao = huarongdao;
	}
	public void actionPerformed(ActionEvent e){
		AboutDialog dlg = new AboutDialog(this.huarongdao);
		Dimension dlgSize = dlg.getPreferredSize();
		Dimension frmSize = this.huarongdao.getSize();
		Point loc = this.huarongdao.getLocation();
		dlg.setLocation(100+loc.x,100+loc.y);
		dlg.pack();
		dlg.show();
	}
}