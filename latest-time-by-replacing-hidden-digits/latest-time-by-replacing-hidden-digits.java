class Solution {
    public String maximumTime(String time) {
        char[] arr = time.toCharArray();
        if(arr[0] == '?') arr[0] = (arr[1]<='9'&&arr[1]>='4') ? '1' : '2';
        if(arr[1] == '?') arr[1] = arr[0]=='2' ? '3' : '9';
        if(arr[3] == '?') arr[3] = '5';
        if(arr[4] == '?') arr[4] = '9';

        return new String(arr);
    }
}