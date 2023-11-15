//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//输入：l1 = [], l2 = []
//输出：[]
//输入：l1 = [], l2 = [0]
//输出：[0]
package com.shh;
import java.util.ArrayList;
import java.util.List;

public class T27合并两个有序链表 {
    public static void main(String[] args) {
    Solution27 st27=new Solution27();
    }
}
class Solution27 {
    public ListNode1 mergeTwoLists(ListNode1 list1, ListNode1 list2) {
    ListNode1 temp1=list1;
    ListNode1 temp2=list2;
    //使用集合,将两个链表从小到大存储,最后再形成链表
    List<ListNode1> All=new ArrayList<>();
    List<ListNode1> l1=new ArrayList<>();
    List<ListNode1> l2=new ArrayList<>();
    int n=0;
    int m=0;
    while(temp1!=null)
    {
     l1.add(temp1);
     temp1=temp1.next;
    }
    while(temp2!=null)
    {
     l2.add(temp2);
     temp2=temp2.next;
    }
    while(true)
    {
       if(n==l1.size()-1||m==l2.size()-1)
       {
           if(n==l1.size()-1&&m==l2.size()-1)//将剩余的l2放到All集合中
           {
               break;
           }
           else if(n==l1.size()-1)//将剩余的l2放到All集合中
           {
              All.add(l2.get(m));
              m++;
           }
           else//将剩余的l2放到All集合中
           {
               All.add(l1.get(n));
               n++;
           }
       }
       else if(l1.get(n).val<l2.get(m).val)
       {
          All.add(l1.get(n));
          n++;
       }
       else
       {
          All.add(l2.get(m));
          m++;
       }
    }
    //构建链表
    for(int i=0;i<All.size()-1;i++)
    {
       All.get(i).next=All.get(i+1);
    }
    All.get(All.size()-1).next=null;
    return All.get(0);
    }
}
class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1() {}
    ListNode1(int val) { this.val = val; }
    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
}
/*使用递归的方法
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) return list2;
    if (list2 == null) return list1;
    ListNode temp = new ListNode();
    if (list1.val < list2.val)
    {
        temp = new ListNode(list1.val);
        temp.next = mergeTwoLists(list1.next, list2);
    }
    else {
        temp = new ListNode(list2.val);
        temp.next = mergeTwoLists(list1, list2.next);
    }
    return temp;
}
}
 */
