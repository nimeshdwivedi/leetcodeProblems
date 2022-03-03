package main.java.problems.strings;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some
(can be none) of the characters without disturbing the relative positions of the remaining characters.
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false

Constraints:
0 <= s.length <= 100
0 <= t.length <= 10^4
s and t consist only of lowercase English letters.
 */
public class SubSequence {

    public static void main(String[] args) {
        System.out.println(new SubSequence().isSubsequence("axc", "ahbgdc"));
    }

    // my solution 0ms
    // 1ms if we use only Strings
    public boolean isSubsequence(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        int i=0,j=0;
        while(i<s1.length && j<t1.length){
            if(s1[i] == t1[j]){
                i++; j++;
            } else {
                j++;
            }
        }
        return i >= s1.length;
    }
}
