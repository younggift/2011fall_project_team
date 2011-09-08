<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%

String nn=request.getParameter("number");
int n = Integer.parseInt(nn);
for(int i = 1;i<=n;i++)
{
	for(int j = 0;j<i;j++)
	{out.print("*");}
	out.print("<br>");
}
%>