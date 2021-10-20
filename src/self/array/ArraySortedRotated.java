package self.array;

public class ArraySortedRotated {

    static int sortedRotated(int[] arr, int low, int high, int key) {
        int mid = (low + high) / 2;

        if (low > high)
            return -1;

        if (arr[mid] == key)
            return mid;

        if (arr[low] <= arr[mid]) {
            if (arr[low] <= key && arr[mid] >= key)
                return sortedRotated(arr, low, mid - 1, key);
            else
                return sortedRotated(arr, mid + 1, high, key);
        } else {
            if (arr[mid] <= key && arr[high] >= key)
                return sortedRotated(arr, mid + 1, high, key);
            else
                return sortedRotated(arr, low, mid - 1, key);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2, 3};
        System.out.println(sortedRotated(arr, 0, 5, 6));
    }
}