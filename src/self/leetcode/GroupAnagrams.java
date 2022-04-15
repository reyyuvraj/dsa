package self.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] str) {
        if (str.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>();

        for (String s : str) {
            char[] arr = new char[26];
            for (char c : s.toCharArray()) arr[c - 'a']++;
            String k = String.valueOf(arr);
            if (!hm.containsKey(k)) hm.put(k, new ArrayList<>());
            hm.get(k).add(s);
        }
        return new ArrayList<>(hm.values());
    }

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(str));
    }
}
