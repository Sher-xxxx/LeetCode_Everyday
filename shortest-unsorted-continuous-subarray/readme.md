## LeetCode-最短无序连续子数组

### 题目描述

1. 输入：整数数组nums
2. 输出：最短连续子数组的长度，令该数组排序后能够将整个数组按照升序排序

### 算法思想

方法一：排序，将原数组复制之后排序，对比两个数组，中间值不相同的子数组即为所求。

方法二：一次遍历

### 代码实现

方法一：

```java
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        int res = 0;
        int n = nums.length;
        int l=0, r=n-1;
        while(l < n){
            if(nums[l] == tmp[l]){
                l++;
            }
            else
                break;
        }
        while(r > l){
            if(nums[r] == tmp[r]){
                r--;
            }
            else
                break;
        }
        return r-l+1;
    }
}
```

方法二：

```java
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        System.out.println(maxn);
        int minn = Integer.MAX_VALUE, left = -1;
        for(int i = 0; i < n; i++){
            if(maxn > nums[i]){
                right = i;
            }else{
                maxn = nums[i];
            }
            if(minn < nums[n - i - 1]){
                left = n - i - 1;
            }else{
                minn = nums[n - i - 1];
            }
        }
        return right==-1? 0 : right-left+1;
    }
}
```

