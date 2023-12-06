package com.shh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T68寻找两个正序数组的中位数 {
}
class Solution68{
    List <Double>list=new ArrayList();
    int index;
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        for(int i=0;i<nums1.length;i++)
        {list.add((double)nums1[i]);}
        for(int i=0;i<nums2.length;i++)
        {list.add((double)nums2[i]);}
        Collections.sort(list);//对整个数组按顺序进行排序
        if(list.size()%2==0)//长度为偶数
        {
            index=list.size()/2;
            return (list.get(index-1)+list.get(index))/2;
        }
        else//长度为奇数
        {
            index=list.size()/2;
            return list.get(index);
        }
    }
}

