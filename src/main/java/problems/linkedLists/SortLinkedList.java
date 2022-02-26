package main.java.problems.linkedLists;

import java.util.List;

/*
Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []

Constraints:

The number of nodes in the list is in the range [0, 5 * 10^4].
-10^5 <= Node.val <= 10^5

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */
public class SortLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode3 = new ListNode(3);
        ListNode listNode1 = new ListNode(1, listNode3);
        ListNode listNode2 = new ListNode(2, listNode1);
        ListNode listNode4 = new ListNode(4, listNode2);
        System.out.print("Input: ");
        printList(listNode4);
        ListNode sortedNode = new SortLinkedList().sortList(listNode4);
        System.out.println("Output: ");
        printList(sortedNode);
    }

    public static void printList(ListNode head) {
        if (head != null) {
            System.out.print(" -> " + head.val);
            printList(head.next);
        }
    }

    // online solution Bottom Up Merge Sort Algorithm (without recursion)
    // http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/7-Sort/merge-sort5.html
    // https://leetcode.com/problems/sort-list/discuss/46712/Bottom-to-up(not-recurring)-with-o(1)-space-complextity-and-o(nlgn)-time-complextity
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int n = 0;
        while (head != null) {
            head = head.next;
            n++;
        }

        for (int step = 1; step < n; step <<= 1) {
            ListNode prev = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(left, step);
                cur = split(right, step);
                prev = merge(left, right, prev);
            }
        }

        return dummy.next;
    }

    private ListNode split(ListNode node, int step) {
        if (node == null)
            return null;

        for (int i = 0; i < step && node.next != null; i++)
            node = node.next;

        ListNode result = node.next;
        node.next = null;
        return result;
    }

    private ListNode merge(ListNode leftNode, ListNode rightNode, ListNode previousNode) {
        ListNode cur = previousNode;
        while (leftNode != null && rightNode != null) {
            if (leftNode.val < rightNode.val) {
                cur.next = leftNode;
                leftNode = leftNode.next;
            } else {
                cur.next = rightNode;
                rightNode = rightNode.next;
            }
            cur = cur.next;
        }

        if (leftNode != null) cur.next = leftNode;
        else if (rightNode != null) cur.next = rightNode;
        while (cur.next != null) cur = cur.next;
        return cur;
    }
}
