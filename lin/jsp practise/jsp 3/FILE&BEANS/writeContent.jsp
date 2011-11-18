//提交文件内容的页面（包括文件所在目录、文件名及内容)

<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="ReadFile" %> 
<HTML>
<BODY ><Font size=1>
<P>请选择一个目录：
 <FORM action="writeFile.jsp" method=post>
     <Select name="filePath" >
          <Option value="f:/2000"> f:/2000
          <Option value="d:/tomcat">D:/tomcat
          <Option value="d:/root">Root
          <Option value="F:/javabook">f:/javabook
          <Option value="f:/Example">f:/Example
       </Select> 
<P>输入保存文件的名字：
<Input type=text name="fileName" >
<P>输入文件的内容：
<BR>
<TextArea  name= "fileContent" Rows= "10" Cols= "40"  >
</TextArea>
<BR><Input type=submit value="提交">
</FORM>
</FONT>
</BODY>
</HTML>