package SeungWook;

import java.util.Scanner;

public class 설탕_배달 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int count = 0;
        while (n >= 0) {
            //매 루프 5로 나누어 떨어지는지 확인
            if (n % 5 == 0) {
                count +=  (n / 5);
                System.out.println(count);
                return;
            }
            n -= 3;
            count++;
        }
        System.out.println(-1);
    }
}
