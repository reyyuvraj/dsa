package self.miscellaneous;

import java.util.Arrays;

public class SlidingWindow {

    static int maximum(int[] arr, int start, int end) {
        int i = start, j = 0;
        int[] a = new int[end - start + 1];
        while (i <= end) {
            a[j] = arr[i];
            i++;
            j++;
        }
        Arrays.sort(a);
        return a[a.length - 1];
    }

    static void window(int[] arr, int w){
        for (int i=0;i<arr.length-w+1;i++){
            System.out.print(maximum(arr, i, i+w-1)+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1};
        window(arr,1);
    }

}