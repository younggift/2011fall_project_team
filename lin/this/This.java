
public class This {
	private int i=0;
    //��һ������������һ��int���β�
    This(int i){
       this.i=i+1;//��ʱthis��ʾ���ó�Ա�����飬���Ǻ���������
       System.out.println("Int constructor i����this.i:  "+i+"����"+this.i);
       System.out.println("i-1:"+(i-1)+"this.i+1:"+(this.i+1));
       //���������������֤����i��this.i�ǲ�һ���ģ�
    }
    //  �ڶ�������������һ��String���β�
    This(String s){
       System.out.println("String constructor:  "+s);
    }
    //  ����������������һ��int���βκ�һ��String���β�
    This(int i,String s){
       this(s);//this���õڶ���������
     /*������˵�ڶ����������еĲ���s��ֵ�Ѿ��ı��ˣ������ok again����*/

       //this(i);
       /*�˴������ã���Ϊ�����κη��������ܵ��ù�������ֻ�й��췽���ܵ�������
       ���Ǳ���ע�⣺�����ǹ��췽�����ù�������Ҳ����Ϊ�����һ�У����췽��Ҳֻ�ܵ�
       ��һ���ҽ�һ�ι�������*/
       this.i=i++;//this�����ø���ĳ�Ա����
       System.out.println("Int constructor:  "+i+"/n"+"String constructor:  "+s);
    }
    public This increment(){
       this.i++;
       return this;//���ص��ǵ�ǰ�Ķ��󣬸ö������ڣ�ThisTest��
    }
    public static void main(String[] args){
       This tt0=new This(10);
       This tt1=new This("ok");
       This tt2=new This(20,"ok again!");
      
       System.out.println(tt0.increment().increment().increment().i);
       //tt0.increment()����һ����tt0�����ϣ�++��ThisTest����
       //�����ַ��������淵�صĶ��������i++��ThisTest����
    }
	

}
