<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <title>µÇÂ¼³É¹¦</title>
</head>
<body BGCOLOR=cyan>
  <%
   request.setCharacterEncoding("GB18030");
   String name = request.getParameter("userName");
   out.println("»¶Ó­Äã:" + name);
  %>
</body>
</html> 

