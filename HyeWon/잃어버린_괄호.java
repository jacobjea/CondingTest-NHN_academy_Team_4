package gridy;

/*
1. 아이디어 : 그리디
0~9
+ - 괄호

String[] ops 
StringBuilder
for 0, 입력 길이-1 전까지 : 
	//for 5
	sb += input[i]
	if input[i+1] != digit :
	 	ops += sb
	 	sb = ""
	 	ops += input[i+1]
		i++
ops += sb

//List<String> result
//String[] openClose = {{, -}
//int isTurnOpen
int result = 0 
for ops.len:
	if i %2 == 0:
		result += ops[i]
	else :
		if op[i] == - : // 55-50+40-20
			i++
			tmp = 0
			while(open[i] != -):
				if i 짝수 : tmp 에 누적
				if i 가 len-1 : break
				i++
			result -= tmp
			i++

2. 시간 복잡도
25*6

3. 자료구조

 */
import java.util.*;
public class 잃어버린_괄호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		List<StringBuilder> ops = new ArrayList<>(); 
		StringBuilder sb = new StringBuilder();
		
//		for 0, 입력 길이-1 전까지 : 
		for(int i=0; i<input.length(); i++) {
			if(Character.isDigit(input.charAt(i))) {
				sb.append(input.charAt(i));
			}
//			sb += input[i]
			
//			if input[i+1] != digit :
			else {
//			 	ops += sb
				ops.add(sb);
//			 	sb = ""
				sb = new StringBuilder();
//			 	ops += input[i+1]
				ops.add(new StringBuilder(Character.toString(input.charAt(i)))); 
//				i++
			}
		}
//		ops += sb
		ops.add(sb);
		
//		System.out.println(ops.size());
//		for(StringBuilder op : ops) {
//			System.out.print(op + " ");
//		}
//		System.out.println();
		
//		//List<String> result
//		//String[] openClose = {{, -}
//		//int isTurnOpen
		int result = 0;
		for (int i=0; i<ops.size(); i++) {
			if (i %2 == 0) {
				result += Integer.valueOf(ops.get(i).toString());
			}
			else {
				if (ops.get(i).toString().equals("-")) { // 55-50+40-20
//					System.out.printf("ops.get(%d)=-\n", i);
					i++;
					int tmp = 0;
					while(true) {
						if (i%2==0) tmp += Integer.valueOf(ops.get(i).toString());
						if(i== ops.size()-1) break;
						i++;
						if(ops.get(i).equals("-")) {
							i--;
							break;
						}
					}
					result -= tmp;
//					System.out.printf("i=%d, result=%d\n", i, result);
//					i++
					
					
				}
			}
		}
		System.out.println(result);
	}

}
