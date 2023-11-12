//示例 1:
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

//示例 2:
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

//示例 3:
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//使用滑动窗口判断
//一位一位滑入窗口,判断原窗口第一位和刚滑进去的这一位是否相同
//相同第一位滑出,最后一位划入,不相同则加入到窗口中,在滑动过程中窗口最大的个数就是结果
package com.shh;
import java.util.HashMap;
public class T08无重复字符的最长子串 {
    public static void main(String[] args) {
     Solution8 st8=new Solution8();
     String s="bbbbb";
     System.err.println(st8.lengthOfLongestSubstring(s));
    }
}
class Solution8 {
    public int lengthOfLongestSubstring(String s) {
    if (s.length()==0) return 0;
    HashMap<Integer,Character>map=new HashMap<Integer,Character>();
    int left=0;//窗口的起点
    int max=0;//窗口中个数的最大值
    int before=0;//上一个出现字符的下标
    for(int i=0;i<s.length();i++)
    {
        if(map.containsValue(s.charAt(i)))//说明原窗口已经有这个字符存在了
        {
            for(int m=0;m<i;m++)//找出包含该元素的下标
            {
                if(map.get(m)==s.charAt(i))
                {
                    before=m;//取的最近的before
                    //System.out.println("before:"+before);
                }
            }
           left=Math.max(left,before+1);//更新窗口的首地址,向后移动一位
           //System.out.println("left:"+left);
        }
        map.put(i,s.charAt(i));//不断往map中放入
        max=Math.max(max,i-left+1);//存储窗口的最长长度
    }
    return max;
    }
}

