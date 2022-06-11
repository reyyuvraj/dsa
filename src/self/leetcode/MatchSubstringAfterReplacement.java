package self.leetcode;

import java.util.Scanner;

public class MatchSubstringAfterReplacement {

    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        int subLength = sub.length();
        for (int i = 0; i < mappings.length; i++) {
            char chr = mappings[i][0];
            for (int j = 0; j < sub.length(); j++) {
                if (chr == s.charAt(j))
                    sub = sub.substring(0, i) + mappings[i][1] + sub.substring(i + 1);
            }
        }

        char fCh = sub.charAt(0);
        int firstIndex = s.indexOf(fCh);
        int lastIndex = s.lastIndexOf(fCh);

        for (int i = firstIndex; i <= lastIndex; i++) {
            if ((s.substring(i, i + subLength)).equals(sub))
                return true;
        }

        return false;
    }
}
