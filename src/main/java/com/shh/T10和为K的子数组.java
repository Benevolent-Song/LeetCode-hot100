//示例 1：
//输入：nums = [1,1,1], k = 2
//输出：2

//示例 2：
//输入：nums = [1,2,3], k = 3
//输出：2
//暴力枚举法
package com.shh;
public class T10和为K的子数组 {
    public static void main(String[] args) {

        Solution10 st8=new Solution10();
        System.out.println(st8.subarraySum(new int[]{1, 1, 1},2));
    }
}
class Solution10 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++)//考虑每个数作为结尾
        {
            int sum = 0;
            for (int end = start; end >= 0; end--) //以该数为结尾向前遍历组成数组
            {
                sum += nums[end];//将子数组的求和
                if (sum == k)//如果子数组为要求的值,计数加一
                {
                    count++;
                    //由于有正有负,不能在这里break,可能后面还有成立的值
                }
            }
        }
        return count;
    }
}
