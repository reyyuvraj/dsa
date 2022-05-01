package self.leetcode;

public class RemoveDigitFromNumberToMaximiseResult {

    public String removeDigit(String number, char digit) {
        StringBuilder sbr = new StringBuilder(number);
        int indexS = number.indexOf(digit);
        int indexL = number.lastIndexOf(digit);
        int index = indexS, n = number.length();

        if (indexS == indexL)
            return sbr.deleteCharAt(indexS).toString();

        for (int i = indexS; i < n; i++) {
            if (number.charAt(i) == digit) {
                if (i == indexL) {
                    index = i;
                    break;
                }
                if (number.charAt(i + 1) > number.charAt(i)) {
                    index = i;
                    break;
                }
            }
        }

        return sbr.deleteCharAt(index).toString();
    }

    public static void main(String[] args) {
        String str = "3619552534";
        char digit = '5';
        String output = new RemoveDigitFromNumberToMaximiseResult().removeDigit(str, digit);
        System.out.println(output);
    }
}
