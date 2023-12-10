package com.controller.bootweb.demo.dsa;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    public TreeNode2(int val) {
        this.val = val;
    }
}

public class LevelOrderTraversal {

    public static void levelOrderTraversal(TreeNode2 root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode2> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode2 current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {
        // 示例二叉树
        TreeNode2 root = new TreeNode2(1);
        root.left = new TreeNode2(2);
        root.right = new TreeNode2(3);
        root.left.left = new TreeNode2(4);
        root.left.right = new TreeNode2(5);
        System.out.println("按层遍历结果：");
        levelOrderTraversal(root);
    }
}
