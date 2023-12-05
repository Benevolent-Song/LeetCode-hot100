package com.shh;
public class T63搜索插入位置 {
}
class Solution63{
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid=(right+left)/2;
        while(left<=right)
        {
            mid=(right+left)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[mid]<target)
            {
                left=mid+1;
            }
            else if(nums[mid]>target)
            {
                right=mid-1;
            }
        }
        System.out.println("mid:"+mid);
        if(nums[mid]>target)
        {
            if(mid==0)
            {return 0;}
            else if(mid==nums.length-1)
            {return nums.length-1;}
            else
            {return mid;}
        }
        if(nums[mid]<target)
        {
            if(mid==0)
            {return 1;}
            else if(mid==nums.length-1)
            {return nums.length;}
            else
            {return mid+1;}
        }
        return mid;
    }
}
