class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length+1;
        // int[][] relation = new int[n][n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] pair: adjacentPairs){
            map.putIfAbsent(pair[0], new ArrayList<Integer>());
            map.putIfAbsent(pair[1], new ArrayList<Integer>());
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }

        System.out.print(map);
        int[] res = new int[n];
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
            int e = entry.getKey();
            List<Integer> adj = entry.getValue();
            if(adj.size() == 1){
                res[0] = e;
                break;
            }
        }

        res[1] = map.get(res[0]).get(0);
        for(int i=2; i<n; i++){
            List<Integer> adj = map.get(res[i-1]);
            res[i] = res[i-2]==adj.get(0) ? adj.get(1) :adj.get(0);
        }

        return res;
    }
}