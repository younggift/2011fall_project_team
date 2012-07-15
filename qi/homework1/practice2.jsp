<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html>
 <head>
    <title>My JSP 'practice2.jsp' starting page</title>


  </head>
  
  <body>
    <% 
      String nn = request.getParameter("name");
      String pw = request.getParameter("passwd");
      out.print("Your name is :" + nn +"<br>");		
      out.print("Your password is: "+ pw);			
%>

  </body>
</html>
