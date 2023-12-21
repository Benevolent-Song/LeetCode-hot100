package com.shh;

import java.util.Arrays;

public class T96多数元素 {
}
class Solution96
{
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);//对数组进行排序
        return nums[nums.length / 2];//因为最多的那个数大于2/n,nums[nums.length / 2]那个数一定属于对多的那个数
    }
}
