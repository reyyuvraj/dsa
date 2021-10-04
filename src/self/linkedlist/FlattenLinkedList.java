package self.linkedlist;

public class FlattenLinkedList {

    static Node head;

    static class Node {
        int value;
        Node next;
        Node bottom;
        Node(int value){
            this.value = value;
            next = bottom = null;
        }
    }

    static Node flatten(Node root){
        Node list = null;
        Node right;
        if (root==null || root.next ==null)
            return root;

        root.next = flatten(root.next);

        root = mergeLastTwo(root, root.next);

        return root;
    }

    static Node mergeLastTwo(Node a, Node b){

        Node temp = new Node(0);
        Node res = temp;

        while(a!=null && b!=null){
            if (a.value<b.value){
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            } else {
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }

        if (a!=null) temp.bottom = a;
        else temp.bottom = b;
        return res.bottom;

    }

    static void printList(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.value+" ");
            temp = temp.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args){

    }
}
