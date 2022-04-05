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

    private static boolean atPosition(String word, HashMap<Integer, String> atPos) {
        for (int i = 1; i <= 5; i++) {
            String pos = atPos.get(i);
            if (!Objects.equals(pos, "")) {
                if (!Character.toString(word.charAt(i - 1)).equals(pos))
                    return false;
            }
        }
        return true;
    }

    private static boolean notAtPosition(String word, HashMap<Integer, ArrayList<String>> notAtPos) {
        for (int i = 1; i <= 5; i++) {
            int len = 0;
            if (notAtPos.get(i)!=null)
                len = notAtPos.get(i).size();
            if (len > 0) {
                for (String str : notAtPos.get(i)) {
                    if (Objects.equals(str, Character.toString(word.charAt(i-1))))
                        return false;
                }
            }
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

        //TODO -> create a function to eliminate words not present at a certain position.

        //wrd.removeIf(wr -> !wr.startsWith("t") && wr.charAt(1)!='a');

        System.out.println(wrd + "\n" + wrd.size());

        HashMap<Integer, String> atPos = new HashMap<>();

        HashMap<Integer, ArrayList<String>> notAtPos = new HashMap<>();

        for (int i = 1; i <= 5; i++) {
            System.out.println("If you know the letter at position " + i + " enter it, otherwise write (no) :\n");
            String str = in.next();
            if (!Objects.equals(str, "no"))
                atPos.put(i, str);
            else
                atPos.put(i, "");
        }

        wrd.removeIf(wr -> !atPosition(wr, atPos));

        for (int i=1;i<=5;i++){
            System.out.println("If you know letter(s) are not present at "+i+" enter there number and then letters, otherwise type -1 :");
            int len = in.nextInt();

            ArrayList<String> a = new ArrayList<>();
            if (len!=-1){
                System.out.println("Enter the letters :");
                for (int j=0;j<len;j++){
                    String s = in.next();
                    a.add(s);
                }
            }
            notAtPos.put(i, a);
        }

        wrd.removeIf(wr -> !notAtPosition(wr, notAtPos));

        System.out.println(wrd + "\n" + wrd.size());
    }
}