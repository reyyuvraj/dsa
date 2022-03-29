package self.array;

public class MaximizeSubsequences {

    public static long countSubsequence(String str, String pattern) {
        char first = str.charAt(0);
        char second = str.charAt(1);
        long count = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            if (first == str.charAt(i)) {
                for (int j = i + 1; j < str.length(); j++) {
                    if (second == str.charAt(j))
                        count++;
                }
            }
        }
        return count;
    }

    public long maximumSubsequenceCount(String text, String pattern) {
        return 0;
    }

    public static void main(String[] args) {
        String str = "aabb", pattern = "ab";
        System.out.println(countSubsequence(str, pattern));
    }
}
