//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
//{0,0,1}
package com.shh;
import java.util.ArrayList;
public class T04移动零 {
    public static void main(String[] args) {
        Solution4 s1=new Solution4();
        int [] nums = {0,1,0,3,12};
        s1.moveZeroes(nums);
    }
}
class Solution4 {
    public void moveZeroes(int[] nums) {
        ArrayList num1 =new ArrayList();//数组存放到集合方便操作
        for(int i=0;i<nums.length;i++)
        {
            num1.add(nums[i]);
        }
        int index=0;
        int zero=0;//计算出现0的位数
        while(true)
        {
            if((int)num1.get(index)==0)
            {
                num1.remove(index);
                num1.add(0);
                index=0;
                zero++;
            }
            else {index++;}
            if(index==nums.length-zero)//由于后面几位都为0,会陷入循环中
            {break;}
        }
        for(int i=0;i<nums.length;i++)//由于力扣输出的是数组nums.所以集合要转换为数组
        {
            nums[i]=(int)num1.get(i);
        }
        System.out.println(num1);
    }
}
/** 其它方法,链接：https://leetcode.cn/problems/move-zeroes/
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for(int i=0;i<nums.length;++i) {
            if(nums[i]!=0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for(int i=j;i<nums.length;++i) {
            nums[i] = 0;
        }
    }
}
*/
