
import java.io.*;
public class Test
{  String filename="",  //存放考题文件名字的字符串。
   correctAnswer="",   //存放正确答案的字符串。
   //存放试题和客户提交的答案的字符串：
   testContent="" ,
   selection="" ;
   int score=0;         //考试者的得分。
   File f=null;
   FileReader in=null;
   BufferedReader buffer=null;
  public void setFilename(String name)
      {   filename=name; 
           //当选择了新的考题文件后，将用户的答案字符串清空，
           //将分数设为0:
            score=0;
            selection="";
          //读取试题文件的第一行：标准答案
          try { f=new File("F:/2000",filename);
                in=new FileReader(f);
                buffer=new BufferedReader(in); 
                correctAnswer=(buffer.readLine()).trim();//读取一行,去掉前后空格。
              }
           catch(Exception e)
              {testContent="没有选择试题";
              }  
      }
  public String getFilename()
     { return filename;
     }
  public String getTestContent()  //获取试题的内容
        { try {  String s=null;
                 StringBuffer temp=new StringBuffer();
                if(buffer!=null) //如果客户选择了试题文件，buffer就不是空对象。
                  {while((s=buffer.readLine())!=null) //继续取某个试题。
                    { if(s.startsWith("**")) //试题结束标志。
                         break;
                     //为了能显示原始的HTML或JSP文件考题内容需使用回压流技术：
                      s=getString(s+"\n");
                      temp.append(s);
                      if(s.startsWith("endend")) //试题文件结束标志。
                       { in.close();          //关闭和文件的连接。
                         buffer.close();  
                       }
                     testContent=new String(temp);  
                   }
                  }
                else
                  { testContent=new String("没有选择试题");
                  } 
              } 
          catch(Exception e)
              { testContent="试题无内容,考试结束了！！";
              }
          return testContent;
        }
  public void setSelection(String s)
        {  
           selection=selection+s; //将用户提交的答案依次尾加到selection。
        }
  public int getScore()
        {  int i=selection.length()-1; //客户提交的第i题答案在selection中的位置。
           int m=correctAnswer.length();
           if(i<=m-1)
              { try{  //判定分数：
                    if(selection.charAt(i)==correctAnswer.charAt(i))
                      score++;
                   }
                catch(StringIndexOutOfBoundsException e) 
                   { i=0;
                   }
              }
           return score;
        }
//对字符串进行处理的方法：
 public String getString(String content)
   {try{  StringReader in=new StringReader(content) ;//指向字符串的字符流。
          PushbackReader push=new PushbackReader(in); //回压流
          StringBuffer stringbuffer=new StringBuffer(); //缓冲字符串对象。
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
          return new String(stringbuffer); //返回处理后的字符串。
      }
    catch(IOException e)
      {return content=new String("不能读取内容");
      }   
  }
}