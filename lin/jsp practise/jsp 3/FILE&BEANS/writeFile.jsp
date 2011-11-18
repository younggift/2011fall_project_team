//将内容写入文件的页面

<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="WriterFile" %> 
<HTML>
<BODY ><Font size=1>
<jsp:useBean id="file" class="WriterFile" scope="page" >
</jsp:useBean>
<jsp:setProperty  name= "file"  property="filePath" param="filePath" />
<jsp:setProperty  name= "file"  property="fileName" param="fileName" />
<jsp:setProperty  name= "file"  property="fileContent" param="fileContent" />
<BR>你写文件到目录：
<jsp:getProperty  name= "file"  property="filePath"  />
<BR>文件的名字是：
<jsp:getProperty  name= "file"  property="fileName"  />
<BR>文件的内容是：
<jsp:getProperty  name= "file"  property="fileContent"  />
</Font>
</Body>
</HTML>