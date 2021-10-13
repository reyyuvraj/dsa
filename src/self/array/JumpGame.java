package self.array;

import java.util.Scanner;
public class JumpGame {

    static boolean jumpGame(int[] nums){
        int pos=0;
        for (int i=0;i< nums.length;){
            if (i == nums.length-1)
                return true;
            if (nums.length!=1 && nums[i]==0)
                return false;
            if (nums[i]==0)
                return false;
            pos += nums[i];
            if (pos< nums.length)
                return false;
            else
                i=pos;
        }
        return false;
    }

    public static void main(String[] args){
        int[] arr = {2,3,1,1,4};
        System.out.println(jumpGame(arr));
        arr = new int[]{0};
        System.out.println(jumpGame(arr));
        arr= new int[]{0,1};
        System.out.println(jumpGame(arr));
        arr = new int[]{1,2,0};
        System.out.println(jumpGame(arr));
        arr = new int[]{2,1,3,0,4,3};
        System.out.println(jumpGame(arr));
        arr = new int[]{2,1,0};
        System.out.println(jumpGame(arr));
        arr = new int[]{2,1,2,1,3,0,2,1};
        System.out.println(jumpGame(arr));


    }
}