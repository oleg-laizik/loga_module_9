package module_9;
public class MyArrayList<E> {

    private E[] data;
    private int size;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public void add(E value) {
        if (size == data.length) {
            E[] copy = (E[]) new Object[(size * 3) / 2 + 1];
            System.arraycopy(data, 0, copy, 0, size);
            data = copy;
        }

        data[size] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index - " + index);
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }

        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index - " + index);
        }

        return data[index];
    }

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("!");
        System.out.println("Size : " + list.size());
        System.out.println("Element 3: " + list.get(2));
        list.remove(0);
        System.out.println("Removing: " + list.size());
        list.clear();
        System.out.println("Clearing: " + list.size());
    }
}
