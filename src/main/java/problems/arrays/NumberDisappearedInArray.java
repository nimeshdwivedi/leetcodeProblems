package main.java.problems.arrays;

import java.util.ArrayList;
import java.util.List;

/*
Given an array nums of n integers where nums[i] is in the range [1, n],
return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:
Input: nums = [1,1]
Output: [2]

Constraints:

n == nums.length
1 <= n <= 10^5
1 <= nums[i] <= n
 */
public class NumberDisappearedInArray {

    public static void main(String[] args) {
        List<Integer> disappearedNumbers = new NumberDisappearedInArray().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(disappearedNumbers.toString());
        disappearedNumbers = new NumberDisappearedInArray().findDisappearedNumbers(new int[]{1, 1});
        System.out.println(disappearedNumbers.toString());
    }

    // my solution Runtime: 7 ms
    //Memory Usage: 66.1 MB
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums.length == 1)
            return new ArrayList<>();

        int[] numsCount = new int[nums.length+1];
        for (int num : nums) {
            numsCount[num] = 1;
        }
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i < numsCount.length; i++)
            if (numsCount[i] != 1)
                integerList.add(i);
        return integerList;
    }
}
