<%@ page contentType="text/html;charset=GB2312"%>

<html>
  <body><Font size=3>
  <P>������ѧϰresponse����� 
  <BR>setContentType����
  <P>����ǰҳ�汣��Ϊword�ĵ���
  <FORM action="" method="get" name=form>
  <input type="submit" value="yes" name="submit">
  </FORM>
  <%String str=request.getParameter("submit");
    if(str==null)
    {
    str="";
    }
    if(str.equals("yes"))
    {
    response.setContentType("application/msword;charset=GB2312");
    }
    %>
    </FONT>
  </body>
</html>
