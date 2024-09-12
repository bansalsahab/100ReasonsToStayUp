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
    public int minDiffInBST(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        inOrderTraversal(root, nodeList);
        
        int minDifference = Integer.MAX_VALUE;
        for (int i = 1; i < nodeList.size(); i++) {
            minDifference = Math.min(minDifference, nodeList.get(i) - nodeList.get(i - 1));
        }
        
        return minDifference;
    }
    private void inOrderTraversal(TreeNode node, List<Integer> nodeList) {
        if (node == null) return;
        
        inOrderTraversal(node.left, nodeList); 
        nodeList.add(node.val); 
        inOrderTraversal(node.right, nodeList); 
    }
}
