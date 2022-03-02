package self.leetcode;

public class FindDuplicate {

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

    public static void main(String[] args){
        int[] arr = {1,3,4,2,2};
        System.out.println(findDuplicate(arr));
    }
}
