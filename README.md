## LeetCode-和相同的二元子数组

### 题目描述

1. 输入：二元数组nums，整数goal
2. 输出：nums中和为goal的非空子数组的个数

### 算法思想

1. HashMap+前缀和：

``` 
sum[i+1] = sum[i] + nums[i]
target = sum[right] - sum[left]
```

2. 滑动窗口：

   滑动窗口思想：sum<target，右指针右移；sum>target，左指针右移。

   子数组两个数之间有0，则设计两个左指针，子数组的个数就为两个1之间0的个数

### 代码实现

方法一：

``` java
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        for(int num: nums){
            map.put(sum, map.getOrDefault(sum, 0)+1);
            sum += num;
            res += map.getOrDefault(sum-goal, 0);// 使用前缀和思想
        }
        return res;
        
    }
}
```

