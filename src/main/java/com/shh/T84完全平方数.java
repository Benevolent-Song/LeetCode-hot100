package com.shh;

public class T84完全平方数 {
}
//动态规划
class Solution84{
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++)
            {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }
}
/*
class Solution84{
    public int times=0;
    public int m;
    public int numSquares(int n) {
        final int first=n;//n所能加的最大的的平方数
        m=(int)Math.sqrt(first);//最大的平方数
        System.out.println(n+":"+m);
        if((m*m)==n)//如果本身就是完全平方数
        {return ++times;}
        else if(m*m>n)//如果m的值过大了
        {m=m-1;}
        else if(m*m<n)//计算下一个的平方和
        {times++;numSquares(n-m*m);}
        else//如果起始的m不能作为最大平方数起始
        {
        times=0;
        m--;
        numSquares(first);
        }
        return times;
    }
}
*/
