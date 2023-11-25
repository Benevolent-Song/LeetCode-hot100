package com.shh;
public class T40二叉树的直径 {
    public static void main(String[] args) {

    }
}
class Solution40{
    int maxd=0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxd;
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            int leftHeight = maxDepth(root.left);//递归调用
            int rightHeight = maxDepth(root.right);
            maxd=Math.max(leftHeight+rightHeight,maxd);//将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
            return Math.max(leftHeight, rightHeight) + 1;//每找到一层节点加一
        }
    }
}
