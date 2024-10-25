import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FizzBuzz {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        for(int i = 0; i<3; i++){
            String line = br.readLine();
            try{
                Integer.parseInt(line);
            } catch(Exception e){
                continue;
            }
            n = Integer.parseInt(line) + 3-i;
            break;
        }
     
        // 3의 배수이면서 5의 배수
        if (n % 15  == 0) {
            System.out.println("FizzBuzz");
        }
        else if (n % 3 == 0 && n % 5 != 0) {
            System.out.println("Fizz");
        }
        else if (n % 3 != 0 && n % 5 == 0) {
            System.out.println("Buzz");
        }
        else
        {
            System.out.println(n);
        }
    }
}
