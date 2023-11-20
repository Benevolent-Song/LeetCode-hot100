//示例：
//输入:
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出:
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//解释:
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
package com.shh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T35LRU缓存 {
    public static void main(String[] args) {

    }
}
class LRUCache {
    public Map <Integer,Integer> map;
    public int capacity;
    //链表保存使用的频率,最近使用的始终放在最后
    public List <Integer>list=new ArrayList();
    public LRUCache(int capacity)//使用哈希hashmap存储
    {
        map=new HashMap<>(capacity);//初始化容量
        this.capacity=capacity;
    }
    public int get(int key)
    {
        if(map.get(key)!=null)//如果没有查询到
        {
            return map.get(key);
        }
        else//查询到返回
        {return -1;}
    }
    public void put(int key, int value) {
        if(map.get(key)!=null)//更新原有的数据
        {
            map.put(key,value);
            delete(key);//对操作后的使用频率更新
            list.add(key);
        }
        else if(map.size()>=capacity)//最久未使用key-value被改变
        {
            for(int i=0;i<list.size();i++)
            {
                if(list.get(i)!=null)//找到最开头的非空key,即为最少被使用的key-value
                {
                    int old=list.get(i);
                    map.remove(old);//移除map中的最少被使用的key-value
                    map.put(key,value);//加入新的key-value
                    list.add(key);
                    delete(old);
                    break;
                }
            }
        }
        else//如果还没有到达容量,直接添加
        {
            map.put(key,value);
            list.add(key);//添加到顺序链表中
        }
    }
    //对先后循序的链表进行删除操作
    public void delete(int key)
    {
        int find=0;
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i)==key)
            {
                find=1;
                list.set(i,null);//该节点设为null
            }
        }
    }
}

