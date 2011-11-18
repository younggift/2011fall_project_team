
public class GuessNumber
{ int answer=0,    //实际答案。
      guessNumber=0, //客户猜测的数。
      guessCount=0;  //客户猜到正确答案之前所用的次数。
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
         result="恭喜，猜对了";
    else if(guessNumber>answer)
         result="猜大了";
     else if(guessNumber<answer)
         result="猜小了";    
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