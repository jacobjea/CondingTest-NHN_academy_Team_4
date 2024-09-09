package SeungWook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 보물 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");

        Integer[] i1 = new Integer[n];
        Integer[] i2 = new Integer[n];

        for(int i = 0 ; i< n; i++){
            i1[i] = Integer.parseInt(s1[i]) ;
            i2[i] = Integer.parseInt(s2[i]) ;
        }

        for(int i = 0; i < i1.length; i++){
            for(int j = 1; j < i1.length-i; j++){
                if (i1[j-1] > i1[j]) {
                    int temp = i1[j-1];
                    i1[j-1] = i1[j];
                    i1[j] = temp;
                }
            }
        }

        // 배열하나는 오름차순 하나는 내림차순
        Arrays.sort(i2, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += i1[i] * i2[i];
        }
        System.out.println(sum);
    }
}
