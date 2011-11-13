<%@ page contentType="text/html;charset=GBK" %>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="vote.VoteConn"/>
<%
String nn =request.getParameter("note");
if(nn!=null&&nn.length()>0)
{
	ResultSet tmpRs = connDbBean.executeQuery("select max(id) As maxid from vote");
	tmpRs.next();
	int max_id = tmpRs.getInt("maxid")+1;
	tmpRs.close();
	String sql = "insert into vote values("+max_id+",'";sql+=nn+"',0);";
	connDbBean.executeUpdate(sql);
}
%>
<jsp:forward page="admin.jsp"/>