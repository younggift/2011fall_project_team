<%@ page contentType="text/html;charset=GB2312"%>
<%@ page import="Circle" %>
<html>
  <body><font size=3>
  <jsp:useBean id="text" class="Circle" scope="page">
  </jsp:useBean>
  <P> Բ�İ뾶�ǣ�
  <%=text.getRadius()%>
  <P>��������Բ�İ뾶��100��
  <%text.setRadius(100);%>
  <P>����Բ�İ뾶�ǣ�
  <%=text.getRadius() %>
  <P>Բ���ܳ��ǣ�
  <%=text.circleLength() %>
  <P>Բ������ǣ�
  <%=text.circleArea() %>
  </font>
  </body>
</html>
