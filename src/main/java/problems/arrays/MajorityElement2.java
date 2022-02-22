package main.java.problems.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:
Input: nums = [3,2,3]
Output: [3]

Example 2:
Input: nums = [1]
Output: [1]

Example 3:
Input: nums = [1,2]
Output: [1,2]

Constraints:
1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
 */
public class MajorityElement2 {

    public static void main(String[] args) {
        System.out.println(new MajorityElement2().majorityElement(new int[]{3, 2, 3}));
        System.out.println(new MajorityElement2().majorityElement(new int[]{1, 1}));
        System.out.println(new MajorityElement2().majorityElement(new int[]{1, 2}));
    }

    // my solution fails for testCases
    public List<Integer> majorityElement1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int count = map.getOrDefault(i, 0);
            if (count >= threshold)
                result.add(i);//add to result and ignore further map addition
            else
                map.put(i, count + 1);
        }
        return result;
    }

    // online solution
    // modified Boyer-Moore Majority Vote Algorithm
    // https://leetcode.com/problems/majority-element-ii/discuss/63520/Boyer-Moore-Majority-Vote-algorithm-and-my-elaboration
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0)
            return res;

        // for n/2 times to appear, max 1 element can be majority
        // for n/3 times to appear, max 2 elements can be majority
        // hence taking 2 elements and their count and proceeding with the general BM Majority Vote Algo
        int num1 = nums[0];
        int num2 = nums[0];// just default value
        int count1 = 0;
        int count2 = 0;

        for (int val : nums) {
            if (val == num1)
                count1++;
            else if (val == num2)
                count2++;
            else if (count1 == 0) {
                num1 = val;
                count1++;
            } else if (count2 == 0) {
                num2 = val;
                count2++;
            } else {//downvote
                count1--;//downvote
                count2--;
            }
        }
        // by now we have possibly found num1 or num2 or both qualifying n/3 votes
        // so checking through the array again for total count, i.e. only upvotes
        count1 = 0;
        count2 = 0;
        for (int val : nums) {
            if (val == num1)
                count1++;
            else if (val == num2)
                count2++;
        }
        if (count1 > nums.length / 3)
            res.add(num1);
        if (count2 > nums.length / 3)
            res.add(num2);
        return res;
    }
}
