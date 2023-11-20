package com.shh;

import java.util.ArrayList;
import java.util.List;

public class T36二叉树的中序遍历 {
    public static void main(String[] args) {

    }
}
//对节点进行中序遍历
class Solution36{
    public List list1=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
    midfind(root);//运行中序遍历
    return list1;
    }
    public void midfind(TreeNode treenode)
    {
        if(treenode==null)
        {
            return;
        }
        if(treenode.left!=null)
        {
            midfind(treenode.left);
        }
        list1.add(treenode.val);//加入遍历的结果
        if(treenode.right!=null)
        {
            midfind(treenode.right);
        }
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
     }
  }
