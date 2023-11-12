//示例 1：
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

//示例 2：
//输入：nums = [1]
//输出：1

//示例 3：
//输入：nums = [5,4,-1,7,8]
//输出：23
package com.shh;
public class T13最大子数组和 {
    public static void main(String[] args) {
        int [] nums={-1,-2};
        Solution13 st13=new Solution13();
        System.out.println(st13.maxSubArray(nums));
    }
}
class Solution13 {
    public int maxSubArray(int[] nums) {
    int max=0;//保存每次较大的那个值
    int temp=0;//保存每次取出的数组的值
    max=nums[0];//初始化为第一个元素
    for(int i=0;i<nums.length;i++)
    {
        for(int j=i+1;j<nums.length+1;j++)
        {
            temp=0;
            for(int m=i;m<j;m++)
            {
               temp=temp+nums[m];
            }
            if(temp>max)
            {
                max=temp;
            }
        }
    }
    return max;
    }
}
