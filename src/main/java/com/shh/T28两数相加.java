//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
package com.shh;

import java.util.ArrayList;
import java.util.List;
public class T28两数相加 {
    public static void main(String[] args) {
    String s1=new String("123");
    }
}
/**
 class Solution{
 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
 ListNode temp1=l1;
 ListNode temp2=l2;
 int n=0,m=0,sum=0;
 //判断数字的位数
 while(temp1!=null)
 {
 n++;//链表的长度
 temp1=temp1.next;
 }
 while(temp2!=null)
 {
 m++;//链表的长度
 temp2=temp2.next;
 }
 temp1=l1;
 temp2=l2;
 //将两个数字相加
 for(int i=0;i<n;i++)
 {
 sum=temp1.val*((int)Math.pow(10,i))+sum;
 temp1=temp1.next;
 }
 System.out.println(sum);
 for(int i=0;i<m;i++)
 {
 sum=temp2.val*((int)Math.pow(10,i))+sum;
 temp2=temp2.next;
 }
 System.out.println(sum);
 //取出数字的每一位
 String str = String.valueOf(sum);//转换为字符串
 int length = str.length();//求出数字的长度
 //System.out.println(length);
 ListNode []node=new ListNode [length];
 for(int i=0;i<length;i++)
 {
 node[i]=new ListNode(Character.getNumericValue(str.charAt(i)));
 System.out.println(Character.getNumericValue(str.charAt(i)));
 }
 for(int i=length-1;i>0;i--)
 {
 node[i].next=node[i-1];
 }
 return node[length-1];
 }
 }*/
class ListNode2{
int val;
ListNode2 next;
ListNode2() {}
ListNode2(int val) { this.val = val; }
ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
}
