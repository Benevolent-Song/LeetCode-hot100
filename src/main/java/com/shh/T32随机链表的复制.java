package com.shh;
import java.util.HashMap;
import java.util.Map;

public class T32随机链表的复制 {
    public static void main(String[] args) {
        Solution32 st32=new Solution32();
        Node node1=new Node(0);
        Node node2=new Node(1);
        node1.next=node2;
        st32.copyRandomList(node1);
    }
}
class Solution32{
    public Node copyRandomList(Node head) {
        if(head==null) {
            return null;
        }
        //创建一个哈希表，key是原节点，value是新节点
        Map<Node,Node> map = new HashMap<Node,Node>();
        Node p = head;
        //将原节点和新节点放入哈希表中
        while(p!=null) {
            Node newNode = new Node(p.val);//创建新节点,复制节点的value值
            map.put(p,newNode);
            p = p.next;
        }
        p = head;
        //遍历原链表，设置新节点的next和random
        while(p!=null) {
            Node newNode = map.get(p);
            //根据key值p,查找value值
            if(p.next!=null) {
                newNode.next = map.get(p.next);//复制新节点的next值
            }
            //p.random是原节点随机指向
            //map.get(p.random)是原节点随机指向  对应的新节点
            if(p.random!=null) {
                newNode.random = map.get(p.random);//复制新节点的random值
            }
            p = p.next;
        }
        //返回头结点，即原节点对应的value(新节点)
        return map.get(head);
    }
}
/**为什么这段代码没有起到复制的作用
 * class Solution32{
 *     public Node copyRandomList(Node head) {
 *         Node temp=head;
 *         List <Node>list=new ArrayList<>();
 *         while(temp!=null)
 *         {
 *           list.add(temp);
 *           temp=temp.next;
 *         }
 *         Node [] copy=new Node[list.size()];
 *         for(int i=0;i<list.size();i++)
 *         {
 *           copy[i]=new Node(list.get(i).val);
 *           copy[i].next=list.get(i).next;
 *           copy[i].random=list.get(i).random;
 *         }
 *         return copy[0];
 *     }
 * }
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
