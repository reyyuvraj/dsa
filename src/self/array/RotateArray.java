package self.array;

import java.util.Arrays;

public class RotateArray {

    static void rotate(int[] arr){
        int a = arr[arr.length-1];
        for (int i= arr.length-1;i> 0;i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = a;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr);
        System.out.println(Arrays.toString(arr));
    }
}