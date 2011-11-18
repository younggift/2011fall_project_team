//读取文件内容页面

<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="ReadFile" %> 
<HTML>
<BODY ><Font size=2>
<jsp:useBean id="file" class="ReadFile" scope="session" >
</jsp:useBean>
<jsp:setProperty  name= "file"  property="fileName" param="fileName" />
<P>文件
<jsp:getProperty  name= "file"  property="fileName"  />
的内容如下:<BR>
</Font>
<Font size=1>
<% StringBuffer s=file.readFile();
   out.print(s);
%>
<FORM action="filepathselect.jsp" method=post name=form>
<Input type=submit value="重新选择目录">
</FORM>
<BR>
<FORM action="listfilename.jsp" method=post name=form>
<Input type=submit value="重新选择文件">
</FORM>
</Body>
</HTML>
