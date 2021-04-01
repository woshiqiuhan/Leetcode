package 树.二叉树.problem1838;

import 树.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * 疑问：节点值是否可为负数？ 存在负数节点
 */
class Solution {
    private List<List<Integer>> res = null;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.res = new LinkedList<>();
        if (root == null) {
            return this.res;
        }
        dfs(new LinkedList<>(), sum, root);
        return this.res;
    }

    private void dfs(List<Integer> list, int attr, TreeNode root) {
        if (root == null) return;
        attr -= root.val;
        List<Integer> tmpList = new LinkedList<>(list);
        tmpList.add(root.val);
        // 保证是叶子结点
        if (root.left == null && root.right == null && attr == 0) {
            this.res.add(tmpList);
            return;
        }
        dfs(tmpList, attr, root.left);
        dfs(tmpList, attr, root.right);
    }
}