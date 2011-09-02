public class Interface_test
{
    public static void main(String[] args)
    {
         B b;
         b=new B();
         b.number=12+A.MAX;
         System.out.println("number:"+b.number);
         System.out.println("sum:"+b.f(100));
    }
}