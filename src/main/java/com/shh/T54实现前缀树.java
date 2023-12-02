package com.shh;

import java.util.ArrayList;
import java.util.List;

public class T54实现前缀树 {
    public static void main(String[] args) {

    }
}
class Trie {

    public List <String>list;
    public Trie() {
    list=new ArrayList<>();
    }
    public void insert(String word) {
        list.add(word);
    }
    public boolean search(String word) {
    if(list.contains(word))
    {
        return true;
    }
    return false;
    }

    public boolean startsWith(String prefix) {
    for(int i=0;i<list.size();i++)
    {
        if(list.get(i).length()>=prefix.length()) {
            if(list.get(i).substring(0, prefix.length()-1).equals(prefix))
            {
                return true;
            }
        }
    }
    return false;
    }
}
