package main.java;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{0,1,2,2,3,0,4,2}));
    }

    public int removeDuplicates(int[] nums) {
        int[] newnums = Arrays.stream(nums).distinct().toArray();
        for(int i: newnums)
            nums[i] = newnums[i];
        return newnums.length;
    }
}
