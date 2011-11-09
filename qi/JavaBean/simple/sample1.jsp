<%@ page contentType="text/html;charset=GBK"%>
<html>
<head>
<title>Servlet使用JSP</title></head>
<jsp:useBean id = "myBean"
               scope = "application" class = "bean.sampleBean"/>
<body bgcolor = "cyan">
<h2>JSP使用JavaBean的例子:</h2>
<hr>
调用jsp:setProperty之前的值：
<jsp:getProperty name = "myBean" property = "sample"/>
<p>
<jsp:setProperty name = "myBean" property = "sample" value="hahahahahhaha"/>
调用jsp:setProperty之后的值：
<jsp:getProperty name="myBean" property = "sample"/>
</body>
</html>