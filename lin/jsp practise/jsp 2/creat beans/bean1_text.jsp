<%@ page contentType="text/html;charset=GB2312"%>
<%@ page import="Circle" %>
<html>
  <body><font size=3>
  <jsp:useBean id="text" class="Circle" scope="session">
  </jsp:useBean>
  <P> Բ�İ뾶�ǣ�
  <%=text.getRadius() %>
  <A href="bean2_text.jsp"><br>bean2_text.jsp</A>
  </font>
  </body>
</html>
