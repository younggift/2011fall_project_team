<%@ page contentType="text/html;charset=GB2312"%>
<%@ page import="java.util.*" %>

<html>
  <body>
    <%!
    Vector v=new Vector();
    int i=0;
    ServletContext application;
    synchronized void sendmessage(String s)
    {
    application=getServletContext();
    i++;
    v.add("No."+i+"#"+s);
    application.setAttribute("mess",v);
    } 
    %>
    <%
    String name=request.getParameter("peoplename");
    String title=request.getParameter("messagetitle");
    String message=request.getParameter("messages");
    if(name==null)
    {
    name="guest"+(int)(Math.random()*1000);
    }
    if(title==null)
    {
    title="no title";
    }
    if(message==null)
    {
    message="no massage";
    }
    String s="Name:"+name+"#"+"Title:"+title+"#"+"Message<br>"+message;
    sendmessage(s);
    out.print("您的信息已提交");
     %>
     <A HREF="submit.jsp"> 返回
     </A>
  </body>
</html>
