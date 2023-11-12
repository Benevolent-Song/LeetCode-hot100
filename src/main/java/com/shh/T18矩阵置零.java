//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
//输入：matrix = {{1,1,1},{1,0,1},{1,1,1}}
//输出：[[1,0,1],[0,0,0],[1,0,1]]

//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
package com.shh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T18矩阵置零 {
    public static void main(String[] args) {
    int [][] matrix=new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
    Solution18 st18=new Solution18();
    st18.setZeroes(matrix);
    for(int [] i:matrix)
    {
        System.out.println(Arrays.toString(i));
    }
    }
}
class Solution18 {
    public void setZeroes(int[][] matrix) {
        List <int []> list=new ArrayList<int []>();//存放0元素的所在行列的数组
        int [] temp=new int[2];//暂时存放0元素的所在行列的数组
        int h;//0所在行
        int l;//0所在列
        for(int i=0;i<matrix.length;i++)//遍历所有的元素,先找到所有的0,并保存0所在的行列
        {
            for(int j=0;j<matrix[0].length;j++)
            {
               if(matrix[i][j]==0)
               {
                   temp= new int[]{i, j};
                   list.add(temp);
               }
            }
        }
        for(int i=0;i<list.size();i++)
        {
            h=list.get(i)[0];//行
            l=list.get(i)[1];//列
            matrix[h]=new int[matrix[0].length];//将0所在行置0
            for(int j=0;j<matrix.length;j++)//将所在列置0
            {
                matrix[j][l]=0;
            }
        }
    }
}
