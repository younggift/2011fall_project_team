
import java.io.*;
public class Test
{  String filename="",  //��ſ����ļ����ֵ��ַ�����
   correctAnswer="",   //�����ȷ�𰸵��ַ�����
   //�������Ϳͻ��ύ�Ĵ𰸵��ַ�����
   testContent="" ,
   selection="" ;
   int score=0;         //�����ߵĵ÷֡�
   File f=null;
   FileReader in=null;
   BufferedReader buffer=null;
  public void setFilename(String name)
      {   filename=name; 
           //��ѡ�����µĿ����ļ��󣬽��û��Ĵ��ַ�����գ�
           //��������Ϊ0:
            score=0;
            selection="";
          //��ȡ�����ļ��ĵ�һ�У���׼��
          try { f=new File("F:/2000",filename);
                in=new FileReader(f);
                buffer=new BufferedReader(in); 
                correctAnswer=(buffer.readLine()).trim();//��ȡһ��,ȥ��ǰ��ո�
              }
           catch(Exception e)
              {testContent="û��ѡ������";
              }  
      }
  public String getFilename()
     { return filename;
     }
  public String getTestContent()  //��ȡ���������
        { try {  String s=null;
                 StringBuffer temp=new StringBuffer();
                if(buffer!=null) //����ͻ�ѡ���������ļ���buffer�Ͳ��ǿն���
                  {while((s=buffer.readLine())!=null) //����ȡĳ�����⡣
                    { if(s.startsWith("**")) //���������־��
                         break;
                     //Ϊ������ʾԭʼ��HTML��JSP�ļ�����������ʹ�û�ѹ��������
                      s=getString(s+"\n");
                      temp.append(s);
                      if(s.startsWith("endend")) //�����ļ�������־��
                       { in.close();          //�رպ��ļ������ӡ�
                         buffer.close();  
                       }
                     testContent=new String(temp);  
                   }
                  }
                else
                  { testContent=new String("û��ѡ������");
                  } 
              } 
          catch(Exception e)
              { testContent="����������,���Խ����ˣ���";
              }
          return testContent;
        }
  public void setSelection(String s)
        {  
           selection=selection+s; //���û��ύ�Ĵ�����β�ӵ�selection��
        }
  public int getScore()
        {  int i=selection.length()-1; //�ͻ��ύ�ĵ�i�����selection�е�λ�á�
           int m=correctAnswer.length();
           if(i<=m-1)
              { try{  //�ж�������
                    if(selection.charAt(i)==correctAnswer.charAt(i))
                      score++;
                   }
                catch(StringIndexOutOfBoundsException e) 
                   { i=0;
                   }
              }
           return score;
        }
//���ַ������д���ķ�����
 public String getString(String content)
   {try{  StringReader in=new StringReader(content) ;//ָ���ַ������ַ�����
          PushbackReader push=new PushbackReader(in); //��ѹ��
          StringBuffer stringbuffer=new StringBuffer(); //�����ַ�������
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
          return new String(stringbuffer); //���ش������ַ�����
      }
    catch(IOException e)
      {return content=new String("���ܶ�ȡ����");
      }   
  }
}