import java.sql.*;
public class TestJDBC
{
	public static void main(String[] args){
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:student","","");
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Table1");
			while(rs.next()){
				System.out.println("编号："+rs.getString(1));
				System.out.println("性别："+rs.getString(2));
				System.out.println("分数："+rs.getString(3));
			}
			rs.close();
			stmt.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}