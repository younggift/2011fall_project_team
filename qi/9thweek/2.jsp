<%@ page contentType="text/html;charset=GBK" %>
<%
request.setCharacterEncoding("GBK");
String Languages[] = request.getParameterValues("Language");
%>
<html>
<head>
<title>�������ѡ���������</title>
</head>
<body bgcolor="#FFFFFF">
<h2 align="center">�������ѡ���������</h2>
<hr>
<p>��ѡ������Ե���:</p>
<ul>
<%
for(int i=0;i<Languages.length;i++)
{
	out.println("<li>"+Languages[i]);
}
%>
</ul>
</body>
</html>