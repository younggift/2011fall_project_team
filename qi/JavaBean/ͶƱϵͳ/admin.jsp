<%@ page contentType="text/html;charset=GBK" %>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="vote.VoteConn"/>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body bgcolor=cyan>
<div align="center">
<p><font color="#990000" size="+2"><u>调查系统维护中心</u></font>
</p>
<%
ResultSet tempRs=connDbBean.executeQuery("SELECT id,note FROM vote Order BY id");
%>
<table width="80%" border="0" cellspacing="1" cellpadding="2">
<tr>
<td width="10%" class="text1" bgcolor="#99CCFF">
<div align="center">序号</div>
</td>
<td width="80%" class="text1" bgcolor="#99CCFF">
<div align="center">内容</div>
</td>
<td width="10%" class="text1" bgcolor="#99CCFF">
<div align="center">操作</div>
</td>
</tr>
<%
int i=1;
while(tempRs.next()){
%>
<tr>
<td><div align="center"><%=i%></div>
</td>
<td><%=tempRs.getString("note")%></td>
<td><div align="center"><a href="delvote.jsp?id=<%=tempRs.getInt("id")%>">删除</a></div>
</td>
</tr>
<%
	i=i+1;
}
%>
<tr>
<td colspan="3">
<hr width="100%" size="1">
</td>
</tr>
<tr>
<td class="text1">
<div align="center"></div>
</td>
<td class="text1" colspan="2">&nbsp;</td>
</tr>
<tr>
<td class="text1" colspan="3" bgcolor="#99CCFF">增加项目</td>
</tr>
<tr>
<td class="text1" colspan="3">
<form method="post" action="addvote.jsp">
<p>内容：<input type="text" name="note" size="50" maxlength="50">
</p>
<p><input type="submit" name="Submit" value="提交">
<input type="reset" name="Reset" value="重置">
</p>
<p>&nbsp</p>
</form>
</td>
</tr>
</table>
<%
	tempRs.close();
%>
</body>
</html>