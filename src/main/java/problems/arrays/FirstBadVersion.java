package main.java.problems.arrays;

/*
You are a product manager and currently leading a team to develop a new product.
Unfortunately, the latest version of your product fails the quality check.
Since each version is developed based on the previous version, all the versions after a bad version
are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes
all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad.
Implement a function to find the first bad version. You should minimize the number of calls to the API.

The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version);

Example 1:
Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.

Example 2:
Input: n = 1, bad = 1
Output: 1

Constraints:
1 <= bad <= n <= 231 - 1
 */
class VersionControl {
    public boolean isBadVersion(int version) {
        return version == 4;
    }
}

public class FirstBadVersion extends VersionControl {
    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(5));
    }

    // 31 ms
    public int myfirstBadVersion(int n) {
        return searchBadVersion(1, n);
    }

    public int searchBadVersion(int start, int end) {
        if (start == end && isBadVersion(end))
            return end;

        int num = start + (end - start) / 2;
        if (!isBadVersion(num))
            return searchBadVersion(num + 1, end);
        else
            return searchBadVersion(start, num);
    }

    // online solution 23ms
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(!isBadVersion(mid))
                start = mid+1;
            else
                end = mid;
        }
        return start;
    }
}
