package main.java.algorithms;

/*
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

Constraints:
1 <= nums.length <= 10^4
-10^4 < nums[i], target < 10^4
All the integers in nums are unique.
nums is sorted in ascending order.
 */
public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 1 && target == nums[0])
            return 0;

        return searchArr(nums, target, 0, nums.length - 1);
    }

    public int searchArr(int[] nums, int target, int startIndex, int endIndex) {
        if (startIndex == endIndex)
            return nums[startIndex] == target ? startIndex : -1;

        if(startIndex > endIndex)
            return -1;

        int index = startIndex + (endIndex - startIndex) / 2;
        if (nums[index] == target)
            return index;
        else if (nums[index] < target)
            return searchArr(nums, target, index + 1, endIndex);
        else
            return searchArr(nums, target, startIndex, index - 1);
    }
}
