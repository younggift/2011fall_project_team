<%@ page contentType="text/html;charset=gb2312"%>
<html>
<body><font size=3>
<%
    String site=request.getParameter("site");
	if(site!=null)
	{
		if(site.equals("baidu")) response.sendRedirect("http://www.baidu.com");
		if(site.equals("google")) response.sendRedirect("http://google.com.hk");
	}
%>
<p> 请选择你需要访问的站点
<br>
<form action="redirect.jsp" method="get">
<select name="site">
<option value="baidu" selected> 百度
<option value="google" selected> 谷歌
</select>
<input type="submit" value="确定">
</form>
</body>
</html>
