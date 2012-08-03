package function;
public class Radom {
   public int [] arr=new int[55];
    public Radom(){
        for(int i=1;i<55;i++){
            arr[i]=0;
        }
    }
 public int CreatRadom(){
   
       int Radom1=(int)(Math.random()*54)+1;
         if(arr[Radom1]==0)  arr[Radom1]=1;
         else{
              while(arr[Radom1]==1){
               Radom1=(int)(Math.random()*54)+1;   
              }
              arr[Radom1]=1;
         }   
         return Radom1;
          }
 /* public static void main(String[] args) {
    Radom c= new Radom();
         for(int i=1;i<55;i++){
           System.out.println(c.CreatRadom()+"    "+i);
        }
}
  * 
  */
 }


