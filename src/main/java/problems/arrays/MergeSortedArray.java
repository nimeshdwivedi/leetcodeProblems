package main.java.problems.arrays;

import java.util.Arrays;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[6];
        nums1[0] = 4;
        nums1[1] = 5;
        nums1[2] = 6;
        int[] nums2 = new int[]{1, 2, 3};
        new MergeSortedArray().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
        int[] nums3 = new int[6];
        new MergeSortedArray().merge(nums3, 0, nums2, 3);
        System.out.println(Arrays.toString(nums3));
    }

    // Runtime: 1 ms
    // Memory Usage: 43 MB
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;
        if (m == 0) {
            int j = 0, k = 0;
            while (j < n)
                nums1[k++] = nums2[j++];
        } else {
            int[] sortedArray = Arrays.copyOf(nums1, nums1.length);
            int i = 0, j = 0, k = 0;
            while (i < m && j < n) {
                if (sortedArray[i] < nums2[j])
                    nums1[k++] = sortedArray[i++];
                else
                    nums1[k++] = nums2[j++];
            }
            if (i == m)
                while (j < n)
                    nums1[k++] = nums2[j++];
            if (j == n)
                while (i < m)
                    nums1[k++] = sortedArray[i++];
        }

    }
}
