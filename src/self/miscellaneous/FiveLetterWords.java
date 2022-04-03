package self.miscellaneous;

import java.io.*;
import java.util.*;

public class FiveLetterWords {

    public static void getWords(String s, ArrayList<String> wrd) {
        s = s.trim();
        wrd.add(s);
    }

    private static boolean doesNotContain(String word, ArrayList<String> notContain) {
        for (String nct : notContain) {
            if (word.contains(nct))
                return true;
        }
        return false;
    }

    private static boolean doesContain(String word, ArrayList<String> contains) {
        for (String cn : contains) {
            if (!word.contains(cn))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\reyyu\\Documents\\FiveLetterWords.txt");// Note: Double back-quote is to avoid compiler interpret words like \test as \t (that is. as an escape sequence)

        BufferedReader br = new BufferedReader(new FileReader(file));
        Scanner in = new Scanner(System.in);

        String st;
        ArrayList<String> wrd = new ArrayList<>();
        ArrayList<String> contains = new ArrayList<>();
        ArrayList<String> notContain = new ArrayList<>();

        while ((st = br.readLine()) != null) {
            getWords(st, wrd);
        }

        System.out.println("Enter the number of letters not in the word : ");
        int size_of_not = in.nextInt();
        String[] notThere = new String[size_of_not];

        for (int i = 0; i < size_of_not; i++) {
            notThere[i] = in.next();
            notContain.add(notThere[i]);
        }

        wrd.removeIf(wr -> doesNotContain(wr, notContain));

        System.out.println("\n" + "Enter number of letters present definitely present in the word");
        int size_of_definite = in.nextInt();

        for (int i = 0; i < size_of_definite; i++) {
            String k = in.next();
            contains.add(k);
        }

        wrd.removeIf(wr -> !doesContain(wr, contains));

        System.out.println(wrd + "\n" + wrd.size());

        //TODO -> create a function to eliminate words not present at a certain position.
        //TODO -> create a function if it does not have a word present at a certain position.

        HashMap<Integer, String> atPos = new HashMap<>();
        HashMap<Integer, ArrayList<String>> notAtPos = new HashMap<>();
    }
}