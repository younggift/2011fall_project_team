<%@ page contentType="text/html;charset=GBK" %>
<%
request.setCharacterEncoding("GBK");
%>
<%
String s = request.getParameter("item");
String ss = request.getParameter("submit");
%>
<html>
<head>
<title>��ѡ��CD</title>
</head>
<jsp:useBean id="cart" scope="session" class="sessions.DummyCart"/>
<jsp:setProperty name="cart" property="item" value="s"/>
<jsp:setProperty name="cart" property="submit" value="ss"/>
<%
cart.processRequest();
%>
<FONT size=5 COLOR=cyan>
<br>����ǰѡ��������CD��
<ol>
<%
String[] items = cart.getItems();
for(int i=0;i<items.length;i++){
%>
<li><% out.print(items[i]); %>
<%
}
%>
</ol>
</FONT>
<hr>
<body>
<form action="carts.jsp" method="post">
<select name="item">
<option selected>��������</option>
<option>ʨ����</option>
<option>��ͼ��</option>
<option>�ǵ�</option>
</select>
<p>
<input type="submit" name="submit" value="add"><br>
<input type="submit" name="submit" value="remove"><br>
</form>
</body>
</html>