package main.java.problems.math;

/*
Given a string columnTitle that represents the column title as appear in an Excel sheet,
return its corresponding column number.

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
Input: columnTitle = "A"
Output: 1

Example 2:
Input: columnTitle = "AB"
Output: 28

Example 3:
Input: columnTitle = "ZY"
Output: 701

Constraints:
1 <= columnTitle.length <= 7
columnTitle consists only of uppercase English letters.
columnTitle is in the range ["A", "FXSHRXW"].
 */
public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("A"));
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("AB"));
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("ZY"));
    }

    // online solution
    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.isEmpty())
            return -1;

        int result = 0;
        for (char ch : columnTitle.toCharArray()) {
            result *= 26;// each time we add a character after 1st place, we go ahead by 26 times
            result += ch - 'A' + 1;
        }
        return result;
    }
}
