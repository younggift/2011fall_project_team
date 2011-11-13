<%@ page contentType="text/html;charset=GBK" %>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="vote.VoteConn"/>
<%
String rb = request.getParameter("type");
if(rb!=null&&rb!=""){
	String sql="Update vote Set c_num=c_num+1 where id="+rb;
	connDbBean.executeQuery(sql);
}
%>
<jsp:forward page="details.jsp"/>