package org.example;

public class ReverseNodesKGroup {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        ListNode listNode = new ReverseNodesKGroup().reverseKGroup(head, 3);
        System.out.println(listNode);
    }

    // Time Complexity: O(N) since we process each node exactly twice.
    // Once when we are counting the number of nodes in each recursive call,
    // and then once when we are actually reversing the sub-list.
    // A slightly optimized implementation here could be that we don't count the number of nodes at all and simply reverse k nodes.
    // If at any point we find that we didn't have enough nodes,
    // we can re-reverse the last set of nodes so as to keep the original structure as required by the problem statement.
    // That ways, we can get rid of the extra counting.

    // Space Complexity: O(N/k) used up by the recursion stack.
    // The number of recursion calls is determined by both kk and N.
    // In every recursive call, we process k nodes and then make a recursive call to process the rest.
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode ptr = head;
        while (count < k && ptr != null) {
            ptr = ptr.next;
            count++;
        }
        if (count == k) {
            ListNode reversedHead = this.reverseLinkedList(head, k);
            head.next = this.reverseKGroup(ptr, k);
            return reversedHead;
        }
        return head;
    }

    public ListNode reverseLinkedList(ListNode head, int k) {
        ListNode newHead = null;
        ListNode pointer = head;

        while (k > 0) {
            ListNode nextNode = pointer.next;
            pointer.next = newHead;
            newHead = pointer;
            pointer = nextNode;
            k--;
        }
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