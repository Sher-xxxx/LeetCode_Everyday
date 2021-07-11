## LeetCode-主要元素

### 题目描述

1. 输入：一个整数数组
2. 输出：占比超过一半的元素，若没有则返回-1
3. 要求：时间复杂度O(N)，空间复杂度O(1)

### 算法思想

1. 使用HashMap存储每个元素及其出现的次数，时间复杂度O(N)，空间复杂度O(N)
2. 摩尔投票：整体遍历两次，第一次遍历时将出现的不同的元素进行抵消，如果最后还有值没被抵消，那他出现的次数就最多；第二次遍历check他出现的次数是否大于一半



### 代码实现

方法一：

```java
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
            if(map.get(i) > n/2)
                return i;
        }
        return -1;
    }
}
```

方法二：

```java
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int x = -1, cnt = 0;
        for(int i : nums){
            if(cnt == 0){
                // 如果cnt==0,则说明之前的值都被抵消了，这时注入新的值
                x = i;
                cnt = 1;
            }else{
                // 没抵消完
                cnt += (x == i)? 1 : -1;
            }
        }
        cnt = 0;
        for(int i : nums) cnt+=(i==x)?1:0;
        return cnt>n/2?x:-1;
    }
}
```



