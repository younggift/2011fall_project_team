<%@ page contentType="text/html;charset=GB2312" %>

<html>
  <body>
  <form action="messagepane.jsp" method=post name=form>
  <P>�������������֣� 
  <br>
  <input type="text" name="peoplename">
  <br>
  <P>���������Ա���:
  <br>
  <input type="text" name="messagetitle">
  <br>
  <P>���������ԣ�
  <br>
  <TEXTAREA name="messages" rows=10 cols=36 wrap=physical>
  </TEXTAREA>
  <br>
  <input type="submit" value="submit" name=submit>
  </form>
  <form action="showmessage.jsp" method=post name=form1>
  <input type="submit" value="showmessage" name=look>
  </form>
  </body>
</html>
