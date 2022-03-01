package main.java.problems.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
find two numbers such that they add up to a specific target number.
Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.

Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:
Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

Constraints:
2 <= numbers.length <= 3 * 10^4
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.
 */
public class Sum2ArrayIsSorted {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Sum2ArrayIsSorted().twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(new Sum2ArrayIsSorted().twoSum(new int[]{2,3,4}, 6)));
        System.out.println(Arrays.toString(new Sum2ArrayIsSorted().twoSum(new int[]{-1,0}, -1)));
    }

    // my solution O(2N) space
    public int[] myTwoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[0] = map.get(target - numbers[i]) + 1;
                result[1] = i + 1;
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }

    // online solution O(N)
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        // taking 2 pointers
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int res = numbers[start] + numbers[end];
            if (res == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            } else if (res > target) {
                end--;
            } else {
                start++;
            }
        }
        return result;
    }
}
