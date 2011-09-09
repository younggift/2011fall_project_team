import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
public class WindowMenu extends JFrame{
	JMenuBar menubar;
	JMenu menu,subMenu;
	JMenuItem item1,item2;
	public WindowMenu(){}
	public WindowMenu(String s,int x,int y,int w,int h)
	{
		init(s);
		setLocation(x,y);
		setSize(w,h);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	void init(String s)
	{
		setTitle(s);
		menubar=new JMenuBar();
		menu=new JMenu("�˵�");
		subMenu=new JMenu("�Ӳ˵�");
		item1=new JMenuItem("�½�");
		item2=new JMenuItem("����");
		item1.setAccelerator(KeyStroke.getKeyStroke('N'));
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		menu.add(item1);
		menu.addSeparator();
		menu.add(item2);
		menu.add(subMenu);
		subMenu.add(new JMenuItem("����"));
		menubar.add(menu);
		setJMenuBar(menubar);
		
	}

}
