package com.shh;

public class T87乘积最大子数组 {
}
class Solution87{
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0)//如果要乘的下一个数为负数
            {
                int tmp = imax;//最大值和最小值交换的中间变量
                imax = imin;//最小值乘以负数变为最大值
                imin = tmp;//最大值乘负数变为最小值
            }
            imax = Math.max(imax*nums[i], nums[i]);//判断当前的最大值
            imin = Math.min(imin*nums[i], nums[i]);//判断当前的最小值

            max = Math.max(max, imax);//最大值
        }
        return max;
    }
}
