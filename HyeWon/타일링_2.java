package dp;

/*
1. 아이디어 : dp
--규칙 찾기 
A0 : 0
A1 : A0 + 1 = 1
A2 : A1(a2이 세로일 때) + (2)(:a2이 세로 아닐 때) = 3  
A3 : A2(a3이 세로일 때) + (A1*2) = 6
A4 : A3 + A3*2
--점화식
A0 = 0, A1 = 1
a>=2 : Ai = Ai-1 + Ai-2 + 2

2. 복잡도
n = 1000

3. 자료구조
memo : int[]
 */
import java.util.*;
public class 타일링_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] memo = new int[n+3];
		
		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 3;
		for(int i=3; i<=n; i++) {
			memo[i] = (memo[i-1] + memo[i-2] * 2)%10007;
		}
		
		System.out.println(memo[n]);

	}

}
