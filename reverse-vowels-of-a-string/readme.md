# LeetCode-反转字符串中的元音字母

## 题目描述

1. 输入：字符串s
2. 输出：将字符串s中出现的元音字母进行翻转后的字符串

## 算法思想

使用双指针，左右指针分别找第一个遇到的元音字母，二者交换位置

## 代码实现

```java
class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int l = 0, r = n-1;
        while(l < r){
            while(l<n && !isVowel(arr[l])){
                System.out.println(l);
                l++;
            }
            while(r>0 && !isVowel(arr[r])){
                r--;
            }
            if(l < r){
                swap(arr, l, r);
                l++;
                r--;
            }
        }
        return new String(arr);
    }

    boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c) >= 0;
    }

    void swap(char[] arr, int l, int r){
        char temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
```

