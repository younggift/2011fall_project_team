public class test
{
      public static void main(String[] args)
      {
            long sum=0;
            for(int i=1;i<=20;i++)
            {
                 long s=1;
                 for(int j=1;j<=i;j++)
                 s=s*j;
                 sum+=s;
             }
          System.out.println(sum);
       }
}
            