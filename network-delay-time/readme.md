## LeetCode-网络延迟时间

### 题目描述

1. 输入：二维数组[ui, vi, wi]，意味着从ui到vi需要wi的时间；节点个数n；出发节点k
2. 输出：从k出发所有节点都收到信号的时间

### 算法思想

最短路径算法

### 代码实现

```java
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(g[i], INF);
        }

        for(int[] t: times){
            int x = t[0]-1, y = t[1] - 1;
            g[x][y] = t[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k-1] = 0;
        boolean[] used = new boolean[n];
        for(int i=0; i < n; i++){
            int x = -1;
            for(int y=0; y < n; y++){
                if(!used[y] && (x == -1 || dist[y] < dist[x]))
                    x = y;
            }
            used[x] = true;
            for(int y=0; y < n; y++){
                dist[y] = Math.min(dist[y], dist[x]+g[x][y]);
            }
        }
        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF? -1 : ans;
    }
}
```

