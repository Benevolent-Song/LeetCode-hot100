//给你一个链表的头节点 head ，判断链表中是否有环。
//使用快慢指针,如果存在环则两个指针一定能相遇
package com.shh;
public class T25环形链表 {
    public static void main(String[] args) {

    }
}
//不存在环,则指针一定会结束
class Solution25{
    public boolean hasCycle(ListNode head) {
        ListNode temp1=head;//慢指针
        ListNode temp2=head;//快指针
        boolean iffind=false;
        int i=0;
        while(temp2!=null&&temp1.next!=null)
        {
            i++;//temp1=temp2=head的条件时不成立
            if(temp1==temp2&&i>1)
            {
                iffind=true;
                break;
            }
            if(temp2.next==null)//如果temp2.next已经是null了不能再取下一位了
            {
                break;
            }
            temp1=temp1.next;//不断取下一个指针
            temp2=temp2.next.next;//不断取下一个指针
        }
        return iffind;
    }
}
