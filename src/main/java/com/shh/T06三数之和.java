//示例 1：
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
package com.shh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class T06三数之和 {
    public static void main(String[] args)
    {
        int [] array={1,6,7,2,1,-5,-4,-1,-7,9,4,-7,4,-9,2,-3,-3,6,4,-3,7,-10,4,-10,8,-2,1,-1};
        Solution6 st6=new Solution6();
        st6.threeSum(array);
    }
}
class Solution6 {
    public List<List<Integer>> threeSum(int[] nums) {
      List <List<Integer>> num=new ArrayList<>();
      List <Integer>[] numslist=new ArrayList[nums.length+10000];
      int [] []array=new int[nums.length+10000][3];//存放找到的数据
      int size=0;
      //使用3个指针遍历数组
      for(int i=0;i<nums.length;i++)
      {
          for(int j=i+1;j<nums.length;j++)
          {
              for(int m=j+1;m<nums.length;m++)
              {
                 if(nums[i]+nums[j]+nums[m]==0)
                 {
                     array[size][0]=nums[i];
                     array[size][1]=nums[j];
                     array[size][2]=nums[m];
                     //System.out.print("("+i+",");
                     //System.out.print(j+",");
                     //System.out.print(m+")");
                     //System.out.println(Arrays.toString(array[size]));
                     Arrays.sort(array[size]);//对得到的数组元素进行排序
                     size++;//得到的结果个数
                 }
              }
          }
      }
      //将排序好的数组保存到集合中
        for(int i=0;i<size;i++)
        {
            numslist[i]=new ArrayList();
            numslist[i].add(array[i][0]);
            numslist[i].add(array[i][1]);
            numslist[i].add(array[i][2]);
        }
      //里面有重复的集合,已经对每个数组中的三个数排序,再判断如有数组相等删去一个数组
        for(int i=0;i<size;i++)
        {
            for(int j=i+1;j<size;j++)
            {
               if(numslist[i].equals(numslist[j]))//集合的相等性判断使用equals方法
               {
                   numslist[j].clear();
               }
            }
        }
        for(int i=0;i<size;i++)
        {
           if(!numslist[i].isEmpty())
           {
               num.add(numslist[i]);
           }
        }
      System.out.println(num);
      return num;
    }
}
/**
 * 链接：https://leetcode.cn/problems/3sum/
 class Solution {
 public List<List<Integer>> threeSum(int[] nums) {
 Arrays.sort(nums);
 List<List<Integer>> res = new ArrayList<>();
 for(int k = 0; k < nums.length - 2; k++){
 if(nums[k] > 0) break;
 if(k > 0 && nums[k] == nums[k - 1]) continue;
 int i = k + 1, j = nums.length - 1;
 while(i < j){
 int sum = nums[k] + nums[i] + nums[j];
 if(sum < 0){
 while(i < j && nums[i] == nums[++i]);
 } else if (sum > 0) {
 while(i < j && nums[j] == nums[--j]);
 } else {
 res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
 while(i < j && nums[i] == nums[++i]);
 while(i < j && nums[j] == nums[--j]);
 }
 }
 }
 return res;
 }
 }
 */
