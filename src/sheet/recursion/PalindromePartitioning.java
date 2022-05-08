package sheet.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(0, s, s.length(), new ArrayList<>(), res);

        return res;
    }

    public void helper(int index,
                       String s,
                       int n,
                       List<String> temp,
                       List<List<String>> res) {
        if (index == n) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < n; i++) {
            if (isPalindrome(s, index, i)) {
                temp.add(s.substring(index, i + 1));
                helper(i + 1, s, n, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new PalindromePartitioning().partition(s));
    }
}
