<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.util.*" %>

<html>
  <body>
    <%int a=100;long b=300;boolean c=true;
    out.println("<H1>这是标题1字体的大小</HT1>");
    out.println("<H2>这是标题2字体的大小</HT2>");
    out.print("<BR>");
    out.println(a);
    out.println(b);
    out.println(c);
     %>
     
     <Center>
     <P><Font size=2>以下是一个表格</Font>
     <%out.print("<Font face=隶书 size=2>");
     out.println("<Table Border >");
     out.println("<TR >");
     out.println("<TH width=80>"+"姓名"+"</TH>");
     out.println("<TH width=60>"+"性别"+"</TH>");
     out.println("<TH width=200>"+"出生日期"+"</TH>");
     out.println("</TR>");
     out.println("<TR >");
     out.println("<TD >"+"LIN"+"</TD>");
     out.println("<TD >"+"女"+"</TD>");
     out.println("<TD >"+"1992.10.19"+"</TD>");
     out.println("</TR>");
     out.println("<TR>");
     out.println("<TD >"+"LIU"+"</TD>");
     out.println("<TD >"+"男"+"</TD>");
     out.println("<TD >"+"1991.03.12"+"</TD>");
     out.println("<TD width=100>"+"这是表格"+"</TD>");
     out.println("</TR>");
     out.println("</Table>");
     out.println("</Font>");
      %>
      </Center>
  </body>
</html>
