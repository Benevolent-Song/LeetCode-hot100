package com.shh;
public class T65在排序数组中查找元素的第一个和最后一个位置 {
}
class Solution65{
    public int[] searchRange(int[] nums, int target) {
        int []index=new int[2];
        int left=0;
        int right=nums.length-1;
        int mid = 0;
        int find=-1;
        while(right>=left)//二分查找
        {
            mid=(left+right)/2;
            if(nums[mid]==target)
            {
                find=mid;
                break;
            }
            else if(nums[mid]>target)
            {right=mid-1;}
            else if(nums[mid]<target)
            {left=mid+1;}
        }
        if(find==-1)//如果没有找到
        {return new int[]{-1, -1};}
        //对前后有几个target进行判断mid
        int sta=find;
        //System.out.println("index:"+mid);
        while(nums[find]==target&&find>0)//前
        {
            find--;
            if(find==0&&nums[find]==target)//增加while中缺少的对第一个元素的判断
            {find=-1;break;}
            //System.out.println("find"+find);
        }
        while(nums[mid]==target&&mid<nums.length-1)//后
        {
            mid++;
            if(mid==nums.length-1&&nums[mid]==target)//增加while中缺少的对最后一个元素的判断
            {mid=nums.length;break;}
            //System.out.println("mid:"+mid);
        }
        if(find==sta)
        {index[0]=find;}else{index[0]=find+1;}
        if(mid==sta)
        {index[1]=mid;}else{index[1]=mid-1;}
        return index;
    }
}
