package main.java.problems.arrays;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the frequency of at least one of the chosen numbers is different.
It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []

Constraints:
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
All elements of candidates are distinct.
1 <= target <= 500
 */
public class CombinationSum {

    public static void main(String[] args) {
        List<List<Integer>> lists = new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists.size());
        lists = new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(lists.size());
        lists = new CombinationSum().combinationSum(new int[]{2}, 1);
        System.out.println(lists.size());
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    // Runtime 2ms
    // https://leetcode.com/problems/combination-sum/discuss/1777011/Java-Recursion-4ms-Daily-Challenge-21722
    private void helper(int[] candidates, int target, int startIndex, List<Integer> currentList) {
        // when no target remaining, add the extracted list to results
        if (target == 0)
            // list of items summed upto target, hence added to result
            result.add(currentList);

        // start from last covered index
        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                // add a possible candidate summing up to target
                List<Integer> integerList = new ArrayList<>(currentList);
                integerList.add(candidates[i]);
                // similar check for other candidates with remaining length
                helper(candidates, target - candidates[i], i, integerList);
            }
        }
    }
}
