package sheet.sde.binary;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        int n1 = arr1.length, n2 = arr2.length, count = 0, mid = (n1 + n2) / 2;
        boolean even = ((n1 + n2) & 1) == 1;
        double res = 0;

        return median(arr1, arr2);
    }

    private double median(int[] arr1, int[] arr2) {
        if (arr2.length > arr1.length)
            return median(arr2, arr1);

        int p1 = 0, p2 = 0, count = 0;
        int n1 = arr1.length, n2 = arr2.length, mid = (n1 + n2) / 2;
        boolean even = ((n1 + n2) & 1) == 0;
        double res = 0;

        while ((p1 < n1 || p2 < n2) && count <= mid) {
            if (arr1[p1] >= arr2[p2]) {
                p2++;
                if (p1 + p2 == mid)
                    res = arr2[p2];
            } else {
                p1++;
                if (p1 + p2 == mid)
                    res = arr1[p1];
            }
            count++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3};
        int[] arr2 = {2};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(arr1, arr2));
    }
}
