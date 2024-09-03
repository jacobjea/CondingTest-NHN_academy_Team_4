package SeungWook;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class 스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.contains(" ")) {
                String[] command = s.split(" ");
                stack.push(Integer.parseInt(command[1]));
            } else if (s.equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                }
                else{
                    System.out.println(stack.top());
                }
            } else if (s.equals("size")) {
                System.out.println(stack.size());
            } else if (s.equals("empty")) {
                String message = stack.isEmpty() ? "1" : "0";
                System.out.println(message);
            } else if (s.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                }
                else{
                    System.out.println(stack.pop());
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
        list = (E[]) new Object[100000];
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
