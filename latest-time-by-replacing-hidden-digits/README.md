## LeetCode-替换隐藏数字得到的最晚时间

### 题目描述

1. 输入：字符串time（如2？：50）
2. 输出：将问号替换成能令字符串时间最大的数字

### 算法思想

使用if逐位进行判别

### 代码实现

```java
class Solution {
    public String maximumTime(String time) {
        char[] arr = time.toCharArray();
        if(arr[0] == '?') arr[0] = (arr[1]<='9'&&arr[1]>='4') ? '1' : '2';
        if(arr[1] == '?') arr[1] = arr[0]=='2' ? '3' : '9';
        if(arr[3] == '?') arr[3] = '5';
        if(arr[4] == '?') arr[4] = '9';

        return new String(arr);
    }
}
```

