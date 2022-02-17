package main.java.problems.linkedLists;

import java.util.List;

/*
Given a linked list, swap every two adjacent nodes and return its head.
You must solve the problem without modifying the values in the list's nodes
(i.e., only nodes themselves may be changed.)

Example 1:
Input: head = [1,2,3,4]
Output: [2,1,4,3]

Example 2:
Input: head = []
Output: []

Example 3:
Input: head = [1]
Output: [1]
 */
public class SwapNodesInPair {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode4 = new ListNode(4);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode result = new SwapNodesInPair().swapPairs(listNode1);
        while (result != null) {
            System.out.println("1: " + result.val);
            result = result.next;
        }

        ListNode result2 = new SwapNodesInPair().swapPairs(null);
        while (result2 != null) {
            System.out.println("2: " + result2.val);
            result2 = result2.next;
        }

        ListNode listNode = new ListNode(4);
        ListNode result3 = new SwapNodesInPair().swapPairs(listNode);
        while (result3 != null) {
            System.out.println("3: " + result3.val);
            result3 = result3.next;
        }
    }

    // my solution 0ms
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode currentNode = head;
        head = currentNode.next;
        ListNode temp = currentNode.next.next;
        currentNode.next.next = currentNode;
        currentNode.next = swapPairs(temp);

        return head;
    }
}
