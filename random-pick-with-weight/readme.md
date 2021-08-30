# LeetCode-按权重随机选择

## 题目描述

给定整数数组，w[i]为下标i的权重，写出函数pickIndex，随机获取下标i，概率与w[i]成正比

## 算法思想

首先构造给定数组的对应前缀和数组，使用二分查找找到其对应的下标

## 算法实现

```java
class Solution {
    int[] pre;
    int num;
    public Solution(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        for(int i = 1; i < w.length; i++){
            pre[i] = pre[i-1] + w[i];
        }
        num = Arrays.stream(w).sum();
    }
    
    public int pickIndex() {
        int x = (int)(Math.random()*num)+1;
        return binarySearch(x);
    }
    int binarySearch(int x){
        int left = 0, right = pre.length - 1;
        while(left < right){
            int mid = (right - left)/2 + left;
            if(pre[mid] < x){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
```

