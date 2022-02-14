package main.java.problems.arrays;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{0,1,2,2,3,0,4,2}));
    }

    // my solution
    public int myRemoveDuplicates(int[] nums) {
        int[] distinctArr = Arrays.stream(nums).distinct().toArray();
        System.arraycopy(distinctArr, 0, nums, 0, distinctArr.length);
        return distinctArr.length;
    }

    // online solution
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int curIndex = 1;
        int curValue = nums[0];
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (curValue != nums[i]) {
                nums[curIndex] = nums[i];
                curValue = nums[i];
                curIndex++;
                res++;
            }
        }
        return res;
    }
}
