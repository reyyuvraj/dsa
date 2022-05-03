package sheet.sde.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsInAString {

    public String reverseWordsOld(String s) {
        String[] str = s.split(" ");
        ArrayList<String> ar = new ArrayList<>();
        StringBuilder res = new StringBuilder();

        for (String value : str) {
            String tst = value;
            StringBuilder sbr = new StringBuilder(tst);
            while (tst.contains(" ")) {
                int idx = tst.indexOf(' ');
                tst = sbr.deleteCharAt(idx).toString();
            }
            if (tst.length() != 0)
                ar.add(tst);
        }
        Collections.reverse(ar);
        for (String k : ar) {
            res.append(k).append(" ");
        }

        return res.toString().trim();
    }

    public String reverseWords(String s) {
        int left = 0;
        int right = s.length() - 1;

        String temp = "", ans = "";

        while (left <= right) {
            char ch = s.charAt(left);
            if (ch != ' ')
                temp += ch;
            else {
                if (!ans.equals("") && !temp.equals("")) ans = temp + " " + ans;
                else if (!temp.equals("")) ans = temp;
                temp = "";
            }
            left++;
        }

        if (!temp.equals("")) {
            if (!ans.equals("")) ans = temp + " " + ans;
            else ans = temp;
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "  the  sky  is    blue    ";
        System.out.println(new ReverseWordsInAString().reverseWords(s));
    }
}
