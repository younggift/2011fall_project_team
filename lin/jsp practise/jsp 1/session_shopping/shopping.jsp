<%@ page contentType="text/html;charset=GB2312"%>
<html>
  <body>
    <%
    session.setAttribute("customer","顾客");
     %>
     <p><font size=2> 请输入您的姓名：
     <form action="first.jsp" method=post name=form>
     <input type="text" name="name1">
     <input type="submit" value="ok" name=submit>
     </form>
     </font>
  </body>
</html>
