package self.leetcode;

import java.util.*;
public class CheckAscendingNumbersInAString {

    public static boolean areNumbersAscending(String s) {
        ArrayList<Integer> a = new ArrayList<>();

        numbersInString(a, s);

        System.out.println(a);

        for (int i=1;i<a.size();i++){
            if(a.get(i)<=a.get(i-1))
                return false;
        }

        return true;
    }

    private static void numbersInString(ArrayList<Integer> a, String s){
        String[] array = s.split(" ");

        for (String value : array) {
            if (value.charAt(0) >= '0' && value.charAt(0) <= '9')
                a.add(Integer.parseInt(value));
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(areNumbersAscending(s));
    }
}
