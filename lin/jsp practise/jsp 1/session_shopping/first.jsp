<%@ page contentType="text/html;charset=GB2312"%>

<html>
  <body><font size=3 >
  <%String s=request.getParameter("name1"); 
  session.setAttribute("name",s); 
  %>
  <P>���������빺�����Ʒ��
  <form action="show.jsp" method=post name=form>
  <input type="text" name="buy">
  <input type="submit" value="ok" name=submit>  
  </form>
  </font>
  </body>
</html>
