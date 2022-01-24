package main.java;

import java.util.ArrayList;
import java.util.List;

public class SequentialNumbers {

    /*
    An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
    Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

    Example 1:
    Input: low = 100, high = 300
    Output: [123,234]

    Example 2:
    Input: low = 1000, high = 13000
    Output: [1234,2345,3456,4567,5678,6789,12345]
     */

    public static void main(String[] args) {
        getSequentialNumbers(100, 4000).forEach(System.out::println);
    }

    public static List<Integer> getSequentialNumbers(int low, int high) {
        //t means the number of times we are going to loop this layer.
        //inc is the distance between 2 valid numbers and is always 11 or 111 or 1111 depending on num of digits.
        //start marks the starting point of each digit: 1, 12, 123, e.g. 1 + 11(inc) = 12, 12 + 111(inc) = 123.
        //cur is our current number.
        List<Integer> seqNums = new ArrayList<>();
        int t = 8; // starting with 12,23...89 (t=8), then 123, 234...789 (t=7), decreases by 1
        int inc = 11; // starting with 11, then 111,1111..., increases by (inc * 10 + 1)
        int start = 1; // starting with 1, then 12, 123..., increases by start+inc
        int cur = start;

        while (cur < high){
            for (int i=0; i<t; i++){
                cur += inc;
                if(cur>= low && cur<=high)
                    seqNums.add(cur);
            }
            // initializing for another decimal digit
            start = start + inc;
            inc = inc * 10 + 1;
            cur = start;
            t--;

        }
        return seqNums;
    }
}
