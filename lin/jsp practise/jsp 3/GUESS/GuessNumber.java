
public class GuessNumber
{ int answer=0,    //ʵ�ʴ𰸡�
      guessNumber=0, //�ͻ��²������
      guessCount=0;  //�ͻ��µ���ȷ��֮ǰ���õĴ�����
  String result=null; 
  public void setAnswer(int n)
   { answer=n;
     guessCount=0;
   }  
  public int  getAnswer()
   {return answer;
   }
  public void  setGuessNumber(int n)
   { guessNumber=n;
     guessCount++;
     if(guessNumber==answer)
         result="��ϲ���¶���";
    else if(guessNumber>answer)
         result="�´���";
     else if(guessNumber<answer)
         result="��С��";    
   }
  public int getGuessNumber()
   {return guessNumber;
   }
  public int getGuessCount()
   {return guessCount;
   }
  public String getResult()
   {return result;
   }
 }