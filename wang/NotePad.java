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
    	super("���±�");
    	menubar=new JMenuBar();
    	menu1=new JMenu("�ļ�");
    	menu2=new JMenu("��ʽ");
    	menu3=new JMenu("����");
    	
    	item1=new JMenuItem("�½�");
    	item2=new JMenuItem("��");
    	item3=new JMenuItem("����");
    	item4=new JMenuItem("���Ϊ");
    	item5=new JMenuItem("�˳�");
    	
    	item6=new JMenuItem("�Զ�����");
    	item7=new JMenuItem("����");
    	
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
