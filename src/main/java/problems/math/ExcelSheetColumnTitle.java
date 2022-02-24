
package main.java.problems.math;

/*
Given a string columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...

Example 1:
Input: columnNumber = 1
Output: "A"

Example 2:
Input: columnNumber = 28
Output: "AB"

Example 3:
Input: columnNumber = 701
Output: "ZY"

Constraints:
1 <= columnNumber <= 2^31 - 1
 */
public class ExcelSheetColumnTitle {

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(1));
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(28));
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(701));
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;// since 'A' starts from 1, not 0, hence making it compatible with 0 diff wd 'A'
            int ch = columnNumber % 26;
            columnNumber /= 26;
            sb.append((char) (ch+'A'));
        }
        return sb.reverse().toString();
    }
}
