import java.util.*;
public class 공_바꾸기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] balls = new int[n];
        for(int i=0; i<n; i++)
            balls[i] = i;
        
        for(int i=0; i<m; i++) {
            int b = sc.nextInt()-1;
            int b2 = sc.nextInt()-1;

            int tmp = balls[b];
            balls[b] = balls[b2];
            balls[b2] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(balls[i]+1).append(" ");

        }

        System.out.println(sb);
    }
}
