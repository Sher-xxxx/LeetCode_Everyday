//方法一
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

//方法二
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
