## LeetCode-变位词组

### 题目描述

1. 输入：字符串数组
2. 输出：变位词组合在一起的数组

### 算法思想

方法一：排序

对字符串数组中的每个字符串排序，当排序结果相同时，则说明这两个字符串是变位词。如：abc →abc，bac→abc



方法二：计数

把排序换成对字符串中字符计数，计数相同的字符串为变位词。如：abc→a1b1c1，bac→a1b1c1

### 代码实现

方法一：

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 排序，对字符串排序后，有相同字母的字符串一定是相同的
        Map<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
```

方法二：

``` java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 计数
        Map<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            int[] counts = new int[26];
            for(int i=0; i<str.length(); i++){
                counts[str.charAt(i) - 'a'] += 1;
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++){
                if(counts[i] != 0){
                    sb.append((char)('a'+i));
                    sb.append(counts[i]);
                }
            }

            String key = sb.toString();
            System.out.println(key);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
```

