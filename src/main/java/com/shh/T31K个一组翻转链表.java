package com.shh;

import java.util.ArrayList;
import java.util.List;

public class T31K个一组翻转链表 {
    public static void main(String[] args) {

    }
}
class Solution31{
    public ListNode reverseKGroup(ListNode head, int k){
        List<ListNode> list=new ArrayList<>();
        List<ListNode> list1=new ArrayList<>();
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
        if(k>length)
        {
            return head;
        }
        //在集合中进行调换
        for(int i=0;i<length-k+1;i=i+k)//每次跳k位
        {
            //对于k位进行翻转
            for(int j=0;j<k;j++)
            {
                list1.add(list.get(i+k-1-j));//把节点暂存到list1集合中
                //System.out.println(list.get(i+k-1-j).val);
            }
            for(int j=0;j<k;j++)
            {
                list.set(i+j,list1.get(j));//把节点暂存到list1集合中
                //System.out.println(list.get(j).val);
            }
            list1.clear();//清除集合方便下一次的操作
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
