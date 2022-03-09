package main.java.problems.numbers;

import java.util.HashSet;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(4));
    }

    // online solution O(1), using Chasing algo, similar to CheckingCycle in LinkedList
    public boolean isHappy(int n) {
        int x = n;
        int y = n;
        while (x > 1) {
            x = cal(x);
            if (x == 1) return true;
            y = cal(cal(y));
            if (y == 1) return true;

            if (x == y) return false;
        }
        return true;
    }

    public int cal(int n) {
        int x = n;
        int s = 0;
        while (x > 0) {
            s = s + (x % 10) * (x % 10);
            x = x / 10;
        }
        return s;
    }

    // my solution 4 ms, 40 MB
    public boolean myIsHappy(int n) {
        HashSet<Integer> visitedNumbers = new HashSet<>();
        while (visitedNumbers.add(n)) {
            if (n == 1)
                return true;
            if (n < 4)
                return false;
            int sum = 0;
            while (n / 10 > 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            sum += Math.pow(n % 10, 2);
            n = sum;
        }
        return false;
    }
}
