# 最小的K个数

## 题目描述

1. 输入：数组input，int型数字k
2. 输出：数组排序的前k个数字，不要求顺序、

## 算法思想

创建数组res，保存input的前k个数，排序后找到第一个大于新插入的位置，依次往后移。

## 代码实现

```java
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList();
        int[] minK = new int[k];
        for(int i = 0; i < k; i++){
            minK[i] = input[i];
        }

        Arrays.sort(minK);

        for(int i = k; i < input.length; i++){
            for(int j = 0; j < k; j++){
                if(minK[j] > input[i]){
                    int tmp = j;
                    for(int m = k-1; m > j; m--){
                        minK[m] = minK[m-1];
                    }
                    minK[tmp] = input[i];
                    break;
                }
            }
        }
        
        for(int i = 0; i < k; i++){
            res.add(minK[i]);
        }
        return res;
    }
}
```

