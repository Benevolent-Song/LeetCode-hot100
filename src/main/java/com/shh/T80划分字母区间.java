package com.shh;
//输入：s = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T80划分字母区间 {
}
class Solution80{
    public List<Integer> partitionLabels(String s) {
        Map<Character,List<Integer>> map=new HashMap<>();//存放字符串和其对应的起始结束位置
        List <Character> list=new ArrayList<>();//存放各个字母第一次出现的顺序
        List<Integer> res=new ArrayList<>();//存放最终分割数组的个数
        for(int i=0;i<s.length();i++)//存放所有字母第一次出现和最后一次出现时的下标
        {
            if(!map.containsKey(s.charAt(i)))
            {
                list.add(s.charAt(i));//按照字母出现的顺序添加到集合
                map.put(s.charAt(i),new ArrayList<>());//放置字符串
                map.get(s.charAt(i)).add(i);//存放起始下标
                map.get(s.charAt(i)).add(i);//存放初始的结束下标(本身)
            }
            else
            {map.get(s.charAt(i)).set(1,i);}//如果已经有结束下标了,对结束下标进行更新}
        }
        System.out.println(s.length());
        System.out.println(map);
        int start=map.get(list.get(0)).get(0);//开始下标
        int finsh=map.get(list.get(0)).get(1);//结束下标
        int max=map.get(list.get(0)).get(1);
        //已经存储了起始和结束的索引
        for(int i=0;i<list.size();)//查找finsh内所有字母最大的结束下标,将其与start相减,得到下一个要开始的i=finsh+1
        {
            for(int n=start;n<finsh;n++)//查找finsh内所有字母最大的结束下标
            {
                max=Math.max(max,map.get(s.charAt(n)).get(1));
            }
            res.add(max-start+1);//添加分割数组的长度
            start=max+1;//更新开始下标
            if(start>s.length())
            {return res;}
            finsh=map.get(s.charAt(start)).get(1);//更新结束下标
            i=start;
        }
        return res;
    }
}
