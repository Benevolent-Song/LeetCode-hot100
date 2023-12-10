package com.shh;

import java.util.Arrays;

public class T73柱状图中最大的矩形 {
}
//暴力法,超过时间限定
class Solution73{
    public int largestRectangleArea(int[] heights) {
        int []nums=new int[heights.length];
        for(int i=0;i<heights.length;i++)
        {
            nums[i]=find(heights,i)*heights[i];
        }
        Arrays.sort(nums);
        return nums[heights.length-1];
    }
    //判断数组的宽度
    public int find(int [] array,int index)
    {
        int left=0;
        int right=array.length-1;
        //左遍历
        for(int i=index;i>=0;i--)
        {
            if(array[i]<array[index])
            {
                left=i+1;
                break;
            }
        }
        //右遍历
        for(int i=index;i<array.length;i++)
        {
            if(array[i]<array[index])
            {
                right=i-1;
                break;
            }
        }
        return right-left+1;
    }
  }

