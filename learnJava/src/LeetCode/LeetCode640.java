package LeetCode;

public class LeetCode640 {
    int temp = -1;
    int ans = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        rec(root);
        return ans;
    }
    void rec(TreeNode root){
        if(root.left!=null){
            rec(root.left);
        }
        if(temp!=-1) {
            ans = Math.min(Math.abs(root.val-temp),ans);
        }
        temp = root.val;
        if(root.right!=null){
            rec(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right=new TreeNode(5);
        root.right.left=new TreeNode(3);
        System.out.println(new LeetCode640().getMinimumDifference(root));
    }
}
