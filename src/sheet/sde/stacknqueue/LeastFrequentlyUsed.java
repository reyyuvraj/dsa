package sheet.sde.stacknqueue;

import java.util.HashMap;

public class LeastFrequentlyUsed {

    public static void main(String[] args) {
        int i = 1;
        LFUCache lruCache = new LFUCache(2);
        lruCache.put(1, 0);
        System.out.println(lruCache.hm + "\t" + (i++));
        lruCache.put(2, 2);
        System.out.println(lruCache.hm + "\t" + (i++));
        lruCache.get(1);
        System.out.println(lruCache.hm + "\t" + (i++));
        lruCache.put(3, 3);
        System.out.println(lruCache.hm + "\t" + (i++));
        lruCache.get(2);
        System.out.println(lruCache.hm + "\t" + (i++));
        lruCache.put(4, 4);
        System.out.println(lruCache.hm + "\t" + (i++));
        lruCache.get(1);
        System.out.println(lruCache.hm + "\t" + (i++));
        lruCache.get(3);
        System.out.println(lruCache.hm + "\t" + (i++));
        lruCache.get(4);
        System.out.println(lruCache.hm + "\t" + (i));
    }

}

class LFUCache {// wrong

    HashMap<Integer, Node> hm;
    int capacity;
    Node head = new Node(0, 0, 0);
    Node tail = new Node(0, 0, 0);

    public LFUCache(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<>();
    }

    public int get(int key) {
        if (hm.containsKey(key)) {
            Node node = hm.get(key);
            ++node.counter;
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        int counter = 1;
        if (hm.containsKey(key)) {
            counter = hm.get(key).counter + 1;
            remove(hm.get(key));
        }
        if (hm.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value, counter));
    }

    private void insert(Node node) {
        hm.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void remove(Node node) {
        hm.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    static class Node {
        int key, value, counter;
        Node next, prev;
        Node(int key, int value, int counter) {
            this.key = key;
            this.value = value;
            this.counter = counter;
        }
    }
}
