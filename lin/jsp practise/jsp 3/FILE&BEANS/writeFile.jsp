//������д���ļ���ҳ��

<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="WriterFile" %> 
<HTML>
<BODY ><Font size=1>
<jsp:useBean id="file" class="WriterFile" scope="page" >
</jsp:useBean>
<jsp:setProperty  name= "file"  property="filePath" param="filePath" />
<jsp:setProperty  name= "file"  property="fileName" param="fileName" />
<jsp:setProperty  name= "file"  property="fileContent" param="fileContent" />
<BR>��д�ļ���Ŀ¼��
<jsp:getProperty  name= "file"  property="filePath"  />
<BR>�ļ��������ǣ�
<jsp:getProperty  name= "file"  property="fileName"  />
<BR>�ļ��������ǣ�
<jsp:getProperty  name= "file"  property="fileContent"  />
</Font>
</Body>
</HTML>