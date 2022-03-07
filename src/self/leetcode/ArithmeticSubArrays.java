package self.leetcode;

public class ArithmeticSubArrays {

    public static int numberOfArithmeticSlices(int[] arr) {
        int slices = 0;
        for (int i = 2, prev = 0; i < arr.length; i++)
            slices += (arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) ?
                    ++prev :
                    (prev = 0);
        return slices;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        System.out.println(numberOfArithmeticSlices(arr));
    }
}
