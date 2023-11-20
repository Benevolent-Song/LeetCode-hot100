package com.shh;

public class T34合并K个升序链表 {
    public static void main(String[] args) {

    }
}
class Solution34{
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;//头节点
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists(ans, lists[i]);//合并链表
        }
        return ans;
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null)//有一个链表为空
        {
            return a != null ? a : b;//谁不为空返回谁(可以同时为空)
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;//头指针设为空指针
        ListNode aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null)//遍历a,b链表
        {
            if (aPtr.val < bPtr.val)
            {
                tail.next = aPtr;//取值较小的节点,保存到暂存链表
                aPtr = aPtr.next;//取a链表的下一个节点
            }
            else
            {
                tail.next = bPtr;//取值较小的节点,保存到暂存链表
                bPtr = bPtr.next;//取b链表的下一个节点
            }
            tail = tail.next;//始终指向当前刚存放的那个元素
        }
        tail.next = (aPtr != null ? aPtr : bPtr);//有一个链表为空,将暂存链表的后面直接接上不为空的那个链表
        return head.next;//由于头指针为空指针,取next才为链表开头
    }
}
