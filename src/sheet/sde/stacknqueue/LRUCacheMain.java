package sheet.sde.stacknqueue;

import java.util.HashMap;
import java.util.Stack;

public class LRUCacheMain {

    public static void main(String[] args) {
        int i = 1;
        LRUCache lruCache = new LRUCache(2);
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

class LRUCacheStack {//uses stack
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    int capacity;
    HashMap<Integer, Integer> hm;

    public LRUCacheStack(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<>();
    }

    public int get(int key) {
        int recent = hm.getOrDefault(key, -1);
        if (recent == -1) return -1;
        while (!st1.empty() && st1.peek() != recent) {
            st2.push(st1.pop());
        }
        if (!st1.empty()) st1.pop();
        while (!st2.empty()) {
            st1.push(st2.pop());
        }
        st1.push(recent);

        return recent;
    }

    public void put(int key, int value) {
        if (st1.size() != hm.size() || st1.size() == capacity) {
            while (!st1.empty()) {
                st2.push(st1.pop());
            }
            hm.remove(st2.pop());
            while (!st2.empty()) {
                st1.push(st2.pop());
            }
        }
        st1.push(key);
        hm.put(key, value);
    }
}

class LRUCache {

    Node head = new Node(0, 0), tail = new Node(0, 0);
    HashMap<Integer, Node> hm = new HashMap();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (hm.containsKey(key)) {
            Node node = hm.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            remove(hm.get(key));
        }
        if (hm.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        hm.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        hm.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    static class Node {
        Node prev, next;
        int key, value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
