<%@ page contentType="text/html;charset=GB2312"%>
<%@ page import="Circle" %>
<html>
  <body><font size=3>
  <jsp:useBean id="text" class="Circle" scope="page">
  </jsp:useBean>
  <P> 圆的半径是：
  <%=text.getRadius()%>
  <P>重新设置圆的半径是100：
  <%text.setRadius(100);%>
  <P>现在圆的半径是：
  <%=text.getRadius() %>
  <P>圆的周长是：
  <%=text.circleLength() %>
  <P>圆的面积是：
  <%=text.circleArea() %>
  </font>
  </body>
</html>
