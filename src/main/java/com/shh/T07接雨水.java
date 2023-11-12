//{0,1,0,2,1,0,1,3,2,1,2,1}  输出:6
//{4,2,0,3,2,5} 输出:9
//{5,4,1,2} 输出:1
//{5,5,1,7,1,1,5,2,7,6} 输出:23
//{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3} 输出:83
//{0,2,5,0,6,9,8,7,4,4,5,6} 输出:10
/**按列求
 * 作者：windliang
 * 链接：https://leetcode.cn/problems/trapping-rain-water/submissions/
 */
package com.shh;
public class T07接雨水 {
    public static void main(String[] args) {
        int[] array={5,4,1,2};
        Solution7 st7=new Solution7();
        System.out.println(st7.trap(array));
    }
}
class Solution7
{
    public int trap(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;//找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0; //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
}
