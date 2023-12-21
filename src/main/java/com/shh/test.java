//用于测试各种小想法
package com.shh;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        List <Integer> list=new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.remove(2);
        System.out.println(list);
        System.out.println(list.size());
    }
}

