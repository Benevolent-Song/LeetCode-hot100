package com.shh;

public class T93最长公共子序列 {
}
class Solution93{
    public int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length();
        int N = text2.length();
        int[][] dp = new int[M + 1][N + 1];//存放text1,text2子序列的公共子序列个数
        for (int i = 1; i <= M; ++i)//行遍历
        {
            for (int j = 1; j <= N; ++j)//列遍历
            {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                //如果两个序列的末尾元素相同
                {dp[i][j] = dp[i - 1][j - 1] + 1;}//左上元素加1
                else
                {//左元素和上元素较大的那
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[M][N];
    }
}


