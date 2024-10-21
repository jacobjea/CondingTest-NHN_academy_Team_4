package backtracking;

/*
10:45~
11:27

11:35~
12:4

42+29=71

모든 경우 -> 백트랙킹
	cf) for 문은 n/2 만큼 반복되야하므로 너무 많아짐
종료조건 : 깊이 == n/2
	차이의 최소 갱신
방문 기록 : 겹치지 않게 n/2 명 뽑도록

dfs(0)

스타트팀 리스트 초기화
dfs(deep) :
	deep == n/2 이면 
		스타트팀 능력치 계산
		링크팀 만들기
		링크팀 능력치 계산
		능력치 차이 계산해서 min 갱신
		0이면 아예 종료?
		return
	for n
		i 방문 안했으면
			i 방문 처리
			스타트팀에 넣기
			dfs(deep+1)
			i 방문 처리 취소
			스타트팀에서 빼기

시간 복잡도
20*19*18*..*11 < 시간 초과

아이디어 2. 이진 트리

n : 사람 번호 (0 ~ n-1)
dfs(n, 스타트팀, 링크팀):
	min 0나왔으면 리턴

	n==N이면 
		스타트팀 능력치 계산
		링크팀 능력치 계산
		능력치 차이 계산해서 min 갱신
		return

	dfs(n+1, 스타트팀+n, 링크팀)
	dfs(n+1, 스타트팀+n, 링크팀)

시간 복잡도
2^n= 2^20 = (2^10)^2 > (10^3)^2 = 10^6 < 가능 

 */

import java.util.*;

public class 스타트와_링크 {
	static int N, min;
	static int[][] power;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		min = 100*2*(N/2);
		power = new int [N][N]; 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				power[i][j] = sc.nextInt();
			}
		}
		
		
		dfs(0, new LinkedList<Integer>(), new LinkedList<Integer>());
		System.out.println(min);
	}

	
	static void dfs(int plr, List<Integer> startTeam, List<Integer> linkTeam) {
		// 가치치기(optional) : min == 0 이면 리턴
		
		if (plr==N) {
			if(startTeam.size() != linkTeam.size()) return;
			int startTeamSum = 0;
			int linkTeamSum = 0;

			for(int i=0; i<N/2; i++) {
				for(int j=0; j<N/2; j++) {
					startTeamSum += power[startTeam.get(i)][startTeam.get(j)];
//					startTeamSum += power[startTeam.get(j)][startTeam.get(i)];

					linkTeamSum += power[linkTeam.get(i)][linkTeam.get(j)];
//					linkTeamSum += power[linkTeam.get(j)][linkTeam.get(i)];
				}
			}
			
			min = Math.min(min, Math.abs(startTeamSum-linkTeamSum));
			return;
		}
		
		dfs(plr+1, addToList(startTeam, plr), linkTeam);
		dfs(plr+1, startTeam, addToList(linkTeam, plr));
	}

    private static List<Integer> addToList(List<Integer> list, int plr) {
        List<Integer> newList = new ArrayList<>(list);
        newList.add(plr);
        return newList;
    }
}
