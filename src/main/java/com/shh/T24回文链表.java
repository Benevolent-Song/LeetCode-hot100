//回文链表,以中间结点为基准,两边都一样
//输入：head = [1,2,2,1]
package com.shh;
import java.util.ArrayList;
import java.util.List;

public class T24回文链表 {
    public static void main(String[] args) {
    }
}
class Solution{
    public boolean isPalindrome(ListNode head) {
        List<ListNode> list=new ArrayList<>();
        ListNode temp=head;
        boolean ifis=true;
        while(temp!=null)
        {
            list.add(temp);
            temp=temp.next;
        }
        if(list.size()%2==0)//为偶数的情况
        {
            for(int i=0;i<list.size()/2;i++)
            {
                if(list.get(list.size()-1-i).val!=list.get(i).val)
                {
                    ifis=false;
                    return ifis;
                }
            }
        }
        else//为奇数的情况
        {
            int mid=list.size()/2;//中间节点的下标
            for(int i=0;i<list.size()/2+1;i++)
            {
                if(list.get(mid-i).val!=list.get(mid+i).val)
                {
                    ifis=false;
                    return ifis;
                }
            }
        }
        return ifis;
    }
}
/**
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
