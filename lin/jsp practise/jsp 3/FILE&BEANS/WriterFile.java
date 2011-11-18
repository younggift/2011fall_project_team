import java.io.*;
public class WriterFile
{ String filePath=null,
         fileName=null,
         fileContent=null;
  public WriterFile()
    { filePath="C:/";
      fileName="无标题";
      fileContent="无内容"; 
    }
  public void setFilePath(String s)
   {filePath=s;
     try{byte b[]=filePath.getBytes("ISO-8859-1");
         filePath= new String(b); 
        }
     catch(Exception ee)
        { }
   }
  public String getFilePath()
   {return filePath;
   }
  public void setFileName(String s)
   { fileName=s;
     try{byte b[]=fileName.getBytes("ISO-8859-1");
         fileName=new String(b); 
        }
     catch(Exception ee)
        { }
   }
  public String getFileName()
   {return fileName;
   }
 //获取属性fileContent的值，为了能显示HTML或JSP源文件，需进行流的处理技术：
 public String getFileContent()
   { try{ StringReader in=new StringReader(fileContent) ;//指向字符串的字符流。
          PushbackReader push=new PushbackReader(in);
          StringBuffer stringbuffer=new StringBuffer(); 
          int c; 
          char b[]=new char[1]; 
          while ( (c=push.read(b,0,1))!=-1)//读取1个字符放入字符数组b。 
            { String s=new String(b);
              if(s.equals("<"))        //回压的条件  
               {  push.unread('&');
                  push.read(b,0,1); //push读出被回压的字符字节,放入数组b.
                  stringbuffer.append(new String(b));
                  push.unread('L');
                  push.read(b,0,1); //push读出被回压的字符字节,放入数组b.
                  stringbuffer.append(new String(b));
                  push.unread('T');
                  push.read(b,0,1); //push读出被回压的字符字节,放入数组b.
                  stringbuffer.append(new String(b));
                }
              else if(s.equals(">"))        //回压的条件  
               {  push.unread('&');
                  push.read(b,0,1); //push读出被回压的字符字节,放入数组b.
                  stringbuffer.append(new String(b));
                  push.unread('G');
                  push.read(b,0,1); //push读出被回压的字符字节,放入数组b.
                  stringbuffer.append(new String(b));
                  push.unread('T');
                  push.read(b,0,1); //push读出被回压的字符字节,放入数组b.
                  stringbuffer.append(new String(b));
               }
              else if(s.equals("\n"))        
               {  stringbuffer.append("<BR>");
               }
              else
               { stringbuffer.append(s);
               }
            }
          push.close();
          in.close();
          return  fileContent=new String(stringbuffer);  
        }
    catch(IOException e)
       {return fileContent=new String("不能读取内容");
       }   
   }
  //写文件：
   public void setFileContent(String s)
   { fileContent=s;
    try{ 
        byte b[]=fileContent.getBytes("ISO-8859-1");
         fileContent=new String(b);
        File file=new File(filePath,fileName);
        FileWriter in=new FileWriter(file) ;
        BufferedWriter buffer=new BufferedWriter(in);
        buffer.write(fileContent);
        buffer.flush();
        buffer.close();
        in.close();
       }
    catch(Exception e)
       {}   
   }
}