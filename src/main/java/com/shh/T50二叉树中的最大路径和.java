package com.shh;

public class T50二叉树中的最大路径和 {
}
class Solution50{
    int maxSum = Integer.MIN_VALUE; // 最大路径和

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    /**
     * 递归函数，计算以当前节点为根节点的子树的最大路径和
     * @param root 当前节点
     * @return 以当前节点为根节点的子树对外提供的最大路径和
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0; // 遍历到null节点，收益0
        }

        int left = dfs(root.left); // 左子树提供的最大路径和
        int right = dfs(root.right); // 右子树提供的最大路径和

        int innerMaxSum = left + root.val + right; // 当前子树内部的最大路径和
        maxSum = Math.max(maxSum, innerMaxSum); // 挑战最大纪录

        int outputMaxSum = root.val + Math.max(0, Math.max(left, right)); // 当前子树对外提供的最大和

        // 如果对外提供的路径和为负，直接返回0。否则正常返回
        return outputMaxSum < 0 ? 0 : outputMaxSum;
    }
}
