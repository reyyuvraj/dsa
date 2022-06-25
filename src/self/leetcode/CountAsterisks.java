package self.leetcode;

public class CountAsterisks {

    public int countAsterisks(String s) {
        boolean line = false;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                line = !line;
                continue;
            }
            if (line)
                continue;
            if (s.charAt(i) == '*')
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "l|*e*et|c**o|*de|";
        System.out.println(new CountAsterisks().countAsterisks(str));
    }
}
