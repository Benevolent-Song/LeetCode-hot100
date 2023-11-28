package com.shh;
public class T51岛屿数量 {
}
class Solution51{
    public int numIslands(char[][] grid) {
    int count=0;
    for(int i=0;i<grid.length;i++)
    {
        for(int j=0;j<grid[0].length;j++)
        {
            if(grid[i][j]=='1')
            {
                dfs(grid,i,j);
                count++;
            }
        }
    }
    return count;
    }
    //DFS遍历
    public void dfs(char[][] grid,int n,int m)
    {
        if(!if_in(grid,n,m))//如果不在矩阵内部了
        {
            return;
        }
        if(grid[n][m]!='1')
        {
            return;
        }
        grid[n][m]='0';//表示已经遍历过了
        dfs(grid,n-1,m);//上
        dfs(grid,n+1,m);//下
        dfs(grid,n,m-1);//左
        dfs(grid,n,m+1);//右
    }
    //判断是否超过边界
    public boolean if_in(char[][] grid,int n,int m)
    {
        return (n>=0&&n<grid.length)&&(m>=0&&m<grid[0].length);
    }
}
