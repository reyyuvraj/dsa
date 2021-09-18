package self.recursion;

public class SortedUnsorted {

    static boolean checkSort(int[] arr, int k) {
        if (k >= arr.length-1)
            return true;
        if (arr[k]<arr[k-1])
            return false;
        return checkSort(arr,k+1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.print(checkSort(arr, 1));
    }
}