package self.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;

//https://leetcode.com/problems/split-linked-list-in-parts/submissions/
public class SplitLinkedList {

    private static class ListNode {
        ListNode next;
        int value;
        ListNode(int k){
            value = k;
            this.next = null;
        }
    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode curr = root;
        ListNode[] res = new ListNode[k];
        int n = getLength(root);
        int width = n/k, rem = n%k;

        for (int i=0;i<k;++i){
            ListNode head = new ListNode(0) , write = head;

            for (int j=0;j<width+(i<rem?1:0);++j){
                write = write.next = new ListNode(curr.value);
                if (curr!=null)
                    curr =curr.next;
            }
            res[i] = head.next;
        }
        return res;
    }

    private static int getLength(ListNode root) {
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

        ListNode head = null;

        for (int i= arr.length-1;i>=0;i--)
            head = new ListNode(arr[i]);
        System.out.println(head);

        ListNode[] listNodes = splitListToParts(head, 3);
        System.out.println(Arrays.toString(splitListToParts(head, 3)));
    }
}