## LeetCode-Excel表列序号

### 题目描述

1. 输入：字符串columnTitle
2. 输出：对应的int型序号，如A→1，B→2，···，AA→27，AB→28

### 算法思想

26进制转10进制，但是要从后向前来

### 代码实现

```Java
class Solution {
    public int titleToNumber(String columnTitle) {
        // 26进制转10进制
        int res = 0, pos=1;
        char[] ca = columnTitle.toCharArray();
        for(int i = ca.length-1; i >= 0; i--){
            res += pos * (ca[i]-'A'+1);
            pos *= 26;
            // System.out.println(c-'A'+1);
        }
        return res;
    }
}
```

## 类似题目-Excel表列名称

### 题目描述

1. 输入：int型表序号
2. 输出：String型表列名称，1→A，2→B，···，28→AB

### 算法思想

10进制转26进制，同样也需要计算后对字符串进行翻转

### 代码实现

```java
class Solution {
    public String convertToTitle(int columnNumber) {
        if(columnNumber == 0) return "";
        StringBuilder s = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;
            s.append((char)(columnNumber%26+'A'));
            columnNumber /= 26;
        }
        return s.reverse().toString();
    }
}
```

