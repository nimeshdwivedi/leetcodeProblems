package main.java.algorithms;

/*
This is where we iterate over the Array in two different places at the same time.

Read all the elements like we did before, to identify the duplicates.
We call this our readPointer.

Keep track of the next position in the front to write the next unique element we've found.
We call this our writePointer.
 */
public class TwoPointerTechnique {

    // return size of array after removing duplicates
    public int removingDuplicateFromArray(int[] nums) {
        if (nums == null)
            return 0;

        int writePointer = 1;
        for (int readPointer = 1; readPointer < nums.length; readPointer++) {
            if (nums[readPointer] != nums[readPointer - 1]) {
                nums[writePointer] = nums[readPointer];
                writePointer++;
            }
        }
        return writePointer;
    }

}
