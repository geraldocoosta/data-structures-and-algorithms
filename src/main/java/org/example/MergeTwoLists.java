package org.example;

public class MergeTwoLists {

    public static void main(String[] args) {
        // create two ListNode
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(3);
        first.next = second;

        ListNode third = new ListNode(2);
        ListNode fourth = new ListNode(4);

        third.next = fourth;

        System.out.println();
        System.out.println(new MergeTwoLists().mergeTwoLists1(first, third));
        System.out.println(new MergeTwoLists().mergeTwoLists2(first, third));

    }

    // Time complexity : OO(n+m)
    //Because each recursive call increments the pointer to l1 or l2 by one
    // (approaching the dangling null at the end of each list),
    // there will be exactly one call to mergeTwoLists per element in each list.
    // Therefore, the time complexity is linear in the combined size of the lists.
    //
    //Space complexity : O(n + m)O(n+m)
    //The first call to mergeTwoLists does not return until the ends of both l1 and l2 have been reached,
    // so n+m stack frames consume O(n+m) space.


    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists1(list1, list2.next);
            return list2;
        }
    }

    //Time complexity : O(n+m)
    //Because exactly one of l1 and l2 is incremented on each loop iteration,
    // the while loop runs for a number of iterations equal to the sum of the lengths of the two lists.
    // All other work is constant, so the overall complexity is linear.
    //
    //Space complexity : O(1)
    //
    //The iterative approach only allocates a few pointers, so it has a constant overall memory footprint.

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode handler = head;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                handler.next = l1;
                l1 = l1.next;
            } else {
                handler.next = l2;
                l2 = l2.next;
            }
            handler = handler.next;
        }

        if (l1 != null) {
            handler.next = l1;
        } else if (l2 != null) {
            handler.next = l2;
        }

        return head.next;
    }

    static class ListNode {
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}

