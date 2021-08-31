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
        System.out.println(Arrays.toString(ans));
        for(int i = 1; i < n; i++){
            ans[i] += ans[i-1];
        }
        return ans;
    }
}