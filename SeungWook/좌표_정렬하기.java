package SeungWook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Comparator;

public class 좌표_정렬하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer,Integer> map = new HashMap<>();
        String[] array = new String[n];

        for(int i = 0; i< n; i++){
            String s = br.readLine();
            array[i] = s;
        }

        Arrays.sort(array, new Comparator<String>() {
           public int compare(String s1, String s2){
            String[] array1 = s1.split(" ");
            String[] array2 = s2.split(" ");


            int x1 = Integer.parseInt(array1[0]);
            int y1 = Integer.parseInt(array1[1]);

            int x2 = Integer.parseInt(array2[0]);
            int y2 = Integer.parseInt(array2[1]);

            if (Integer.compare(x1, x2) != 0) {
                return Integer.compare(x1, x2);
            }
            return Integer.compare(y1, y2);
           } 
        });

        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]) ;
        }
    }
}
