import java.io.*;
public class ReadFile
{ String filePath="c:/",fileName="";
  //����Ŀ¼���Ե�ֵ��
  public void setFilePath(String s)
   {filePath=s;
     try{byte b[]=filePath.getBytes("ISO-8859-1");
         filePath= new String(b); 
        }
     catch(Exception ee)
        {  }
   }
 // �����ļ��������Ե�ֵ��
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
  //�г�Ŀ¼�е��ļ���
  public String[] listFile()
  { File dir=new File(filePath);
    String file_name[]=dir.list();
    return file_name;
  }  
  //��ȡ�ļ���ԭʼ��Ϣ��
  public StringBuffer readFile()
   { try{ File file=new File(filePath,fileName);
        FileReader in=new FileReader(file) ;
        PushbackReader push=new PushbackReader(in);
        StringBuffer stringbuffer=new StringBuffer(); 
        int c; 
        char b[]=new char[1];  
        while ( (c=push.read(b,0,1))!=-1)//��ȡ1���ַ������ַ�����b�� 
          { String s=new String(b);
              if(s.equals("<"))        //��ѹ������  
               {  push.unread('&');
                  push.read(b,0,1); //push��������ѹ���ַ��ֽ�,��������b.
                  stringbuffer.append(new String(b));
                  push.unread('L');
                  push.read(b,0,1); //push��������ѹ���ַ��ֽ�,��������b.
                  stringbuffer.append(new String(b));
                  push.unread('T');
                  push.read(b,0,1); //push��������ѹ���ַ��ֽ�,��������b.
                  stringbuffer.append(new String(b));
                }
            else if(s.equals(">"))        //��ѹ������  
               {  push.unread('&');
                  push.read(b,0,1); //push��������ѹ���ַ��ֽ�,��������b.
                  stringbuffer.append(new String(b));
                  push.unread('G');
                  push.read(b,0,1); //push��������ѹ���ַ��ֽ�,��������b.
                  stringbuffer.append(new String(b));
                  push.unread('T');
                  push.read(b,0,1); //push��������ѹ���ַ��ֽ�,��������b.
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
       {return new StringBuffer("���ܶ�ȡ�ļ�");
       } 
   }
}
