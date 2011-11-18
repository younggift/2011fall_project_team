<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="Test" %> 
<HTML>
<BODY bgcolor=cyan> <Font size=1 >
 <jsp:useBean id="test" class="Test" scope="session" >
 </jsp:useBean>
<P>选择试题文件
<% String str=response.encodeRedirectURL("standardTest.jsp");
%>
<Form action="<%=str%>"  method="post">
 <Select name="filename"  value="A.txt">
          <Option value="A.txt" > A.txt
          <Option value="B.txt"> B.txt
          <Option value="C.txt"> C.txt
          <Option value="D.txt"> D.txt
          <Option value="E.txt"> E.txt
 </Select> 
<Input type="submit" name="sub" value="确定">
</FORM>
 <%-- 过beans设置文件的名字 ,下面的标签只有提交了相应的表单才被执行：--%>
  <jsp:setProperty  name="test"  property="filename"  param="filename"/> 
<P>你选择的试题是：
<jsp:getProperty  name= "test"  property="filename" /> 
<%-- 通过beans获取试题的内容--%>
<BR>
   <jsp:getProperty  name="test"  property="testContent" /> 
<BR>请选择：
<BR><Form action="<%=str%>" method="post">
    <Input type="radio" name="selection" value="A">A
    <Input type="radio" name="selection" value="B">B   
    <Input type="radio" name="selection" value="C">C
    <Input type="radio" name="selection" value="D">D
<BR><Input type="submit" name="tijaio" value="提交答案">
</FORM>
<% //判断客户是否选择了答案：
   String s=request.getParameter("selection");
      if(s==null)
         {s="";
         }
%>
<%if(!(s.equals("")))
   { // 将答案送给beans，下面的标签只有提交了相应的表单才被执行：
   %> 
    <jsp:setProperty  name= "test"  property="selection" />
   <%}
 %> 
<%--通过beans得到分数--%>
<P> 您现在的得分是：
<% if(!(s.equals("")))
  {%>
    <jsp:getProperty  name= "test"  property="score" />
  <%}
%>
</BODy>
</HTML>