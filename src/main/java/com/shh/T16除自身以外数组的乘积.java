//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
//题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
//请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
//示例 1:
//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
//示例 2:
//输入: nums = [-1,1,0,-3,3]
//输出: [0,0,9,0,0]
package com.shh;
import java.util.Arrays;
public class T16除自身以外数组的乘积 {
    public static void main(String[] args) {
    int [] nums=new int[]{1,2,3,4};
    Solution16 st16=new Solution16();
    System.out.println(Arrays.toString(st16.productExceptSelf(nums)));
    }
}
//使用该数组元素的前缀和后缀相乘得到结果(前后缀数组对应元素相乘得到结果)
class Solution16{
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        // L 和 R 分别表示左右两侧的乘积列表
        int[] L = new int[length];//前缀数组
        int[] R = new int[length];//后缀数组

        int[] answer = new int[length];//最终结果的数组

        L[0] = 1;//由于第一个元素没有前缀,1就不会改变后缀的值
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];//得到前缀的值,保存到前缀数组中
        }

        R[length - 1] = 1;//由于最后一个元素没有后缀,1就不会改变前缀的值
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];//得到后缀的值,保存到后缀数组中
        }

        // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];//前后缀相乘得到想要得到的结果
        }

        return answer;
    }
}
/*
class Solution16{
    public int[] productExceptSelf(int[] nums) {
        int [] res=new int[nums.length];
        int temp=1;//必须设为1,为0任何数乘以它都是0
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
              if (nums[j]==0&&j!=i)//如果出现了0就直接结束
              {
                  temp=0;
                  break;
              }
              if(i==nums.length-1)//如果是最后一位,将前面几位都相乘起来
              {
                 temp=1;
                 for(int m=0;m<nums.length-1;m++) {
                     temp = temp * nums[m];
                 }
                 break;
              }
              if(j==i&&j<nums.length-1)//遇到自身,就跳过自身和下一个数相乘
              {
                j++;
              }
              temp=temp*nums[j];//将所有数相乘
            }
            res[i]=temp;//赋值
            temp=1;
        }
        return res;
    }
}
*/
