package module_9;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Object data;
        Node next;
        Node prev;

        public Node(Object data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void add(Object value) {
        Node newNode = new Node(value);

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

        Node nodeToRemove = getNode(index);

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

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        Node node = getNode(index);
        return node.data;
    }

    private Node getNode(int index) {
        Node currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }
    public static void main(String[] args) {
        MyLinkedList liststr = new MyLinkedList();
        MyLinkedList listint = new MyLinkedList();
        System.out.println(liststr);
        System.out.println(listint);
    }

}
