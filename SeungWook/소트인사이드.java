package SeungWook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class 소트인사이드 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char[] charArray = s.toCharArray();
        Integer[] intArray = new Integer[charArray.length];

        for(int i = 0; i < charArray.length; i++){
            intArray[i] = Character.getNumericValue(charArray[i]);
        }

        Arrays.sort(intArray, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2){
                return i2.compareTo(i1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i =0; i< intArray.length; i++){
            sb.append(intArray[i]);
        }
        System.out.println(sb.toString());
    }
}
