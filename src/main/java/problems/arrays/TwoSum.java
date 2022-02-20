package main.java.problems.arrays;

import java.util.Arrays;
import java.util.HashMap;

/*
Given an array of integers nums and an integer target, return indices of the two numbers
such that they add up to target.

Assume that each input would have exactly one solution,and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:

2 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
Only one valid answer exists.

Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("-----");
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println("-----");
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3, 3}, 6)));
    }

    // my solution
    // Runtime: 3 ms
    //Memory Usage: 45.9 MB
    public int[] myTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else
                map.put(nums[i], i);
        }
        return new int[]{};
    }

    // online solution
    //Runtime: 0 ms
    //Memory Usage: 44.3 MB
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;

        for (int i = 1; i < length; i++) {
            for (int j = i; j < length; j++) {
                System.out.println("i " + i + ",j " + j + ", nums[j]: " + nums[j] + ", nums[j-i]: " + nums[j - i]);
                if (nums[j] + nums[j - i] == target)
                    return new int[]{j, j - i};
            }
        }
        return null;
    }
}
