package main.java.problems.arrays;

/*
Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4

Constraints:
1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
nums contains distinct values sorted in ascending order.
-10^4 <= target <= 10^4
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 0));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1,3}, 2));
    }

    public int searchInsert(int[] nums, int target) {
        if(target < nums[0])
            return 0;

        return searchPosition(nums, target, 0, nums.length - 1);
    }

    private int searchPosition(int[] nums, int target, int start, int end) {
        if (start == end)
            // if last element is greater or equal then last index, if lesser than end+1
            return nums[end] >= target ? end : end + 1;

        // if start crossed end, means target greater than highest integer in array, hence end+1
        if (start > end)
            return end + 1;

        int mid = start + (end - start) / 2;
        if(nums[mid] == target)
            return mid;
        else if(nums[mid] < target)
            return searchPosition(nums, target, mid+1, end);
        else
            return searchPosition(nums, target, start, mid-1);
    }
}
