package main.java.problems.arrays;

import java.util.HashMap;

/*
Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i < j < nums.length
|nums[i] - nums[j]| == k
Notice that |val| denotes the absolute value of val.

Example 1:
Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.

Example 2:
Input: nums = [1,2,3,4,5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

Example 3:
Input: nums = [1,3,1,5,4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).

Constraints:
1 <= nums.length <= 10^4
-10^7 <= nums[i] <= 10^7
0 <= k <= 10^7
 */
public class KDiffPairsInArray {

    public static void main(String[] args) {
        System.out.println(new KDiffPairsInArray().findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(new KDiffPairsInArray().findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(new KDiffPairsInArray().findPairs(new int[]{1, 3, 1, 5, 4}, 0));
        System.out.println(new KDiffPairsInArray().findPairs(new int[]{1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, 3));
    }

    //my logic failed for last case, 1,2,4,4,3,3,0,9,2,3 where 0 was messing up
    public int myFindPairs(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int diff = Math.abs(i - k);
            if (map.containsKey(diff)) {
                count++;
            }
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return count;
    }

    public int findPairs(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        for (int i : map.keySet())
            if ((k == 0 && map.get(i) > 1) || (k>0 && map.containsKey(i+k)))
                count++;

        return count;
    }

}
