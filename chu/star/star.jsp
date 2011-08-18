<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html> 
<head>    
<title>My JSP 'star.jsp' starting page</title>  
</head>    
<body>    
<%       for(int j=1;j<=4;j++){			
	for(int i=0;i<j;i++){	  
out.print("*");			 
  }			 
  out.print("<br>");			
  }%> 
 </body>
</html>