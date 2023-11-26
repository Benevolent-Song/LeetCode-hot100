package com.shh;

import java.util.ArrayList;
import java.util.List;

public class T46二叉树展开为链表 {
    public static void main(String[] args) {

    }
}
class Solution46{
    public List<TreeNode> list=new ArrayList<>();
    public void flatten(TreeNode root) {
        if(root==null)
        {
            return;
        }
        findall(root);
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i).val);
        }
        for(int i=0;i<list.size()-1;i++)
        {
            list.get(i).left=null;
            list.get(i).right=list.get(i+1);
        }
        list.get(list.size()-1).right=null;
        list.get(list.size()-1).left=null;
    }
    public void findall(TreeNode root)
    {
        list.add(root);
        if(root.left!=null)
        {
            findall(root.left);
        }
        if(root.right!=null)
        {
            findall(root.right);
        }
    }
}
