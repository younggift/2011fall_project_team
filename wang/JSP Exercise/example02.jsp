<%@ page contentType="text/html;charset=gb2312"%>
<HTML>
<BODY bgcolor=cyan><font size=4>
<%! Integer number=new Integer(0);
%>

<%
    synchronized(number)
    {
         int i=number.intValue();
          i++;
         number=new Integer(i);
    }
%>

<P>您是第
<%=number.intValue()%>
个访问本站的客户
</body>
<html>