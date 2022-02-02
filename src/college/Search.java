package college;

public class Search {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int find = 7;
        System.out.println("Linear Search - " + "Position of " + find + " is " + linearSearch(arr, find));
        System.out.println("Binary Search - " + "Position of " + find + " is " + binarySearch(arr, find, 0, arr.length - 1));
    }

    private static int linearSearch(int[] arr, int find) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == find)
                return i + 1;
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int find, int start, int end) {
        int mid = arr[(start + end) / 2];

        if (mid == find)
            return start + 1;

        if (mid > find)
            return binarySearch(arr, find, start, (start + end) / 2 - 1);
        else
            return binarySearch(arr, find, (start + end) / 2 + 1, end);
    }
}
