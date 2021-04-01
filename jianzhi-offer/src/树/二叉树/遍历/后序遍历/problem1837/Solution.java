package 树.二叉树.遍历.后序遍历.problem1837;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
class Solution {
    private int[] postorder = null;

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        this.postorder = postorder;
        return verifyPostorderList(0, postorder.length - 1);
    }

    /**
     * 判断 postorder 属组中 l r 区间的子数组是否满足二叉搜索树的后序遍历
     *
     * @param ll 子数组最左端
     * @param rr 子数组最右端
     * @return
     */
    private boolean verifyPostorderList(int ll, int rr) {
        int n = rr - ll + 1; // 子数组长度
        if (n <= 2) { // 当节点数小于等于2时 必定可以是
            return true;
        }
        // 最后一个元素即树根
        int root = this.postorder[rr];
        int lr = ll; // 左子树的右端点
        for (int i = 0; i <= rr; i++) {
            if (this.postorder[i] >= root) {
                lr = i - 1;
                break;
            }
        }
        // 右子树的左端点
        int rl = lr + 1;
        // System.out.println("** " + ll + " " + lr + " " + rl + " " + (rr - 1));
        // 若右子树中存在小于当前根结点当节点，则 false
        for (int i = rl; i < rr; i++) {
            if (this.postorder[i] < root) {
                return false;
            }
        }
        // System.out.println("** " + ll + " " + lr + " " + rl + " " + (rr - 1));
        return verifyPostorderList(ll, lr) && verifyPostorderList(rl, rr - 1);
    }
}