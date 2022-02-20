package main.java.problems.arrays;

import java.util.*;

/*
Remove Covered Intervals

Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that are covered by another interval in the list.
The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.
Return the number of remaining intervals.

Example 1:
Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.

Example 2:
Input: intervals = [[1,4],[2,3]]
Output: 1

Constraints:
1 <= intervals.length <= 1000
intervals[i].length == 2
0 <= li <= ri <= 10^5
All the given intervals are unique.
 */
public class RemoveCoveredIntervals {

    public static void main(String[] args) {
        System.out.println(new RemoveCoveredIntervals().removeCoveredIntervals(new int[][]{{1,4},{2,3}}));
        System.out.println(new RemoveCoveredIntervals().removeCoveredIntervals(new int[][]{{1,4},{3,6},{2,8}}));
        System.out.println(new RemoveCoveredIntervals().removeCoveredIntervals(new int[][]{{3,10},{4,10},{5,11}}));
        System.out.println(new RemoveCoveredIntervals().removeCoveredIntervals(new int[][]{{3, 10}, {3, 9}, {5, 11}}));
        System.out.println(new RemoveCoveredIntervals().removeCoveredIntervals(new int[][]{{3, 10}, {3, 11}, {5, 9}}));
    }

    // online solution
    // If we sort the intervals, both li and ri are increasing
    // any pair of interval[li] where ri is not increasing, shall be removed
    // example, {3,10},{4,10},{5,11} - 4,10 doesn't increases the last ri from {3,10}
    // meaning last li covers curr li, as well as, last ri now covers curr ri, hence removable
    public int removeCoveredIntervals(int[][] intervals) {
        // Sorting the intervals using custom comparator
        Arrays.sort(intervals, (a, b) -> {
            // Eg, between (X,9) and (X,10), greater one of 9 and 10 should come first
            if (a[0] == b[0])
                return b[1] - a[1]; // if diff>0 then b[1] else a[1]
                // Eg, between (3,X) and (4,X), lesser one of 3 and 4 should come first
            else
                return a[0] - b[0];// if diff<0 then a[0] else b[0]
        });

        // After sorting, li of interval 0 covers li of interval 1, and so on
        // hence we just need to check if ri is covered
        int alreadyCovered = 0, lastCovered = -1;
        for (int[] intv : intervals) {
            if (intv[1] > lastCovered)
                lastCovered = intv[1];
            else
                alreadyCovered++;
        }
        return intervals.length - alreadyCovered;
    }

    public int myRemoveCoveredIntervals(int[][] intervals) {
        if (intervals.length <= 1)
            return 1;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] arr : intervals) {
            System.out.println(map);
            boolean alreadyCovered = false;
            Integer[] keys = map.keySet().toArray(new Integer[0]);
            for (int key : map.keySet()) {
                System.out.println("Checking " + key + " against " + arr[0]);
                if (arr[0] < key && map.get(key) < arr[1]) {
                    System.out.println("removed " + key);
                    map.remove(key);// failed due to concurrent modification
                    map.put(arr[0], arr[1]);
                }
                if (key <= arr[0] && arr[1] <= map.get(key))
                    alreadyCovered = true;
            }
            if (!alreadyCovered)
                map.put(arr[0], arr[1]);
        }
        System.out.println("Final Map: " + map);
        return map.size();
    }
}
