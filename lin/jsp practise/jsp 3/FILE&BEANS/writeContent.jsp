//�ύ�ļ����ݵ�ҳ�棨�����ļ�����Ŀ¼���ļ���������)

<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="ReadFile" %> 
<HTML>
<BODY ><Font size=1>
<P>��ѡ��һ��Ŀ¼��
 <FORM action="writeFile.jsp" method=post>
     <Select name="filePath" >
          <Option value="f:/2000"> f:/2000
          <Option value="d:/tomcat">D:/tomcat
          <Option value="d:/root">Root
          <Option value="F:/javabook">f:/javabook
          <Option value="f:/Example">f:/Example
       </Select> 
<P>���뱣���ļ������֣�
<Input type=text name="fileName" >
<P>�����ļ������ݣ�
<BR>
<TextArea  name= "fileContent" Rows= "10" Cols= "40"  >
</TextArea>
<BR><Input type=submit value="�ύ">
</FORM>
</FONT>
</BODY>
</HTML>