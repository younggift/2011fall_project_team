<%@ page contentType="text/html;charset=GB2312" %>
<%@page import="java.util.*"%>
<HTML>
<HEAD>
<TITLE>Date ��ķ���Ӧ��</TITLE>
</HEAD>
<BODY>
<%
  Date d1=new Date();
  Date d2=new Date(86400000*20);
  long now=d1.getTime();
  out.print("d1����Ϊ��"+d1.toString()+"<br>");
  out.print("d2����Ϊ��"+d2.toString()+"<br>");
  out.print("<br>");
  if(d1.compareTo(d2)>0)
  {
    out.print("d1��d2��<br>");
  }else if(d1.compareTo(d2)==0)
  {
    out.print("d1��d2һ����<br>");
  }else
  {
    out.print("d1��d2С��<br>");
  }
  d2.setTime(now+86400000*3);//��������d2��ʱ��
  out.print("������ʱ��Ϊ��"+d2.toString()+"<br>");
%>
</BODY>
</HTML>