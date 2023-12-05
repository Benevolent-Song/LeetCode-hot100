package com.shh;

import java.util.Arrays;

public class T66搜索旋转排序数组 {
}
class Solution66{
    public int search(int[] nums, int target) {
        //找到第一个比后一个数大的数组,将数组分为两个顺序数组
        int get=-1;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]>nums[i+1])
            {
                get=i;//以此划分数组
                break;
            }
        }
        int []list1=new int[get+1];
        int []list2=new int[nums.length-get];
        if(get!=-1)
        {
            list1= Arrays.copyOfRange(nums,0,get+1);
            list2= Arrays.copyOfRange(nums,get+1,nums.length);
            /*
            for(int i=0;i<list1.length;i++)
            {
                System.out.print(list1[i]+",");
            }
            System.out.println();
            for(int i=0;i<list2.length;i++)
            {
                System.out.print(list2[i]+",");
            }
            */
        }
        else//如果没有旋转
        {return find(nums,target);}
        if(target>=list1[0]&&target<=list1[list1.length-1])
        {
            if(find(list1,target)==-1){return -1;}
            else {return find(list1,target);}
        }
        if(target>=list2[0]&&target<=list2[list2.length-1])
        {
            if(find(list2,target)==-1){return -1;}
            else {return find(list2,target)+list1.length;}
        }
        return -1;
    }
    public int find(int nums[],int target)
    {
        int left=0;
        int right=nums.length-1;
        int mid;
        while (right>=left)
        {
            mid=(left+right)/2;
            if(nums[mid]==target)
            {return mid;}
            else if (nums[mid]>target) {right=mid-1;}
            else if (nums[mid]<target) {left=mid+1;}
        }
        return -1;
    }
}

