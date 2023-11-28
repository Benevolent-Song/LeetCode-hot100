package com.shh;
public class T48路径总和3 {
    public static void main(String[] args) {

    }
}
class Solution48{
    int ans, t;
    public int pathSum(TreeNode root, int _t) {
        t = _t;
        dfs1(root);
        return ans;
    }
    void dfs1(TreeNode root) {
        if (root == null) return;
        dfs2(root, root.val);
        dfs1(root.left);
        dfs1(root.right);
    }
    void dfs2(TreeNode root, long val) {
        if (val == t) ans++;
        if (root.left != null) dfs2(root.left, val + root.left.val);
        if (root.right != null) dfs2(root.right, val + root.right.val);
    }
}
