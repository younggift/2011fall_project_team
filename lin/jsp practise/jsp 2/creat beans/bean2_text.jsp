<%@ page contentType="text/html;charset=GB2312"%>
<%@ page import="Circle" %>
<html>
  <body><font size=3>
  <jsp:useBean id="text" class="Circle" scope="session">
  </jsp:useBean>
  <P> 圆的半径是：
  <%=text.getRadius() %>
  <%text.setRadius(400); %>
  <P>修改后圆的半径是：
  <%=text.getRadius() %>
  </font>
  </body>
</html>
