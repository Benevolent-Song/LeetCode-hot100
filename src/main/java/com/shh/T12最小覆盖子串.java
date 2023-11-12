//给你一个字符串s、一个字符串t。返回s中涵盖t所有字符的最小子串。如果s中不存在涵盖t所有字符的子串，ff则返回空字符串 "" 。
//注意:对于t中重复字符，我们寻找的子字符串中该字符数量必须不少于t中该字符数量。
//如果 s 中存在这样的子串，我们保证它是唯一的答案。
//示例 1：
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。

//示例 2：
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。

//示例 3:
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。
//还有一点小问题
package com.shh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T12最小覆盖子串 {
    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        Solution12 st12=new Solution12();
        System.out.print(st12.minWindow(s,t));
    }
}
class Solution12{
    public String minWindow(String s, String t) {
        String s1=new String();
        int [] chartT=new int[26];//存放子字符串的字母情况
        int [] chartT1=new int[26];//存放子字符串的字母情况
        int [][]temp=new int[s.length()+10][26];//存放包含子字符串的字符串的字符情况
        List list=new ArrayList();
        int nums=0;//统计子字符串的个数
        int [][] index = new int[temp.length][2];//存放每个数组的起始和结束下标
        int head=0;//存放数组的头
        if(t.length()>s.length()||((t.length()==1&&s.length()==1)&&!t.equals(s)))//一定不存在子字符串的情况
        {
            return new String();
        }
        //如果父字符串和子字符串不是相同的大小写则直接返回null
        if(((int)t.charAt(0)<=122&&(int)t.charAt(0)>=97)&&((int)s.charAt(0)<=90&&(int)s.charAt(0)>=65))//如果大小写间不匹配
        {
            return new String();
        }
        if(((int)s.charAt(0)<=122&&(int)s.charAt(0)>=97)&&((int)t.charAt(0)<=90&&(int)t.charAt(0)>=65))
        {
            return new String();
        }
        for(int i=0;i<t.length();i++)//将子字符串的字母情况保存
        {
            chartT[charttonum(t.charAt(i))]++;
        }
        for(int i=0;i<s.length();i++)//将父字符串的字母情况保存
        {
            chartT1[charttonum(s.charAt(i))]++;
        }
        if(Arrays.equals(chartT1,chartT))
        {
            return s;
        }
        if(t.length()==s.length()&&!chartT1.equals(chartT)&&!t.equals(s))//一定不存在子字符串的情况
        {
            return new String();
        }
        for(int i=0;i<s.length();i++)//在父字符串中取字符串
        {
            temp[nums][charttonum(s.charAt(i))]++;
            if(t.length()==1&&s.charAt(i)==t.charAt(0))//s(母字符串) t(子字符串)
            {
                return t;
            }
            if(ifson(temp[nums],chartT))//如果字符情况和子字符串相同
            {
               //System.out.println("字串字母分布情况:"+Arrays.toString(temp[nums]));
               list.add(temp[nums]);
               index[nums][0]=head;
               index[nums][1]=i;
               //System.out.println("begin:"+head);
               //System.out.println("end:"+i);
               //System.out.println("---------------------------------------");
               nums++;
               head++;
               i=head-1;
            }
        }
        /*
        for(int []i:temp)
        {
            System.out.println("temp:"+Arrays.toString(i));
        }
        System.out.println("---------------------------------------------");
        for(int []i:index)
        {
            System.out.println("index:"+Arrays.toString(i));
        }
         */
        //寻找temp中个数最少的,返回其下标
        int m=minindex(index,list.size());
        //System.out.println("m:"+m);
        //System.out.println("final-begin:"+index[m][0]);
        //System.out.println("final-end:"+index[m][1]);
        if(index[m][0]==0||index[m][0]==index[m][1]){s1=s.substring(index[m][0],index[m][1]+1);}
        else{s1=s.substring(index[m][0],index[m][1]+1);}
        return s1;
    }
    //将字母转换为下标
    public int charttonum(char a)
    {
        if((int)a>=(int)'a'&&(int)a<=(int)'z')
        {
            return (int)a-(int)'a';
        }
        else if((int)a>=(int)'A'&&(int)a<=(int)'Z')
        {
            return (int)a-(int)'A';
        }
        else {return 0;}
    }
    //是否输出子字符串
    public boolean ifson(int [] s1,int [] s2)//s1父字符串,s2子字符串
    {
       boolean t=true;
       for(int i=0;i<s1.length;i++)
       {
           if(s2[i]!=0)
           {
               if(s1[i]<s2[i])
               {
                   t=false;
                   break;
               }
           }
       }
       return t;
    }
    //取最小的数组的下标
    public int minindex(int [][]s,int nums)
    {
        int index=0;
        int min=s[0][1]-s[0][0];
        for(int i=0;i<nums;i++)
        {
           if(s[i][1]-s[i][0]<min)
           {
              min=s[i][1]-s[i][0];
              index=i;
           }
        }
        return index;
    }
}
