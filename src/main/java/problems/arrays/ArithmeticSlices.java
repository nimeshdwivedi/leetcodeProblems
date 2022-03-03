package main.java.problems.arrays;

/*
An integer array is called arithmetic if it consists of at least three elements and if the difference
between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.
A subarray is a contiguous subsequence of the array.

Example 1:
Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.

Example 2:
Input: nums = [1]
Output: 0

Constraints:
1 <= nums.length <= 5000
-1000 <= nums[i] <= 1000
 */
public class ArithmeticSlices {

    public static void main(String[] args) {
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(new int[]{1,2,3,4}));
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(new int[]{1}));
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(new int[]{1,2,3,4,6,7,8}));
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(new int[]{1,2,4,5,6}));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3)
            return 0;

        int a=0, b=1, c=2, count=0, previosCount = 0;
        while(c<nums.length){
            if(nums[b]-nums[c] == nums[a]-nums[b]) {
                previosCount++;// if last 3 sets were also Arithmetic Slice, add to it
                count += previosCount;
            } else {
                previosCount = 0;
            }
            a++;b++;c++;
        }
        return count;
    }
}
