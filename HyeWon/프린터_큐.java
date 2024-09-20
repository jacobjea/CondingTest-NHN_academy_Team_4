package implementation;

/*
1. 아이디어

큐가 빌 때까지 반복 :
	q[0] 보다 큰게 있으면 뒤로 보내기
	없으면 
		인쇄 즉 pop
		인쇄 횟수++
		내가 찾는 문서였으면 반복 종료
인쇄 횟수 출력

2. 시간 복잡도
T * N * N = 10000

3. 자료구조
문서 : Doc 클래스 만들기
	필드 : 중요도 int, 타겟 boolean
프린터 큐 : Queue<Doc>

 */

import java.util.*;

public class 프린터_큐 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0) {
			int n = sc.nextInt();
			int target = sc.nextInt();
			
//			System.out.printf("n:%d, target:%d\n", n, target);
			
			Queue<Doc> q = new LinkedList<>();
			for(int i=0; i<n; i++) {
				int weight = sc.nextInt();
				if (target == i) 
					q.add(new Doc(weight, true));
				else {
					q.add(new Doc(weight, false));
				}
			}
			
			
			
			int cnt = 0;
			
			while(!q.isEmpty()) {
				Doc doc = q.poll();
				boolean isImportant = !q.stream().anyMatch(d -> doc.weight < d.weight);
//				System.out.println("isImportant : " + isImportant);
				if(isImportant || q.isEmpty()) {
					cnt++;
					if (doc.target) {
						System.out.println(cnt);
						break;
					}
				}	
				else q.add(doc);
//				System.out.println(q);
			}
		}

	}

}

class Doc {
	int weight;
	boolean target;
	
	Doc(int weight, boolean target) {
		this.weight = weight;
		this.target = target;
	}
	
	public String toString() {
		return "weight:"+weight+", target:"+target;
	}
}
