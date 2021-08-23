# LeetCode-获取生成数组中的最大值

## 题目描述

1. 输入：整数n
2. 规则：生成长度为n+1 的数组nums，nums[0] = 0，nums[1] = 1，偶数 nums[i] = nums[i/2]，奇数nums[2I+1] = nums[i] + nums[i+1]
3. 输出：数组nums的最大值

## 算法思想

数组模拟

## 代码实现

```java
class Solution {
    public int getMaximumGenerated(int n) {
        if(n == 0) return 0;
        int[] nums = new int[n+1];
        nums[1] = 1;
        int max = 1;
        for(int i=2; i <= n; i++){
            nums[i] = nums[i/2] + i%2 * nums[i/2 + 1];
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
```

