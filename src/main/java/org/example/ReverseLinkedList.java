public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        new ReverseLinkedList().reverseList(head);
        System.out.println(head);
    }

    // Time O(N)
    // Space O(1)
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            // next é o próximo elemento da fila encadeada
            ListNode next = curr.next;
            // Curr.Next recebe o valor anterior a ele
            curr.next = prev;
            // Trocamos as referencias
            // Agora o anterior é o atual
            prev = curr;
            // Agora o corrente é o próximo da fila encadeada
            curr = next;
        }
        // Prev agora é o Head da Fila
        return prev;
    }

    // Time O(N)
    // Space O(N)
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        public String toString() { return next == null ? "" + val : val + ", " + next.toString(); }
    }
}



/*

Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.



Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []


Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000


Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?


 */