## LeetCode-等差数列划分

### 题目描述

1. 输入：nums数组
2. 输出：nums中等差数组的子数组个数

### 算法思想

计算相邻两个点的差值

### 代码实现

```java
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n <= 2) return 0;
        int l = 0, ans = 0;
        for(int i = 2; i < n; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                ans += ++l;
            }else{
                l = 0;
            }
        }
        return ans;
    }
}
```

