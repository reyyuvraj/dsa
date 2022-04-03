package self.leetcode;

import java.util.Arrays;

public class StepsForAnagram {

    public int minSteps(String s, String t) {
        int count = 0;

        int[] sa = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sa[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            sa[t.charAt(i) - 'a']--;
        }

        for (int c : sa) {
            count += Math.abs(c);
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "night", t = "thing";
        System.out.println(new StepsForAnagram().minSteps(s, t));
    }
}
