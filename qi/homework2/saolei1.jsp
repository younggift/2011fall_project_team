<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html>
<head>
      <title>扫雷界面 : </title>
</head>
<body BGCOLOR=pink>
欢迎进入扫雷界面：<br>

     <form   action="saolei2.jsp" method="post">
      <table width="1003" border="0" cellpadding="5" cellspacing="0" height="118">
   <tr>
    <td width="250">请输入想挖雷位置的横坐标：</td>
           <td width="500"><input name="x" type="text" id="x" size="30"></td>
     </tr>
<tr>
    <td>请输入想挖雷位置的纵坐标：</td>
           <td><input name="y" type="text" id="y" size="30"></td>
     </tr>
  <tr>
       <td>&nbsp;</td>
     <td><input  type="submit" name="sub1"  value="dig"> &nbsp; &nbsp;
         <input  type="submit" name="sub2"  value="mark"></td>
  </tr>
  </table>
</form>
<%
    char [][]jiemian=new char[5][5];
     for(int i=0;i<5;i++)
     for(int j=0;j<5;j++){
  jiemian[i][j]='+';
  }
  out.print("------------");
     out.print("<br>");
     
  out.print("&nbsp");
  for(int i=0;i<5;i++) 
  {
  out.print(" "+i);
  }
  out.print("<br>");
  for(int i=0;i<5;i++){
  out.print(i);
  for(int j=0;j<5;j++)
  {
     out.print(" "+jiemian[i][j]);
 }
 out.print("<br>");
}
 out.print("------------");
     out.print("<br>"); 
 %>
</body>
</html>
