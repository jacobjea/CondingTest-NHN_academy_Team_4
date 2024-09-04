package SeungWook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 스택2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");

            if (s[0].equals("1")) {
                stack.push(Integer.parseInt(s[1]));
            }
            else if (s[0].equals("2")) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                }
                else{
                    System.out.println(stack.pop());
                }
            }
            else if (s[0].equals("3")) {
                System.out.println(stack.size());
            }
            else if (s[0].equals("4")) {
                String message = stack.isEmpty() ? "1" : "0";
                System.out.println(message);
            }
            else if (s[0].equals("5")){
                if (stack.isEmpty()) {
                    System.out.println("-1");
                }
                else{
                    System.out.println(stack.top());
                }
            }
        }
    }
}

@SuppressWarnings("unchecked")
class Stack<E> {
    E[] list;
    int index = 0;

    public Stack() {
        list = (E[]) new Object[1000000];
    }

    public void push(E e) {
        list[index++] = e;
    }

    public E pop() {
        return list[--index];
    }

    public int size() {
        return index;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public E top() {
        return list[index - 1];
    }
}
