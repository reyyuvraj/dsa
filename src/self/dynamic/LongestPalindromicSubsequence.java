package self.dynamic;

public class LongestPalindromicSubsequence {

    public static void main(String[] args){
        String s = "bbabcbcab";
        StringBuffer sbr = new StringBuffer(s);
        String t = sbr.reverse().toString();
        System.out.println(LongestCommonSubsequence.longestCommonSubsequence(s, t));
    }
}
