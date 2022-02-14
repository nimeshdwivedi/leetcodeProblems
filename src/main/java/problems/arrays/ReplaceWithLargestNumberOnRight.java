package main.java.problems.arrays;

import java.util.Arrays;

/*
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
After doing so, return the array.

Example 1:
Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]

Example 2:
Input: arr = [400]
Output: [-1]

Constraints:
1 <= arr.length <= 104
1 <= arr[i] <= 105
 */
public class ReplaceWithLargestNumberOnRight {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ReplaceWithLargestNumberOnRight().replaceElements(new int[]{17,18,5,4,6,1})));
        System.out.println(Arrays.toString(new ReplaceWithLargestNumberOnRight().replaceElements(new int[]{3})));
    }

    public int[] replaceElements(int[] arr) {
        int largest = arr[arr.length-1], temp=0;
        arr[arr.length-1] = -1;
        for(int j=arr.length-2; j>=0; j--){
            temp = arr[j];
            arr[j] = largest;
            if(temp > largest) {
                largest = temp;
            }
        }
        return arr;
    }
}
