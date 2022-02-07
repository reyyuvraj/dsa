package college;

import java.util.*;

public class NumberString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        String[] array1 = s1.split(",");
        String[] array2 = s2.split(",");
        String numberString1 = "", numberString2 = "", ns1 = numberString(s1), ns2 = numberString(s2);
        StringBuilder output1 = new StringBuilder();
        StringBuilder output2 = new StringBuilder();
        String test1 = "", test2 = "";

        for (int i = 0; i < array1.length; i++) {
            test1 = array1[i];
            if (hasDigits(test1)) {
                numberString1 = numberString(test1);
                if (ns2.contains(numberString1)) {
                    output1.append(numberString1).append(",");
                    output2.append(wordsString(test1)).append(",");
                } else {
                    output1.append("NA,");
                    output2.append("NA,");
                }
            }
        }

        System.out.println(output1.substring(0,output1.length()-1) + "\n" + output2.substring(0,output2.length()-1));
    }

    private static boolean hasDigits(String str) {
        int length = str.length();

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                return true;
        }

        return false;
    }

    private static String numberString(String str) {
        StringBuilder numberString = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                numberString.append(str.charAt(i));
        }

        return numberString.toString();
    }

    private static String wordsString(String str) {
        StringBuilder wordsString = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                wordsString.append(str.charAt(i));
        }

        return wordsString.toString();
    }
}