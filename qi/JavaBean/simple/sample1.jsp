<%@ page contentType="text/html;charset=GBK"%>
<html>
<head>
<title>Servletʹ��JSP</title></head>
<jsp:useBean id = "myBean"
               scope = "application" class = "bean.sampleBean"/>
<body bgcolor = "cyan">
<h2>JSPʹ��JavaBean������:</h2>
<hr>
����jsp:setProperty֮ǰ��ֵ��
<jsp:getProperty name = "myBean" property = "sample"/>
<p>
<jsp:setProperty name = "myBean" property = "sample" value="hahahahahhaha"/>
����jsp:setProperty֮���ֵ��
<jsp:getProperty name="myBean" property = "sample"/>
</body>
</html>