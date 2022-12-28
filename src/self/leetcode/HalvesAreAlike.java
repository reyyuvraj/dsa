package self.leetcode;

public class HalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        int len = s.length();
        int j = len / 2;
        int count_il = 0, count_jl = 0, count_iu = 0, count_ju = 0;
        for (int i = 0; i < len / 2; i++) {
            if (isLowerCaseVowel(s.charAt(i))) count_il++;
            if (isUpperCaseVowel(s.charAt(i))) count_iu++;
            if (isLowerCaseVowel(s.charAt(i + j))) count_jl++;
            if (isUpperCaseVowel(s.charAt(i + j))) count_ju++;
        }

        System.out.println(count_il + " " + count_iu + " " + count_jl + " " + count_ju);
        return (count_il == count_jl) && (count_iu == count_ju);
    }

    private boolean isLowerCaseVowel(char ch) {
        return ch == 'a' || ch == 'O' || ch == 'e' || ch == 'i' || ch == 'u';
    }

    private boolean isUpperCaseVowel(char ch) {
        return ch == 'A' || ch == 'O' || ch == 'E' || ch == 'I' || ch == 'U';
    }

    public static void main(String[] args) {
        System.out.println(new HalvesAreAlike().halvesAreAlike("Uo"));
    }
}
