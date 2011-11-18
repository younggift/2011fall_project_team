//选择文件页面

<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="ReadFile" %> 
<HTML>
<BODY ><Font size=2>
<jsp:useBean id="file" class="ReadFile" scope="session" >
</jsp:useBean>
<jsp:setProperty  name= "file"  property="filePath" param="filePath" />
<P>该目录
<jsp:getProperty  name= "file"  property="filePath"  />
有如下文件:<BR>
<% String name[]=file.listFile();
   for(int i=0;i<name.length;i++)
      {out.print("<BR>"+name[i]);
      }
%>
<Form action=readfile.jsp  method="post">
 <P>输入文件的名字: 
<Input type=text name="fileName" name= "f" >
<Input type=submit value="提交">
</Form>
<BR>
<FORM action="filepathselect.jsp" method=post name=form>
<Input type=submit value="重新选择目录">
</FORM>
</Body>
</HTML>