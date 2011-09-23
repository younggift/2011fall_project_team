<%@ page contentType="text/html;charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="javax.servlet.*"%>
<html>
<body bgcolor=cyan><font size=3>

<%!
    public class ADD{
    int check(String  s)
	{
		return s.length();
	}
	boolean quata(int contain)
	{
		if(contain>7) return false;
		else return true;
	}
		
}
%>

<%

try{
        String driver="sun.jdbc.odbc.JdbcOdbcDriver";
		Class.forName(driver).newInstance();
		String connectionURL="jdbc:odbc:Test";
		Connection con=null;
		con=DriverManager.getConnection(connectionURL);
		Statement stmt=null;
		stmt=con.createStatement();
		String username1=request.getParameter("username");
		String password1=request.getParameter("password");

		if(username1.equals("")||password1.length()==0)
		{
			String redirectURL="login.jsp";
			response.sendRedirect(response.encodeURL(redirectURL));
		}
		else
		{
			String sqlstring="SELECT username,password,contain FROM user";
			sqlstring +=" ";
			sqlstring +="where username like'"+username1+"'";
			ResultSet rs=null;
			rs=stmt.executeQuery(sqlstring);
			if(rs.next())
			{
				if(rs.getString(2).equals(password1))
				{
					rs.close();
					stmt.close();
					con.close();
					String redirectURL="add.jsp";
					response.sendRedirect(response.encodeURL(redirectURL));

				}
				else
				{
					rs.close();
					stmt.close();
					con.close();
					String redirectURL="login.jsp";
					response.sendRedirect(response.encodeURL(redirectURL));
				}
			}
			else
			{
				    rs.close();
					stmt.close();
					con.close();
					String redirectURL="login.jsp";
					response.sendRedirect(response.encodeURL(redirectURL));
			}

		}
}
catch(Exception e){
}
%>

<form name="form" action=""  method="post">
<p> «Î ‰»Îed2k£∫
<input type="text" name="ed2k">
<input type="submit" name="submit1" value="»∑»œ">
</form>

<% String s=request.getParameter("ed2k");


   
   if(s!=null)
   {
       ADD ed2k=new ADD();
	   out.println(ed2k.check(s));

       out.println(ed2k.quata(4));
	   
		   
   }

   

%>




</body>
</html>