package SeungWook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 치킨치킨치킨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        String[][] array = new String[n][m];
        for (int i = 0; i < n; i++) {
            array[i] = br.readLine().split(" ");
        }

        int result = 0;
        for (int i = 0; i < m-2; i++) {
            for (int j = i+1; j < m-1; j++) {
                for (int k = j+1; k < m; k++) {
                    int first = 0;
                    int second = 0;
                    int third = 0;
                    int maxSatifation = 0;
                    int sum = 0;

                    for(int l = 0; l<n; l++){

                        first =  Integer.parseInt(array[l][i]);
                        second =  Integer.parseInt(array[l][j]);
                        third =  Integer.parseInt(array[l][k]);

                        //3개의 만족도 중 제일 높은 값을 가져온다.
                        maxSatifation = first > second ? first : second;
                        maxSatifation = maxSatifation > third ? maxSatifation : third;
                        sum += maxSatifation;
                    }
                    result = result > sum ? result : sum;
                }   
            }
        }
        System.out.println(result);
    }
}
