package self.leetcode;

public class CheckNumberHasEqualDigitCount {
    public boolean digitCount(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (((int) num.charAt(i)) != countOccurrence(num, i) + 48)
                return false;
        }
        return true;
    }

    private int countOccurrence(String num, int digit) {
        char ch = (char) (digit + 48);
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            if (ch == num.charAt(i))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String num = "111";
        System.out.println(new CheckNumberHasEqualDigitCount().digitCount(num));
    }
}
