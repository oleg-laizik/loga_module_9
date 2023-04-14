package module_9;

public class MyQueue<E> {

    private E[] elements;
    private int first;
    private int last;

    public MyQueue() {
        elements = (E[]) new Object[10];
        first = -1;
        last = -1;
    }

    public void add(E element) {
        if (last == -1) {
            first = 0;
            last = 0;
        } else {
            last++;
        }

        if (last >= elements.length) {
            E[] newElements = (E[]) new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }

        elements[last] = element;
    }

    public void clear() {
        elements = (E[]) new Object[10];
        first = -1;
        last = -1;
    }

    public int size() {
        if (first == -1 && last == -1) {
            return 0;
        }
        return last - first + 1;
    }

    public E peek() {
        if (first == -1 && last == -1) {
            return null;
        }
        return elements[first];
    }

    public E poll() {
        if (first == -1 && last == -1) {
            return null;
        }

        E element = elements[first];

        if (first == last) {
            first = -1;
            last = -1;
        } else {
            first++;
        }

        return element;
    }
    public static void main(String[] args) {
        MyQueue liststr = new MyQueue();
        MyQueue listint = new MyQueue();
        System.out.println(liststr);
        System.out.println(listint);
    }
}
