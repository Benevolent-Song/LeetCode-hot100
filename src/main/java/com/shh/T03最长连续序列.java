//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//示例 1：
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//示例 2：
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
package com.shh;
import java.util.Arrays;

public class T03最长连续序列 {
    public static void main(String[] args) {
        int [] nums = {0,3,7,2,5,8,4,6,0,1};
        Solution3 st3=new Solution3();
        System.out.println(st3.longestConsecutive(nums));
    }
}
class Solution3 {
    public int longestConsecutive(int[] nums) {
//先对数组进行排序,先使用排序算法
        mergeSort(nums);//使用归并排序缩短运算时间
        System.out.println(Arrays.toString(nums));
        int []temp=new int [nums.length+1];
        int num=1;
        int index=0;
//统计连续数的次数
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i+1]-nums[i]==1)
            {
                num++;
            }
            else if(nums[i+1]==nums[i])//如果相等先不进行操作
            {}
            else
            {
                temp[index]=num;//存储本次的次数
                index++;//下次的次数存储到下个元素中
                num=1;//重新开始计算次数
            }
        }
        if(num>0) {
            temp[index] = num ;
        }
        if(nums.length==0) {
            temp[index] = 0 ;
        }
        System.out.println(Arrays.toString(temp));
        int num1=0;
//找到数组temp[index]中的最大值
       for(int i=0;i<temp.length;i++)
       {
           if(temp[i]>num1)
           {
               num1=temp[i];
           }
       }
       return num1;
    }
    public static void mergeSort(int[] a, int low, int high) {
        //首先判断 low 和 high是否指向一个地方
        // 正常情况下就是 ==
        if(low == high) {
            return;
        }
        int mid = (low + high)/2;
        //先递归左边
        mergeSort(a, low, mid);
        //在递归右边
        mergeSort(a, mid+1, high);
        //合并
        merge(a,low,mid,high);
        System.out.println(Arrays.toString(a));
    }
    //合并
    public static void merge(int[] a,int low,int mid,int high) {
        //定义第一段
        int s1 = low;
        //定义第二段
        int s2 = mid+1;
        //定义临时数组
        int[] temp =new int[high-low+1];
        int i = 0;

        //判断s1,s2是否有数据，放入临时数组
        while(s1<=mid) {
            temp[i++]=a[s1++];
        }
        while(s2<=high) {
            temp[i++]=a[s2++];
        }
        for(int j = 0;j < temp.length;j++) {
            a[j+low]=temp[j];
        }
    }
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        int[] temp = new int[n];
        mergeSortHelper(arr, temp, 0, n - 1);
    }

    private  void mergeSortHelper(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelper(arr, temp, left, mid);
            mergeSortHelper(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }
    private  void merge(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }
    }
    public void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

