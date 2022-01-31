package self.codeforces;

import java.util.*;

public class SuffixStructures {

    private static char[] sort(String str) {
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return ch;
    }

    private static boolean array(String s, String t) {
        return Arrays.equals(sort(s), sort(t));
    }

    private static boolean automaton(String s, String t) {
        int i = 0, j = 0;

        for (i = 0; i < s.length() && j < t.length(); i++)
            j += (s.charAt(i) == t.charAt(j)) ? 1 : 0;

        return j == t.length();
    }

    private static boolean both(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            boolean contains = s.contains(Character.toString(ch));
            if (contains)
                s = s.replaceFirst(Character.toString(ch), " ");
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();

        if (array(s, t))
            System.out.println("array");
        else if (automaton(s, t))
            System.out.println("automaton");
        else if (both(s, t))
            System.out.println("both");
        else
            System.out.println("need tree");
    }
}