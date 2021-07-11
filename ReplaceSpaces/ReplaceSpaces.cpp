class Solution {
public:
    string replaceSpace1(string s) {
        int count = 0;
        for(int i=0; i < s.size(); ++i){
            cout<<s[i];
            if(s[i]==' ')
                count+=2;
        }
        count += s.size();
        string res(count, 'a');
        int left = s.size()-1, right = count-1;
        while(left>=0){
            if(s[left] == ' '){
                res[right--] = '0';
                res[right--] = '2';
                res[right--] = '%';
            }
            else
                res[right--] = s[left];
            left--;
        }
        return res;
    }
    string replaceSpace2(string s) {
        string res;
        for(char a:s){
            if(a == ' '){
                res.push_back('%');
                res.push_back('2');
                res.push_back('0');
            }
            else
                res.push_back(a);
        }
        return res;
    }
};