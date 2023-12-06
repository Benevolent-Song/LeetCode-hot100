package com.shh;
public class T67寻找旋转排序数组中的最小值 {
}
class Solution67{
    public int findMin(int[] nums) {
        int find=-1;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]>nums[i+1])
            {
                find=i+1;
                break;
            }
        }
        if(find==-1)
        {
            return nums[0];
        }
        else
        {
            if(nums[find]>nums[0])
            {return nums[0];}
            else
            {return nums[find];}
        }
    }
}
