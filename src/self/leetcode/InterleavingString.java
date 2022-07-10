package self.leetcode;

import java.util.Arrays;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if(len1+len2!=len3) return false;

        char[] res = (s1+s2).toCharArray();
        char[] rs3 = s3.toCharArray();

        Arrays.sort(res);
        Arrays.sort(rs3);

        return Arrays.equals(res, rs3);
    }
}
