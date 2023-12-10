package com.shh;
import java.util.*;
public class T71字符串解码 {
    public static void main(String[] args){
    }
}
class Solution71{
    public String decodeString(String s) {
        int k = 0;
        StringBuilder res = new StringBuilder();
        Stack<Integer> kstack = new Stack<>();
        Stack<StringBuilder> restack = new Stack<>();

        for(char c : s.toCharArray())//取出每一个字符
        {
            if(c == '[')
            {
                //碰到括号，记录K和当前res，归零。
                kstack.push(k);
                restack.push(res);
                k = 0;//清零
                res = new StringBuilder();//清空
            }
            else if(c ==']')
            {
                //pop出最近的一个左括号入的k,当前res进行计算不入栈
                int curk = kstack.pop();
                StringBuilder temp = new StringBuilder();
                for(int i = 0; i < curk; i++)
                {
                    temp.append(res);
                }
                //与括号外合并
                res = restack.pop().append(temp);

            }else if(c >= '0' && c <= '9'){
                k = c - '0' + k * 10;
                //如果k是多位数需要x10
            }else{
                res.append(c);
                //如果是字母则缓慢添加
            }
        }
        return res.toString();
    }
}
/**其它都可以了,但是对于没有括号的不能处理
class Solution71{
    public String decodeString(String s) {
        Stack<Character>times=new Stack<>();
        Stack<Character>fuhao=new Stack<>();
        List<Character>word=new ArrayList<>();
        List<Character>word1=new ArrayList<>();
        List<Character>words=new ArrayList<>();
        char [] ss=s.toCharArray();//将字符串转换为字符数组
        for(char ch:ss)//一位位取出字符串中的内容
        {
            if(ch!='['&&ch!=']')//如果存储的不是符号,判断是数字还是字母
            {
                if('1'<=ch&&ch<='9')
                {System.out.println(times);times.push(ch);}//压入次数
                else
                {
                     fuhao.push(ch);
                     if(fuhao.size()>1)
                     {
                     word1.clear();
                     }
                }
            }
            else if(ch=='[')
            {
                fuhao.push(ch);
                if(fuhao.size()>1)
                {
                  word1.clear();
                }
            }
            else if(ch==']')//此时需要处理一个括号内的字符串
            {
                //根据字符栈中的符号确定嵌套关系
                if(fuhao.size()>1)//如果存在嵌套关系
                {
                    for(int i=0;i<(int)times.pop()-48;i++)
                    {word.addAll(word1);}
                    word1.clear();
                    fuhao.pop();//清除一个符号
                }
                if(fuhao.size()==1)//如果没有嵌套关系
                {
                    for(int i=0;i<(int)times.pop()-48;i++)
                    {words.addAll(word);}
                    word.clear();//清空要处理的字符
                    fuhao.pop();//清除一个符号
                }
            }
        }
        String wordss="";
        for(int i=0;i<words.size();i++)
        {
            wordss=wordss+words.get(i);
        }
        return wordss;
    }
}
*/
