package self.codeforces;

import java.util.*;

public class Lecture {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        HashMap<String, String> words = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String first = in.next();
            String second = in.next();
            words.put(first, second);
        }

        String[] lecture = new String[n];
        StringBuilder notes = new StringBuilder();

        for (int i = 0; i < n; i++) {
            lecture[i] = in.next();
            if (lecture[i].length() <= words.get(lecture[i]).length()) {
                notes.append(lecture[i]).append(" ");
            } else {
                notes.append(words.get(lecture[i])).append(" ");
            }
        }
        System.out.println(notes);
    }
}
