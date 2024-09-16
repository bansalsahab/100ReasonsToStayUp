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
public class Solution {
    private Map<Integer, Integer> mp = new HashMap<>();

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        mp.put(root.val, mp.getOrDefault(root.val, 0) + 1);
        dfs(root.right);
    }

    public int[] findMode(TreeNode root) {
        dfs(root);

        List<Integer> resultList = new ArrayList<>();
        int maxFreq = 0;

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value > maxFreq) {
                maxFreq = value;
                resultList.clear();
                resultList.add(key);
            } else if (value == maxFreq) {
                resultList.add(key);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
