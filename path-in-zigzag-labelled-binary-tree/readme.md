## LeetCode-二叉树寻路

### 问题描述

1. 输入：整数label
2. 输出：寻求按照“之”字构建的二叉树中，到达label的路径

### 算法思想

先求层数，然后自底向上按照目标值与父节点关系计算

### 代码实现

```java
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        //先求层数
        int depth=0, k=label;
        while(k>=1){
            depth++;
            k = k>>1;
        }

        while(label>1){
            res.add(0, label);
            label /= 2;
            depth--;
            int left = (int)(Math.pow(2, depth) -1);
            int right = (int)(Math.pow(2, depth-1));

            label = right-(label-left);
        }
        res.add(0, 1);
        // System.out.println(10>>1);
        return res;
    }
}
```

