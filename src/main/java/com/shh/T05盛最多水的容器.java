//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
//穷举法
package com.shh;
public class T05盛最多水的容器 {
    public static void main(String[] args) {
        int [] array={1,8,6,2,5,4,8,3,7};
        Solution5 st5=new Solution5();
        System.out.println(st5.maxArea(array));
    }
}
class Solution5 {
    public int maxArea(int[] height) {
        int max=0;//存放最大值
        int temp=0;//存放遍历的结果
        for(int i=0;i<height.length;i++)
        {
            for(int j=i+1;j<height.length;j++)
            {
                temp=(j-i)*Math.min(height[i],height[j]);
                if(temp>max)
                {
                    max=temp;
                }
            }
        }
        return max;
    }
}
/**双指针方法
 class Solution {
 public int maxArea(int[] height) {
 int i = 0, j = height.length - 1, res = 0;
 while(i < j)//左右两个指针相遇则表示内缩结束
 {
 res = height[i] < height[j] ?
 Math.max(res, (j - i) * height[i++]):
 Math.max(res, (j - i) * height[j--]);
 }
 return res;
 }
 }
 */
