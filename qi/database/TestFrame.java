import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class TestFrame 
{
	public static void main(String[] args) 
	{
		Frame f =  new Frame("Login Test");
		Label label = new Label("please input your name and password");
		label.setForeground(Color.white);
		TextField tfName = new TextField("");
		TextField tfPassword = new TextField("");
		Button button = new Button("Login");
		f.setLayout(new GridLayout(4,1));
		f.add(label);
		f.add(tfName);
		f.add(tfPassword);
		f.add(button);
		button.addActionListener(new MyActionListener(tfName,tfPassword,label));
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		f.setSize(300,200);
		f.setBackground(Color.blue);
		f.setVisible(true);
	}
}
class MyActionListener implements ActionListener
{
	private TextField tfName;
	private TextField tfPassword;
	private Label label;
	Boolean flag = false;
	public MyActionListener(TextField tfName,TextField tfPassword,Label label){
		this.tfName = tfName;
		this.tfPassword = tfPassword;
		this.label = label;
	}
	public void actionPerformed(ActionEvent e){
		flag = false;
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:student","","");
			Statement stmt=con.createStatement();
			String sql = "select * from Table1 where name='"+ tfName.getText() +"'";
			sql +="and sex='"+ tfPassword.getText() +"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) flag = true;
		}catch(Exception ee){
			ee.printStackTrace();		
		}
		if(flag) label.setText("OK!");
		else label.setText("Fail!");
	}
}