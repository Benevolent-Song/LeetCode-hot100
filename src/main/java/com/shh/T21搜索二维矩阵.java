//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
//每行的元素从左到右升序排列。
//每列的元素从上到下升序排列。
//输入：matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, target = 5
//输出：true
//输入：matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, target = 20
//输出：false
//输入：matrix = {{-1,3}}
package com.shh;
public class T21搜索二维矩阵 {
    public static void main(String[] args) {
    int [][] matrix=new int[][] {{-1,3}};
    Solution21 st21=new Solution21();
    System.out.println(st21.searchMatrix(matrix,3));
    }
}
class Solution21 {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean find=false;//时候找到的标志
        //对每一行进行二分查找
        for(int i=0;i<matrix.length;i++)
        {
            int l=0;
            int r=matrix[0].length-1;
            int mid;
            while (l<=r) {
                mid=(r+l)/2;
                System.out.println("l:"+i);
                System.out.println("r:"+i);
                System.out.println("i:"+i);
                System.out.println("mid:"+mid);
                System.out.println("---------------");
                if (target == matrix[i][mid]) {
                    find = true;
                    break;
                }
                else if (target > matrix[i][mid]) {
                    l=mid+1;
                }
                else if (target < matrix[i][mid]) {
                    r=mid-1;
                }
            }
            if(find==true)
            {
                break;
            }
        }
        return find;
    }
}
