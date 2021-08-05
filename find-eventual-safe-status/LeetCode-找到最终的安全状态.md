## LeetCode-找到最终的安全状态

### 题目描述

1. 输入：二维数组graph[]/[]，表示i节点能到其他的哪些节点
2. 输出：终点，按升序排序

### 算法思想

方法一：深度优先搜索

方法二：拓扑排序

### 代码实现

方法一：

```java
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i < n; i++){
            if(safe(graph, color, i)){
                ans.add(i);
            }
        }
        return ans;
    }
    boolean safe(int[][] graph, int[] color, int x){
        if(color[x] > 0){
            // 如果该点被遍历过,则返回该点是否为安全节点
            return color[x] == 2;
        }
        // 标记该点被遍历
        color[x] = 1;
        for(int y : graph[x]){
            if(!safe(graph, color, y)){
                return false;
            }
        }
        color[x] = 2;
        return true;
    }
}
```

方法二：

```java
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<List<Integer>> rg = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++){
            rg.add(new ArrayList<Integer>());
        }
        int[] inDeg = new int[n];
        for(int x = 0; x < n; x++){
            for(int y: graph[x]){
                rg.get(y).add(x);
            }
            inDeg[x] = graph[x].length;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < n; i++){
            if(inDeg[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int y = queue.poll();
            for(int x: rg.get(y)){
                if(--inDeg[x] == 0){
                    queue.offer(x);
                }
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            if(inDeg[i] == 0){
                ans.add(i);
            }
        }
        return ans;
    }
}
```

