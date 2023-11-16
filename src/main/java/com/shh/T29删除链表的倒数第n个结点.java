//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
package com.shh;
public class T29删除链表的倒数第n个结点 {
    public static void main(String[] args) {

    }
}
class Solution29{
    public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode temp=head;
    int m=0;
    while (temp!=null)
    {
      m++;
      temp=temp.next;
    }
    temp=head;
    if(m==0||m==1)
    {
        return null;
    }
    for(int i=0;i<m-n-1;i++)
    {
        if(i==m-n-1)
        {
            if(temp.next.next==null)//如果删除的是最后一个节点
            {
              temp.next=null;
            }
            else {
                //要删除的前一个节点
                temp = temp.next.next;
            }
        }
        //如果删除的是中间的·一个节点
        temp=temp.next;
    }
    return head;
    }
}
