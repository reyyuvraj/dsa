package self.miscellaneous;

class MaximumCountOfOne {
    static int findMaxConsecutiveOnes(int[] nums) {
        int flag = 0, v = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == 0) {
                if (flag > v)
                    v = flag;
                flag = 0;
            } else if (nums[nums.length - 1] == 1 && i == nums.length - 1) {
                ++flag;
                if (flag > v)
                    v = flag;
                flag = 0;
            } else
                flag++;
        return v;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,0,1,0,0,0};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}