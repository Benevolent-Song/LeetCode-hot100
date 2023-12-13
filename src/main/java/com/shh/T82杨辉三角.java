package com.shh;

import java.util.ArrayList;
import java.util.List;
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
public class T82杨辉三角 {
}
class Solution82{
    public List<List<Integer>> generate(int numRows) {
        List <List<Integer>> res=new ArrayList<>();//最终结果的集合
        for(int i=0;i<numRows;i++)
        {
            List <Integer> list=new ArrayList<>();//每次创建一个新的集合
            list.add(1);//第一个元素一定是1
            for(int n=1;n<=i-1;n++)
            {
                list.add(res.get(i-1).get(n-1)+res.get(i-1).get(n));//去上一行的n-1和n位,再将两数相加
            }
            if(i>0)//只有在第二行开始在末尾添加1
            {
                list.add(1);//结尾添加1,最后一个元素一定是1
            }
            res.add(list);//将该行结果保存到最终集合中
        }
        return res;
    }
}
