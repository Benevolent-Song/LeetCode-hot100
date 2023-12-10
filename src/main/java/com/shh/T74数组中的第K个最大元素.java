package com.shh;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T74数组中的第K个最大元素 {
}
//找第k大的数(不考虑重复)(暴力法)
class Solution74{
    public int findKthLargest(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
/**找第k大的数(不同的数)
class Solution74{
    public int findKthLargest(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        Arrays.sort(nums);
        for(int i:nums)
        {
            System.out.print(i+",");
        }
        int find=0;
        for(int i=nums.length-1;i>0;i--)
        {
            find=nums[i];
            map.put(nums[i],i);
            if(map.size()==k)
            {
                return  find;
            }
        }
        return 0;
    }
}
*/
