package self.leetcode;

public class ValidWordsInASentence {

    public int countValidWords(String sentence) {
        String[] s = sentence.split(" ");
        int count = 0;
        for (String value : s) {
            if (isValidWord(value)) {
                if (isValidPunctuation(value) && isValidHyphen(value))
                    count++;
            }
        }
        return count;
    }

    public boolean isValidWord(String str) {
        if (str.length() == 0)
            return false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || ch == '!' || ch == '.' || ch == ','))
                return false;
        }
        return true;
    }

    public boolean isValidPunctuation(String str) {
        int counter = 0, index = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '!' || ch == '.' || ch == ',') {
                counter++;
                index = i;
            }
            if (counter > 1)
                return false;
        }
        return isValidPunctuation(str, index);
    }

    public boolean isValidPunctuation(String str, int index) {
        return index == str.length() - 1;
    }

    public boolean isValidHyphen(String str) {
        int counter = 0, index = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '-') {
                counter++;
                index = i;
            }
            if (counter > 1)
                return false;
        }
        return isValidHyphen(str, index);
    }

    public boolean isValidHyphen(String str, int index) {
        if (index == 0 || index == str.length() - 1)
            return false;
        return (isLetter(str.charAt(index - 1)) && isLetter(str.charAt(index + 1)));
    }

    public boolean isLetter(char ch) {
        return (ch >= 'a' && ch <= 'z');
    }

    public static void main(String[] args) {
        String str = "cat and  dog";
        ValidWordsInASentence v = new ValidWordsInASentence();
        System.out.println(v.countValidWords(str));
    }
}
