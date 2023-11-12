//给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
//示例 1:
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右轮转 1 步: [7,1,2,3,4,5,6]
//向右轮转 2 步: [6,7,1,2,3,4,5]
//向右轮转 3 步: [5,6,7,1,2,3,4]

//示例 2:
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释:
//向右轮转 1 步: [99,-1,-100,3]
//向右轮转 2 步: [3,99,-1,-100]
package com.shh;

import java.util.ArrayList;
import java.util.List;

public class T15轮转数组 {
    public static void main(String[] args) {
        int []nums = {1,2,3,4,5,6,7};
        Solution15 st15=new Solution15();
        st15.rotate(nums,3);
    }
}
class Solution15 {
    public void rotate(int[] nums, int k) {
       int m;
       if(k>nums.length)
       {
         m=k%nums.length;
       }
       else{m=k;}//如果轮转的次数大于nums的长度是多余的
       List org=new ArrayList<>();
       for(int i=0;i<nums.length;i++)//将原数组保存到集合中
       {
           org.add(nums[i]);
       }
        for(int i=0;i<nums.length;i++)//将原数组扩容两倍
        {
            org.add(0);
        }
       for(int i=0;i<nums.length-m;i++)//对只需要后移的部分操作
       {
           org.set(i+m+nums.length,nums[i]);
       }
       for(int i=0;i<m;i++)//进行轮转操作
       {
           org.set(m-i-1+nums.length,nums[nums.length-i-1]);
       }
       System.out.println(org);
       System.out.println(org.subList(nums.length,nums.length*2));
       for(int i=0;i<nums.length;i++)//数据重新保存到数组中
       {
           nums[i]=(int)org.subList(nums.length,nums.length*2).get(i);
       }
    }
}
