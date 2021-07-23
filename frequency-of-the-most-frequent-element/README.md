## LeetCode-最高频元素的频数

### 题目描述

1. 输入：整数数组nums，可以+1的次数k
2. 输出：数组中的数最多执行k次+1后，出现最高频的数

### 算法思想

**滑动窗口**

首先对nums数组进行排序

从左到右计算差值是多少，可以加多少个1，每次右移一位，需要加(nums[right]-nums[right-1])*(right-left)这些数

如果需要加的数超出了k，那左边指针就需要右移，即i++

### 代码实现

```java
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int max=0, temp=0;
        for(int i=0, j=0; j<nums.length; j++){
            while(nums[j]*(j-i)-temp > k){
                // 如果需要加的值超出了k，那左边界就往右移
                temp -= nums[i++];
            }
            temp += nums[j];
            max = Math.max(max, j-i+1);
        }
        return max;
    }
}
```

