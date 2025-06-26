package com.interview.algo;

public class CustomLinkedList<T> {

    static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private int size;

    public CustomLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public Node<T> reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        while(current != null) {
            Node<T> next = current.next;
            current.next = head;
            prev = current;
            current = next;
        }
        return prev;
    }

    public Node<T> reverseList(Node<T> head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next; // Сохраняем следующий узел
            curr.next = prev;          // Меняем указатель на предыдущий
            prev = curr;               // Сдвигаем prev
            curr = next;               // Сдвигаем curr
        }

        return prev; // Новая голова
    }

    public void print(Node<T> head) {
        Node current = head;
        while(current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public void print() {
        Node current = head;
        while(current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(5);
        System.out.println("Test");
        list.print();
//        list.addLast(6);
//        list.addLast(7);
//        list.addLast(8);
//        list.print();
        System.out.println("Test 2");
        Node<Integer> newHead = list.reverseList(list.head);
        list.print(newHead);
    }
}
