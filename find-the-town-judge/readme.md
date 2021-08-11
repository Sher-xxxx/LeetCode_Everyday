## LeetCode-找到小镇的法官

### 题目描述

1. 输入：整数n代表有n个人，二维数组trust，trust[i]\[j]代表i信任j
2. 输出：不信任任何人且其余人都信任他的编号

### 算法思想

图的出度和入度，inTrust[tr[1]] += 1，outTrust[tr[0]] += 1

inTrust=n-1 且 outTrust = 0

### 代码实现

```java
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inTrust = new int[n+1]; // 信任i的人有几个
        int[] outTrust = new int[n+1];// i信任的人有几个

        for(int[] tr: trust){ 
            outTrust[tr[0]] += 1;
            inTrust[tr[1]] += 1;
        }
        for(int i = 1; i <= n; i++)
            if(inTrust[i] == n-1 && outTrust[i] == 0) return i;

        return -1;
    }
}
```

