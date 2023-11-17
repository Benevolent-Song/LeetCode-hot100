//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
//你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
//示例 1：
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]

//示例 2：
//输入：head = []
//输出：[]

//示例 3：
//输入：head = [1]
//输出：[1]
package com.shh;
import java.util.ArrayList;
import java.util.List;

public class T30两两交换链表中的节点 {
    public static void main(String[] args) {

    }
}
class Solution30 {
    public ListNode swapPairs(ListNode head) {
        List <ListNode>  list=new ArrayList<>();
        ListNode temp=head;
        if(temp==null||temp.next==null)
        {
            return temp;
        }
        while(temp!=null)
        {
            list.add(temp);
            temp=temp.next;
        }
        int length=list.size();//链表的长度
        //在集合中进行调换
        int times=length/2;//需要进行操作的次数
        for(int i=0;i<length-1;i=i+2)//每次跳两位
        {
         ListNode temp1=list.get(i+1);//暂时保存要被替换的节点
         list.set(i+1,list.get(i));//交换两个节点
         list.set(i,temp1);
        }
        //按照顺序构建新的链表
        for(int i=0;i<list.size()-1;i++)
        {
            list.get(i).next=list.get(i+1);//对于链表的
        }
        list.get(length-1).next=null;//对于链表最后的元素的next赋值为null

    return list.get(0);
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
