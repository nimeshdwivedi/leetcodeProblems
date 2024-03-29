package main.java.problems.arrays;

import java.util.Arrays;

public class DuplicateZeroesInArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,2,3,0,4,5,0};
        new DuplicateZeroesInArray().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void duplicateZeros(int[] arr) {
        for(int i=0; i<arr.length - 1; i++){
            if(arr[i] == 0){
                for(int j=arr.length - 1; j>i; j--){
                    arr[j] = arr[j-1];
                }
                i++;
            }
        }
    }
}
