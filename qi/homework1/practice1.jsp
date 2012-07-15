<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html>
<head>
      <title>简单登陆界面 : </title>
</head>
<body>
     <form action="printstar2.jsp" method="post">
      <table width="1003" border="0" cellpadding="5" cellspacing="0" height="118">
   <tr>
    <td width="250">用户名：</td>
           <td width="500"><input name="name" type="text" id="name" size="30"></td>
     </tr>
<tr>
    <td>密码：</td>
           <td><input name="passwd" type="password" id="passwd" size="30"></td>
     </tr>
  <tr>
       <td>&nbsp;</td>
     <td><input  type="submit" name="Submit"  value="确定"> &nbsp; &nbsp;
         <input  type="reset" name="reset"  value="重置"></td>
  </tr>
</table>
</form>
</body>
</html>

   

