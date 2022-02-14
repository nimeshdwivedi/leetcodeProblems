package main.java.problems.arrays;

import java.util.Arrays;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]

Constraints:
1 <= nums.length <= 10^4
-2^31 <= nums[i] <= 2^31 - 1
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 12};
        int[] arr2 = new int[]{1, 1, 1, 0, 2};
        int[] arr3 = new int[]{1, 2};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
        moveZeroes.moveZeroes(arr2);
        System.out.println(Arrays.toString(arr2));
        moveZeroes.moveZeroes(arr3);
        System.out.println(Arrays.toString(arr3));
    }

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len > 1) {
            int i = 0;
            // checking initial series of zero till 2nd last point
            while (i < len - 1 && nums[i] != 0)
                i++;

            // fillin in the non-zero spots from there onwards
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] != 0) {
                    nums[i++] = nums[j];
                    nums[j] = 0;
                }
            }
        }
    }
}
