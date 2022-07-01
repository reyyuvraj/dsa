package self.leetcode;

import java.util.Arrays;

public class MaximumUnitsOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int res = 0;

        for (int[] box: boxTypes) {
            if (truckSize>=box[0]){
                res += box[0]*box[1];
                truckSize -= box[0];
            } else {
                res += truckSize * box[1];
                return res;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 2}, {3, 1}};
        System.out.println(new MaximumUnitsOnTruckKln().maximumUnits(arr, 4));
    }
}
