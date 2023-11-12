package com.shh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T02字母异位词分组 {
    public static void main(String[] args) {
        String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution2 st1=new Solution2();
        System.out.println(st1.groupAnagrams(strs));
    }
}
class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
       List <List<String>> list1=new ArrayList<List<String>>(100);
       List <String> [] listtemp = new List[100];
       List  chartlist=new ArrayList<>();
       int[][] chart=new int [strs.length][24];//存放各字母的出现次数
        for(int i=0;i<strs.length;i++)
        {
            for(int j=0;j<strs[i].length();j++) {
                int s;
                s=returnnum(strs[i].charAt(j));//统计各字母出现的次数
                chart[i][s]++;
            }
        }
        for(int []i:chart) {
            System.out.println(Arrays.toString(i));
        }
        for(int i=0;i<strs.length;i++) {
            listtemp[i]=new ArrayList<>();//创建足够多的集合
        }
        for(int []i:chart) {
            chartlist.add(i);//将字符保存到集合方便操作,chart保存字符个数信息
        }
        int num=0;
        for(int i=0;i<strs.length;i++)
        {
            if(chartlist.get(i)!=null) {
                listtemp[num].add(strs[i]);//别忘了每次放入比较的第一个字符串都还没有放入
                for (int j = 0; j < strs.length; j++) {
                    if(Arrays.equals((int[])chartlist.get(i),(int[])chartlist.get(j))&&i!=j)//数组的比较必须要用equals方法
                    {
                        listtemp[num].add(strs[j]);
                        chartlist.set(j,null);
                    }
                }
                num++;
                chartlist.set(i,null);
            }
        }
        System.out.println(num);//相同字母构成的组数
        for(int i=0;i<num;i++)//只取出存放有数据的集合
        {
            list1.add(listtemp[i]);
        }
            return list1;
    }
    public int returnnum(char b)
    {
        return (int)b-97;
    }
}
