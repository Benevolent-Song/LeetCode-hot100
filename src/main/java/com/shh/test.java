//用于测试各种小想法
package com.shh;

import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        // 创建HashMap
        HashMap<String, String> hashMap = new HashMap<>();

        // 添加键值对
        hashMap.put("Key1", "Value1");
        hashMap.put("Key2", "Value2");

        // 替换键值对
        String oldKey = "Key1";
        String newValue = "NewValue";

        // 使用replace方法替换值
        hashMap.replace(oldKey, newValue);

        // 输出修改后的HashMap
        System.out.println(hashMap);
    }
}

