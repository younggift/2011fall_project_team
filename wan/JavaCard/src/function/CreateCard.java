package function;
public class CreateCard {
      public int[] imgPath=new int[55];
     static Radom r=new Radom();

    public CreateCard(){
    
        for(int i=1;i<55;i++){
            int j=r.CreatRadom();
          imgPath[i]=j;
           
        }
    this.maoPao(imgPath,1,17);
     this.maoPao(imgPath,18,34);
     this.maoPao(imgPath,35,54);
    }
    public static void maoPao(int[] x,int begin,int end) {   
  for (int i = begin; i <end; i++) {   
   for (int j = i + 1; j <=end; j++) {   
    if (x[i] > x[j]) {   
     int temp = x[i];   
     x[i] = x[j];   
     x[j] = temp;   
    }   
   }   
  }
    }

  public void prinArray(){

         for(int i=1;i<55;i++){
             if(i%17==1) {System.out.println();}   
           System.out.println(imgPath[i]);
        }
      
    }
 /*public static void main(String[] args) {
    CreateCard c= new CreateCard();
    c.prinArray();
}
   * 
   */
  }

