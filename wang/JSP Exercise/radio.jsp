<%@page contentType="text/html;charset=gb2312"%>
<html>
<body><font size=3>
<p> ����ѡ����:</p>
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
	   out.print("JSP�ļ�");
	   tjsp++;
	}
	else if(ftype.equals("java"))
	{
	
	    out.print("Java�ļ�");
		tjava++;
	}
	else if(ftype.equals("HTML"))
	{

		out.print("html�ļ�");
		thtml++;
	}
	else if(ftype.equals("ASP"))
	{
	     out.print("ASP�ļ�");
		 tasp++;
	}
%>
<%=tjsp%>
<%=tjava%>
<%=thtml%>
<%=tasp%>
</body>
</html>