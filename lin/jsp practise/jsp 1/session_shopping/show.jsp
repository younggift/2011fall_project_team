<%@ page contentType="text/html;charset=GB2312"%>
<%!
public String getstring(String s)
{
if(s==null) s="";
try
{
byte b[]=s.getBytes("ISO-8859-1");
s=new String(b);
}
catch(Exception e)
{
}
return s;
}
%>
<html>
  <body>
  <%String s=request.getParameter("buy"); 
  session.setAttribute("goods",s); 
  %>
  <br>
  <%String 顾客=(String)session.getAttribute("customer");
    String 商品=(String)session.getAttribute("goods");
    String 姓名=(String)session.getAttribute("name");
         商品=getstring(商品);
         姓名=getstring(姓名);
  %>
  <P><font size=3>
  <%=顾客 %>的姓名是:
  <%=姓名 %>
  <P>您输入的商品是:
  <%=商品 %>
  </font>
  </body>
</html>
