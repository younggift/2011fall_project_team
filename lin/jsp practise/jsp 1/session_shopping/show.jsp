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
  <%String �˿�=(String)session.getAttribute("customer");
    String ��Ʒ=(String)session.getAttribute("goods");
    String ����=(String)session.getAttribute("name");
         ��Ʒ=getstring(��Ʒ);
         ����=getstring(����);
  %>
  <P><font size=3>
  <%=�˿� %>��������:
  <%=���� %>
  <P>���������Ʒ��:
  <%=��Ʒ %>
  </font>
  </body>
</html>
