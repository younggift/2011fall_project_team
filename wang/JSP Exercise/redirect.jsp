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
<p> ��ѡ������Ҫ���ʵ�վ��
<br>
<form action="redirect.jsp" method="get">
<select name="site">
<option value="baidu" selected> �ٶ�
<option value="google" selected> �ȸ�
</select>
<input type="submit" value="ȷ��">
</form>
</body>
</html>
