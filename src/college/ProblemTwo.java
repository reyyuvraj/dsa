package college;

import java.util.*;

public class ProblemTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.next();
        String output_vowel = "", output_consonant = "";

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u') {
                output_vowel += input.charAt(i);
            } else {
                output_consonant += input.charAt(i);
            }
        }

        output_vowel = sortString(output_vowel);
        output_consonant = sortString(output_consonant);

        if (output_vowel.length()==0 && output_consonant.length()!=0){
            System.out.println("NA-1"+ output_consonant + (input.lastIndexOf(output_consonant.charAt(output_consonant.length()-1))));
        } else if (output_vowel.length()!=0 && output_consonant.length()==0){
            System.out.println(output_vowel + input.indexOf(output_vowel.charAt(0)) +"NA-1");
        } else {
            System.out.println(output_vowel + input.indexOf(output_vowel.charAt(0)) + output_consonant + (input.lastIndexOf(output_consonant.charAt(output_consonant.length()-1))));
        }
    }

    static String sortString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
}