package main.java.problems.strings;

import java.util.Arrays;

public class ReverseString {
    // my solution 1ms
    public void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while(start<end){
            char c = s[end];
            s[end] = s[start];
            s[start] = c;
            start++;
            end--;
        }
    }

    public void reverseString1(char[] s) {
        for(int start=0, end = s.length-1; start<=end; start++, end--){
            char c = s[end];
            s[end] = s[start];
            s[start] = c;
        }
    }
}
