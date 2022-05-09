package self.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        return combination(digits);
    }

    private List<String> combination(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        generate(digits, 0, map, new StringBuilder(), res);

        return res;
    }

    private List<String> comb(String digits) {
        List<String> ans = new LinkedList<>();
        if (digits.isEmpty())
            return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add(0, "");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            int size = ans.size();     // number of nodes/strings already in the queue
            for (int k = 1; k <= size; k++) {
                String t = ans.remove(0);
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }

    private void generate(String digits, int i, HashMap<Character, String> map, StringBuilder curr, List<String> ans) {
        if (i == digits.length()) {
            ans.add(curr.toString());
            return;
        }

        String str = map.get(digits.charAt(i));
        for (int j = 0; j < str.length(); j++) {
            curr.append(str.charAt(j));
            generate(digits, i + 1, map, curr, ans);
            curr.deleteCharAt(curr.length() - 1);
        }

    }

    public String getString(int digit) {
        return switch (digit) {
            case 2 -> "abc";
            case 3 -> "def";
            case 4 -> "ghi";
            case 5 -> "jkl";
            case 6 -> "mno";
            case 7 -> "pqrs";
            case 8 -> "tuv";
            case 9 -> "wxyz";
            default -> "";
        };
    }

    public static void main(String[] args) {

    }
}
