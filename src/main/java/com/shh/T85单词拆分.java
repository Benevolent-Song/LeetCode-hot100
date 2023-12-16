package com.shh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T85单词拆分 {
}
//没有考虑两个字典单词是包含关系的情况,例入“aaa”和“aaaaa”
class Solution85{
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String,String> map=new HashMap<>();//存放字典单词
        String temp="";//存放取出来的单词
        String all ="";//存放取出来的单词
        int start=0;
        int finsh=0;
        for(String ss:wordDict)
        {
            map.put(ss,"");
        }
        for(int i=0;i<s.length();i++)
        {
            temp=temp+s.charAt(i);
            if(map.containsKey(temp))
            {
                finsh=i+1;
                all=all+s.substring(start,finsh);
                start=i+1;
                temp="";//清空
            }
        }
        if(all.equals(s))
        {
            return true;
        }
        return false;
    }
}
