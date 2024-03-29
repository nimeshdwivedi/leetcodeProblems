package main.java.problems.numbers;

import java.util.Arrays;

/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
ans[i] is the number of 1's in the binary representation of i.

Example 1:
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

Constraints:
0 <= n <= 10^5

Follow up:
It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
 */
public class CountBits {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(new CountBits().countBits(5)));
        System.out.println(Arrays.toString(new CountBits().countBits(3)));
    }

    // online solution
    public int[] countBits(int n){
        int[] ans = new int[n+1];
        for(int i=0; i<=n; i++)
        {
            ans[i] = i%2 == 0 ? ans[i/2] : 1 + ans[(i-1)/2];
        }
        return ans;
    }

    // my solution 21 ms
    public int[] myCountBits(int n) {
        int[] result = new int[n+1];
        result[0] = 0;
        for(int i=1; i<=n; i++){
            result[i] = count1s(i);
        }
        return result;
    }

    public int count1s(int n) {
        int count=0;
        while(n>0){
            if(n%2 == 1)
                count++;
            n/=2;
        }
        return count;
    }
}
