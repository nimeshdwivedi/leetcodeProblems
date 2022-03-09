package main.java.problems.arrays;

/*
https://leetcode.com/problems/delete-and-earn/
 */
public class DeleteAndEarn {

    // online solution
    // https://leetcode.com/problems/delete-and-earn/discuss/109895/JavaC%2B%2B-Clean-Code-with-Explanation
    public int deleteAndEarn(int[] nums) {
        int[] map = new int[10001];
        for (int num : nums) {
            map[num] += num;
        }
        int prev = 0;
        int curr = 0;
        int temp;
        for (int value : map) {
            temp = curr;
            curr = Math.max(curr, prev + value);
            prev = temp;
        }
        return curr;
    }
}
