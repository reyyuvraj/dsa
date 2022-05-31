package self.leetcode;

import java.util.HashSet;

public class StringContainsAllBinaryCodes {

    public boolean hasAllCodes(String s, int k) {
        int totalSubstring = (int) Math.pow(2, k), len = s.length();
        if (totalSubstring == len/k) {
            HashSet<String> hashSet = new HashSet<>();
            for (int i = 0; i < len/k; i += k) {
                String temp = s.substring(i, i + k);
                hashSet.add(temp);
            }
            return hashSet.size() == totalSubstring;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "00110110";
        int k = 2;
        System.out.println(new StringContainsAllBinaryCodes().hasAllCodes(s, k));
    }
}
