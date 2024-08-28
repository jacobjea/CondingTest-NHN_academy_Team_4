package SeungWook;

// 각 자리수의 값 구하기
// %10으로 나누면 1의 자리 -> 나머지를 빼준다. 거기에 
// %100으로 나누면 10의 자리 -> 나머지를 빼준다. 거기에 %1000 백의 자리-> 나머지를 빼준다.
// 반복하여 n이 = 이되면 종료한다
public class 셀프_넘버 {
    public static void main(String[] args){
        int max = 10000;
        boolean[] array = new boolean[10001];

        for(int i = 0; i <= max; i++){
            int n = sum(i);
            if (n <= max) {
                array[n] = true;
            }
        }

        for(int i = 0; i < array.length; i++){
            if (array[i] == false) {
                System.out.println(i);
            }
        }
    }

    public static int sum(int n){
        int number = n;
        int sum = 0;
        while (number > 0) {
            int remain = number % 10;
            sum += remain;
            number = (number - remain) / 10;
        }
        return n + sum;
    }
}
