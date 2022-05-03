package self.leetcode;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1 = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder(t);

        while (s.contains("#")) {
            int i = sb1.indexOf("#");
            sb1.deleteCharAt(i);
            if (i - 1 >= 0) s = sb1.deleteCharAt(i - 1).toString();
            else s = sb1.toString();
        }

        while (t.contains("#")) {
            int i = sb2.indexOf("#");
            sb2.deleteCharAt(i);
            if (i - 1 >= 0) t = sb2.deleteCharAt(i - 1).toString();
            else t = sb2.toString();
        }

        return s.equals(t);
    }

    public static void main(String[] args) {
        String s = "a##c", t = "#a#c";
        System.out.println(new BackspaceStringCompare().backspaceCompare(s, t));
    }
}
