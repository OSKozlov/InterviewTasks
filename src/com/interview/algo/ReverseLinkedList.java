package com.interview.algo;

public class ReverseLinkedList {

    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // Сохраняем следующий узел
            curr.next = prev;          // Меняем указатель на предыдущий
            prev = curr;               // Сдвигаем prev
            curr = next;               // Сдвигаем curr
        }

        return prev; // Новая голова
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Создаём список: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Исходный список:");
        printList(head);

        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode reversed = solution.reverseList(head);

        System.out.println("Развёрнутый список:");
        printList(reversed);
    }
}
