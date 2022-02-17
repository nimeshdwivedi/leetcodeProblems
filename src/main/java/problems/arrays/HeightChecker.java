package main.java.problems.arrays;

import java.util.Arrays;

/*
A school is trying to take an annual photo of all the students. The students are asked to stand in a
single file line in non-decreasing order by height. Let this ordering be represented by the integer
array expected where expected[i] is the expected height of the ith student in line.
You are given an integer array heights representing the current order that the students are standing in.
Each heights[i] is the height of the ith student in line (0-indexed).

Return the number of indices where heights[i] != expected[i].

Example 1:
Input: heights = [1,1,4,2,1,3]
Output: 3
Explanation:
heights:  [1,1,4,2,1,3]
expected: [1,1,1,2,3,4]
Indices 2, 4, and 5 do not match.

Example 2:
Input: heights = [5,1,2,3,4]
Output: 5
Explanation:
heights:  [5,1,2,3,4]
expected: [1,2,3,4,5]
All indices do not match.

Example 3:
Input: heights = [1,2,3,4,5]
Output: 0
Explanation:
heights:  [1,2,3,4,5]
expected: [1,2,3,4,5]
All indices match.

Constraints:
1 <= heights.length <= 100
1 <= heights[i] <= 100
 */
public class HeightChecker {

    public static void main(String[] args) {
        System.out.println(new HeightChecker().heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
        System.out.println(new HeightChecker().heightChecker(new int[]{5, 1, 2, 3, 4}));
        System.out.println(new HeightChecker().heightChecker(new int[]{1, 2, 3, 4, 5}));
    }

    // My solution
    public int myHeightChecker(int[] heights) {
        if (heights.length <= 1)
            return 0;

        int[] sortedHeights = heights.clone();// Runtime: 2 ms, Memory Usage: 42.3 MB
        //int[] sortedHeights = Arrays.copyOf(heights, heights.length); // Runtime: 3 ms, Memory Usage: 41.7 MB
        Arrays.sort(sortedHeights);
        int count = 0;
        for (int i = 0; i < heights.length; i++)
            if (sortedHeights[i] != heights[i])
                count++;
        return count;
    }

    // online solution Runtime: 1 ms, Memory Usage: 42.5 MB
    public int heightChecker(int[] heights) {
        int count = 0;
        int[] heightCounts = new int[101];
        for (int j : heights) heightCounts[j] += 1;

        for (int i = 0, height = 1; height < 101; height++) {
            while (heightCounts[height] > 0) {
                if (heights[i++] != height)
                    count++;
                heightCounts[height]-=1;
            }
        }
        return count;
    }
}
