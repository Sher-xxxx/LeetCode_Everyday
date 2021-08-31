# LeetCode-航班预定统计

## 题目描述

1. 输入：二维数组bookings=[[first, last, seats], ...]，从first到last都需要seats个，整数n为航班数
2. 输出：每个航班所需要的座位数

## 算法思想

差分法，由于n输入在1-2*10^4之间，所以贪心法会超时

差分数组：
$$
d[i] = arr[i]-arr[i-1]
$$
此时在某个范围内进行加减，不需要遍历数组再每个进行加减，修改差分数组就行。比如需要修改[left, right]区间所有数，那调整d[left]和d[right+1]就行。

对于本题来说，bookings数组前两个数分别代表区间的开始start和结束end，即差分数组的起始端和结束端，在差分数组上对start和end+1位置修改就能得到本题的差分数组，再对差分数组进行累加就可以得到目标数组。

差分法时间复杂度为O(n^2)，差分法时间复杂度为O(n+m)

## 代码实现

```java
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        // 差分
        for(int[] booking: bookings){
            ans[booking[0]-1] += booking[2];
            if(booking[1] < n){
                ans[booking[1]] -= booking[2];
            }
        }
        for(int i = 1; i < n; i++){
            ans[i] += ans[i-1];
        }
        return ans;
    }
}
```



