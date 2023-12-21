package com.shh;

import java.util.*;

public class T95只出现一次的数字 {
}
class Solution95{
    public int singleNumber(int[] nums) {
        //对数组进行排序,如果有相同的数,则它的前后一定是有相同的数的
        if(nums.length==1)
        {
            return nums[0];
        }
        Arrays.sort(nums);
        for(int i=1;i<nums.length-1;i++)
        {
            if(nums[i]!=nums[i-1]&&nums[i]!=nums[i+1])
            {
              return nums[i];
            }
            if(nums[i]!=nums[i-1]||nums[i]!=nums[i+1])
            {
                return nums[i];
            }
            if(nums[i]==nums[i+1])
            {i=i+2;}
        }
        return -1;
    }
}
