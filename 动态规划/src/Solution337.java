/*
 * 树形动态规划问题：
 * 就此题来说，根节点作为爷爷节点，该节点有两个儿子，四个孙子；
 * 基本描述：爷爷偷的钱加上孙子偷的钱和儿子偷的钱相比较
 *
 * */
class Solution337 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int money = root.val;
        if (root.left != null) {
            money = money + rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            money = money + rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(money, rob(root.right) + rob(root.left));


    }
}