<%@ page contentType="text/html;charset=GBK" %>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="student1.conn"/>
<html>
<head>
<title>test db connection</title>
</head>
<body bgcolor=cyan>
<div align="center">
<table width="60%" border="1">
<tr bgcolor=pink>
<td width="50%">
<div align="center"><font color=black><b>姓名</b></font></div>
</td>
<td width="25%">
<div align="center"><font color=black><b>性别</b></font></div>
</td>  
<td width="25%">
<div align="center"><font color=black><b>分数</b></font></div>
</td>
</tr>
<%
ResultSet RS_result = connDbBean.executeQuery("select * from table1");	
String studentName="";
String studentSex="";
int studentScore=0;
if(RS_result!=null){        
		while(RS_result.next()){
			studentName=RS_result.getString("name");
			studentSex =RS_result.getString("sex");
			studentScore=RS_result.getInt("score");
%>
<tr>
<td width="50%" bgcolor=cyan>
<div align="center"><%=studentName%></div>
</td>
<td width="25%">
<div align="center"><%=studentSex%></div>
</td>
<td width="25%">
<div align="center"><%=studentScore%></div>
</td>
</tr>
<%
}
RS_result.close();
}
%>
</table>
</body>
</html>