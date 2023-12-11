package com.shh;
import java.util.Arrays;

public class T77买卖股票的最佳时机{
}
class Solution77{
    public int [] array;
    public int maxProfit(int[] prices) {
        this.array=prices;
        int [] price=new int[array.length];
        for(int i=0;i<array.length;i++)//计算每一天卖出的最大利润
        {
            price[i]=findprice(i);
        }
        Arrays.sort(price);
        return price[price.length-1];//挑出利润的最大值
    }
    //找到最大的利润
    public int findprice(int index)
    {
        int max=array[index];
        for(int i=index;i<array.length;i++)//找到最大的值
        {
            if(array[i]>max)
            {
                max=array[i];
            }
        }
        return  max-array[index];//返回利润
    }
}
