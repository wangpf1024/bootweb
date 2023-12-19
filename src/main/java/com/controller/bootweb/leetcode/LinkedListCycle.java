package com.controller.bootweb.leetcode;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // 链表为空或只有一个节点，不存在环
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false; // 如果链表中没有环，快指针会先到达链表尾部
            }
            slow = slow.next;         // 慢指针每次移动一步
            fast = fast.next.next;    // 快指针每次移动两步
        }

        return true; // 链表中存在环
    }

    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();

        // 创建一个带环的链表
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // 形成环

        boolean result = solution.hasCycle(head);
        System.out.println("Has Cycle: " + result);
    }
}
