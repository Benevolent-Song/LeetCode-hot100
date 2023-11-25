package com.shh;

import java.util.ArrayList;
import java.util.List;

public class T45二叉树的右视图 {
    public static void main(String[] args) {

    }
}
class Solution45{
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0); // 从根节点开始访问，根节点深度是0
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 先访问当前节点，再递归地访问右子树和左子树。
        if (depth == res.size()) {
            // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);//先对右子树进行深度遍历
        dfs(root.left, depth);//对左子树进行深度遍历
    }
}

