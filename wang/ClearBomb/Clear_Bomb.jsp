<%@ page contentType="text/html;charset=GB2312"%>
<HTML>
<BODY bgcolor=cyan>
<font size=3>
<P> 扫雷界面
<br>
<form action="ClearBomb.jsp" method=post>
<P>请输入横坐标：
<input type="text" name="x" >
<br>
<P>请输入纵坐标：
<input type="text" name="y">
<br>
<br>
<input type="submit" value="dig" name="submit1">
<input type="submit" value="mark" name="submit2">
</form>
<%
    char Bomb_Show[][]=new char[5][5];
    for(int i=0;i<5;i++)
    for(int j=0;j<5;j++)
    Bomb_Show[i][j]='$';
   

    out.print("&nbsp");
    for(int i=0;i<5;i++)
    out.print(" "+i);
    out.print("<BR>");
    for(int i=0;i<5;i++)
    {
       out.print(i);
       for(int j=0;j<5;j++)
       {
            out.print(" "+Bomb_Show[i][j]);
        }
       out.print("<BR>");
     }
%>

       
 
        

  

 
             




</body>
<html>
