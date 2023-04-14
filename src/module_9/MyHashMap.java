package module_9;

public class MyHashMap {
    private int size;
    private Node[] buckets;

    public MyHashMap() {
        this.size = 16;
        this.buckets = new Node[size];
    }

    public MyHashMap(int size) {
        this.size = size;
        this.buckets = new Node[size];
    }

    public void put(Object key, Object value) {
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode) % size;

        Node newNode = new Node(key, value);

        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
            Node current = buckets[index];
            Node previous = null;

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

    public Object get(Object key) {
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode) % size;

        Node current = buckets[index];

        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.getValue();
            }
            current = current.getNext();
        }

        return null;
    }

    public void remove(Object key) {
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode) % size;

        Node current = buckets[index];
        Node previous = null;

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
        for (Node node : buckets) {
            Node current = node;
            while (current != null) {
                count++;
                current = current.getNext();
            }
        }
        return count;
    }

    private static class Node {
        private Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("one", 1);
        map.put("two", 2);

        System.out.println("Map size: " + map.size());


        map.remove("one");
        System.out.println("Remowing:" + map.size());


        map.clear();
        System.out.println("Clearning: " + map.size());
    }
}
