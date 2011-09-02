public class B implements A
{
     int number;
     public int f(int x)
     {
          int s=0;
          for(int i=1;i<=x;i++)
          s+=i;
          return s;
     }
}