<%@ page contentType="text/html;charset=GB2312" %>
<HTML>
<BODY>
<Font size=1>
<FORM action="byname.jsp" Method="post">
 <P>�ɼ���ѯ
 <P>��������:
  <Input type=text name="name">
  <Input type=submit name="g" value="�ύ">
</Form>
<FORM action="byscore.jsp" Method="post" >
 <P>���ݷ�����ѯ����:<BR>  Ӣ������� 
<Input type=text name="englishmin" value=0>
  ��
 <Input type=text name="englishmax" value=100>
  ֮��
 <BR> ��ѧ������ 
<Input type=text name="mathmin" value=0>
  ��
 <Input type=text name="mathmax" value=100>
  ֮��
  <BR>  <Input type=submit  value="�ύ">
</Form>
</BODY>
</HTML>