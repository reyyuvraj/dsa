package self.codeforces;

import java.util.*;

public class LittleGirlGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int odd = 0;
        int[] occur = new int[26];

        for (int i = 0; i < str.length(); i++) {
            occur[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (occur[i] % 2 == 1)
                odd += 1;
        }

        if (odd <= 1 || odd % 2 == 1)
            System.out.println("First");
        else System.out.println("Second");
    }
}