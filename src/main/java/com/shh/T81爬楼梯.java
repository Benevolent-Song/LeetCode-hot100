package com.shh;
public class T81爬楼梯 {
}
//示例 1：
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶

//示例 2：
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
class Solution81{
    public int climbStairs(int n) {
        if(n <= 2){//当有0、1、2个台阶时，分别有0、1、2种方法
            return n;
        }
        int[] dp = new int[n]; //记录从1个台阶到n个台阶中，每个台阶所需要的方法。
        dp[0] = 1; //dp[0]是第一个台阶
        dp[1] = 2; //dp[1]是第二个台阶
        for(int i = 2; i < n; i++){//i=2时是第三个台阶，i=n-1时是第n个台阶。
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1]; //dp[n-1]是第n个台阶
    }
}
