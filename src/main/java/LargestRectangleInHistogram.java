package main.java;

import java.util.Arrays;

/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104

Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    /*
    For any bar i the maximum rectangle is of width r - l - 1 where r - is the last coordinate of the bar to the right with height h[r] >= h[i] and l - is the last coordinate of the bar to the left which height h[l] >= h[i]

So if for any i coordinate we know his utmost higher (or of the same height) neighbors to the right and to the left, we can easily find the largest rectangle:

int maxArea = 0;
for (int i = 0; i < height.length; i++) {
    maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
}
The main trick is how to effectively calculate lessFromRight and lessFromLeft arrays. The trivial solution is to use O(n^2) solution and for each i element first find his left/right heighbour in the second inner loop just iterating back or forward:

for (int i = 1; i < height.length; i++) {
    int p = i - 1;
    while (p >= 0 && height[p] >= height[i]) {
        p--;
    }
    lessFromLeft[i] = p;
}
The only line change shifts this algorithm from O(n^2) to O(n) complexity: we don't need to rescan each item to the left - we can reuse results of previous calculations and "jump" through indices in quick manner:

while (p >= 0 && height[p] >= height[i]) {
      p = lessFromLeft[p];
}

Here's the intuition to understand p = lessFromLeft[p]; :

Consider the test case
indices.......... : 0 1 2 3 4 5 6 7 8 9 10 11
heights.......... : 4 9 8 7 6 5 9 8 7 6 5 4.
lessFromLeft :-1 0 0 0 0 0 5 5 5 5 . .

In this, when we reach 5 at index 10, we start searching for idx=9, i.e. p points at 6.
6 > 5.
Now, we want something which is smaller than 5, so it should definitely be smaller than 6. So 6 says to 5:

I've already done the effort to find the nearest number that's smaller than me and you needn't traverse the array again till that point. My lessFromLeft points at index 5 and all the elements between that and me are greater than me so they are surely greater than you. So just jump to that index and start searching from there.

So you next p directly points at idx = 5, at value 5.

There, this 5 again says the same statement to current 5 and asks it to jump directly to idx = 0. So in the second iteration itself, our search has reached idx=0 and that's our answer for the current element.

Similarly, for the next element 4, it'll take 3 steps.

And for all the elements following 4, if they are greater than 4, their search will stop at 4 itself.

Bottomline: we are not traversing the array again and again. it's O(n)
     */

    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;
        for (int i = 1; i < height.length; i++) {
            int p = i - 1;

            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        System.out.println("heightArray: "+ Arrays.toString(height));
        System.out.println("lessFromLeft: "+ Arrays.toString(lessFromLeft));
        System.out.println("lessFromRight: "+ Arrays.toString(lessFromRight));
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
            System.out.println("i: "+ i + ", height[i]: "+ height[i] + ", max: "+ maxArea);
        }

        return maxArea;
    }
}
