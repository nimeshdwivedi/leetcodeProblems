package main.java.problems.linkedLists;

public class RemoveNthNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode result = new RemoveNthNode().removeNthFromEnd(node1, 5);
        while(result != null){
            System.out.println("->" + result.val);
            result = result.next;
        }
        node1.next = null;
        result = new RemoveNthNode().removeNthFromEnd(node1, 1);
        while(result != null){
            System.out.println("->" + result.val);
            result = result.next;
        }
    }

    // online solution
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode front = start, rear = start;
        for(int i=1; i<=n+1; i++){
            front = front.next;
        }
        while(front != null){
            front = front.next;
            rear = rear.next;
        }
        rear.next = rear.next.next;
        return start.next;
    }

    // fails when first node needs to be removed
    public ListNode myRemoveNthFromEnd(ListNode head, int n) {
        int i=0;
        ListNode temp = head;
        ListNode result = new ListNode();
        result.next = head;
        while(head.next != null){
            i++;
            head = head.next;
            if(i>n){
                temp = temp.next;
            }
        }
        temp.next = temp.next.next;
        return result.next;
    }
}
