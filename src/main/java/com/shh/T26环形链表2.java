//给定一个链表的头节点  head ，返回链表开始入环的第一个节点。如果链表无环，则返回 null。
//如果有环则返回形成环的第一个节点的下标
package com.shh;
public class T26环形链表2 {
    public static void main(String[] args) {

    }
}
class Solution26{
    public ListNode detectCycle(ListNode head) {
        ListNode s=head;//慢指针
        ListNode f=head;//快指针
        while(true)//不断取出
        {
            if(f==null||f.next==null)
            {return null;}
            s=s.next;
            f = f.next.next;
            if(s==f)//如果两个指针相遇了,则退出
            {break;}//(a为环开始的节点,b为环的长度,s走过的路径s)f走过的路径:s+nb=2s,可得s=nb
            //从head结点走到入环点需要走:a + nb， 而slow已经走了nb，那么s再走a步就是入环点了。
        }
        f=head;
        while(true)//让它们都走a步相遇
        {
            if(s==f)
            {
             return f;
            }
            f=f.next;
            s=s.next;
        }
    }
}
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
