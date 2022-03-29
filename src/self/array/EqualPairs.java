package self.array;

public class EqualPairs {

    public static boolean divideArray(int[] arr) {
        boolean[] toBit = new boolean[501];

        for (int num : arr) {
            toBit[num] ^= true;
        }

        for (boolean odd : toBit) {
            if (odd) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 4, 1, 2};
        int[] c = {9,9,19,10,9,12,2,12,3,3,11,5,8,4,13,6,2,11,9,19,11,15,9,17,15,12,5,14,12,16,18,16,10,3,8,9,16,20,2,4,16,12,11,14,20,16,2,18,17,20,3,13,16,17,1,1,11,20,20,4};
        System.out.println(divideArray(arr));
    }
}
