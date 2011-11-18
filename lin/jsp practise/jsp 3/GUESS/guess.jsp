//猜数页面

<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="GuessNumber" %> 
<HTML>
<BODY>
<jsp:useBean id="guess" class="GuessNumber" scope="session" >
</jsp:useBean>
<jsp:setProperty  name= "guess"  property="guessNumber" param="guessNumber" />
<BR>
<jsp:getProperty  name= "guess"  property="result" />
<br>这是第
<jsp:getProperty  name= "guess"  property="guessCount" />
   猜
<BR>你给出的数是
<jsp:getProperty  name= "guess"  property="guessNumber" />
<% String str=response.encodeRedirectURL("guess.jsp");
%>
<Form action="<%=str%>" method=post >
<BR>再输入你的猜测 <Input type=text name="guessNumber">
<Input type=submit value="提交">
</FORM>
<% String str1=response.encodeRedirectURL("getNumber.jsp");
%>
<BR><FORM action="<%=str1%>" method="post" name="f">
     <Input type="submit" value="重新玩"> 
     </FORM>
</BODY>
</HTML>