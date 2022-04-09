package self.leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int max = 0;

        for (int i=0, j=0;i<s.length();i++){
            if (hm.containsKey(s.charAt(i)))
                j = Math.max(j, hm.get(s.charAt(i))+1);
            hm.put(s.charAt(i), i);
            max = Math.max(max, i-j+1);
        }
        return max;
    }

    public static void main(String[] args){
        String s = "abcabcbb";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
    }
}
