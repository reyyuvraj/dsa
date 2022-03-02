package self.array;

import java.util.Arrays;

public class MergeSortedArray {

    static int[] mergeSortedArray(int[] a, int[] b) {
        int[] merge = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j])
                merge[k++] = a[i++];
            else
                merge[k++] = b[j++];
        }
        return merge;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0, num = 0;

        while (i < m || j < n) {
            if (nums1[i] < nums2[j] && i < m) {
                num = nums2[j];
                if (num<nums1[j]){
                    nums1[k++] = num;
                    i++;
                } else {
                    nums1[k++] = nums1[i++];
                }
            } else {
                num = nums1[i];
                if (num<nums2[j]){
                    nums1[k++] = num;
                    j++;
                } else {
                    nums1[k++] = nums2[j++];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {3, 5, 7, 8};
        System.out.println(Arrays.toString(mergeSortedArray(a, b)));
        int[] c = {1, 2, 3, 0, 0, 0};
        int[] d = {2, 5, 6};
        merge(c, 3, d, 3);
        System.out.println(Arrays.toString(c));
    }
}