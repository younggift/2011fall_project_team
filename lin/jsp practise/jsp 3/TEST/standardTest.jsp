<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="Test" %> 
<HTML>
<BODY bgcolor=cyan> <Font size=1 >
 <jsp:useBean id="test" class="Test" scope="session" >
 </jsp:useBean>
<P>ѡ�������ļ�
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
<Input type="submit" name="sub" value="ȷ��">
</FORM>
 <%-- ��beans�����ļ������� ,����ı�ǩֻ���ύ����Ӧ�ı��ű�ִ�У�--%>
  <jsp:setProperty  name="test"  property="filename"  param="filename"/> 
<P>��ѡ��������ǣ�
<jsp:getProperty  name= "test"  property="filename" /> 
<%-- ͨ��beans��ȡ���������--%>
<BR>
   <jsp:getProperty  name="test"  property="testContent" /> 
<BR>��ѡ��
<BR><Form action="<%=str%>" method="post">
    <Input type="radio" name="selection" value="A">A
    <Input type="radio" name="selection" value="B">B   
    <Input type="radio" name="selection" value="C">C
    <Input type="radio" name="selection" value="D">D
<BR><Input type="submit" name="tijaio" value="�ύ��">
</FORM>
<% //�жϿͻ��Ƿ�ѡ���˴𰸣�
   String s=request.getParameter("selection");
      if(s==null)
         {s="";
         }
%>
<%if(!(s.equals("")))
   { // �����͸�beans������ı�ǩֻ���ύ����Ӧ�ı��ű�ִ�У�
   %> 
    <jsp:setProperty  name= "test"  property="selection" />
   <%}
 %> 
<%--ͨ��beans�õ�����--%>
<P> �����ڵĵ÷��ǣ�
<% if(!(s.equals("")))
  {%>
    <jsp:getProperty  name= "test"  property="score" />
  <%}
%>
</BODy>
</HTML>