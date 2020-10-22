package LeetCode;
/*https://leetcode-cn.com/problems/merge-two-binary-trees/*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class LeetCode617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        boolean hasT1 = t1 != null;
        boolean hasT2 = t2 != null;
        if (!(hasT1 || hasT2)) {
            return null;
        }
        TreeNode res = new TreeNode((hasT1 ? t1.val : 0) + (hasT2 ? t2.val : 0));
        res.left = mergeTrees(hasT1 ? t1.left : null, hasT2 ? t2.left : null);
        res.right = mergeTrees(hasT1 ? t1.right : null, hasT2 ? t2.right : null);
        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode merged = new LeetCode617().mergeTrees(t1, t2);
        System.out.println(merged.val);

    }
}
