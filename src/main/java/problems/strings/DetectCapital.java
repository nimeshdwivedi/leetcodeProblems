package main.java.problems.strings;

public class DetectCapital {

    /*
    We define the usage of capitals in a word to be right when one of the following cases holds:

    All letters in this word are capitals, like "USA".
    All letters in this word are not capitals, like "leetcode".
    Only the first letter in this word is capital, like "Google".
    Given a string word, return true if the usage of capitals in it is right.

    Example 1:
    Input: word = "USA"
    Output: true

    Example 2:
    Input: word = "FlaG"
    Output: false
     */

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("ABC"));
        System.out.println(detectCapitalUse("ABc"));
        System.out.println(detectCapitalUse("abc"));
        System.out.println(detectCapitalUse("Abc"));
    }

    public static boolean detectCapitalUse(String word) {
        // solution, Runtime 1ms MemoryUsage 39.2Mb
        char[] arr = word.toCharArray();
        int sum = 0;
        for (char c : arr) {
            if (c >= (int) 'A' && c <= (int) 'Z') {
                sum += 1;
            }
        }
        if(sum == 0 || sum == arr.length)
            return true;
        return sum == 1 && arr[0] >= (int) 'A' && arr[0] <= (int) 'Z';
    }
}
