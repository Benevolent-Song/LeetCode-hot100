//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//将最后的节点作为头节点
package com.shh;

import java.util.ArrayList;
import java.util.List;

public class T23反转链表 {
    public static void main(String[] args) {

    }
}
class Solution23 {
    public ListNode reverseList(ListNode head) {
    ListNode temp = head;
    List<ListNode> list=new ArrayList<>();
    if(head==null)
    {
        return new ListNode(1);
    }
    while(temp!=null)
    {
      list.add(temp);
      temp=temp.next;
    }
    head=list.get(list.size()-1);
    temp=head;
    for(int i=0;i<list.size();i++)//构造链表
    {
      temp.next=list.get(list.size()-1-i);
      temp=temp.next;
    }
    return head;
    }
}
 /* public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
  */
