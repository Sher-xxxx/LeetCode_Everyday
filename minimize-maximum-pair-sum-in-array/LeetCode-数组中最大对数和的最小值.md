## LeetCode-数组中最大对数和的最小值

### 题目描述

1. 输入：数组nums（长度为偶数）
2. 输出：数组中元素两两组合，不重复出现，求最大数对和

### 算法思想

排序+贪心

先排序，头尾相加，找到最大值

### 代码实现

```java
class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        for(int i=0; i < nums.length; i++){
            int temp = nums[i] + nums[nums.length - i - 1];
            ret = Math.max(temp, ret);
        }
        
        return ret;
    }
}
```

