## LeetCode-检查是否区域内所有整数都被覆盖

### 题目描述

1. 输入：二维数组ranges，其中为多个区间范围，整数left，整数right
2. 输出：判断区间[left, right]中的数是否都被ranges包含

### 算法思想

**方法一：暴力法**

由于题目给定限定要求“1<=left<=right<=50”，所以可以使用boolean数组保存每一位是否被包含的情况。

**方法二：排序法**

将ranges数组按照起点大小排序，缩小[left, right]区间范围，最后判断left和right的大小关系得到结果。

**优化：**将子区间相交的部分才将flag赋值为true，在[left, right]之外的不变。

### 代码实现

方法一：

```Java
class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean flag[] = new boolean[51];
        for(int[] range: ranges){
            for(int i=range[0]; i <= range[1]; i++){
                flag[i] = true;
            }
        }
        for(int i=left; i<=right; i++){
            if(flag[i] == false) return false;
        }

        return true;
    }
}
```

方法二：

```java
class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (a1, a2)->a1[0]-a2[0]);

        for(int range[]:ranges){
            int l = range[0];
            int r = range[1];
            if(l <= left && left <= r){
                left = r+1;
            }
        }
        return left>right;
    }
}
```

优化：

```java
class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean flag[] = new boolean[51];
        for(int[] range: ranges){
            int L = Math.max(range[0], left);
            int R = Math.min(range[1], right);
            for(int i=L; i<=R; i++){
                flag[i] = true;
            }
        }

        for(int i=left; i<=right; i++){
            if(flag[i] == false) return false;
        }

        return true;
    }
}
```

