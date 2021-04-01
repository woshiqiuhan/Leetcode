package problem105;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int[] preorder, inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        int n = preorder.length;
        if (n == 0) {
            return null;
        }
        this.preorder = preorder;
        this.inorder = inorder;

        if (n == 1) {
            return new TreeNode(preorder[0]);
        }
        return buildSubTree(0, n - 1, 0, n - 1);
    }

    private TreeNode buildSubTree(int lp, int rp, int li, int ri) {
        int n = rp - lp + 1;
        if (n <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(this.preorder[lp]);
        if (n == 1) {
            return root;
        }

        // 记录中序遍历中 root 的位置
        int rootIndex = 0;
        for (int i = li; i <= ri; i++) {
            if (this.inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }
        // 左子树的节点数
        int l = rootIndex - li;

        root.left = buildSubTree(lp + 1, l + lp, li, li + l - 1);
        root.right = buildSubTree(lp + l + 1, rp, li + l + 1, ri);

        return root;
    }
}