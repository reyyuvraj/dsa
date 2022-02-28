package self.leetcode;

public class NextPermutation {

    public static void reverse(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static boolean findNextPermutation(int[] arr) {

        if (arr.length <= 1)
            return false;

        int last = arr.length - 2;

        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};

    }
}
