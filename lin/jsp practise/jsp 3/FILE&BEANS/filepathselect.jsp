//选择目录的页面

<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.util.*" %>
<%@ page import="ReadFile" %> 
<HTML>
<BODY ><Font size=1>
<P>请选择一个目录：
 <FORM action="listfilename.jsp" method=post>
     <Select name="filePath" >
          <Option value="f:/2000"> f:/2000
          <Option value="d:/tomcat">D:/tomcat
          <Option value="d:/tomcat/jakarta-tomcat-4.0/webapps/root">Root
          <Option value="F:/javabook">f:/javabook
          <Option value="f:/Example">f:/Example
       </Select>   
<Input type=submit value="提交">
</FORM>
</FONT>
</BODY>
</HTML>