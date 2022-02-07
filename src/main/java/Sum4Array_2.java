package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Given an array nums of n integers, return an array of all the unique quadruplets
[nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

Constraints:
1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
 */
public class Sum4Array_2 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = new Sum4Array_2().fourSum(nums, 0);
        System.out.println(lists.size());
    }

    // https://leetcode.com/problems/4sum/discuss/1741754/Java-4Sum-Solution-oror-Java-oror-Two-pointer
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < len - 3; i++) {
            // skipping duplicate elements already covered
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i; j < len - 2; j++) {
                // skipping duplicate elements already covered
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                // implementing modified 2Sum Problem solution
                int start = j + 1, end = len - 1;
                // fetching remaining target for 2S problem
                int remainingTarget = target - (nums[i] + nums[j]);
                while (start < end) {
                    if (remainingTarget == nums[start] + nums[end]) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        // ignoring duplicate elements until distinct found
                        while (start < end && nums[start] == nums[start + 1])
                            start++;
                        while (start < end && nums[end] == nums[end - 1])
                            end--;
                    } else if (remainingTarget < nums[start] + nums[end]){
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return lists;
    }
}
