package self.leetcode;

public class FindTheDuplicateNumber {

    public static void main(String[] args){
        int[] arr = {1,2,3,2,4};
        System.out.println(duplicateNumber(arr));
    }

    private static int duplicateNumber(int[] arr){
        int len = arr.length;

        return 0;
    }

    private static int get(int num){
        int res=0;
        for (int i=1;i<=num;i++){
            res ^= i;
        }

        return res;
    }
}
