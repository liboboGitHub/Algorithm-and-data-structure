import java.util.HashMap;

class Solution337_2 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> hashMap = new HashMap<>();  // 考虑这里为什么不使用数组来存储
        return generation(root, hashMap);

    }

    private int generation(TreeNode root, HashMap<TreeNode, Integer> hashMap) {
        if (root == null) {
            return 0;
        }
        if (hashMap.containsKey(root)) {
            return hashMap.get(root);
        }
        int money = root.val;
        if (root.left != null) {
            money = money + generation(root.left.right, hashMap) + generation(root.left.left, hashMap);

        }
        if (root.right != null) {
            money = money + generation(root.right.left, hashMap) + generation(root.right.right, hashMap);
        }
        int result = Math.max(money, generation(root.left, hashMap) + generation(root.right, hashMap));

        hashMap.put(root, result);
        return result;
    }
}
