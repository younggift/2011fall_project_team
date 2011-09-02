public class test2
{
      public static void main(String[] args)
      {
             int j;
             for(int i=1;i<=100;i++)
             {
                  for(j=2;j<=Math.sqrt(i);j++)
                  {
                       if(i%j==0)
                       {
                            break;
                       }
                  }
                 if(j>Math.sqrt(i)) System.out.print(i+" ");
             }
        }
}