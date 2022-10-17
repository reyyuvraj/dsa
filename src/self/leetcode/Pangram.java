package self.leetcode;

public class Pangram {
    public boolean checkIfPangram(String sentence) {
        for (int i = 97; i <= 122; i++)
            if (!sentence.contains(Character.toString((char) i)))
                return false;

        return true;
    }
}
