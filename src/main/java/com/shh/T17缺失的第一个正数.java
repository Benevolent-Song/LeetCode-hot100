//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//示例 1：
//输入：nums = [1,2,0]
//输出：3

//示例 2：
//输入：nums = [3,4,-1,1]
//输出：2

//示例 3：
//输入：nums = [7,8,9,10,12]
//输出：1

//示例 4：
//输入：nums = [1,1]
//输出：2
package com.shh;

import java.util.Arrays;

public class T17缺失的第一个正数 {
    public static void main(String[] args) {
        int[] nums=new int[]{3,4,-1,1};
        Solution17 st17=new Solution17();
        System.out.println(st17.firstMissingPositive(nums));
    }
}
class Solution17 {
    public int firstMissingPositive(int[] nums) {
       int res=0;
       int find=-1;//找的的第一个大于0的元素
       int index=-1;//找到的第一个大于0的元素的下标
       Arrays.sort(nums);//对数组从小到大排序
       System.out.println("排序后的数组:"+Arrays.toString(nums));
       for(int i=0;i<nums.length;i++)
       {
           if(nums[i]>=0)
           {
             find=nums[i];//找到了大于0的数
             index=i;
             break;
           }
       }
       if(nums[nums.length-1]<=0&&find==-1)//所有数都是小于0的
       {
           res=1;
       }
       else//有数是大于0的
       {
           if (find>1)//第一个正整数一定为1的情况
           {
             res=1;
             return res;
           }
           else if(nums[nums.length-1]-find!=nums.length-index-1)//说明这个大于0的数组不是连续的,且最大正整数是第一个不连续的数,第一个元素一定是1
           {
              int [] array=new int[nums[nums.length-1]-find];//本来需要的长度
              for(int i=0;i<nums.length-index-1;i++)//现在的长度
              {
                  array[nums[index+i]-nums[index]]=nums[index+i];//1,2,3,5(length=4 find=1,index=0)   1,2,5(length=3 find=1,index=0)
              }
              System.out.println("整理后的数组:"+Arrays.toString(array));
              for(int i=0;i<array.length;i++)
              {
                  if(array[i]==0)//找到第一不连续的数,就是想要的结果
                  {
                      res=i+1;//由于第一个元素一定是1,而且连续所以一定是i+1
                      return res;
                  }
              }
           }
           else
           {
               res=nums[nums.length-1]+1;
               return res;
           }
       }
       return res;
    }
}
