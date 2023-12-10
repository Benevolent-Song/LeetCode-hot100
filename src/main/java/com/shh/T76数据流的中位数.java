package com.shh;

import java.util.*;

class MedianFinder {
    List<Integer> list;
    public MedianFinder() {
        list=new ArrayList<>();
    }
    public void addNum(int num) {
        list.add(num);
    }
    public double findMedian() {
        Collections.sort(list);//对数组来排序
        int mid=list.size()/2;//找到中间下标
        //System.out.println("mid:"+mid);
        //System.out.println(list);
        if(list.size()%2==1)//如果为奇数
        {return (double)list.get(mid);}
        else//如果为偶数
        {return ((double)list.get(mid)+(double)list.get(mid-1))/2; }
    }
}
