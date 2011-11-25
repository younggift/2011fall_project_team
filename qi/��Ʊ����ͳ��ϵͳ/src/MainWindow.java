import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame
{
	JPanel contentPane;

	JTextPane jTextPane1 =  new JTextPane();

	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JLabel jLabel6 = new JLabel();

	JTextField jTextField1 = new JTextField();	
	JTextField jTextField2 = new JTextField();
	JTextField jTextField3 = new JTextField();
	JTextField jTextField4 = new JTextField();
	JTextField jTextField5 = new JTextField();
	JTextField jTextField6 = new JTextField();

	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	JButton jButton3 = new JButton();
	JButton jButton4 = new JButton();
	JButton jButton5 = new JButton();

	JMenuBar jMenuBar1 = new JMenuBar();
	JMenu jMenu1 = new JMenu();
	JMenu jMenuhelp = new JMenu();
	JMenuItem jMenuabout = new JMenuItem();
	JMenuItem jMenuexit =  new JMenuItem();

	public MainWindow()
	{
		try{
			init();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private void init() throws Exception
	{
		contentPane = (JPanel)this.getContentPane();
		contentPane.setLayout(null);
		this.setTitle("学生订购火车票统计系统");
		
		jMenu1.setActionCommand("文件");
		jMenu1.setText("文件");
		jMenuhelp.setActionCommand("帮助");
		jMenuhelp.setText("帮助");
		jMenuexit.setActionCommand("退出");
		jMenuexit.setText("退出");
		jMenuexit.addActionListener(new ExitAction());
		jMenuabout.setActionCommand("关于");
		jMenuabout.setText("关于");
		jMenuabout.addActionListener(new AboutAction(this));	
		
		jTextPane1.setBackground(SystemColor.control);
		jTextPane1.setFont(new Font("Dialog",0,14));
		jTextPane1.setBorder(BorderFactory.createLoweredBevelBorder());
		jTextPane1.setEditable(false);
		jTextPane1.setText("");
		jTextPane1.setBounds(new Rectangle(27,1,344,61));

		jLabel1.setText("请输入学号：");
		jLabel1.setFont(new Font("Monospaced",1,15));
		jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel1.setBounds(new Rectangle(4,90,109,38));
		jLabel2.setFont(new Font("Dialog",0,15));
		jLabel2.setForeground(Color.black);
		jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel2.setText("姓名");
		jLabel2.setBounds(new Rectangle(57,137,56,25));
		jLabel3.setFont(new Font("Dialog",0,15));
		jLabel3.setForeground(Color.black);
		jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel3.setText("始发地点");
		jLabel3.setBounds(new Rectangle(50,173,63,27));
		jLabel4.setFont(new Font("Dialog",0,15));
		jLabel4.setForeground(Color.black);
		jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel4.setText("目的地点");
		jLabel4.setBounds(new Rectangle(42,215,71,29));
		jLabel5.setFont(new Font("Dialog",0,15));
		jLabel5.setForeground(Color.black);
		jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel5.setText("票价");
		jLabel5.setBounds(new Rectangle(66,251,47,23));
		jLabel6.setFont(new Font("Dialog",0,15));
		jLabel6.setForeground(Color.black);
		jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel6.setText("学号");
		jLabel6.setBounds(new Rectangle(66,291,47,25));
	
		jTextField1.setText("");
		jTextField1.setBounds(new Rectangle(130,95,95,27));
		jTextField2.setText("");
		jTextField2.setBounds(new Rectangle(130,134,95,27));
		jTextField3.setText("");
		jTextField3.setBounds(new Rectangle(130,172,95,27));
		jTextField4.setText("");
		jTextField4.setBounds(new Rectangle(130,210,95,27));
		jTextField5.setText("");
		jTextField5.setBounds(new Rectangle(130,247,95,27));
		jTextField6.setText("");
		jTextField6.setBounds(new Rectangle(130,285,95,27));

		jButton1.setBounds(new Rectangle(251,91,73,31));
		jButton1.setFont(new Font("Monospaced",1,15));
		jButton1.setText("查询");
		jButton1.addActionListener(new ViewAction(this));
		jButton2.setBounds(new Rectangle(251,135,73,31));
		jButton2.setFont(new Font("Monospaced",1,15));
		jButton2.setText("删除");
		jButton2.addActionListener(new DeleteAction(this));
		jButton3.setBounds(new Rectangle(251,179,73,31));
		jButton3.setFont(new Font("Dialog",0,15));
		jButton3.setText("修改");
		jButton3.addActionListener(new UpdateAction(this));
		jButton4.setBounds(new Rectangle(108,325,73,36));
		jButton4.setFont(new Font("Dialog",0,15));
		jButton4.setText("添加");
		jButton4.addActionListener(new AddAction(this));
		jButton5.setBounds(new Rectangle(200,325,73,36));
		jButton5.setFont(new Font("Dialog",0,15));
		jButton5.setText("取消");
		jButton5.addActionListener(new CancelAction(this));
		
		jMenuBar1.add(jMenu1);
		jMenu1.add(jMenuexit);
		jMenuBar1.add(jMenuhelp);
		jMenuhelp.add(jMenuabout);
		setJMenuBar(jMenuBar1);

		contentPane.add(jTextPane1);

		contentPane.add(jLabel1);
		contentPane.add(jLabel2);
		contentPane.add(jLabel3);
		contentPane.add(jLabel4);
		contentPane.add(jLabel5);
		contentPane.add(jLabel6);

		contentPane.add(jTextField1);
		contentPane.add(jTextField2);
		contentPane.add(jTextField3);
		contentPane.add(jTextField4);
		contentPane.add(jTextField5);
		contentPane.add(jTextField6);

		contentPane.add(jButton1);
		contentPane.add(jButton2);
		contentPane.add(jButton3);
		contentPane.add(jButton4);
		contentPane.add(jButton5);
	}
	public static void main(String[] args)
	{
		MainWindow mw = new MainWindow();
		mw.setBounds(200,200,400,450);
		mw.setVisible(true);
		mw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
class ExitAction implements ActionListener{
	public ExitAction(){  
	}
	public void actionPerformed(ActionEvent e){
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
	JLabel imageLabel = new JLabel(new ImageIcon("C:/Users/GAY/Desktop/火车票订购统计系统/wolf.jpg"));
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	BorderLayout borderLayout1 = new BorderLayout();
	BorderLayout borderLayout2 = new BorderLayout();
	FlowLayout flowLayout1 = new FlowLayout();
	GridLayout gridLayout1 = new GridLayout();
	String product="made by blackwolf";
	String version="version 1.0";
	String copyright="Copyright (c) 2011-11";
	String comments="欢迎您的批评与指正";

	public AboutDialog(MainWindow parent)
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
	private MainWindow window;
	public AboutAction(MainWindow window){
		this.window = window;
	}
	public void actionPerformed(ActionEvent e){
		AboutDialog dlg = new AboutDialog(this.window);
		Dimension dlgSize = dlg.getPreferredSize();
		Dimension frmSize = this.window.getSize();
		Point loc = this.window.getLocation();
		dlg.setLocation(100+loc.x,100+loc.y);
		dlg.pack();
		dlg.show();
	}
}
class DBConnection{
	private String db_user;
	private String db_password;
	static final String DBDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
	static final String strConn ="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=C:/Users/GAY/Desktop/火车票订购统计系统/ticket.mdb";

	public DBConnection(String user, String password){
		this.db_user = user;
		this.db_password = password;
	}
	public Connection getConnection() throws SQLException{
		DBConnection.loadDriver();
		return java.sql.DriverManager.getConnection(this.strConn, this.db_user,this.db_password);
	}
	private static String loadDriver(){
		String sErr = "";
		try{
			java.sql.DriverManager.registerDriver((java.sql.Driver)(Class.forName(DBDriver).newInstance()));
		}
		catch (Exception e){
			sErr = e.toString();
		}
		return (sErr);
	}
	public static void close(Connection conn){
		try{
			conn.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
class DBHandler{
	private Connection conn;
	final String db_user = "";
	final String db_password = "";

	public DBHandler(){
		try{
			this.conn = new DBConnection(db_user, db_password).getConnection();
		}
		catch (SQLException ex){
			ex.printStackTrace();
		}
	}
	public boolean validate(String number){
		try{
			String cmd = "select * from Ticket where studentNo='"+number+"'";
			Statement stat = this.conn.createStatement();
			ResultSet rs = stat.executeQuery(cmd);
			int i = 0;
			while (rs.next()){
				i++;
			}
			if(i>0){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	public boolean addStudent(String studentNo, String name, String start,String to,String price){
		try{
			String cmd ="insert into Ticket(studentNo,name,start,to,price) values('" +studentNo + "','" + name + "','" + start + "','" + to +"','"+ price +"')";
			Statement stat = this.conn.createStatement();
			stat.executeUpdate(cmd);
			return true;
		}
		catch (Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	public boolean updateStudent(String studentNo, String name, String start,String to,String price){
		try{
			String cmd ="update Ticket set name='" + name + "' , start='" + start + "' , to='" + to +"',price='"+ price +"' where studentNo='" + studentNo + "'";
			Statement stat = this.conn.createStatement();
			stat.executeUpdate(cmd);
			return true;
		}
		catch (Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	public boolean deleteStudent(String number){
		try{
			String cmd = "delete from Ticket where studentNo='" + number + "'";
			Statement stat = this.conn.createStatement();
			stat.executeUpdate(cmd);
			return true;
		}
		catch (Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	public ResultSet getStudent(String number){
		try{
			String cmd ="select name,start,to,price from Ticket where studentNo = '" +number + "'";
			Statement stat = this.conn.createStatement();
			ResultSet rs = stat.executeQuery(cmd);
			return rs;
		}
		catch (Exception ex){
		ex.printStackTrace();
		}
		return null;
	}
}
class Student{
	private String studentNo;
	private String name;
	private String start;
	private String to;
	private String price;
	private DBHandler db = new DBHandler();
	public Student(String number){
		ResultSet rs = db.getStudent(number);
		try{
			while (rs.next()){
				this.studentNo = number;
				this.name = rs.getString("name");
				this.start = rs.getString("start");
				this.to = rs.getString("to");
				this.price = rs.getString("price");
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		finally{
			try{
				rs.close();
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
	}
	public Student(String number, String name, String start, String to,String price){
		this.studentNo = number;
		this.name = name;
		this.start = start;
		this.to = to;
		this.price = price;
	}
	public String getNo() {
		return this.studentNo;
	}
	public String getName(){
		return this.name;
	}
	public String getStart(){
		return this.start;
	}
	public String getTo(){
		return this.to;
	}
	public String getPrice(){
		return this.price;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setStart(String start){
		this.start = start;
	}
	public void setTo(String to){
		this.to = to;
	}
	public void setPrice(String price){
		this.price = price;
	}
	public boolean update(){
		return db.updateStudent(this.studentNo, this.name, this.start,this.to,this.price);
	}
	public static boolean addStudent(String studentNo, String name,String start, String to,String price){
		return new DBHandler().addStudent(studentNo, name, start, to,price);
	}
	public static boolean deleteStudent(String number){
		return new DBHandler().deleteStudent(number);
	}
}
class ViewAction implements ActionListener{
	private MainWindow window;
	private DBHandler db = new DBHandler();
	public ViewAction(MainWindow window){
		this.window = window;
	}
	public void actionPerformed(ActionEvent e){
		try{
			String number = this.window.jTextField1.getText();
			if(db.validate(number)){
				Student student = new Student(number);
				this.window.jTextField2.setText(student.getName());
				this.window.jTextField3.setText(student.getStart());
				this.window.jTextField4.setText(student.getTo());
				this.window.jTextField5.setText(student.getPrice());
				this.window.jTextField6.setText(student.getNo());
			}
			else{
				this.window.jTextField1.setText("");
				this.window.jTextPane1.setText("数据库中没有您查询的学号!");
			}
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
class DeleteAction implements ActionListener{
	private MainWindow window;
	private DBHandler db = new DBHandler();
	public DeleteAction(MainWindow window){
		this.window = window;
	}
	public void actionPerformed(ActionEvent e){
		try{
			String number = this.window.jTextField1.getText();
			if(number.equals("")){
				this.window.jTextPane1.setText("请输入学号!");
				return;
			}
			if(!db.validate(number)){ 
				this.window.jTextField1.setText("");
				this.window.jTextPane1.setText("数据库中没有您要删除的学号!");
			}
			else{
				if(Student.deleteStudent(number)){
					this.window.jTextField1.setText("");
					this.window.jTextField2.setText("");
					this.window.jTextField3.setText("");
					this.window.jTextField4.setText("");
					this.window.jTextField5.setText("");
					this.window.jTextField6.setText("");
					this.window.jTextPane1.setText("记录已成功删除!");
				}
				else{
					this.window.jTextPane1.setText("记录删除失败!");
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
class UpdateAction implements ActionListener{
	private MainWindow window;
	public UpdateAction(MainWindow window){
		this.window = window;
	}
	public void actionPerformed(ActionEvent e){
		try{
			if(this.window.jTextField1.getText().length() == 0){
				this.window.jTextPane1.setText("不能修改，请先输入学号！");
			}
			else{
				String number = this.window.jTextField1.getText();
				Student theStudent = new Student(number);
				if(theStudent.getName().equals("")&&theStudent.getStart().equals("")&&theStudent.getTo().equals("")&&theStudent.getPrice().equals("")) {
					this.window.jTextPane1.setText("该学号不存在");
					return;
				}
				this.window.jTextField6.setText(this.window.jTextField1.getText());
				if(this.window.jTextField2.getText().length()!= 0){
					theStudent.setName(this.window.jTextField2.getText());
				}
				if(this.window.jTextField3.getText().length()!= 0){
					theStudent.setStart(this.window.jTextField3.getText());
				}
				if(this.window.jTextField4.getText().length()!= 0){
					theStudent.setTo(this.window.jTextField4.getText()); 
				}
				if(this.window.jTextField5.getText().length()!= 0){
					theStudent.setPrice(this.window.jTextField5.getText()); 
				}
				if(this.window.jTextField2.getText().length()==0&&this.window.jTextField3.getText().length() == 0&&this.window.jTextField4.getText().length() == 0&&this.window.jTextField5.getText().length() == 0){
					this.window.jTextPane1.setText("请输入修改的数据");
				}
				else{
					if(theStudent.update()){
						this.window.jTextPane1.setText("记录修改成功!");
					}
					else{
						this.window.jTextPane1.setText("修改失败，请重试!");
					}
				}
			}
			this.window.jTextField1.setText("");
			this.window.jTextField2.setText("");
			this.window.jTextField3.setText("");
			this.window.jTextField4.setText("");
			this.window.jTextField5.setText("");
			this.window.jTextField6.setText("");
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
class AddAction implements ActionListener{
	private MainWindow window;
	public AddAction(MainWindow window){
		this.window = window;
	}
	public void actionPerformed(ActionEvent e){
		try{
			if(this.window.jTextField2.getText().length()==0){
				this.window.jTextPane1.setText("请输入姓名！");
				return;
			}
			if(this.window.jTextField3.getText().length() == 0){
				this.window.jTextPane1.setText("请输入始发地点！");
				return;
			}
			if(this.window.jTextField4.getText().length() == 0){
				this.window.jTextPane1.setText("请输入目的地点！");
				return;
			}
			if(this.window.jTextField5.getText().length() == 0){
				this.window.jTextPane1.setText("请输入票价！");
				return;
			}
			if(this.window.jTextField6.getText().length() == 0){
				this.window.jTextPane1.setText("请输入学号！");
				return;
			}
			if(Student.addStudent(this.window.jTextField6.getText(),this.window.jTextField2.getText(),this.window.jTextField3.getText(), this.window.jTextField4.getText(),this.window.jTextField5.getText())){
				this.window.jTextPane1.setText("添加成功！");
			}
			else{
				this.window.jTextPane1.setText("添加失败！");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
class CancelAction implements ActionListener{
	private MainWindow window;
	public CancelAction(MainWindow window){
		this.window = window;
	}
	public void actionPerformed(ActionEvent e){
		this.window.jTextField1.setText("");
		this.window.jTextField2.setText("");
		this.window.jTextField3.setText("");
		this.window.jTextField4.setText("");
		this.window.jTextField5.setText("");
		this.window.jTextField6.setText("");
		this.window.jTextPane1.setText("");
	}
}