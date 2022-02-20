package main.java.problems.arrays;

import java.util.Arrays;

/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */
public class SquareOfSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SquareOfSortedArray().sortedSquares(new int[]{-4,-1,0,3,10})));
        System.out.println(Arrays.toString(new SquareOfSortedArray().sortedSquares(new int[]{-7,-3,2,3,11})));
    }

    // my solution 5 ms
    public int[] mySortedSquares(int[] nums) {
        for(int i=0; i<nums.length; i++){
            nums[i] = (int) Math.pow(nums[i], 2);
        }
        Arrays.sort(nums);
        return nums;
    }

    // 1 ms
    public int[] sortedSquares(int[] nums) {
        int ans[] = new int[nums.length];
        int i = 0 ;
        int j = nums.length-1;
        int index  = nums.length-1;
        while(i <= j){
            int start = nums[i];
            int end = nums[j];
            start = start * start;
            end = end * end;
            if(end > start){
                ans[index--] = end;
                j--;
            }
            else{
                ans[index--] = start;
                i++;
            }
        }
        return ans;
    }
}
