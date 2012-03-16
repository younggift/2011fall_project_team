import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class NotePad extends JFrame /*implements ActionListener,ItemListener,MouseListener*/{
    JMenuBar menubar;
    JMenu menu1,menu2,menu3,menu4;
    JMenuItem item1,item2,item3,item4,item5,item6,item7;
    JPanel p=new JPanel();
    public NotePad()
    {
    	super("记事本");
    	menubar=new JMenuBar();
    	menu1=new JMenu("文件");
    	menu2=new JMenu("格式");
    	menu3=new JMenu("帮助");
    	
    	item1=new JMenuItem("新建");
    	item2=new JMenuItem("打开");
    	item3=new JMenuItem("保存");
    	item4=new JMenuItem("另存为");
    	item5=new JMenuItem("退出");
    	
    	item6=new JMenuItem("自动换行");
    	item7=new JMenuItem("字体");
    	
    	menu1.add(item1);
    	menu1.add(item2);
    	menu1.add(item3);
    	menu1.add(item4);
    	menu1.insertSeparator(4);
    	menu1.add(item5);
    	
    	menu2.add(item6);
    	menu2.add(item7);
    	
    	menubar.add(menu1);
    	menubar.add(menu2);
    	menubar.add(menu3);
    	setJMenuBar(menubar);
    	
    	p.setBackground(Color.cyan);
    	add(p);
    	setBounds(200,100,600,600);
    	setVisible(true);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new NotePad();
	}

}
