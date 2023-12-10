package com.shh;

import java.util.*;
import java.util.stream.Collectors;

public class T75前K个高频元素 {
}
class Solution75{
    public int [] array;
    public int[] topKFrequent(int[] nums, int k) {
        this.array=nums;
        int [] res=new int[k];//存放最终结果
        int mm=0;
        Map<Integer,Integer> map=new HashMap<>();//存放数字及其出现次数
        Arrays.sort(nums);//对原始数组排序
        for(int i=0;i<nums.length;)//统计数字对应出现的次数
        {
            map.put(nums[i],find(i)-i);//存放数字和它对应的次数(下标相减)
            i=find(i);//下次从下一个不同的数字开始处理
        }
        //使用stream对map的entry按照value降序排序，然后取前k个
        List<Map.Entry<Integer, Integer>> sortedEntries = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .collect(Collectors.toList());
        // 将排序后的key取出来,放置到最终结果数组中
        Map<Integer, Integer> topKEntries = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : sortedEntries)
        {
            res[mm]=entry.getKey();
            mm++;
        }
        return res;
    }
    //找到比该数大的下标
    public int find(int index)
    {
        for(int i=index;i<array.length;i++)
        {
            if(array[index]<array[i])
            {
                return i;
            }
        }
        return  array.length;
    }
}

