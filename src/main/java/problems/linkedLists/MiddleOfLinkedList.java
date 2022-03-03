package main.java.problems.linkedLists;

/*
https://leetcode.com/problems/middle-of-the-linked-list/

Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.\

1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

Constraints:
The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100
 */
public class MiddleOfLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println(new MiddleOfLinkedList().middleNode(node1).val);
        node5.next = null;
        System.out.println(new MiddleOfLinkedList().middleNode(node1).val);
    }

    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode middle = head;
        int i=0;
        while(head != null){
            i++;
            head = head.next;
            if(i%2 == 0)
                middle = middle.next;
        }
        return middle;
    }
}
