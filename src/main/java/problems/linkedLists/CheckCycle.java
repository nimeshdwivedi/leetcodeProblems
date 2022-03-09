package main.java.problems.linkedLists;

import java.util.HashMap;

/*
https://leetcode.com/problems/linked-list-cycle/
 */
public class CheckCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode listNode3 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode0 = new ListNode(0);
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode2;
        listNode2.next = listNode0;
        listNode0.next = listNode4;
        listNode4.next = listNode2;
        System.out.println(new CheckCycle().hasCycle(listNode3));
    }

    // online solution, O(1), Chasing problem
    public boolean hasCycle(ListNode head) {
        ListNode walker = head, runner = head;
        while(runner.next != null && runner.next.next != null){
            walker = walker.next;
            runner = runner.next.next;
            if(walker == runner)
                return true;
        }
        return false;
    }
}
