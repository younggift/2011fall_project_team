<%@ page contentType="text/html;charset=GB2312" %>
<HTML>
<BODY>
<Font size=1>
<FORM action="byname.jsp" Method="post">
 <P>成绩查询
 <P>输入姓名:
  <Input type=text name="name">
  <Input type=submit name="g" value="提交">
</Form>
<FORM action="byscore.jsp" Method="post" >
 <P>根据分数查询名单:<BR>  英语分数在 
<Input type=text name="englishmin" value=0>
  和
 <Input type=text name="englishmax" value=100>
  之间
 <BR> 数学分数在 
<Input type=text name="mathmin" value=0>
  和
 <Input type=text name="mathmax" value=100>
  之间
  <BR>  <Input type=submit  value="提交">
</Form>
</BODY>
</HTML>