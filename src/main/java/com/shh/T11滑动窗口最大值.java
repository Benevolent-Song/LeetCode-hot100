//示例 1：
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//示例 2：
//输入：nums = [1], k = 1
//输出：[1]
//[1,-1] k=1 [1,-1]
//[7,2,4] k=2 [7,4]
package com.shh;
import java.util.Arrays;

public class T11滑动窗口最大值 {
    public static void main(String[] args) {
        Solution11 st11=new Solution11();
        System.out.println(Arrays.toString(st11.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }
}
//8  k=1->7  k=2->7  k=3->6  k=4->5  k=5->4 k=6->3 k=7->2 k=8->1可以得到数组个数的规律
class Solution11 {
    public int[] maxSlidingWindow(int[] nums, int k) {
    int [] s;
    if(nums.length==k)//初始化数组的长度,根据k值动态调整
    {s = new int[1];}
    else if(k==1){s = new int[nums.length];}
    else {s = new int[nums.length-k+1];}//根据数学归纳得到的规律
    int max;//存储一个窗口中最大的数
    for(int i=0;i<nums.length-k+1;i++)
    {
        max=nums[i];
        for(int m=i;m<i+k;m++)
        {
            if(nums[m]>max)
            {
                max=nums[m];
            }
        }
        s[i]=max;
    }
    return s;
    }
}
