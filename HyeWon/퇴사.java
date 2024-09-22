package dp;

/*
1. 아이디어 : dp
Di : i일부터 퇴사까지 최대 수입
	i : 1부터 N까지
점화식 : 
	D[i] = max(D[i+1], D[i+T[i]] + P[i]) // (i+1)일부터 퇴사까지 수입, (i+T[i])부터 퇴사까지 수입에 오늘 일했을 때 얻을 수입을 더한 총 수입 중 큰 값
	단, i+T[i] > n 이면 위 점화식 대신 D[i] = D[i+1]

2. 시간 복잡도
O(N) < 2억

3. 자료구조
상담을 완료하는데 걸리는 기간 : int[]
상담을 했을 때 받을 수 있는 금액 : int[]
i일부터 퇴사까지 최대 수입 : int[]
 */
import java.util.Scanner;
//import java.util.Arrays;
public class 퇴사 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		
		int[] d = new int[n+2];
//		System.out.println(Arrays.toString(d));
		
		for(int i=n; i>0; i--) {
			if(i+t[i] > n) d[i] = d[i+1];
			else d[i] = Math.max(d[i+1], d[i+t[i]] + p[i]);
		}
		
		System.out.println(d[1]);
	}

}
