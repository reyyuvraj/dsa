package sheet.sde.binary;

public class SearchInRotatedSortedArray {

    public int search(int[] arr, int target) {
        return search(arr, 0, arr.length-1, target);
    }

    private int search(int[] arr, int low, int high, int target) {
        int mid = (high + low) / 2;

        if (low > high) return -1;

        if (arr[mid] == target)
            return mid;

        if (arr[low] <= arr[mid]) {
            if (arr[low] <= target && arr[mid] >= target)
                return search(arr, low, mid - 1, target);
            else
                return search(arr, mid + 1, high, target);
        } else {
            if (arr[mid] <= target && arr[high] >= target)
                return search(arr, mid + 1, high, target);
            else
                return search(arr, low, mid - 1, target);
        }
    }

    public static void main(String[] args) {

    }
}
