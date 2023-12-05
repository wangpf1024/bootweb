package com.controller.bootweb.demo.dsa;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class TreeWithSentinel {

    // 哨兵节点作为树的末尾
    private static final TreeNode sentinel = new TreeNode(Integer.MAX_VALUE);

    // 在二叉搜索树中插入节点
    public TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.val) {
            root.left = insert(root.left, value);
        } else if (value > root.val) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // 中序遍历打印树节点值
    public void inorderTraversal(TreeNode root) {
        if (root != null && root != sentinel) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        TreeWithSentinel tree = new TreeWithSentinel();

        // 示例：插入节点并中序遍历
        TreeNode root = null;
        root = tree.insert(root, 5);
        root = tree.insert(root, 3);
        root = tree.insert(root, 7);
        root = tree.insert(root, 2);
        root = tree.insert(root, 4);

        // 中序遍历打印节点值
        tree.inorderTraversal(root);
    }
}

