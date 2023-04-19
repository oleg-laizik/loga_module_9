package module_9;

import java.util.NoSuchElementException;

public class MyStack<T> {

    private Node<T> top;
    private int size;

    public MyStack() {
        top = null;
        size = 0;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            top = top.next;
        } else {
            Node<T> current = top;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        return top.value;
    }

    public T pop() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        T value = top.value;
        top = top.next;
        size--;
        return value;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

    }
    public static void main(String[] args) {
        MyStack<String> liststr = new MyStack<>();
        MyStack<Integer> listint = new MyStack<>();
        System.out.println(liststr);
        System.out.println(listint);
    }
}