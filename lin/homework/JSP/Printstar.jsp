<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html>
 <head>
    <title>My JSP 'Printstar.jsp' starting page</title>
 </head>

 <body>
    <%
       String row = request.getParameter("r");
       int n = Integer.parseInt(row);

            for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
			    out.print("*");
			   }
			   out.print("<br>");
			  }
%>

  </body>
</html>