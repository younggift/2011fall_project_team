package vote;
import java.sql.*;
public class VoteConn
{
	String sDBDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
	String sConnStr = "jdbc:odbc:vote";
	Connection connect = null;
	ResultSet rs = null;
	public VoteConn()
	{
		try{
			Class.forName(sDBDriver);
		}
		catch(java.lang.ClassNotFoundException e)
		{
			System.err.println(e.getMessage());
		}
	}
	public ResultSet executeQuery(String sql)
	{
		try{
			connect = DriverManager.getConnection(sConnStr);
			Statement stmt =  connect.createStatement();
			rs =  stmt.executeQuery(sql);
		}
		catch(SQLException ex){
			System.err.println(ex.getMessage());
		}
		return rs;
	}
	public int executeUpdate(String sql)
	{
		int result =0;
		try{
			connect = DriverManager.getConnection(sConnStr);
			Statement stmt  = connect.createStatement();
			result = stmt.executeUpdate(sql);
		}
		catch(SQLException ex)
		{
			System.err.println(ex.getMessage());
		}
		return result;
	}
}