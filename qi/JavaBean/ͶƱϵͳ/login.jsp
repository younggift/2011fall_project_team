<%@ page contentType="text/html;charset=GBK" %>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="vote.VoteConn"/>
<html>
<head>
<title>���ϵ����</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<%
ResultSet rs=connDbBean.executeQuery("select * from vote");
%>
<body bgcolor=cyan>
<center>
<h2><font color=red>����ͶƱ:</font></h2>
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
<tr align="center"><td><input type="submit" value="ͶƱ"></td></tr>
</form>
<tr><td><a href="details.jsp">�鿴ͶƱ</a></td></tr>
</table>
</center>
</body>
</html>