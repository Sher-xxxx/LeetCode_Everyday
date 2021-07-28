/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, TreeNode> parents = new HashMap<Integer, TreeNode>();
    List<Integer> ans = new ArrayList<Integer>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParents(root);

        findAns(target, null, 0, k);
        
        return ans;
        
    }

    public void findParents(TreeNode node){
        if(node.left != null){
            parents.put(node.left.val, node);
            findParents(node.left);
        }
        if(node.right != null){
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }

    public void findAns(TreeNode node, TreeNode from, int depth, int k){
        if(node == null){
            return ;
        }
        if(depth == k){
            ans.add(node.val);
            return ;
        }
        if(node.left != from){
            findAns(node.left, node, depth+1, k);
        }
        if(node.right != from){
            findAns(node.right, node, depth+1, k);
        }
        if(parents.get(node.val) != from){
            findAns(parents.get(node.val), node, depth+1, k);
        }
    }
}