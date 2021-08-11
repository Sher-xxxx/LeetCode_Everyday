## LeetCode-访问所有节点的最短路径

### 题目描述

1. 输入：二维数组graph，表示节点的连通关系
2. 输出：从任意节点开始访问所有节点的最短路径

### 算法思想

方法一：状态压缩+广度优先搜索。

### 代码实现

```java
class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] seen = new boolean[n][1 << n];
        for(int i = 0; i < n; i++){
            queue.offer(new int[]{i, 1 << i, 0});
            seen[i][1 << i] = true;
        }
        int ans = 0;
        while(!queue.isEmpty()){
            int[] tuple = queue.poll();
            int u = tuple[0], mask = tuple[1], dist = tuple[2];
            if(mask == (1 << n) - 1){
                ans = dist;
                break;
            }

            for(int v: graph[u]){
                int maskV = mask | (1 << v);
                if(!seen[v][maskV]){
                    queue.offer(new int[]{v, maskV, dist+1});
                    seen[v][maskV] = true;
                }
            }
        }
        return ans;
    }
}
```

