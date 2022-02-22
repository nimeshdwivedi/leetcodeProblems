package main.java.problems.arrays;

import java.util.Arrays;
import java.util.HashMap;

/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2

Constraints:
n == nums.length
1 <= n <= 5 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
 */
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement2(new int[]{3, 2, 3}));
        System.out.println(new MajorityElement().majorityElement2(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    // Using maps, my solution
    // Runtime: 18 ms
    // Memory Usage: 55.3 MB
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int threshold = nums.length / 2;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if(map.get(i) > threshold)
                return i;
        }
        return 0;
    }

    // Another online solution using sorting
    // Runtime: 5 ms
    // Memory Usage: 56.9 MB
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // Fastest solution online
    // Boyer-Moore Majority Vote Algorithm
    // https://www.cs.utexas.edu/~moore/best-ideas/mjrty/
    // target number, in majority, will never have count reach 0 when full array traversed
    // Runtime: 1 ms
    // Memory Usage: 56.9 MB
    public int majorityElement2(int[] nums) {
        int count = 0, target = nums[0];
        for(int i: nums) {
            if(count == 0){
                count++;
                target = i;
            } else if (target == i) {
                count++;
            } else {
                count--;
            }
        }
        return target;
    }
}
