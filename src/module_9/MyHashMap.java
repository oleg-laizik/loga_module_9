package module_9;

public class MyHashMap<K, V> {
    private final int size;
    private Node<K, V>[] buckets;

    public MyHashMap() {
        this.size = 16;
        this.buckets = new Node[size];
    }

    public MyHashMap(int size) {
        this.size = size;
        this.buckets = new Node[size];
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode) % size;

        Node<K, V> newNode = new Node<>(key, value);

        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
            Node<K, V> current = buckets[index];
            Node<K, V> previous = null;

            while (current != null) {
                if (current.getKey().equals(key)) {
                    current.setValue(value);
                    return;
                }
                previous = current;
                current = current.getNext();
            }

            previous.setNext(newNode);
        }
    }

    public V get(K key) {
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode) % size;

        Node<K, V> current = buckets[index];

        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.getValue();
            }
            current = current.getNext();
        }

        return null;
    }

    public void remove(K key) {
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode) % size;

        Node<K, V> current = buckets[index];
        Node<K, V> previous = null;

        while (current != null) {
            if (current.getKey().equals(key)) {
                if (previous == null) {
                    buckets[index] = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                return;
            }
            previous = current;
            current = current.getNext();
        }
    }

    public void clear() {
        this.buckets = new Node[size];
    }

    public int size() {
        int count = 0;
        for (Node<K, V> node : buckets) {
            Node<K, V> current = node;
            while (current != null) {
                count++;
                current = current.getNext();
            }
        }
        return count;
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("one", 1);
        map.put("two", 2);

        System.out.println("Map size: " + map.size());

        map.remove("one");
        System.out.println("Removing: " + map.size());

        map.clear();
        System.out.println("Clearing: " + map.size());

    }
}
