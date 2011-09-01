<%@ page contentType="text/html;charset=GB2312"%>
<html>
<BODY Bgcolor=cyan><FONT size=2>
<P>Please input the lines you want to print
<FORM action="" method=post name=form>
<INPUT type="text" name="number">
<BR><INPUT TYPE="submit" value="commit",name=submit>
</FORM>

<%
String a=request.getParameter("number");
if(a==null)
{
     a="0";
}
try{
      int number=Integer.parseInt(a);
      int i,j;
      for(i=1;i<=number;i++)
     {
          for(j=1;j<=i;j++)
          out.print("* ");
          out.print("<br>");
     }
}
catch(NumberFormatException e)
{
     out.print("<BR>"+"Plese input number");
}

%>
</BODY>
</HTML>