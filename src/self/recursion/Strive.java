package self.recursion;

import java.util.*;

public class Strive {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = 5;

        System.out.println(sum(n));
        System.out.println(factorial(n));

        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

        String palindrome = "ABBA";
        System.out.println(checkPalindrome(palindrome, 0));

    }

    private static int sum(int n) {
        if (n < 0) return 0;
        return n + sum(n - 1);
    }

    private static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }


    private static void reverseArray(int[] arr, int l, int r) {
        if (l >= r) return;
        swap(arr, l, r);
        reverseArray(arr, l + 1, r - 1);
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    private static boolean checkPalindrome(String s, int i){
        if (i>=s.length()/2) return true;
        if (s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
        return checkPalindrome(s, i+1);
    }
}