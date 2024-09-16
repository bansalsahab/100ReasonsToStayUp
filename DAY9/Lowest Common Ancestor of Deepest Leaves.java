/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     
    Map<TreeNode, Integer> heightNode = new HashMap<>();
    int max_h = 0;

    
    public TreeNode lowestCommonAncestor(TreeNode root) {
        if (root == null || heightNode.get(root) == max_h) {
            return root;
        }
        
        TreeNode leftLCA = lowestCommonAncestor(root.left);
        TreeNode rightLCA = lowestCommonAncestor(root.right);
        
        if (leftLCA != null && rightLCA != null) {
            return root;
        }
        
        return leftLCA != null ? leftLCA : rightLCA;
    }

    
    public void collectLeaves(TreeNode root, int h) {
        if (root == null) {
            return;
        }
        
        max_h = Math.max(max_h, h);
        heightNode.put(root, h);
        
        collectLeaves(root.left, h + 1);
        collectLeaves(root.right, h + 1);
    }

   
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int h = 0;
        collectLeaves(root, h);
        return lowestCommonAncestor(root);
    }
}
