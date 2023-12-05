package com.controller.bootweb.demo.dsa;

class ListNode {
    char val;
    ListNode next;

    public ListNode(char val) {
        this.val = val;
    }
}

public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // 空链表或只有一个节点的链表是回文串
        }

        // 使用快慢指针找到链表的中点
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转后半部分链表
        ListNode reversedHalf = reverseLinkedList(slow);

        // 比较前半部分和反转后的后半部分链表
        while (reversedHalf != null) {
            if (head.val != reversedHalf.val) {
                return false;
            }
            head = head.next;
            reversedHalf = reversedHalf.next;
        }

        return true;
    }

    // 反转链表的函数
    private static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    public static void main(String[] args) {
        // 示例
        ListNode head = new ListNode('a');
        head.next = new ListNode('b');
        head.next.next = new ListNode('c');
        head.next.next.next = new ListNode('b');
        head.next.next.next.next = new ListNode('a');

        System.out.println(isPalindrome(head)); // 输出 true
    }
}