<%@ page contentType="text/html;charset=GB2312" %>
<%@page import="java.util.*"%>
<HTML>
<HEAD>
<TITLE>Date 类的方法应用</TITLE>
</HEAD>
<BODY>
<%
  Date d1=new Date();
  Date d2=new Date(86400000*20);
  long now=d1.getTime();
  out.print("d1对象为："+d1.toString()+"<br>");
  out.print("d2对象为："+d2.toString()+"<br>");
  out.print("<br>");
  if(d1.compareTo(d2)>0)
  {
    out.print("d1比d2大！<br>");
  }else if(d1.compareTo(d2)==0)
  {
    out.print("d1和d2一样大！<br>");
  }else
  {
    out.print("d1比d2小！<br>");
  }
  d2.setTime(now+86400000*3);//重新设置d2的时间
  out.print("三天后的时间为："+d2.toString()+"<br>");
%>
</BODY>
</HTML>