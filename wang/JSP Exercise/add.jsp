<%@ page contentType="text/html;charset=gb2312"%>
<%@page import="java.sql.*"%>
<html>
<body bgcolor=cyan><font size=3>

<%!
    public class ADD{
    int check(String  s)
	{
		return s.length();
	}
}
%>

<form name="form" action=""  method="post">
<p> «Î ‰»Îed2k£∫
<input type="text" name="ed2k">
<input type="submit" name="submit1" value="»∑»œ">
</form>

<%
    try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String url="jdbc:odbc:Test";
		Connection con=DriverManager.getConnection(url,"","");
		Statement stmt=con.createStatement();
		ResultSet rs= stmt.executeQuery("select * from user");

		rs.close();
		stmt.close();
		con.close();
}
catch(Exception e){
	
}
%>

<% String s=request.getParameter("ed2k");

   if(s!=null)
   {
       ADD ed2k=new ADD();
	   out.println(ed2k.check(s));
		   
   }

%>


</body>
</html>