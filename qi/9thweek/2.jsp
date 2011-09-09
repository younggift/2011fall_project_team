<%@ page contentType="text/html;charset=GBK" %>
<%
request.setCharacterEncoding("GBK");
String Languages[] = request.getParameterValues("Language");
%>
<html>
<head>
<title>允许多项选择的下拉框</title>
</head>
<body bgcolor="#FFFFFF">
<h2 align="center">允许多项选择的下拉框</h2>
<hr>
<p>您选择的语言的是:</p>
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