package main.java;

public class ValidMountainArray {
    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{4,4,3,2,1}));
        System.out.println(validMountainArray(new int[]{4,5,6,5,5}));
        System.out.println(validMountainArray(new int[]{1,2,3,3,1}));
        System.out.println(validMountainArray(new int[]{1,2,3,2,1}));

    }

    // my solution: 3 ms	51.2 MB
    public static boolean validMountainArray2(int[] arr) {
        // eliminating arrays less than size 3
        if(arr.length < 3)
            return false;

        // eliminating single slope arrays
        int len = arr.length;
        if(arr[1] < arr[0] || arr[len-1] > arr[len-2])
            return false;

        int downhill = 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i] == arr[i-1])
                return false;
            if(arr[i] < arr[i-1] && downhill == 0)
                downhill = 1;
            // eliminating valley
            if(arr[i] > arr[i-1] && downhill == 1)
                return false;
        }
        return downhill == 1;
    }

    // online solution 2ms 50.9MB
    public static boolean validMountainArray(int[] A) {
        int n = A.length, i = 0, j = n - 1;
        while (i + 1 < n && A[i] < A[i + 1]) i++;
        while (j > 0 && A[j - 1] > A[j]) j--;
        return i > 0 && i == j && j < n - 1;
    }
}
