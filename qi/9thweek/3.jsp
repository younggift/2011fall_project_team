<%@ page contentType="text/html;charset=GBK"%>
<%
request.setCharacterEncoding("GBK");
String name = request.getParameter("Name");
String phone = request.getParameter("Phone");
Cookie cookies[]=request.getCookies();
if(name!=null){
Cookie c = new Cookie("Name",name);
c.setMaxAge(60);
response.addCookie(c);
}
else if(cookies !=null){
for(int i=0;i<cookies.length;i++){
	if(cookies[i].getName().equals("Name"))
		name=cookies[i].getValue();
}
}
if(phone!=null){
Cookie c = new Cookie("Phone",phone);
c.setMaxAge(60);
response.addCookie(c);
}
else if(cookies !=null){
for(int i=0;i<cookies.length;i++){
	if(cookies[i].getName().equals("Phone"))
		phone=cookies[i].getValue();
}
}
%>
<html>
<head>
<title>ʹ��cookie������Ϣ</title>
</head>
<body bgcolor="#FFFFFF">
<h2 align="left"><font color="#660000" face="����">����Cookie���󱣴���Ϣ</font></h2>
<hr>
<form action="3.jsp" method="POST">
<p>����:
<input type="text" size="20" name="Name" value="<% if(name !=null) out.println(name); %>">
</p>
<p>�绰:
<input type="text" size="20" name="Phone" id="Phone" value="<% if(phone !=null) out.println(phone); %>">
</p>
<p><input type="submit" value="����">
<input type="reset" value="ȡ��">
</p>
</form>
</body>
</html>