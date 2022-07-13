package sheet.sde.linkedlist;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        StringBuilder str = new StringBuilder();

        while (head!= null) {
            str.append(head.val);
            head = head.next;
        }

        String original = str.toString();
        String reverse = str.reverse().toString();

        System.out.println(original + "\n" + reverse);
        return original.equals(reverse);
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);
        System.out.println(new PalindromeLinkedList().isPalindrome(listNode));
    }
}
