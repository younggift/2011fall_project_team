<%@ page contentType="text/html;charset=GBK" %>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="vote.VoteConn"/>
<%
String d_id = request.getParameter("id");
if(d_id!=null&&d_id.length()>0)
{
	connDbBean.executeUpdate("DELETE FROM VOTE Where id="+d_id);
}
%>
<jsp:forward page="admin.jsp"/>