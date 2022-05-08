package self.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> res =  new ArrayList<>();
        res.add(arrayToList(arr));
        int permutations = factorial(arr.length);

        for(int i=2;i<=permutations;i++){
            nextPermutation(arr);
            res.add(arrayToList(arr));
        }

        return res;
    }

    public List<Integer> arrayToList(int[] arr){
        int n=arr.length;
        List<Integer> res = new ArrayList<>();

        for (int j : arr) res.add(j);

        return res;
    }

    public int factorial(int num){
        if(num==0 || num==1) return 1;

        return num*factorial(num-1);
    }

    //next permutation
    public void nextPermutation(int[] arr) {
        if (arr.length <= 1)
            return;

        int last = arr.length - 2;

        while (last >= 0) {
            if (arr[last] < arr[last + 1]) {
                break;
            }
            last--;
        }

        if (last >= 0) {

            int nextGreater = arr.length - 1;

            for (int i = arr.length - 1; i > last; i--) {
                if (arr[i] > arr[last]) {
                    nextGreater = i;
                    break;
                }
            }
            swap(arr, nextGreater, last);
        }

        reverse(arr, last + 1, arr.length - 1);
    }

    public void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public void reverse(int[] arr, int left, int right) {

        while (left < right) {
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }

    public static void main(String[] args){
        int[] arr = {1,2,3};
        System.out.println(new Permutations().permute(arr));
    }
}
