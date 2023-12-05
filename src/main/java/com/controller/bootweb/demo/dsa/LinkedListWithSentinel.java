package com.controller.bootweb.demo.dsa;

class ListNode2 {
    int val;
    ListNode2 next;

    public ListNode2(int val) {
        this.val = val;
    }
}

public class LinkedListWithSentinel {

    public ListNode2 insertAtHead(ListNode2 head, int value) {
        ListNode2 sentinel = new ListNode2(0);
        sentinel.next = head;

        ListNode2 newNode = new ListNode2(value);
        newNode.next = sentinel.next;
        sentinel.next = newNode;

        return sentinel.next;
    }

    public static void main(String[] args) {

        LinkedListWithSentinel list = new LinkedListWithSentinel();

        // 示例：在链表头部插入节点
        ListNode2 head = new ListNode2(1);
        head = list.insertAtHead(head, 2);
        head = list.insertAtHead(head, 3);


        // 打印链表
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
