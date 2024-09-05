import java.util.*;
public class bronze_2869 {
    public static void main(String[] args) {
        
        Scanner sr = new Scanner(System.in);
        
        int a = sr.nextInt();
        int b = sr.nextInt();
        int v = sr.nextInt();
        
        int goal = 0;
        int count = 0;

        if(v<a)
            System.out.println(1);
        else {

             // a-b 로 가다가 마지막 날은 a만큼
             // (v-a)%(a-b) 가 0 이면 a-b 만큼 한번만 더 가면되니까 -a를 고려해서 +1
             // 0이 아니면 v-a에서 a-b만큼 가도 x만큼 남아있어서 결국 하루를 더 써서 a로 채워야하니까 
             // 한번 더 +1
            if((v-a)%(a-b)==0)
                count = (v-a) / (a-b)+1;
            else count = (v-a) / (a-b)+2;

        }

       
       
        System.out.println(count);
/*  //timout
        while(goal<v){
            
            goal += a;
            if(goal>v){
                break;
            }
            goal -= b;
            count++;
            
        }

        System.out.println(count);
*/

    }
}
