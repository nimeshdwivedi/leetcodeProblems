package main.java.problems.arrays;

import java.util.PriorityQueue;
import java.util.TreeSet;

/*
You are given an array nums of n positive integers.
You can perform two types of operations on any element of the array any number of times:

If the element is even, divide it by 2.
For example, if the array is [1,2,3,4], then you can do this operation on the last element, and the array will be [1,2,3,2].
If the element is odd, multiply it by 2.
For example, if the array is [1,2,3,4], then you can do this operation on the first element, and the array will be [2,2,3,4].

The deviation of the array is the maximum difference between any two elements in the array.
Return the minimum deviation the array can have after performing some number of operations.

Example 1:
Input: nums = [1,2,3,4]
Output: 1
Explanation: You can transform the array to [1,2,3,2], then to [2,2,3,2], then the deviation will be 3 - 2 = 1.

Example 2:
Input: nums = [4,1,5,20,3]
Output: 3
Explanation: You can transform the array after two operations to [4,2,5,5,3], then the deviation will be 5 - 2 = 3.

Example 3:
Input: nums = [2,10,8]
Output: 3

Constraints:
n == nums.length
2 <= n <= 10^5
1 <= nums[i] <= 10^9
 */
public class MinimumDeviation {

    public static void main(String[] args) {
        System.out.println(new MinimumDeviation().minimumDeviation(new int[]{1, 2, 3, 4}));
        System.out.println(new MinimumDeviation().minimumDeviation(new int[]{4, 1, 5, 20, 3}));
        System.out.println(new MinimumDeviation().minimumDeviation(new int[]{2, 10, 8}));
    }

    // https://leetcode.com/problems/minimize-deviation-in-array/discuss/1781805/A-very-very-Highly-Detailed-EXPLANATION
    // with TreeSet, as TreeSet is an ordered Set
    // TimeComplexity: BigO(NLogNLogM)
    // SpaceComplexity: BigO(N)
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        // since max of numbers can only happen with odd (odd * 2),
        // hence finding the max that can be drawn out of this array.
        // TimeComplexity - LogN
        for (int i : nums) {
            if (i % 2 == 1)
                i *= 2;
            treeSet.add(i);
        }

        int difference = Integer.MAX_VALUE;
        while (true) {
            // since TreeSet is ordered, max is present at the last, min at first position
            int max = treeSet.last();// TimeComplexity - N
            int min = treeSet.first();

            difference = Math.min(difference, (max - min));
            // to get the min difference, minimizing the max to an extent where it can't be divided further
            // i.e. making it odd
            if (max % 2 == 0) {
                // TimeComplexity - LogM
                treeSet.remove(max);// removing the element
                treeSet.add(max / 2);// adding it back with half value
            } else
                break;// if max is an odd value, it can't be divided further, hence break
        }
        // the difference now is final
        return difference;
    }

    // with Priority Queue
    public int minimumDeviation1(int[] nums) {
        // First create a priority Queue
        // and implemented a custom comperator, which help us in making this priority queue act like a max heap
        // concept of max heap states that, highest value should lie at the front of the queue & lowest value at the back of the queue
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // so we apply the custom comperator over here

        int min = Integer.MAX_VALUE; // creating minimum variable
        for (int i : nums) { // add these values in priority queue
            if (i % 2 == 1) i *= 2; // if value is odd mult. by 2 & make it even
            min = Math.min(min, i); // find the minimum
            pq.add(i);
        } // now we have the value in the priority queue, where we have convert all the odd's into even

        // let's find the maximum of all the value
        int diff = Integer.MAX_VALUE;
        while (pq.peek() % 2 == 0) {
            int max = pq.remove(); // max will be at top of the queue
            diff = Math.min(diff, max - min); // find the difference
            min = Math.min(max / 2, min);//minimum can change because, new value we are getting by half max can be lower then current minimum
            pq.add(max / 2); // add that in the queue
        }

        return Math.min(diff, pq.peek() - min);
    }


}
