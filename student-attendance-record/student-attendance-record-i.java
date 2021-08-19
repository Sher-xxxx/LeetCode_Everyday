class Solution {
    public boolean checkRecord(String s) {
        int n = s.length();
        int absents = 0, lates = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'A'){
                if(++absents == 2)
                    return false;
            }

            if(s.charAt(i) == 'L'){
                if(++lates == 3)
                    return false;
            }else{
                lates = 0;
            }
        }
        return true;
    }
}