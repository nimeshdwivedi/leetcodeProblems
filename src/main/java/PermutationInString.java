package main.java;

import java.util.Arrays;

/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.

Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false

Constraints:
1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
 */
public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(new PermutationInString().checkInclusion("ab", "eidbaooo"));
        System.out.println(new PermutationInString().checkInclusion("ab", "eidboaoo"));
    }

    // my solution - 2039ms Memory: 313MB
    public boolean mycheckInclusion(String s1, String s2) {
        s1 = sort(s1);
        for(int i=0; i<s2.length()-s1.length(); i++){
            if(s1.equals(sort(s2.substring(i, i+s1.length()))))
                return true;
        }
        return false;
    }

    private String sort(String s1) {
        char[] ch = s1.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

    // https://leetcode.com/problems/permutation-in-string/discuss/1761974/java-solution-with-explaination-or-o(n)-time
    // online solution
    public boolean checkInclusion(String s1, String s2) {
        int len_s1 = s1.length(), len_s2 = s2.length();
        if (len_s1 > len_s2) return false;

        int[] count = new int[26];
        for (int i = 0; i < len_s1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (zeroCount(count)) return true;

        for (int i = len_s1; i < len_s2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len_s1) - 'a']++;
            if (zeroCount(count)) return true;
        }

        return false;
    }

    private boolean zeroCount(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0)
                return false;
        }
        return true;
    }
}
