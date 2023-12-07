package com.shh;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class T69有效的括号 {
}
class Solution69{
    public Map<Character,Character> map = new HashMap<Character,Character>()
    {{put('{','}'); put('[',']'); put('(',')'); put('!','!');}};//存放前置符和后置符对应的key-value值
    public boolean isValid(String s) {
        if(s.length()>0&&!map.containsKey(s.charAt(0)))
        {
            return false;
        }
        LinkedList <Character>stack=new LinkedList<>();//创建用作栈的链表
        stack.add('!');//为了栈不为空
        char [] list=s.toCharArray();//将字符串转换为字符数组
        for(char ch:list)//将字符数组一位一位取出
        {
            if(map.containsKey(ch))//如果是前置字符
            {
                stack.add(ch);
            }
            else if(map.get(stack.removeLast())!=ch)//如果是后置字符
            {
                return false;
            }
        }
        return stack.size()==1;//判断栈中最后是否就剩下了占位字符串
    }
}
/**
 //考虑还不完全,使用栈进行判断符号的有效性
 class Solution69{
 boolean find1=true;
 boolean find2=true;
 public boolean isValid(String s) {
 if(s.length()==1)
 {
 return false;
 }
 if(s.length()==2)
 {
 if(((int)s.charAt(0)/10!=(int)s.charAt(1)/10)||(s.charAt(0)==s.charAt(1)))
 {return false;}
 else
 {return true;}
 }
 for(int i=0;i<s.length();i=i+2)//比较相邻的两个
 {
 System.out.println(s.charAt(i));
 System.out.println(s.charAt(i+1));
 if(((int)s.charAt(i)/10!=(int)s.charAt(i+1)/10)||(((int)s.charAt(i)<(int)s.charAt(i+1)))||(s.charAt(i)==s.charAt(i+1)))
 {
 find1=false;
 break;
 }
 }
 for(int i=0;i<s.length()/2;i++)//左右两边同时比较
 {
 if(((int)s.charAt(i)/10!=(int)s.charAt(s.length()-i-1)/10)||(((int)s.charAt(i)<(int)s.charAt(s.length()-i-1)))||(s.charAt(i)==s.charAt(s.length()-i-1)))
 {
 find2=false;
 break;
 }
 }
 System.out.println(find1);
 System.out.println(find2);
 return (!find1&&find2)||(find1&&!find2);
 }
 }
*/
