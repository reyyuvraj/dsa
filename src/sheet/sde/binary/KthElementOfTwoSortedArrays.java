package sheet.sde.binary;

public class KthElementOfTwoSortedArrays {

    public long kthElement0(int[] arr1, int[] arr2, int n, int m, int k) {
        int p1 = 0, p2 = 0, counter = 0;
        long answer = 0;

        while (p1 < m && p2 < n) {
            if (counter == k)
                break;
            else if (arr1[p1] < arr2[p2]) {
                answer = arr1[p1];
                ++p1;
            } else {
                answer = arr2[p2];
                ++p2;
            }
            ++counter;
        }

        if (counter != k) {
            if (p1 != m - 1) answer = arr1[k - counter + p1];
            else answer = arr2[k - counter + p2];
        }

        return answer;
    }

    public long kthElement(int[] arr1, int[] arr2, int n, int m, int k) {
        if (m > n) {
            return kthElement(arr2, arr1, m, n, k);
        }

        int low = Math.max(0, k - m), high = Math.min(k, n);

        while (low <= high) {
            int cut1 = (low + high) >> 1;
            int cut2 = k - cut1;
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 10, 10, 25, 40, 54, 79};
        int[] arr2 = {15, 24, 27, 32, 33, 39, 48, 68, 82, 88, 90};
        System.out.println(new KthElementOfTwoSortedArrays().kthElement(arr1, arr2, 7, 11, 15));
    }
}
