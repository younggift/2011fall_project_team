<%@ page contentType="text/html;charset=GB2312"%>
<HTML>
<BODY bgcolor=yellow>
<font size=3>
<P> WELCOME!
<br>
<form action="ClearLay.jsp" method=post>
<P>Please input x£º
<input type="text" name="x" >
<br>
<P>Please input y£º
<input type="text" name="y">
<br>
<br>
<input type="submit" value="dig" name="submitdig">
<input type="submit" value="mark" name="submitmark">
</form>
<%
    char face[][]=new char[5][5];
    for(int i=0;i<5;i++)
    for(int j=0;j<5;j++)
    face[i][j]='_';
   

    out.print("&nbsp");
    for(int i=0;i<5;i++)
    out.print(" "+i);
    out.print("<BR>");
    for(int i=0;i<5;i++)
    {
       out.print(i);
       for(int j=0;j<5;j++)
       {
            out.print(" "+face[i][j]);
        }
       out.print("<BR>");
     }
%>

       
 
        

  

 
             




</body>
<html>
