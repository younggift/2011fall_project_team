import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class NotePad2 extends JFrame implements ActionListener/*ItemListener,MouseListener*/{
    JMenuBar menubar;
    JMenu menu1,menu2,menu3;
    JMenuItem item1,item2,item3,item4,item5,item6,item7;
    JTextArea area;

    
    public NotePad2()
    {
    	super("记事本");
    	area=new JTextArea();
    	JScrollPane p=new JScrollPane(area);
    	menubar=new JMenuBar();
    	menu1=new JMenu("文件");
    	menu2=new JMenu("格式");
    	menu3=new JMenu("帮助");
    	
    	item1=new JMenuItem("新建");
    	item2=new JMenuItem("打开");
    	item3=new JMenuItem("保存");
    	item4=new JMenuItem("另存为");
    	item5=new JMenuItem("退出");
    	
    	item6=new JMenuItem("字体");
    	item7=new JMenuItem("格式");
    	
    	menu1.add(item1);
    	item1.addActionListener(this);
    	
    	menu1.add(item2);
    	item2.addActionListener(this);
    	
    	menu1.add(item3);
    	item3.addActionListener(this);
    	
    	menu1.add(item4);
    	item4.addActionListener(this);
    	
    	menu1.insertSeparator(4);
    	
    	menu1.add(item5);
    	item5.addActionListener(this);
    	
    	menu2.add(item6);
    	item6.addActionListener(this);
    	
    	menu2.add(item7);
    	item7.addActionListener(this);
    	
    	menubar.add(menu1);
    	menubar.add(menu2);
    	menubar.add(menu3);
    	setJMenuBar(menubar);
    	
    	area.setBackground(Color.cyan);
    	add(p);
    	setBounds(200,100,600,600);
    	setVisible(true);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	
    }
    
    
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==item1)
    	{
    		area.setText("");
    		setTitle("未命名.txt");
    	}
    	else if(e.getSource()==item2)
    	{
    		openFile();
    	}
     	else if(e.getSource()==item3||e.getSource()==item4)
    	{
    		saveFile();
    	}
     	else if(e.getSource()==item5)
    	{
    		System.exit(0);
    	}
     	else if(e.getSource()==item6)
    	{
    		
    	}
     	else if(e.getSource()==item7)
    	{
    		
    	}
    }
    
    
    public void saveFile()
    {
    	JFileChooser filechoose=new JFileChooser();
    	int result=filechoose.showSaveDialog(null);
    	if(result==JFileChooser.APPROVE_OPTION)
    	{
    		try{
    			File file=filechoose.getSelectedFile();
    			FileWriter fw=new FileWriter(file);
    			fw.write(area.getText());
    			setTitle(file.getName());
    			fw.close();
    		}
    		catch(Exception e)
    		{
    			System.out.println("保存文件失败！");
    			
    		}
    	}
    	else return;
    }
    
    public void openFile()
    {
    	JFileChooser filechoose=new JFileChooser();
    	int result=filechoose.showOpenDialog(null);
    	if(result==JFileChooser.APPROVE_OPTION)
    	{
    		try{
    			File file=filechoose.getSelectedFile();
    			FileReader fr=new FileReader(file);
    			int len=(int)file.length();
    			char[] text=new char[len];
    			fr.read(text,0,len);
    			fr.close();
    			area.setText(new String(text));
    			
    		}
    		catch(Exception e)
    		{
    			System.out.println("打开文件失败！");
    		}
    	
    
    	}
    	else return;
    }

	public static void main(String[] args) {
        new NotePad2();
	}

}