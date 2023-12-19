package com.shh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class T89最长有效括号 {
}
class Solution89{
    public int longestValidParentheses(String s) {
    Stack <Character> stack=new Stack<>();
    stack.push('!');//防止pop时是空的
    List<Integer> list=new ArrayList<>();
    int nums=0;
    for(int i=0;i<s.length();i++)
    {
      if(s.charAt(i)=='(')
      {
         stack.push('(');
      }
      else if(s.charAt(i)==')')
      {
         if(stack.pop()=='(')
         {
             nums++;
         }
         else
         {list.add(nums);nums=0;stack.clear();stack.push('!');}
      }
    }
    Collections.sort(list);
    return list.get(list.size()-1);
    }
}
