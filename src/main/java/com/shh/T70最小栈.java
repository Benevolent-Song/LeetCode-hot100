package com.shh;

import java.util.Collections;
import java.util.LinkedList;

public class T70最小栈 {
    public static void main(String[] args) {

    }
}
class MinStack {
    LinkedList <Integer> stack;
    public MinStack() {
        stack=new LinkedList<>();
    }

    public void push(int val) {
        delete();
        stack.add(val);
    }

    public void pop(){
        delete();
        stack.removeLast();
    }

    public int top() {
        delete();
        return stack.getLast();
    }

    public int getMin() {
        return Collections.min(stack);
    }
    public void delete()//如果添加数是null时
    {
        if(stack.size()>0)
        {
            while(stack.getLast()==null)
            {
                stack.removeLast();
            }
        }
    }
}
