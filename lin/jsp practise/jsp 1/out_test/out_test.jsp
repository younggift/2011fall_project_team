<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.util.*" %>

<html>
  <body>
    <%int a=100;long b=300;boolean c=true;
    out.println("<H1>���Ǳ���1����Ĵ�С</HT1>");
    out.println("<H2>���Ǳ���2����Ĵ�С</HT2>");
    out.print("<BR>");
    out.println(a);
    out.println(b);
    out.println(c);
     %>
     
     <Center>
     <P><Font size=2>������һ�����</Font>
     <%out.print("<Font face=���� size=2>");
     out.println("<Table Border >");
     out.println("<TR >");
     out.println("<TH width=80>"+"����"+"</TH>");
     out.println("<TH width=60>"+"�Ա�"+"</TH>");
     out.println("<TH width=200>"+"��������"+"</TH>");
     out.println("</TR>");
     out.println("<TR >");
     out.println("<TD >"+"LIN"+"</TD>");
     out.println("<TD >"+"Ů"+"</TD>");
     out.println("<TD >"+"1992.10.19"+"</TD>");
     out.println("</TR>");
     out.println("<TR>");
     out.println("<TD >"+"LIU"+"</TD>");
     out.println("<TD >"+"��"+"</TD>");
     out.println("<TD >"+"1991.03.12"+"</TD>");
     out.println("<TD width=100>"+"���Ǳ��"+"</TD>");
     out.println("</TR>");
     out.println("</Table>");
     out.println("</Font>");
      %>
      </Center>
  </body>
</html>
