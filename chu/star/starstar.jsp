<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html>
<head>
      <title>打印星号: </title>
</head>
<body Bgcolor=yellow><font size=20 color=red>
     <form action=""  method="post">
      <table width="1003" border="0" cellpadding="5" cellspacing="0" height="118">
   <tr>
    <td width="300"><h2>星号的行数：</h2></td>
           <td width="500"><input name="hangshu" type="text" id="hangshu" size="30"></td>
     </tr>
  <tr>
       <td>&nbsp;</td>
     <td><input  type="submit" name="Submit"  value="Yes"> &nbsp; &nbsp;
         <input  type="reset" name="reset"  value="Cancel"></td>
  </tr>
</table>
</form>
<% 
      String m = request.getParameter("hangshu");
      if(m==null)
      {
          m="0";
      }
      int h = Integer.parseInt(m);
      
      for(int j=1;j<=h;j++){
			for(int i=0;i<j;i++){
			    out.print("*");
			   }
			   out.print("<br>");
			  }
	
	
%>

</body>
</html>

   
