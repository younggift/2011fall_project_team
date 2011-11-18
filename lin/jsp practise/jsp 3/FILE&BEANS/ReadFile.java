import java.io.*;
public class ReadFile
{ String filePath="c:/",fileName="";
  //设置目录属性的值：
  public void setFilePath(String s)
   {filePath=s;
     try{byte b[]=filePath.getBytes("ISO-8859-1");
         filePath= new String(b); 
        }
     catch(Exception ee)
        {  }
   }
 // 设置文件名字属性的值：
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
  //列出目录中的文件：
  public String[] listFile()
  { File dir=new File(filePath);
    String file_name[]=dir.list();
    return file_name;
  }  
  //读取文件的原始信息：
  public StringBuffer readFile()
   { try{ File file=new File(filePath,fileName);
        FileReader in=new FileReader(file) ;
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
          return stringbuffer;  
       }
    catch(IOException e)
       {return new StringBuffer("不能读取文件");
       } 
   }
}
