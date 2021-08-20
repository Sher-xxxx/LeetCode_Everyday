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