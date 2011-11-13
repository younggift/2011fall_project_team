<%@ page contentType="text/html;charset=GBK" %>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="vote.VoteConn"/>
<%!
int tot_num=0;
int tmp_num=0;
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Expires" content="Sun,13 Nov 2011 20:15:30 GMT">
<meta http-equiv="Pragma" content="no-cache">
</head>
<body>
<table width="80%" border="0" cellspacing="2" cellpadding="3">
<%
ResultSet tmpRs=connDbBean.executeQuery("select sum(c_num) As totalnum from vote");
tmpRs.next();
tot_num=tmpRs.getInt("totalnum");
tmpRs.close();
ResultSet rs = connDbBean.executeQuery("select * from vote");
int i=1;
while(rs.next()){
%>
<tr bgcolor="#99CCFF">
<td>选项<%=i%>:<%=rs.getString("note")%></td>
</tr>
<tr>
<%
	tmp_num=rs.getInt("c_num");
%>
<td>投票率：<img src="back.gif" width="<%=Math.floor(tmp_num*200/tot_num)%>" height="8"><%=Math.floor(tmp_num*100/tot_num)%>%[得：<%=tmp_num%>票 共：<%=tot_num%>票]</td>
</tr>
<%
	i++;
}
%>
</table>
<%
rs.close();
%>
</body>
</html>