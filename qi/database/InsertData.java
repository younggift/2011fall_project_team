import java.sql.*;
public class InsertData
{
	public static void main(String[] args)
	{
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:student","","");
			Statement stmt = con.createStatement();
			int i= stmt.executeUpdate("insert into Table1 values('dirk','m','20')");
			System.out.println(i+"rows been affected");
			stmt.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}