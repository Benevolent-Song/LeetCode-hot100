//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//输入：matrix = {{1,2,3},{4,5,6},{7,8,9}};
//输出：[1,2,3,6,9,8,7,4,5]
//输入：matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}}
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
package com.shh;

import java.util.ArrayList;
import java.util.List;

public class T19螺旋矩阵 {
    public static void main(String[] args) {
    int [][]matrix=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
    Solution19 st19=new Solution19();
    System.out.println(st19.spiralOrder(matrix));
    }
}
class Solution19{
    public List<Integer> spiralOrder(int[][] matrix) {
       List <Integer> list=new ArrayList<>();
       int top=0;
       int bottom=matrix.length;
       int left=0;
       int right=matrix[0].length;
       if(matrix==null||matrix.length==0||matrix[0].length==0)
       {
           return list;
       }
       while(left <= right && top <= bottom)//循环遍历,直到遍历完
       {
           //遍历上行
           for (int i =left; i < right; i++) {
               list.add(matrix[top][i]);
           }
           //遍历下列
           for (int i =top+1; i < bottom-1; i++) {
               list.add(matrix[i][right-1]);
           }
           if(left+1 < right && top+1 < bottom)//如果是最后一遍的遍历,下一次的下行和上列遍历就不用了
           {
               //遍历下行
               for (int i = right - 1; i > left - 1; i--) {
                   list.add(matrix[bottom - 1][i]);
               }
               //遍历上列
               for (int i = bottom - 2; i > top; i--) {
                   list.add(matrix[i][left]);
               }
           }
           left++;
           right--;
           top++;
           bottom--;
       }
       return list;
    }
}
