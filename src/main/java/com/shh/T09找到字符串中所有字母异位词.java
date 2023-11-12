//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。
//不考虑答案输出的顺序。异位词 指由相同字母重排列形成的字符串(包括相同的字符串)。
//示例 1:
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。

// 示例 2:
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
//"abaacbabc"   "abc"  [3, 4, 6]
//bpaa  aa  [2]
//cbaebabacd abc [0,6]
//自己写的时间超时了
package com.shh;
import java.util.ArrayList;
import java.util.List;
public class T09找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        Solution9 st9=new Solution9();
        System.out.println(st9.findAnagrams("cbaebabacd","abc"));
    }
}
class Solution9 {
    public List<Integer> findAnagrams(String s, String p) {
        List <Integer>list=new ArrayList<Integer>();
        List <Character>map_son=new ArrayList<Character>();//保持不变
        List <Character>map_son1=new ArrayList<Character>();//复制子字符串
        for(int i=0;i<p.length();i++)//将子字符串保存到hashmap中先
        {
            map_son.add(p.charAt(i));
        }
        map_son1.addAll(map_son);//复制子字符串,后面会有删减操作,map_son保持不变,不断赋值给map_son1
        int head=0;//存储异位分词头位置
        for(int i=0;i<s.length();i++)
        {
            if(p.length()>s.length())//如果子字符串大于父字符串,一定找不到结果
            {
               return new ArrayList<>();
            }
            if(map_son1.contains(s.charAt(i)))//如果包含子字符串
            {
                    //System.err.println("---------");
                    //System.err.println("i-head:" + (i - head));
                    //System.err.println("i:" + i);
                    //System.err.println("head:" + head);
                    //System.err.println("i:" + i + "|" + s.charAt(i));
                    int index = map_son1.lastIndexOf(s.charAt(i));//返回指定元素在动态数组中最后一次出现的位置。
                    map_son1.remove(index);//移除该字符,方便下一位比较
                    //System.err.println("size:" + map_son1.size());
                    if(map_son1.isEmpty())//说明此时字符串已经取出了一个完整的字母异位词
                    {
                        //System.err.println("---------");
                        map_son1.clear();
                        map_son1.addAll(map_son);//准备寻找下一个字母异位词
                        list.add(head);//将字母异位词的首字母的索引输出
                        head++;
                        i=head-1;//从head的下一位重新开始索引
                    }
            }
            else if(map_son1.size()==p.length())//不包含,而且还没有开始寻找
            {head++;i=head-1;}
            else if((i-head)!=p.length()-map_son1.size()-1)
            { //如果已经找了n位,但是突然有一位是不包含的,需要重新开始
                map_son1.clear();//如果不清理,会在他的后面继续添加
                map_son1.addAll(map_son);
                head++;
                i=head-1;
            }
        }
        return list;
    }
}
