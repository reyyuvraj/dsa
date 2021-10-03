package self.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;

public class SplitLinkedList {

    private static class Node {
        Node next;
        int value;
        Node(int k, Node next){
            value = k;
            this.next = next;
        }
    }

    public static Node[] splitListToParts(Node root, int k) {
        Node[] res = new Node[k];
        if (k == 1) {
            res[0] = root;
            return res;
        }
        int n = getLength(root);
        Node pre = null;
        for (int i = 0; i < k; i++) {
            res[i] = root;
            int j = n / k + (i < n % k ? 1 : 0);
            while (root != null && j > 0) {
                pre = root;
                root = root.next;
                j--;
            }
            if (pre != null) pre.next = null;
        }
        return res;
    }

    private static int getLength(Node root) {
        int len = 0;
        while (root != null) {
            len++;
            root = root.next;
        }
        return len;
    }

    public static void main(String[] args){

        int[] arr = {1,2,3,4,5,6};

        LinkedList<Integer> ll = new LinkedList<>();

        Node head = null;

        for (int i= arr.length-1;i>=0;i--)
            head = new Node(arr[i], head);
        System.out.println(head);

        Node[] nodes = splitListToParts(head, 3);
        System.out.println(Arrays.toString(splitListToParts(head, 3)));
    }
}