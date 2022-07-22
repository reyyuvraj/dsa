package college.place;

import java.util.HashMap;

public class MinimumXOR {


}

class treasureHunt {
    static final int INT_SIZE = 32;

    // A Trie Node
    static class TrieNode {
        int value; // used in leaf node
        TrieNode[] Child = new TrieNode[2];

        public TrieNode() {
            value = 0;
            Child[0] = null;
            Child[1] = null;
        }
    }

    static TrieNode root;

    // utility function insert new key in trie
    static void insert(int key) {
        TrieNode temp = root;

        // start from the most significant bit, insert all
        // bit of key one-by-one into trie
        for (int i = INT_SIZE - 1; i >= 0; i--) {
            // Find current bit in given prefix
            int current_bit = (key & (1 << i)) >= 1 ? 1 : 0;

            // Add a new Node into trie
            if (temp != null && temp.Child[current_bit] == null)
                temp.Child[current_bit] = new TrieNode();

            temp = temp.Child[current_bit];
        }

        // store value at leafNode
        temp.value = key;
    }

    // Returns minimum XOR value of an integer inserted
    // in Trie and given key.
    static int minXORUtil(int key) {
        TrieNode temp = root;

        for (int i = INT_SIZE - 1; i >= 0; i--) {
            // Find current bit in given prefix
            int current_bit = (key & (1 << i)) >= 1 ? 1 : 0;

            // Traversal Trie, look for prefix that has
            // same bit
            if (temp.Child[current_bit] != null)
                temp = temp.Child[current_bit];

                // if there is no same bit.then looking for
                // opposite bit
            else if (temp.Child[1 - current_bit] != null)
                temp = temp.Child[1 - current_bit];
        }

        // return xor value of minimum bit difference value
        // so we get minimum xor value
        return key ^ temp.value;
    }

    // Returns minimum xor value of pair in arr[0..n-1]
    static int minXOR(int[] arr, int n) {
        int min_xor = Integer.MAX_VALUE; // Initialize result

        // create a True and insert first element in it
        root = new TrieNode();
        insert(arr[0]);

        // Traverse all array element and find minimum xor
        // for every element
        for (int i = 1; i < n; i++) {
            // Find minimum XOR value of current element with
            // previous elements inserted in Trie
            min_xor = Math.min(min_xor, minXORUtil(arr[i]));

            // insert current array value into Trie
            insert(arr[i]);
        }
        return min_xor;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {9, 5, 3};
        int n = arr.length;
        System.out.println(minXOR(arr, n));
    }
}

class GFG {
    static final int INT_SIZE = 32;

    // A Trie Node
    static class TrieNode {
        int value; // used in leaf node
        TrieNode[] Child = new TrieNode[2];

        public TrieNode() {
            value = 0;
            Child[0] = null;
            Child[1] = null;
        }
    }

    static TrieNode root;

    // utility function insert new key in trie
    static void insert(int key) {
        TrieNode temp = root;

        // start from the most significant bit, insert all
        // bit of key one-by-one into trie
        for (int i = INT_SIZE - 1; i >= 0; i--) {
            // Find current bit in given prefix
            int current_bit = (key & (1 << i)) >= 1 ? 1 : 0;

            // Add a new Node into trie
            if (temp != null && temp.Child[current_bit] == null)
                temp.Child[current_bit] = new TrieNode();

            temp = temp.Child[current_bit];
        }

        // store value at leafNode
        temp.value = key;
    }

    // Returns minimum XOR value of an integer inserted
    // in Trie and given key.
    static int minXORUtil(int key) {
        TrieNode temp = root;

        for (int i = INT_SIZE - 1; i >= 0; i--) {
            // Find current bit in given prefix
            int current_bit = (key & (1 << i)) >= 1 ? 1 : 0;

            // Traversal Trie, look for prefix that has
            // same bit
            if (temp.Child[current_bit] != null)
                temp = temp.Child[current_bit];

                // if there is no same bit.then looking for
                // opposite bit
            else if (temp.Child[1 - current_bit] != null)
                temp = temp.Child[1 - current_bit];
        }

        // return xor value of minimum bit difference value
        // so we get minimum xor value
        return key ^ temp.value;
    }

    // Returns minimum xor value of pair in arr[0..n-1]
    static int minXOR(int[] arr, int n) {
        int min_xor = Integer.MAX_VALUE; // Initialize result

        // create a True and insert first element in it
        root = new TrieNode();
        insert(arr[0]);

        // Traverse all array element and find minimum xor
        // for every element
        for (int i = 1; i < n; i++) {
            // Find minimum XOR value of current element with
            // previous elements inserted in Trie
            min_xor = Math.min(min_xor, minXORUtil(arr[i]));

            // insert current array value into Trie
            insert(arr[i]);
        }
        return min_xor;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {9, 5, 3};
        int n = arr.length;
        System.out.println(minXOR(arr, n));
    }
}

class Solution {

    public int minimumXORSum(int[] a, int[] b) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        int n = a.length;

        int[][] dp = new int[n][(1 << n) + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) map.put(i, new HashMap<>());
                int temp = a[i] ^ b[j];
                map.get(i).put((1 << j), temp);

                if (i == 0) dp[i][(1 << j)] = temp;
            }
        }

        for (int i = 0; i < dp.length - 1; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;
                HashMap<Integer, Integer> map2 = map.get(i + 1);
                for (int bitcode : map2.keySet()) {
                    if ((bitcode & j) == 0) {
                        dp[i + 1][bitcode | j] = Math.min(dp[i + 1][bitcode | j], dp[i][j] + map2.get(bitcode));
                    }
                }
            }
        }
        return dp[n - 1][(1 << n) - 1];
    }
}