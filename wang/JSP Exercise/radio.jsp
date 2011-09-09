<%@page contentType="text/html;charset=gb2312"%>
<html>
<body><font size=3>
<p> 您的选择是:</p>
<%!
     int tjava=0;
	 int tjsp=0;
	 int thtml=0;
	 int tasp=0;
%>
<%
    String ftype=request.getParameter("ftype");
	if(ftype.equals("jsp"))
	{
	   out.print("JSP文件");
	   tjsp++;
	}
	else if(ftype.equals("java"))
	{
	
	    out.print("Java文件");
		tjava++;
	}
	else if(ftype.equals("HTML"))
	{

		out.print("html文件");
		thtml++;
	}
	else if(ftype.equals("ASP"))
	{
	     out.print("ASP文件");
		 tasp++;
	}
%>
<%=tjsp%>
<%=tjava%>
<%=thtml%>
<%=tasp%>
</body>
</html>