package SeungWook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ListQueue<String> queue = new ListQueue<>();

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            if (s[0].equals("push")) {
                queue.enqueue(s[1]);
            } else if (s[0].equals("pop")) {
                if (queue.isEmpry()) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue.dequeue());
                }
            } else if (s[0].equals("size")) {
                System.out.println(queue.size());
            } else if (s[0].equals("empty")) {
                String message = queue.isEmpry() ? "1" : "0";
                System.out.println(message);
            } else if (s[0].equals("front")) {
                if (queue.isEmpry()) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue.front());
                }

            } else if (s[0].equals("back")) {
                if (queue.isEmpry()) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue.back());
                }
            }
        }
    }
}

class ListQueue<V> {
    LinkedList<V> list = new LinkedList<>();
    int size = 0;

    public void enqueue(V v) {
        list.add(v);
        size++;
    }

    public V dequeue() {
        V result = list.get(0);
        list.remove(0);
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpry() {
        return size == 0;
    }

    public V front() {
        return list.get(0);
    }

    public V back() {
        return list.get(size - 1);
    }
}

class LinkedList<V> {
    Node<V> head = null;
    Node<V> tail = null;
    int size = 0;

    class Node<V> {
        Node<V> nextNode;
        V value;

        public Node(V value) {
            this.value = value;
        }

        public void setNextNode(Node<V> node) {
            this.nextNode = node;
        }

        public Node<V> nextNode() {
            return nextNode;
        }
    }

    public void add(V value) {
        Node<V> node = new Node<V>(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNextNode(node);
            tail = node;
        }
        size++;
    }

    Node<V> search(int index) {
        if (head == null) {
            System.out.println(index + " outofrange");
            return null;
        }

        int i = 0;
        Node<V> currentNode = head;
        while (i != index) {
            currentNode = currentNode.nextNode();
            i++;
        }
        return currentNode;
    }

    public V get(int index) {
        Node<V> node = search(index);
        return node.value;
    }

    public void remove(int index) {
        if (size == 0) {
            return;
        }

        if (index == 0) {
            head = head.nextNode();
            if (size == 1) {
                tail = null;
            }
        } else {
            Node<V> prevNode = search(index - 1);
            Node<V> currentNode = search(index - 1).nextNode();
            prevNode.setNextNode(currentNode.nextNode());
            if (index == size - 1) {
                tail = prevNode;
            }
        }
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
