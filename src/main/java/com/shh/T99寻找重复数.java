package com.shh;

import java.util.Arrays;

public class T99寻找重复数 {
}
class Solution99{
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==2)
        {
            return nums[0];
        }
        for(int i=1;i<nums.length-1;i++)
        {
            System.out.println(nums[i]);
            System.out.println(nums[i-1]);
            if(nums[i]==nums[i-1]||nums[i]==nums[i+1])
            {
                return nums[i];
            }
            if(nums[i]!=nums[i+1])
            {
                i=i+2;
            }
        }
        return -1;
    }
}
