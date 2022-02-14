package main.java.problems.arrays;

import java.util.Arrays;

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.
Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105

Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        new RotateArray().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    // my solution, failed for time limit exceeded
    public static void myrotate(int[] nums, int k) {
        int len = nums.length;
        int rotations = k%len;
        while (rotations != 0) {
            int t = nums[len - 1];
            System.arraycopy(nums, 0, nums, 1, len - 1);
            nums[0] = t;
            rotations--;
            System.out.println(Arrays.toString(nums));
        }
    }

// online solution
/*
let a= [1,2,3,4,5,6,7]
k = 3.

we have to first reverse the whole array by swapping first element with the last one and so on..
you will get[7,6,5,4,3,2,1]

reverse the elements from 0 to k-1
reverse the elements 7,6,5
you will get [5,6,7,4,3,2,1]

reverse the elements from k to n-1
reverse the elements 4,3,2,1
you will get[5,6,7,1,2,3,4]
*/
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
