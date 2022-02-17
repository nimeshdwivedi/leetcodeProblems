package main.java.problems.arrays;

import java.util.Arrays;

/*
Given an integer array nums, return the third distinct maximum number in this array.
If the third maximum does not exist, return the maximum number.

Example 1:
Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.

Example 2:
Input: nums = [1,2]
Output: 2
Explanation:
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.

Example 3:
Input: nums = [2,2,3,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.

Constraints:
1 <= nums.length <= 10^4
-2^31 <= nums[i] <= 2^31 - 1
 */
public class ThirdMaximumNumber {

    public static void main(String[] args) {
        System.out.println(new ThirdMaximumNumber().thirdMax(new int[]{1, 2, 2, 5, 3, 5}));
        System.out.println(new ThirdMaximumNumber().thirdMax(new int[]{1, 2, -2147483648}));
        System.out.println(new ThirdMaximumNumber().thirdMax(new int[]{1, -2147483648, -2147483648}));
        System.out.println(new ThirdMaximumNumber().thirdMax(new int[]{3, 2, 2, 2}));
        System.out.println(new ThirdMaximumNumber().thirdMax(new int[]{3, 2, 1}));
        System.out.println(new ThirdMaximumNumber().thirdMax(new int[]{1, 2}));
        System.out.println(new ThirdMaximumNumber().thirdMax(new int[]{2, 2, 3, 1}));
    }

    // my solution, failed testCases
    public int myThirdMax(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        boolean thirdMaxFound = false;
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE;
        for (int i : nums) {
            //System.out.println(i + " " + firstMax + " " + secondMax + " " + thirdMax);
            if (i > firstMax) {
                if (secondMax != Integer.MIN_VALUE)
                    thirdMaxFound = true;
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = i;
            } else if (i > secondMax && i < firstMax) {
                if (secondMax != Integer.MIN_VALUE)
                    thirdMaxFound = true;
                thirdMax = secondMax;
                secondMax = i;
            } else if (i >= thirdMax && i < secondMax) {
                thirdMax = i;
                thirdMaxFound = true;
            }
        }
        return thirdMaxFound ? thirdMax : firstMax;
    }

    // online solution, passed
    public int thirdMax(int[] nums) {
        Integer firstMax = null, secondMax = null, thirdMax = null;
        for (Integer i : nums) {
            if (i.equals(firstMax) || i.equals(secondMax) || i.equals(thirdMax)) continue;
            if (firstMax == null || i > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = i;
            } else if (secondMax == null || i > secondMax) {
                thirdMax = secondMax;
                secondMax = i;
            } else if (thirdMax == null || i > thirdMax) {
                thirdMax = i;
            }
        }
        return (thirdMax == null) ? firstMax : thirdMax;
    }
}
