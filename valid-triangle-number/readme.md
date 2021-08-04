## LeetCode-有效三角形的个数

### 题目描述

1. 输入：包含非负整数的数组
2. 输出：可以组成三角形的三元组的个数

### 算法思想

方法一：暴力法，三重循环判断能否组成三角形

方法二：二分查找，二分查找前两个数之和

方法三：双指针

### 代码实现

方法一：

```java
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for(int i=0; i < n-2; i++){
            for(int j =i+1; j < n-1; j++){
                for(int k = j+1; k < n; k++){
                    if(nums[i] + nums[j] > nums[k] && nums[j]+nums[k] > nums[i] && nums[i]+nums[k]> nums[j])
                        ans += 1;

                    else break;
                }
            }
        }
        return ans;
    }
}
```

方法二：

```java
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for(int i=0; i < n-2; i++){
            for(int j =i+1; j < n-1; j++){
                int s = nums[i] + nums[j];
                int l = j+1, r = n-1;
                while(l < r){
                    int mid = l + r + 1 >> 1;
                    if(nums[mid] < s) l = mid;
                    else r = mid - 1;
                }
                if(nums[r] < s){
                    ans += r-j;
                }
            }
        }
        return ans;
    }
}
```

方法三：

```java
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for(int i = n-1; i >= 2; i--){
            int l = 0, r = i - 1;
            while(l < r){
                if(nums[l] + nums[r] > nums[i]){
                    ans += r - l;
                    --r;
                }else{
                    l++;
                }
            }
        }
        return ans;
    }
}
```

