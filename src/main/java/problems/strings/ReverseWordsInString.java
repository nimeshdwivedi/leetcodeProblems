package main.java.problems.strings;

import java.util.Arrays;

public class ReverseWordsInString {

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInString().reverseWords("hi how are you"));
    }

    // 9 ms when unnecessary stringBuilder is used instead of new String(arr)
    // 2 ms with below implementation
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = 0;
        while (j < arr.length) {
            if (arr[j] == ' ' && j > i) {
                int start = i, end = j - 1;
                while (start < end) {
                    char c = arr[start];
                    arr[start] = arr[end];
                    arr[end] = c;
                    start++;
                    end--;
                }
                i = j + 1;
                j = j + 1;
            } else {
                j++;
            }
        }
        j--;
        while (i < j) {
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
            i++;
            j--;
        }
        return new String(arr);
    }


}
