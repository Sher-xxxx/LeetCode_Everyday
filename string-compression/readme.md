# LeetCode-压缩字符串

## 题目描述

1. 输入：字符数组chars
2. 输出：在原chars数组上修改，并返回修改后的长度

## 算法思想

使用双指针标记读和写的位置



## 代码实现

```java
class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if(n == 1) return 1;
        int write = 0, left = 0;
        for(int read = 0; read < n; read++){
            if(read == n-1 || chars[read] != chars[read+1]){
                // 到了末尾 || 前后两个字符不同
                // 这时就需要把原来的数组修改了
                // chars[write++] = chars[read]
                // 通过read-left 计算中间相同字符的数量
                chars[write++] = chars[read];
                int num = read - left + 1;
                if(num > 1){
                    int anchor = write;
                    while(num > 0){
                        // 把count放到chars里面
                        chars[write++] = (char)(num%10+'0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
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

