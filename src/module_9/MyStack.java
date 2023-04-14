package module_9;

import java.util.NoSuchElementException;

public class MyStack {

    private Node top;
    private int size;

    public MyStack() {
        top = null;
        size = 0;
    }

    public void push(Object value) {
        Node newNode = new Node(value);
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
            Node current = top;
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

    public Object peek() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        return top.value;
    }

    public Object pop() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        Object value = top.value;
        top = top.next;
        size--;
        return value;
    }

    private class Node {
        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
            this.next = null;
        }

    }
    public static void main(String[] args) {
        MyStack liststr = new MyStack();
        MyStack listint = new MyStack();
        System.out.println(liststr);
        System.out.println(listint);
    }
}