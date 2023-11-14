//输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
//输出：Intersected at '2'
//输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
package com.shh;

import java.util.HashSet;
import java.util.Set;

public class T22相交链表 {
    public static void main(String[] args) {

    }
}
class Solution22{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null)//将所有headA的节点放入到哈希集合中
        {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null)//取出所有的headB的节点
        {
            if (visited.contains(temp))
            {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
class ListNode//节点
{
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
     }
}
