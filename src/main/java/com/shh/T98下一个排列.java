package com.shh;
import java.util.Arrays;
//输入：nums = [1,2,3]
//输出：[1,3,2]
public class T98下一个排列 {
}
class Solution98{
    public void nextPermutation(int[] nums) {
        // 尽可能小的[大数]与前面的[小数]交换。
        // 再将尽可能小的[大数]之后的数重置为升序
        // 从后向前 查找第一个满足 A[i] < A[k]
        int small=-1;//较小值的下标
        int big=-1;//较大值的下标
        for(int i=nums.length-1;i>0;i--)
        {
            if(nums[i]>nums[i-1])//找到第一个升序的两个数字的下标,即小值的下标
            {
                small=i-1;
                break;
            }
        }
        if(small==-1)//如果已经是降序排序,没有更大值了
        {
            Arrays.sort(nums);//返回升序的数组
            return;
        }
        else
        {
            for (int i = nums.length-1; i >small; i--)
            {
                if (nums[i] > nums[small])//找到较大致
                {
                    big = i;
                    break;
                }
            }
            //System.out.println("small:"+small);
            //System.out.println("big:"+big);
            int temp = nums[small];//将较大值和小值交换
            nums[small] = nums[big];
            nums[big] = temp;
            //将nums[small]后的数进行升序排序(冒泡排序),使其为最小值
            int m=0;//每次最大的到底部了,不用和最后一位再比较,减去m,减少运行时间
            for (int i = small; i < nums.length - 1; i++) {
                for (int j = small+1; j < nums.length - 1-m; j++) {
                    if (nums[j] > nums[j + 1]) {
                        int temp1 = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j+1] = temp1;
                    }
                }
                m++;
            }
        }
    }
}
