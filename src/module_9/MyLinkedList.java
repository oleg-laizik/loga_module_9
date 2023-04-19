package module_9;

public class MyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        Node<T> nodeToRemove = getNode(index);

        if (nodeToRemove == head) {
            head = nodeToRemove.next;
        } else if (nodeToRemove == tail) {
            tail = nodeToRemove.prev;
        }

        if (nodeToRemove.prev != null) {
            nodeToRemove.prev.next = nodeToRemove.next;
        }

        if (nodeToRemove.next != null) {
            nodeToRemove.next.prev = nodeToRemove.prev;
        }

        size--;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        Node<T> node = getNode(index);
        return node.data;
    }

    private Node<T> getNode(int index) {
        Node<T> currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }
    public static void main(String[] args) {
        MyLinkedList<String> liststr = new MyLinkedList<>();
        MyLinkedList<Integer> listint = new MyLinkedList<>();
        System.out.println(liststr);
        System.out.println(listint);
    }

}
