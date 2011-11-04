<%@ page contentType="text/html;charset=GB2312"%>
<%@ page import="java.util.*" %>

<html>
  <body>
    <% 
    Vector v=(Vector)application.getAttribute("mess"); 
    for(int i=0;i<v.size();i++) 
    { 
    String message=(String)v.elementAt(i); 
    StringTokenizer fenxi=new StringTokenizer(message,"#"); 
    out.print("<br>");
    while(fenxi.hasMoreTokens()) 
    { 
    String str=fenxi.nextToken(); 
    byte a[]=str.getBytes("ISO-8859-1"); 
    str=new String(a); 
    out.print("<br>"+str); 
    } 
    } 
    %>
    <br>
    <A HREF="submit.jsp"> ·µ»Ø
     </A>
  </body>
</html>
