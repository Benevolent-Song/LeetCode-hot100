package com.shh;

import java.util.Stack;

//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
public class T72每日温度 {
    public static void main(String[] args) {
    }
}
//时间超时了
class Solution72{
    public int[] array;
    public int index1;
    public int[] dailyTemperatures(int[] temperatures) {
        array=temperatures;
        Stack<Integer>stack1=new Stack<>();
        Stack<Integer>stack2=new Stack<>();
        //如果该数比后面的数都要大(即最大值),从该数开始全部为0
        int index=0;
        int max=temperatures[0];
        int day[]=new int[temperatures.length];
        for(int i=1;i<temperatures.length;i++)
        {
            if(temperatures[i]>max)
            {
                max=temperatures[i];
                index=i;
                this.index1=i;
            }
        }
        day[index1]=0;
        //对前面的数进行处理
        int find=0;
        for(int i=0;i<index;i++)
        {
            find=findbigger(temperatures[i],i)-i;
            day[i]=find;
        }
        //对后面的数进行处理
        for(int i=index1;i<temperatures.length;i++)
        {
            find=findbigger1(temperatures[i],i)-i;
            day[i]=find;
        }
        return day;
    }
    //处理最大数前面的数,找到更大数的下标(从当前数开始到最大值)
    public int findbigger(int num,int index)
    {
        for(int i=index;i<index1;i++)
        {
            if(array[i]>num)
            {
                return i;
            }
        }
        return index1;//返回最大值的下标
    }
    //处理最大数后面的数,找到更大数的下标(从当前数开始到最后)
    public int findbigger1(int num,int index)
    {
        for(int i=index;i<array.length;i++)
        {
            if(array[i]>num)
            {
                return i;
            }
        }
        return index;//返回自身的下标
    }
}
/**运算速度更快的方法
 class Solution {
    public int[] dailyTemperatures(int[] T)
   {
    Stack<Integer> stack = new Stack<>();
    int length = T.length;
    int[] result = new int[length];
    for (int i = 0; i < length; i++)
    {
        while (!stack.isEmpty() && T[i] > T[stack.peek()])
        {
            int pre = stack.pop();//出栈
            result[pre] = i - pre;
        }
        stack.add(i);//入栈
    }
    return result;
  }
}
 */
