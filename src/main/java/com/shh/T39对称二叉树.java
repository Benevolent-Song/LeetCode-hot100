package com.shh;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T39对称二叉树 {
    public static void main(String[] args) {

    }
}
class Solution39{
    public List <Integer> list1=new ArrayList<>();
    public List <Integer> list2=new ArrayList<>();
    public boolean isSymmetric(TreeNode root) {

        if(root==null)
        {
            return true;
        }
        TreeNode head1=root.left;
        TreeNode head2=root.right;
        findleft(head1);
        findright(head2);
        Collections.reverse(list1);
        if(list1.equals(list2))
        {
            return true;
        }
        return false;
    }
    public void findleft(TreeNode treeNode1)
    {
       if(treeNode1.right!=null)
       {findleft(treeNode1.right);}
       list1.add(treeNode1.val);
       if(treeNode1.left!=null)
       {findleft(treeNode1.left);}
    }
    public void findright(TreeNode treeNode1)
    {
        if(treeNode1.right!=null)
        {findright(treeNode1.right);}
        if(treeNode1.left!=null)
        {findright(treeNode1.left);}
        list2.add(treeNode1.val);
    }
}
