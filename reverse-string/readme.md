# LeetCode-反转字符串

## 反转字符串-1

### 题目描述

1. 输入：字符数组char[] s
2. 输出：原地修改数组，反转s中元素

### 算法思想

从头遍历，前后互调，s[i]与s[n-i-1]互换位置

### 代码实现

```java
class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        for(int i=0; i < n/2; i++){
            char c = s[i];
            s[i] = s[n-i-1];
            s[n-i-1] = c; 
        }
    }
}
```



## 反转字符串-II

### 题目描述

1. 输入：字符串s，整数k
2. 输出：字符串s每2k个字符反转前k个，不满2k的字符则反转前k个，不满k的字符全部反转

### 算法思想

对字符串s分段，隔k个，反转k个，最后一组全部翻转

i += 2k，reverse(i, min(i+k, n)-1)

### 代码实现

```java
class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for(int i=0; i < n; i += 2*k){
            reverse(arr, i, Math.min(i+k, n)-1);
        }
        return new String(arr);
    }
    void reverse(char[] arr, int l, int r){
        while(l < r){
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
```

