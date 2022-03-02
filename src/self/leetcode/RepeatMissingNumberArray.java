package self.leetcode;

public class RepeatMissingNumberArray {

    public int[] repeatedNumber(final int[] A) {
        int repeated=0, notThere=0;


        repeated = findDuplicate(A);


        return new int[] {repeated, notThere};
    }

    public static int findDuplicate(int[] nums) {
        int n = nums.length;

        for(int i =0;i<n;i++){
            int num = nums[i];
            num = Math.abs(num);
            if(nums[num]>0) nums[num]=-nums[num];
            else return num;
        }
        return -1;
    }
}
