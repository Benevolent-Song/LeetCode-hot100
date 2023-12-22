package com.shh;
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
public class T97颜色分类 {
    public static void main(String[] args) {

    }
}
class Solution97{
    public void sortColors(int[] nums) {
        //冒泡排序
        for(int i=0;i<nums.length-1;i++)//进行nums.length-1次冒泡
        {
            for(int j=0;j<nums.length-1-i;j++)//每一次冒泡最大值都在尾部了,不用再次与其比较了,所以nums.length-1-i
            {
                int temp=nums[j];
                if(nums[j]>nums[j+1])//将最大值沉底
                {
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }
}

