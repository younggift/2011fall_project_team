<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>身份验证</title>
</head>
<body>
  <%
    request.setCharacterEncoding("GB18030");
    String name = request.getParameter("userName");
    String password = request.getParameter("password");
    if(name.equals("qijialiang")&& password.equals("416")) {
      
  %>
  <jsp:forward page="afterlogin.jsp">
     <jsp:param name="userName" value="<%=name%>"/>
  </jsp:forward>
  <%
   }
   else {
  %>
  <jsp:forward page="login.jsp"/>
  <%
   }
  %>
</body>
</html> 

