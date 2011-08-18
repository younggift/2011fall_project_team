import com.bruceeckel.simpletest.*;
public class bac {
 static Test monitor=new Test();
 public static void main(String[] args){
	 for(int i=0;i<100;i++){
		 if(i==74)break;
		 if(i%9!=0)continue;
		 System.out.println(i);
	 }
	int i=0;
	while(true){
		i++;
		int j=i*27;
		if(j==1269)break;
		if(i%10!=0)continue;
		System.out.println(i);
	}
	monitor.expect(new String[]{
	"0",
	"9",
	"18",
	"27",
	"36",
	"45",
	"54",
	"63",
	"72",
	"10",
	"20",
	"30",
	"40"
	});
 }
}
