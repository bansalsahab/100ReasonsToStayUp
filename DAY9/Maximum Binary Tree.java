class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }

        // Find the index of the maximum element in the current subarray
        int maxIndex = findMaxIndex(nums, start, end);

        // Create a new TreeNode with the maximum element
        TreeNode root = new TreeNode(nums[maxIndex]);

        // Recursively build the left subtree from the left part of the subarray
        root.left = construct(nums, start, maxIndex - 1);

        // Recursively build the right subtree from the right part of the subarray
        root.right = construct(nums, maxIndex + 1, end);

        // Return the root of the constructed tree
        return root;
    }

    // Helper function to find the index of the maximum element in the subarray
    private int findMaxIndex(int[] nums, int start, int end) {
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
