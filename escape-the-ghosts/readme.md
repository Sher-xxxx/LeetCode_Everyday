# LeetCode-逃离阻碍者

## 题目描述

1. 输入：二维数组ghosts，一维数组target
2. 规则：从[0, 0]出发，可以向任意方向移动，目标到达target点，ghosts为阻碍者，可以向任意方向移动，目标到达target点时不碰见任何的ghost
3. 输出：能否顺利到达target

## 算法思想

计算曼哈顿距离，如果不碰到任何的ghost，那其曼哈顿距离一定会小于任何的ghost到target的距离

## 代码实现

```java
class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] src = {0, 0};
        int distance = cal_distance(src, target);
        for(int[] ghost: ghosts){
            int temp_distance = cal_distance(ghost, target);
            if(temp_distance <= distance)
                return false;
        }
        return true;
    }

    int cal_distance(int[] src, int[] target){
        // 计算两点之间距离
        return Math.abs(src[0] - target[0]) + Math.abs(src[1] - target[1]);
    }
}
```

