package com.shh;
public class T78跳跃游戏 {
}
class Solution78{
    public static boolean canJump(int[] nums) {
        if (nums == null)//如果数组为空
        {return false;}
        //前n-1个元素能够跳到的最远距离
        int k = 0;
        //如果i到达了k,说明k不再增加,k已经到达最远距离了
        for (int i = 0; i <= k; i++)
        {
            //第i个元素能够跳到的最远距离
            int temp = i + nums[i];
            //更新最远距离
            k = Math.max(k, temp);
            //如果最远处到达了末尾,返回true
            if (k >= nums.length - 1)
            {return true;}
        }
        //最远距离k不再改变,且没有到末尾元素
        return false;
    }
}
