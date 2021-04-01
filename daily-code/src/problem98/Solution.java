package problem98;


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

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean isValidBSTRight = true;
        boolean isValidBSTLeft = true;
        if (root.right != null) {
            isValidBSTRight = isValidBST(root.right) &&
                    root.val < root.right.val && root.val < findMin(root.right);
        }
        if (root.left != null) {
            isValidBSTLeft = isValidBST(root.left) &&
                    root.val > root.left.val && root.val > findMax(root.left);
        }

        return isValidBSTLeft && isValidBSTRight;
    }

    private int findMax(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    private int findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
