package SeungWook;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;

public class 암기왕 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            HashMap<String,Boolean> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            String[] nums = br.readLine().split(" ");

            for(int j = 0; j < nums.length; j++){
                map.put(nums[j], true);
            }

            int m = Integer.parseInt(br.readLine());
            String[] nums2 = br.readLine().split(" ");

            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < nums2.length; k++){
                if (map.containsKey(nums2[k])) {
                    sb.append("1");
                }
                else{
                    sb.append("0");
                }
                if (k != nums2.length-1) {
                    sb.append("\n");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
