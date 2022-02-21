package self.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

public class UniqueBinaryString {

    static HashSet<String> hm = new HashSet<>();
    static String s = "";


    public static void main(String[] args) {
        String[] a = {"111", "011", "001"};
        System.out.println(findDifferentBinaryString(a));
        System.out.println(hm);
    }

    public static String findDifferentBinary(String[] arr) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i].charAt(i)) {
                case '0' -> str.append("1");
                case '1' -> str.append("0");
            }
        }
        return str.toString();
    }

    public static String findDifferentBinaryString(String[] nums) {
        ArrayList<String> al = new ArrayList<>();
        Collections.addAll(al, nums);
        int n = nums.length;
        findDifferentBinaryString(n, al, "");
        return s;
    }

    public static void findDifferentBinaryString(int n,ArrayList<String> nums, String str){
        if(n==str.length()){
            if(!nums.contains(str)){
                s=str;
                return;
            }
            return;
        }
        findDifferentBinaryString(n,nums, str+"0");
        findDifferentBinaryString(n,nums, str+"1");
    }
}
