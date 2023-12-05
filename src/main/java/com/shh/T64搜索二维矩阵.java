package com.shh;

public class T64搜索二维矩阵 {
}
class Solution64{
    public boolean searchMatrix(int[][] matrix, int target) {
        int find=-1;
        if(matrix[0].length==1)//如果每一行只有一个元素时
        {
            int left=0;
            int right=matrix.length-1;
            int mid;
            while(left<=right)//对列进行二分查找
            {
                mid=(left+right)/2;
                if(matrix[mid][0]==target)
                {return true;}
                else if(matrix[mid][0]>target)
                {right=mid-1;}
                else if(matrix[mid][0]<target)
                {left=mid+1;}
            }
            return false;
        }
        for(int i=0;i<matrix.length;i++)//对于每一行的元素大于两个时
        {
            if(matrix[i][0]<=target&&target<=matrix[i][matrix[0].length-1])//和每一行的首尾元素进行比较,再去找到的行进行查找
            {
                find=i;
                break;
            }
        }
        if(find!=-1)//如果找到了数字的范围
        {
            int left=0;
            int right=matrix[0].length-1;
            int mid;
            while(left<=right)//对找到范围的行进行二分查找
            {
                mid=(left+right)/2;
                if(matrix[find][mid]==target)
                {return true;}
                else if(matrix[find][mid]>target)
                {right=mid-1;}
                else if(matrix[find][mid]<target)
                {left=mid+1;}
            }
            return false;
        }
        else//如果不在所有的范围内
        {return false;}
    }
}
