package main.java.problems.arrays;

/*
Given a binary array nums, return the maximum number of consecutive 1's in the array.
Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3

Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 2

Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.
 */
public class MaxConsecutive1sInArray {

    public static void main(String[] args) {
        System.out.println(new MaxConsecutive1sInArray().findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max =0, k=0;
        for (int num : nums) {
            if (num == 1)
                k++;
            else {
                if (k > max)
                    max = k;
                k = 0;
            }
        }
        if(k > max)
            max = k;
        return max;
    }
}
