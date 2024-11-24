package dp;


/*
13:57 ~ 14:32 (35m)

2: /2
10: /2 -1 /2 /2
    -1 /3 /3

30: 10 /2 -1 /2 /2
    15 5 4 2 1
9: 3 1
   8 4 2 1
11: 10 5 4 2 1
    10 9 3 1

20: 10
    19 18 6 2 1

1. 아이디어1
n이 3으로 나누어 떨어지면 나누기
    2이면 /2
    아니면 -1

2. 아이디어2
아이디어1의 반례는 못 찾았지만..


an : 1에서 n이 되는 연산 횟수

a1 : 0
a2 : min(a1, a1)+1 ; min(a_i-1, a_i/2)+1 = 1
a3 : min(a2, a1)+1 ; min(a_i-1, a_i/3)+1 = 1
a4 : min(a3, a2)+1 ; min(a_i-1, a_i/2)+1 = 2
a5 : a4+1 ; a_i-1 + = 3

점화식
an =
    if n/3 == 0
        min(a_i-1, a_i/3)+1
    else if n/2 == 0
        min(a_i-1, a_i/2)+1
    else
        a_i-1 + 1
(a1 = 0)

3. 아이디어3
반례는 못 찾았지만..

a6 = min(a5, a3, a2) + 1 ; min(a_i-1, a_i/3, a_i/2) + 1

an =
    if n%6 == 0
        min(a_i-1, a_i/3, a_i/2) + 1
    if n/3 == 0
        min(a_i-1, a_i/3)+1
    else if n/2 == 0
        min(a_i-1, a_i/2)+1
    else
        a_i-1 + 1
(a1 = 0)
 */
import java.util.*;
public class _1로_만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;

        /*
        while(n>2) {
            if(n%3==0) n/=3;
            else n--;
            cnt++;
        }

        if(n==2) cnt++;
        System.out.println(cnt);
         */

        int[] dp = new int[n + 1];
        /*
        for(int i=2; i<=n; i++){
            if(i%3==0)
                dp[i] = Math.min(dp[i-1], dp[i/3]) +1 ;
            else if (i%2==0)
                dp[i] = Math.min(dp[i-1], dp[i/2]) + 1;
            else
                dp[i] = dp[i-1] + 1;
        }
*/


        for(int i=2; i<=n; i++){
            if(i%6==0)
                dp[i] = Math.min(dp[i-1], Math.min(dp[i/3], dp[i/2])) +1 ;
            else if(i%3==0)
                dp[i] = Math.min(dp[i-1], dp[i/3]) +1 ;
            else if (i%2==0)
                dp[i] = Math.min(dp[i-1], dp[i/2]) + 1;
            else
                dp[i] = dp[i-1] + 1;
        }

        System.out.println(dp[n]);
    }
}
