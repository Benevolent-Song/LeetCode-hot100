package com.shh;

public class T91最小路径和 {
}
class Solution91{
    public int minPathSum(int[][] grid) {
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(i==0&&j>0)//如果是第一行边界
                {
                    grid[i][j]=grid[i][j]+grid[i][j-1];//和同行上一列元素相加
                }
                if(j==0&&i>0)//如果是第一列列边界
                {
                    grid[i][j]=grid[i][j]+grid[i-1][j];//和同一列上一行元素相加
                }
                if(i>0&&j>0)//判断是和左边相加小还是和上部相加小
                {
                    grid[i][j]=Math.min(grid[i][j]+grid[i-1][j],grid[i][j]+grid[i][j-1]);
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
