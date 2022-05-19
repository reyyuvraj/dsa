package sheet.sde.binary;

public class SingleElementInSortedArray {

    public int singleNonDuplicate(int[] arr) {
        int n = arr.length, low = 0, high = n / 2;
        while (low < high) {
            int m = (low + high) / 2;
            if (arr[2 * m] != arr[2 * m + 1]) high = m;
            else low = m + 1;
        }

        return arr[2 * low];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(new SingleElementInSortedArray().singleNonDuplicate(arr));
    }
}
