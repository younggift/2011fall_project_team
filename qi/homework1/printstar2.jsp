<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html>
 <head>
    <title>My JSP 'printstar2.jsp' starting page</title>


  </head>
  
  <body>
    <% 
      String mm = request.getParameter("hangshu");
      int m = Integer.parseInt(mm);
      
      for(int j=1;j<=m;j++){
			for(int i=1;i<=j;i++){
			    out.print("*");
			   }
			   out.print("<br>");
			  }
%>

  </body>
</html>
