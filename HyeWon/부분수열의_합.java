/*
8:03 ~ 08:44
    -5
    => 35 m

1. 아이디어 (백트랙킹)
n: 현재 인덱스
종료조건: n==배열길이

0
|포함o |포함x
        1
      |   |

result = 0;

dfs(0, 0, 0)

dfs(index, sum, cnt):
    if(index==nums.len)
        if cnt>0 && sum==S:
            result++
        return
    dfs(index+1, sum+nums[index], cnt+1)
    dfs(index+1, sum, cnt)

복잡도
2^20 = (2^10)^2 = 1024^2 > (10^3)^2 = 10^6 = 1000000 < 2억
 */
import java.util.*;
public class 부분수열의_합 {
    static int N, S;
    static int[] nums;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();

        nums = new int[N];

        for(int i=0; i<N; i++)
            nums[i] = sc.nextInt();

        dfs(0, 0, 0);
        System.out.println(result);
    }

    static void dfs(int index, int sum, int cnt){
        if (index == N) {
            if (cnt>0 && sum==S)
                result++;
            return;
        }

        dfs(index+1, sum+nums[index], cnt+1);
        dfs(index+1, sum, cnt);
    }
}
