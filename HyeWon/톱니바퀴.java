package implementation;

/*
1. 아이디어
톱니1 : 인덱스 2
  2  :     6 2
   3 :     6 2
   4 :     6

톱니3 시계반대 
	회전[3] = -1
	1. 톱니2[2]==톱니3[6] : 
		오른쪽 톱니가 없다면
			톱니3만 회전
		있다면
			톱니3[2] == 톱니4[6] :
				톱니3만 회전
		    다르면



톱니들 회전 하는지(1, -1) 안하는지(0) 저정 배열 0으로 초기화

for k
	번호, 방향 입력 받기 
	rotate(3, -1)

for 4
	-1 : 톱니i  (pop add)1번
	1 :     i  (pop add)6번    또는 데큐로 마지막에 첫번째가 될수있는 방법  찾아보기

rotate(which, dir):
	//if (which가 1~4 아니면) return
	
	회전[which] = dir
	else if which = 2|3
		회전[which+1]==0  &&  톱니[which][2] != 톱니[which+1][6]:
			rotate(which+1, dir*-1)
		회전[which-1]==0  &&  톱니[which-1][2] != 톱니[which][6]:
			rotate(which-1, dir*-1)
	else if which==1
		회전[which+1]==0  &&  톱니[which][2] != 톱니[which+1][6]:
			rotate(which+1, dir*-1)
	else (which==4)
		회전[which-1]==0  &&  톱니[which-1][2] != 톱니[which][6]:
			rotate(which-1, dir*-1)
	

톱니1[0] == 1
		result+=1
   2[0] == 1
   		result+=2
   3[0] == 1
   		result+=4
   4[0] == 1
   		result += 8

2. 시간복잡도
k 

3. 자료구조
톱니들 : ArrayList<데큐<Integer>> = new ArrayList<>(4)
방향 : int[7]

9 48 ~ 10:55 
9 48 ~ 
 */

import java.util.*;

public class 톱니바퀴 {
	static List<LinkedList<Boolean>> wheels;
	static int[] willRotate;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		ArrayDeque<Integer> d = new ArrayDeque<>();
		wheels = new ArrayList<>();
		
		for(int i=0; i<4; i++) {
			String state = sc.nextLine();
			
			LinkedList<Boolean> wheel = new LinkedList<>();
			for(int j=0; j<8; j++) {
//				System.out.println(state.charAt(j));
				boolean isOne = state.charAt(j) == '1' ? true : false;
				wheel.add(isOne);
			}
			
			wheels.add(wheel);
//			System.out.println(wheel);
		}
		
//		for(LinkedList<Boolean> wheel :wheels) {
//			System.out.println(wheel);
//		}
		
		int k = sc.nextInt();
		
		while(k-- > 0) {
			int num = sc.nextInt()-1;
			int dir = sc.nextInt();
			
			willRotate = new int[4];
			rotate(num, dir);
//			System.out.println(Arrays.toString(willRotate));
			
//			for(LinkedList<Boolean> wheel :wheels) {
//				for(int val : willRotate) {
//					if (val == -1) 
//						wheel.add(wheel.removeFirst());
//					else if (val == 1)
//						wheel.addFirst(wheel.removeLast());
//				}
//			}
			for(int i=0; i<4; i++) {
				if (willRotate[i] == -1) 
					wheels.get(i).add(wheels.get(i).removeFirst());
				else if (willRotate[i] == 1)
					wheels.get(i).addFirst(wheels.get(i).removeLast());
			}
			
//			for(LinkedList<Boolean> wheel :wheels) {
//				System.out.println(wheel);
//			}
		}
		
		int result = 0;
		
//		for(LinkedList<Boolean> wheel :wheels) {
//			System.out.println(wheel);
//		}
		
		if (wheels.get(0).get(0)) result+=1;
		if (wheels.get(1).get(0)) result+=2;
		if (wheels.get(2).get(0)) result+=4;
		if (wheels.get(3).get(0)) result+=8;
		
		System.out.println(result);
	}
	
	public static void rotate(int num, int dir) {
		willRotate[num] = dir;
//		System.out.println(Arrays.toString(willRotate));
		
		if(num == 0) {
			if (willRotate[num+1]==0 && 
					wheels.get(num).get(2) != wheels.get(num+1).get(6)) {
				rotate(num+1, dir*-1);
			}
		}
		else if (num == 1 || num ==2) {
			if (willRotate[num+1]==0 && 
					wheels.get(num).get(2) != wheels.get(num+1).get(6)) {
				rotate(num+1, dir*-1);
			}
			if (willRotate[num-1]==0 && 
					wheels.get(num-1).get(2) != wheels.get(num).get(6)) {
				rotate(num-1, dir*-1);
			}
		} else {
			if (willRotate[num-1]==0 && 
					wheels.get(num-1).get(2) != wheels.get(num).get(6)) {
				rotate(num-1, dir*-1);
			}
		}

	}

}
