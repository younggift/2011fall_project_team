//����ҳ��

<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="GuessNumber" %> 
<HTML>
<BODY>
<jsp:useBean id="guess" class="GuessNumber" scope="session" >
</jsp:useBean>
<jsp:setProperty  name= "guess"  property="guessNumber" param="guessNumber" />
<BR>
<jsp:getProperty  name= "guess"  property="result" />
<br>���ǵ�
<jsp:getProperty  name= "guess"  property="guessCount" />
   ��
<BR>�����������
<jsp:getProperty  name= "guess"  property="guessNumber" />
<% String str=response.encodeRedirectURL("guess.jsp");
%>
<Form action="<%=str%>" method=post >
<BR>��������Ĳ²� <Input type=text name="guessNumber">
<Input type=submit value="�ύ">
</FORM>
<% String str1=response.encodeRedirectURL("getNumber.jsp");
%>
<BR><FORM action="<%=str1%>" method="post" name="f">
     <Input type="submit" value="������"> 
     </FORM>
</BODY>
</HTML>