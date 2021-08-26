# LeetCode-救生艇

## 题目描述

1. 输入：数组people为每个人的体重，最大承重limit
2. 输出：需要的最少的船数

## 算法思想

排序+双指针

## 代码实现

```java
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        while(left <= right){
            if(people[left] + people[right] <= limit){
                ++left;
            }
            right--;
            ans++;
        }
        return ans;
    }
}
```

