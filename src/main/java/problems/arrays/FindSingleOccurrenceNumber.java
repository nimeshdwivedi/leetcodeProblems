package main.java.problems.arrays;

import java.util.HashMap;

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1

Constraints:
1 <= nums.length <= 3 * 10^4
-3 * 104 <= nums[i] <= 3 * 10^4
Each element in the array appears twice except for one element which appears only once.
 */
public class FindSingleOccurrenceNumber {

    public static void main(String[] args) {
        System.out.println(new FindSingleOccurrenceNumber().singleNumber(new int[]{2,2,1}));
        System.out.println(new FindSingleOccurrenceNumber().singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(new FindSingleOccurrenceNumber().singleNumber(new int[]{1}));
    }

    // online solution, bitwise operator, runtime 0ms
    public int singleNumber(int[] nums) {
        int result=0;
        for (int i : nums) {
            result = result ^ i;
        }
        return result;
    }

    // my solution, runtime 16ms
    public int mySingleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            if(map.containsKey(i))
                map.remove(i);
            else {
                map.put(i, 1);
            }
        }
        return map.keySet().stream().findFirst().get();
    }
}
