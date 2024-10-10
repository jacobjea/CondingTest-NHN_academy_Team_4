package gridy;

/*
9 50
10 2

1. 아이디어 : 그리디
btns

for btns
	cntA = t / 600
	t %= 600
	cntB = t / 60
	t %= 60
	cntC = t / 10
	t %= 10

if t == 0 
	for 3
		각 버튼 누른 횟수 출력
else -1 출력

2. 시간 복잡도
btn 개수

3. 자료구조
버튼들의 시간 : int[]
각 버튼 누른 횟수 : int[]
 */
import java.util.*;
public class 전자레인지 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int[] btnsTime = {300, 60, 10};
		int[] btnCnt = new int [btnsTime.length];
		
		for(int i=0; i<btnsTime.length; i++) {
			btnCnt[i] = t / btnsTime[i];
			t %= btnsTime[i];
		}
		
		if(t==0) {
			for(int cnt : btnCnt) {
				System.out.print(cnt + " ");
			}
		}
		else 
			System.out.println(-1);
	}
}
