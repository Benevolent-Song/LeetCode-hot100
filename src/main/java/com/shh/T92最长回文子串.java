package com.shh;

public class T92最长回文子串 {
}
class Solution92{
    public boolean isPalindromic(String s)//判断字符串是否为回文,从两端向内
    {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 暴力解法
    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        //遍历所有字串进行判断
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j <= len; j++)
            {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max)
                {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        }
        return ans;
    }
}
