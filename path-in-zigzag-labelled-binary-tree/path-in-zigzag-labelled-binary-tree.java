class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        //先求层数
        int depth=0, k=label;
        while(k>=1){
            depth++;
            k = k>>1;
        }

        while(label>1){
            res.add(0, label);
            label /= 2;
            depth--;
            int left = (int)(Math.pow(2, depth) -1);
            int right = (int)(Math.pow(2, depth-1));

            label = right-(label-left);
        }
        res.add(0, 1);
        // System.out.println(10>>1);
        return res;
    }
}