package com.shh;

public class T94编辑距离 {
}
class Solution94{
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];//存放进行变换所需要的步数
        // 第一行(为‘’,第一行只要进行插入操作,每次是前一次操作数加1)
        for (int j = 1; j <= n2; j++)
        {dp[0][j] = dp[0][j - 1] + 1;}
        // 第一列(为‘’,第一列只要经行删除操作,每次是前一次操作数加1)
        for (int i = 1; i <= n1; i++)
        {dp[i][0] = dp[i - 1][0] + 1;}
        for (int i = 1; i <= n1; i++)//对行列进行遍历
        {
            for (int j = 1; j <= n2; j++)
            {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))//如果最后的字符串是相等的,不用额外的操作,只要继承左上的操作次数
                {dp[i][j] = dp[i - 1][j - 1];}
                else//取所需操作数最少的操作数
                {dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;}
                //即dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
                //dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。
            }
        }
        return dp[n1][n2];
    }
}
