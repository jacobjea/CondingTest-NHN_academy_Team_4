package SeungWook;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 카드_놓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] array = new int[n];
        for(int i = 0; i< n; i++){
            int num = Integer.parseInt(br.readLine());
            array[i] = num;
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            }
            else{
                map.put(num, 1);
            }
        }   

        for(int i = 0; i< n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(factorial(n));
    }

    public static int factorial(int n){
        if (n == 1) {
            return 1;
        }
        else{
            return n * factorial(n-1);
        }
    }
}
