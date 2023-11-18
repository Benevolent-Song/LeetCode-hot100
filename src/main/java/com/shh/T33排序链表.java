package com.shh;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class T33排序链表 {
    public static void main(String[] args) {
    int [] array=new int[]{};
    System.out.println(Arrays.toString(array));
    }
}
//归并排序（递归法）
class Solution33{
    public ListNode sortList(ListNode head) {
        // 1、递归结束条件
        if (head == null || head.next == null) {
            return head;
        }

        // 2、找到链表中间节点并断开链表 & 递归下探
        ListNode midNode = middleNode(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 3、当前层业务操作（合并有序链表）
        return mergeTwoLists(left, right);
    }

    //  找到链表中间节点（876. 链表的中间结点）
    private ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // 合并两个有序链表（21. 合并两个有序链表）
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(-1);
        ListNode curr = sentry;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;
        return sentry.next;
    }
}
/**使用hashmap在创建键值对时,一个key只能对应一个value,
 * 方法是成立的,但是节点的val值有相同的就不成立了
class Solution33{
    public ListNode sortList(ListNode head) {
        ListNode temp=head;
        //这样保存可以根据val在、取出对应的节点
        Map<Integer,ListNode> list=new HashMap<>();
        if(head==null||head.next==null)
        {
            return head;
        }
        while(temp!=null)
        {
            list.put(temp.val,temp);
            temp=temp.next;
        }
        int [] numsort=new int[list.size()];//存放val的数组
        temp=head;
        int i=0;
        while(temp!=null)
        {
            numsort[i]=temp.val;//将val值存放到数组中
            temp=temp.next;
            i++;
        }
        //对数组中val值进行排序
        Arrays.sort(numsort);
        for(int j=0;j<numsort.length-1;j++)
        {
            list.get(numsort[j]).next=list.get(numsort[j+1]);
        }
        list.get(numsort[numsort.length-1]).next=null;//最后一个节点的的next为null
        return  list.get(numsort[0]);
    }
}
 */
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
