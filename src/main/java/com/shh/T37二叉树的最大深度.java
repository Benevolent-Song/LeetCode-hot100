package com.shh;
public class T37二叉树的最大深度 {
    public static void main(String[] args) {
    }
}
class Solution37{
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);//递归调用
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;//每找到一层节点加一
        }
    }
}
class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1() {}
    TreeNode1(int val) { this.val = val; }
    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
