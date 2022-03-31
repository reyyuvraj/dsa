package self.leetcode;

public class WordsWithGivenPrefix {

    public int prefixCount(String[] words, String pref) {
        int count = 0;

        for (String word : words) {
            if (word.startsWith(pref))
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        String[] words = {"pay", "attention", "practice", "attend"};
        String pref = "at";
        System.out.println(new WordsWithGivenPrefix().prefixCount(words, pref));
    }
}
