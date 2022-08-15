package org.example;

public class ReverseNodesKGroup2 {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        ListNode listNode = new ReverseNodesKGroup2().reverseKGroup(head, 3);
        System.out.println(listNode);
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode pointer = head;
        ListNode ktail = null;

        // Head no final de tudo
        ListNode newHeader = null;

        // Keep going until there are nodes in the list
        while (pointer != null) {

            int count = 0;

            // Start counting nodes from the head
            pointer = head;

            // Find the head of the next k nodes
            while (count < k && pointer != null) {
                pointer = pointer.next;
                count += 1;
            }

            // If we counted k nodes, reverse them
            if (count == k) {

                // Reverse k nodes and get the new head
                ListNode revHead = this.reverseLinkedList(head, k);

                // newHeader is the head of the final linked list
                if (newHeader == null) {
                    newHeader = revHead;
                }

                // ktail is the tail of the previous block of
                // reversed k nodes
                if (ktail != null) {
                    ktail.next = revHead;
                }

                ktail = head;
                head = pointer;
            }
        }

        if (ktail != null) {
            ktail.next = head;
        }

        return newHeader == null ? head : newHeader;
    }

    public ListNode reverseLinkedList(ListNode head, int k) {

        // Reverse k nodes of the given linked list.
        // This function assumes that the list contains
        // atleast k nodes.
        ListNode newHead = null;
        ListNode ptr = head;

        while (k > 0) {

            // Keep track of the next node to process in the
            // original list
            ListNode nextNode = ptr.next;

            // Insert the node pointed to by "ptr"
            // at the beginning of the reversed list
            ptr.next = newHead;
            newHead = ptr;

            // Move on to the next node
            ptr = nextNode;

            // Decrement the count of nodes to be reversed by 1
            k--;
        }


        // Return the head of the reversed list
        return newHead;

    }

    static class ListNode {
        int val;
        ListNode next;


        ListNode(int val) {
            this.val = val;
        }


        public String toString() {
            return next == null ? "" + val : val + ", " + next;
        }
    }
}

/*

Reverse Nodes in k-Group

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.



Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]


Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000


Follow-up: Can you solve the problem in O(1) extra memory space?





*/