package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode[] listNodes = mergeKSortedLists.generateNodes();
        ListNode listNode = mergeKSortedLists.mergeKLists(listNodes);
        System.out.println(listNode);


        listNodes = mergeKSortedLists.generateNodes();
        listNode = mergeKSortedLists.mergeKLists2(listNodes);
        System.out.println(listNode);

    }


    // Brute force

    //Time complexity : O(NlogN) where NN is the total number of nodes.
    //
    //Collecting all the values costs O(N) time.
    //A stable sorting algorithm costs O(NlogN) time.
    //Iterating for creating the linked list costs O(N) time.
    //Space complexity : O(N).
    //
    //Sorting cost O(N) space (depends on the algorithm you choose).
    //Creating a new linked list costs O(N) space.
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> l = new ArrayList<>();

        for (ListNode ln : lists) {
            while (ln != null) {
                l.add(ln.val);
                ln = ln.next;
            }
        }

        Collections.sort(l);

        ListNode head = new ListNode(0);
        ListNode h = head;
        for (int i : l) {
            ListNode t = new ListNode(i);
            h.next = t;
            h = h.next;
        }
        h.next = null;
        return head.next;
    }


    // Time space O(NLogN)
    // Space complexity :
    //
    //O(n) Creating a new linked list costs O(n)O(n) space.
    //O(k) The code above present applies in-place method which cost O(1) space.
    // And the priority queue (often implemented with heaps) costs O(k) space (it's far less than NN in most situations).

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        ListNode dummy = new ListNode(0);
        ListNode aux = dummy;

        for (ListNode node : lists)
            if (node != null) queue.add(node);

        while (!queue.isEmpty()) {
            aux.next = queue.poll();
            aux = aux.next;

            if (aux.next != null) queue.add(aux.next);
        }
        return dummy.next;
    }

    public ListNode[] generateNodes() {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(5);

        listNode.next = listNode1;
        listNode1.next = listNode2;

        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);

        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode6 = new ListNode(2);
        listNode6.next = new ListNode(6);

        return new ListNode[]{listNode, listNode3, listNode6};
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
            return "ListNode{" + "val=" + val + ", next=" + next + '}';
        }
    }
}

/*
Merge k Sorted Lists

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.









*/