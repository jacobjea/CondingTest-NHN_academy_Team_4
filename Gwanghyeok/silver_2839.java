import java.util.*;

public class silver_2839{

    
    public static void main(String[] args) {
        
        Scanner sr = new Scanner(System.in);

        int n = sr.nextInt();
        int count = 0;
        
        while(n>=0){

            if(n % 5 == 0){
                count = count + n / 5;
                System.out.println(count);
                break;
            } else {
                n = n - 3;
                count++;
            }
         
        }
        
        if(n<0)
            System.out.println(-1);
        

        sr.close();
    }
}