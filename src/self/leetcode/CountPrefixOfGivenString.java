package self.leetcode;

public class CountPrefixOfGivenString {

    public int countPrefixes(String[] words, String s) {
        int count=0, n=words.length;
        for (String word : words) {
            if (s.startsWith(word))
                count++;
        }
        return count;
    }


}
