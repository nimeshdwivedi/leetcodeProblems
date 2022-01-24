package main.java;

public class DetectCapital {

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
