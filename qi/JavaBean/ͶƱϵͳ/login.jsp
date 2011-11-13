<%@ page contentType="text/html;charset=GBK" %>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="vote.VoteConn"/>
<html>
<head>
<title>网上调查表</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<%
ResultSet rs=connDbBean.executeQuery("select * from vote");
%>
<body bgcolor=cyan>
<center>
<h2><font color=red>请您投票:</font></h2>
<table border bgcolor=pink>
<form action="vote.jsp">
<%
if(rs!=null){        
		while(rs.next()){
%>
<tr>
<td><input type="radio" name="type" value="<%=rs.getString("id")%>"><%=rs.getString("note")%></td>
</tr>
<%}
rs.close();
}
%>
<tr align="center"><td><input type="submit" value="投票"></td></tr>
</form>
<tr><td><a href="details.jsp">查看投票</a></td></tr>
</table>
</center>
</body>
</html>