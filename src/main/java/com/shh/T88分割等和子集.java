package com.shh;

public class T88分割等和子集 {
}
class Solution88{
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        // 题目已经说非空数组，可以不做非空判断
        int sum = 0;
        for (int num : nums)//计算所有数的和(两数组和相同,相当于等于总数组和的一半)
        {
            sum += num;
        }
        // 特判：如果是奇数，就不符合要求(只有偶数才能平分成两组相等的)
        if ((sum & 1) == 1)
        {
            return false;
        }
        int target = sum/2;//数组和的目标
        // 创建二维状态数组,num[i]所能填满的背包容量(0~target),能刚好填满填true
        boolean[][] dp = new boolean[len][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target)
        {
            dp[0][nums[0]] = true;
        }
        // 再填表格后面几行
        for (int i = 1; i < len; i++)
        {
            for (int j = 0; j <= target; j++)
            {
                dp[i][j] = dp[i - 1][j];//复制上一行的结果
                if (nums[i] == j)//如果第i行的元素等于目标值,直接该行的最后一列添true
                {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j)//如果小于目标值,以上一行为基础,
                {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                    //上一行(i-1行)的j-num[i]列能填满则,i行的j一定能填满
                }
            }
        }
        return dp[len - 1][target];//返回保留所有行结果基础上修正的最终结果
    }
}

