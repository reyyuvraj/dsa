package college;

public class TreasureHuntArray {

    public void treasureHunt(int n, int[] a, int[] b) {

    }
}

class Solution {
    public int findMaximumXOR(int[] arr) {
        int max=0;
        Trie trie = new Trie();

        for(int num:arr) trie.insert(num);

        for(int num:arr) max = Math.max(max, trie.getMin(num));

        return max;
    }
}

class Node {
    Node links[] = new Node[2];

    public Node() {
    }
    boolean containsKey(int ind) {
        return (links[ind] != null);
    }
    Node get(int ind) {
        return links[ind];
    }
    void put(int ind, Node node) {
        links[ind] = node;
    }
}

class Trie {
    private static Node root;


    Trie() {
        root = new Node();
    }

    public void insert(int num) {
        Node node = root;
        for(int i = 31;i>=0;i--) {
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    public int getMin(int num) {
        Node node = root;
        int maxNum = 0;
        for(int i = 31;i>=0;i--) {
            int bit = (num >> i) & 1;
            if(!(node.containsKey(1 - bit))) {
                maxNum = maxNum | (1<<i);
                node = node.get( 1 - bit);
            }
            else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}