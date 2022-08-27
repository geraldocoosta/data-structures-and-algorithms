package org.example;

public class RemoveNthNodeFromEndList {

    public static void main(String[] args) {
        ListNode first = new ListNode(2);
        ListNode midle = new ListNode(1);
        ListNode last = new ListNode(0);
        first.next = midle;
        midle.next = last;
        System.out.println(new RemoveNthNodeFromEndList().removeNthFromEnd(first, 1));
    }


    // Time complexity : O(L).
    // The algorithm makes one traversal of the list of L nodes. Therefore time complexity is O(L).
    //
    // Space complexity : O(1).
    public ListNode removeNthFromEnd(ListNode head, int n) {


        // a pegadinha do dummy é a seguinte, e se eu tiver que remover meu primeiro elemento?
        // aí eu preciso de um dummy, que é um elemento que aponta para o primeiro elemento da lista
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;
        //Avança o primeiro ponteiro de modo que o intervalo entre o primeiro e o segundo tenha n nós de distância
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        //Mova primeiro até o final, mantendo a distancia
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return String.format("[valor: %d]", val, next);
        }
    }
}

/*
*

Remove Nth Node From End of List

* Given the head of a linked list, remove the nth node from the end of the list and return its head.



Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]


Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
*
*
* */