package main.java.problems.strings;

import java.util.HashMap;

/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatedChars {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatedChars().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatedChars().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LongestSubstringWithoutRepeatedChars().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        for(int i=0, j=0; i<s.length(); i++){
            // j will mark the start of substring without repeated characters
            // i will slide forward in string to record characters
            if(charMap.containsKey(s.charAt(i))){
                // let s="aba", when i reaches 'a' at s[2],
                //      then start of the string should be set to start from b (map's A pos + 1), hence charMap.get(dupChar)+1
                // let s="abba" when i reaches 'b' at s[2]
                //      then start of the string is set to 2, (map's B pos + 1), now j=2
                // let s="abba" when i reaches 'a' at s[3] and j=2 bcuz of previous step
                //      then j should not be moved to (map's A pos + 1) becuz then it will go back to
                //          substring which already has a duplicate, hence no change
                j = Math.max(j, charMap.get(s.charAt(i))+1);
            }
            charMap.put(s.charAt(i), i);
            result = Math.max(result, (i-j)+1);//max of last length and new substring length
        }
        return result;
    }
}
