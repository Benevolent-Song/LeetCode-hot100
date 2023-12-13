package com.shh;

public class T83打家劫舍 {
}
//动态规划问题
class Solution83{
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 子问题：
        // f(k) = 偷 [0..k) 房间中的最大金额

        // f(0) = 0
        // f(1) = nums[0]
        // f(k) = max{ rob(k-1), nums[k-1] + rob(k-2) }

        int N = nums.length;
        int[] dp = new int[N+1];//存放k个房间抢劫到的最大钱数
        dp[0] = 0;//0个房间
        dp[1] = nums[0];//1个房间
        for (int k = 2; k <= N; k++)//从3个房间起开始偷
        {
            dp[k] = Math.max(dp[k-1], nums[k-1] + dp[k-2]);//偷k个房间偷到的最大值
            //偷前k-1间和偷前k-2间加最后一间取较大的偷法
        }
        return dp[N];//偷N=nums.length个房间偷到的最大值
    }
}

