## LeetCode-复制带随机指针的链表

### 题目描述

1. 输入：长度为N的链表，每个节点还包含一个额外增加的随即指针random，该指针可以指向链表中任何节点或空姐点。
2. 输出：构造链表的深拷贝，所有节点的值都和原链表相同，新节点的指针也指向新链表中的新节点
3. **Tips：**复制链表中的指针不应指向原链表中的节点

### 算法思想

由于节点中包含了random指针，其指向的节点不固定，那么如果按照顺序依次复制节点，其random指针指向的可能是空值，因此，**不能按照顺序直接复制链表**。

**方法一： 回溯+哈希表**

使用哈希表记录每一个节点对应新节点的创建情况，如果当前节点的后继节点和当前节点的随机指针指向的节点中任意一个没有被创建，那就递归地创建

**方法二：迭代+节点拆分**

把链表 A→B→C 变为 A→A'→B→B'→C→C'

### 代码实现

```java
/*
// Definition for a Node.
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
*/

class Solution {
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        if(!cachedNode.containsKey(head)){
            Node node = new Node(head.val);
            cachedNode.put(head, node);
            node.next=copyRandomList(head.next);
            node.random=copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}
```

方法二：

```java

class Solution {
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        for(Node node=head; node != null; node=node.next.next){
            // 先复制节点，并把复制的节点查到原链表中间
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }
        for(Node node=head; node != null; node=node.next.next){
            // 复制原链表的指针关系
            Node newNode = node.next;
            newNode.random = (node.random != null) ? node.random.next : null;
        }
        Node newHead = head.next;
        for(Node node=head; node != null; node=node.next){
            // 把一整条链表拆分成两个
            Node newNode = node.next;
            node.next = node.next.next;
            newNode.next = (newNode.next == null)? null : newNode.next.next;
        }
        return newHead;
    }
}
```

