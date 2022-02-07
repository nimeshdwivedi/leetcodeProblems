package main.java;

import java.util.HashMap;
import java.util.Map;

/*
Given four integer arrays nums1, nums2, nums3, and nums4 all of length n,
return the number of tuples (i, j, k, l) such that:
0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

Example1:
Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
Output: 2
Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0

Example2:
Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
Output: 1

Constraints:
n == nums1.length
n == nums2.length
n == nums3.length
n == nums4.length
1 <= n <= 200
-228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
 */
public class Sum4Array {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{-2,-1};
        int[] nums3 = new int[]{-1,2};
        int[] nums4 = new int[]{0,2};

        System.out.println(new Sum4Array().fourSumCount(nums1, nums2, nums3, nums4));
    }

    // https://leetcode.com/problems/4sum-ii/discuss/1740606/Going-from-O(N4)-greater-O(N3)-greater-O(N2)-JavaC%2B%2B
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int k : nums3)
            for(int l : nums4) {
                map.put(k + l, map.getOrDefault(k + l, 0) + 1);
            }
        int count = 0;
        for(int i : nums1)
            for(int j : nums2)
                count += map.getOrDefault(-(i + j), 0);
        return count;
    }
}
