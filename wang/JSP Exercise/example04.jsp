<%@ page contentType="text/html;charset=gb2312"%>
<HTML>
<BODY bgcolor=cyan><font size=5>
<%!
public class Circle
{
	double r;
	Circle(double r)
	{
		this.r=r;
	}
	double Area()
	{
		double s=Math.PI*r*r;
		return s;
	}
}
%>

<% String str=request.getParameter("number");
double r;
if(str==null)
{
	r=0.0;
}
else
{
	r=Double.parseDouble(str);
}


Circle circle=new Circle(r);
%>
<P>圆的面积为：
<%=circle.Area()%>
<form action="example03.jsp" method=post>
<input type="submit" value="返回" name=submit>
</form>
</body>
<html>
