//��ȡһ�������ҳ��

<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="GuessNumber" %> 
<HTML>
<BODY>
<% int n=(int)(Math.random()*100)+1;%>
<jsp:useBean id="guess" class="GuessNumber" scope="session" >
</jsp:useBean>
<jsp:setProperty  name= "guess"  property="answer" value="<%=n%>" />
<p>�������һ��1��100֮���������²�������Ƕ��٣�
<% String str=response.encodeRedirectURL("guess.jsp");
%>
<Form action="<%=str%>" method=post >
<BR>������Ĳ²� <Input type=text name="guessNumber">
<Input type=submit value="�ύ">
</FORM>
</BODY>