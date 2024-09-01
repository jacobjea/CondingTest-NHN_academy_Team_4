package SeungWook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class 나이순_정렬 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] array = new String[n];

        for(int i = 0; i< n; i++){
            array[i] = br.readLine();
        }

        Arrays.sort(array, new Comparator<String>(){
            public int compare(String s1, String s2){
                String[] strArray1 = s1.split(" ");
                String[] strArray2 = s2.split(" ");

                int age1 = Integer.parseInt(strArray1[0]);
                int age2 = Integer.parseInt(strArray2[0]);

                return Integer.compare(age1, age2);
            }
        });

        for(String s : array){
            System.out.println(s);
        }
    }
}
