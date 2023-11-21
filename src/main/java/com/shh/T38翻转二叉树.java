package com.shh;

import javax.swing.*;

public class T38翻转二叉树 {
    public static void main(String[] args) {

    }
}
class Solution38{
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
        {
            return null;
        }
        findall(root);
        return root;
    }
    public void findall(TreeNode treenode)//遍历所有的节点,交换它们的左右节点
    {
        TreeNode temp=new TreeNode();
        if(treenode.right!=null&&treenode.left!=null)
        {
            temp=treenode.left;
            treenode.left=treenode.right;
            treenode.right=temp;
        }
        else if(treenode.right==null){treenode.right=treenode.left;treenode.left=null;}
        else if(treenode.left==null){treenode.left=treenode.right;treenode.right=null;}
        if(treenode.right!=null)
        {
            findall(treenode.right);
        }
        if(treenode.left!=null)
        {
            findall(treenode.left);
        }
    }
}
