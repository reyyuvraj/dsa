package self.leetcode;

public class StrongPasswordChecker {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8)
            return false;
        int lowerCase = 0, upperCase = 0, digitCount = 0, specialCharacter = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (i > 0) {
                if (ch == password.charAt(i - 1))
                    return false;
            }
            if (ch >= 'a' && ch <= 'z')
                lowerCase++;
            if (ch >= 'A' && ch <= 'Z')
                upperCase++;
            if (ch >= '0' && ch <= '9')
                digitCount++;
            if (ch == '!' || ch == '@' || ch == '#' || ch == '$' || ch == '%' || ch == '^'
                    || ch == '&' || ch == '*' || ch == '(' || ch == ')' || ch == '-' || ch == '+')
                specialCharacter++;
        }
        return lowerCase > 0 && upperCase > 0 && digitCount > 0 && specialCharacter > 0;
    }

    public static void main(String[] args) {
        String str = "+Aa1a1a1";
        System.out.println(new StrongPasswordChecker().strongPasswordCheckerII(str));
    }
}
