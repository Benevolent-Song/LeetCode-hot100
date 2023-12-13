package com.shh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T79跳跃游戏II{
}
class Solution79{
    public int jump(int[] nums) {
        // 记录当前能跳跃到的位置的边界下标
        int border = 0;
        // 记录在边界范围内，能跳跃的最远位置的下标
        int maxPosition = 0;
        // 记录所用步数
        int steps = 0;
        for(int i=0;i<nums.length-1;i++)
        {
            maxPosition = Math.max(maxPosition,nums[i]+i);//取距离的最大值(一定是最短的距离)
            if(i==border)//到达下一个跳跃点
            {
                //设置下一次跳跃的边界
                border = maxPosition;
                steps++;//跳跃的次数加1
            }
        }
        return steps;//返回最短的距离
    }
}

