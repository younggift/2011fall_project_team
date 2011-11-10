<%@ page contentType="text/html;charset=GB2312"%>

<html>
  <body>
    <%String str=null;
    str=request.getParameter("boy");
    if(str==null)
    {
    str="";
    }
    byte b[]=str.getBytes("ISO-8859-1");
    str=new String(b);
    if(str.equals(""))
    {
    response.sendRedirect("response_test2.jsp");
    }
    else
    {
    out.print("»¶Ó­À´µ½±¾ÍøÕ¾£¡");
    out.print(str);
    } 
    %>
  </body>
</html>
