package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode[] listNodes = mergeKSortedLists.generateNodes();
        ListNode listNode = mergeKSortedLists.mergeKLists(listNodes);
        System.out.println(listNode);

        listNodes = mergeKSortedLists.generateNodes();
        listNode = mergeKSortedLists.mergeKLists2(listNodes);
        System.out.println(listNode);

        listNodes = mergeKSortedLists.generateNodes();
        listNode = mergeKSortedLists.mergeKLists3(listNodes);
        System.out.println(listNode);

        listNodes = mergeKSortedLists.generateNodes();
        listNode = mergeKSortedLists.mergeKLists4(listNodes);
        System.out.println(listNode);

        listNodes = mergeKSortedLists.generateNodes();
        listNode = mergeKSortedLists.mergeKLists5(listNodes);
        System.out.println(listNode);
    }

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

    public ListNode mergeKLists2(ListNode[] lists) {
        int min_index = 0;
        ListNode head = new ListNode(0);
        ListNode h = head;
        while (true) {
            boolean isBreak = true;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < min) {
                        min_index = i;
                        min = lists[i].val;
                    }
                    isBreak = false;
                }

            }
            if (isBreak) {
                break;
            }
            ListNode a = new ListNode(lists[min_index].val);
            h.next = a;
            h = h.next;
            lists[min_index] = lists[min_index].next;
        }
        h.next = null;
        return head.next;
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        int min_index = 0;
        ListNode head = new ListNode(0);
        ListNode h = head;
        while (true) {
            boolean isBreak = true;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < min) {
                        min_index = i;
                        min = lists[i].val;
                    }
                    isBreak = false;
                }

            }
            if (isBreak) {
                break;
            }
            h.next = lists[min_index];
            h = h.next;
            lists[min_index] = lists[min_index].next;
        }
        h.next = null;
        return head.next;
    }

    public ListNode mergeKLists4(ListNode[] lists) {

        Queue<ListNode> q = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode l : lists) {
            if (l != null) {
                q.add(l);
            }
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while (!q.isEmpty()) {
            point.next = q.poll();
            point = point.next;
            ListNode next = point.next;
            if (next != null) {
                q.add(next);
            }
        }
        return head.next;
    }


    public ListNode mergeKLists5(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode ans = h;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                h.next = l1;
                h = h.next;
                l1 = l1.next;
            } else {
                h.next = l2;
                h = h.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            h.next = l2;
        }
        if (l2 == null) {
            h.next = l1;
        }
        return ans.next;
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
