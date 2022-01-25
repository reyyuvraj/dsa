package self.codeforces;

import java.util.*;

public class AntonAndCurrency {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();

        System.out.println(exchangeRate(n));
    }

    private static String exchangeRate(String s) {
        String rate = "-1";
        int index = -1;

        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i)-'0';
            if (num % 2 == 0) {
                index=i;
                if ((int)s.charAt(s.length()-1)-'0'>num)
                    break;
            }
        }

        if (index!=-1)
        {
            char[] ch = s.toCharArray();

            char c = ch[index];
            ch[index] = ch[ch.length-1];
            ch[ch.length-1] = c;
            rate = String.copyValueOf(ch);
        }

        return rate;
    }
}