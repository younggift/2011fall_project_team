	<%@ page contentType="text/html;charset=GB2312"%>
<html>
  <body bgcolor=cyan><FONT size=1>
    <FORM action="request_test.jsp" method=post name=form>
    <input type="test" name="girl">
    <input type="submit" value="enter" name="submit">
    </FORM>
    <%String textContent=request.getParameter("girl");
    double number=0,r=0;
    if(textContent==null){
    textContent="";
    } 
    try{
    number=Double.parseDouble(textContent);
    if(number>=0)
    {
    r=Math.sqrt(number);
    out.print("<BR>"+String.valueOf(number)+"��ƽ����: ");
    out.print("<BR>"+String.valueOf(r));
    }
    else
    {
    out.print("<BR>"+"������һ������");
    }
    }
    catch(NumberFormatException e)
    {
    out.print("<BR>"+"�����������ַ�");
    }
    %>
    </FONT>
  </body>
</html>
