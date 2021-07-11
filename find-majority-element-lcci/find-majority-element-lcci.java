class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int x = -1, cnt = 0;
        for(int i : nums){
            if(cnt == 0){
                // 如果cnt==0,则说明之前的值都被抵消了，这时注入新的值
                x = i;
                cnt = 1;
            }else{
                // 没抵消完
                cnt += (x == i)? 1 : -1;
            }
        }
        cnt = 0;
        for(int i : nums) cnt+=(i==x)?1:0;
        return cnt>n/2?x:-1;
    }
}