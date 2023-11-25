package com.shh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class T44二叉搜索树中第K小的元素 {
    public static void main(String[] args) {
    }
}
//使用数的遍历,再进行排序
class Solution44{
    public List<TreeNode> list=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        findall(root);
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i).val);
        }
        //对集合中的节点按照val的大小排序
        Collections.sort(list, new Comparator<TreeNode>() {
            public int compare( TreeNode node1, TreeNode node2) {
                // 根据节点的val值进行比较
                return Integer.compare(node1.val, node2.val);
            }
        });
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i).val);
        }
        return list.get(k-1).val;//下标要减1
    }
    //使用前序遍历将所有的节点放入集合,方便后序的排序
    public void findall(TreeNode root)
    {
        list.add(root);
        if(root.right!=null)
        {
            findall(root.right);
        }
        if(root.left!=null)
        {
            findall(root.left);
        }
    }
}
