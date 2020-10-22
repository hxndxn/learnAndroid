import java.util.Scanner;

public class TreeHeight {
    static class BinaryNode{
        BinaryNode left;
        BinaryNode right;
        int val;
        BinaryNode(int val){
            this.val = val;
        }
    }
    static BinaryNode root;
    static BinaryNode findNode(int val, BinaryNode root){
        if(root == null){
            return null;
        }
        if(root.val==val){
            return root;
        }
        BinaryNode res =  findNode(val,root.left);
        return res==null?findNode(val,root.right):res;
    }
    static void addNode(int val,BinaryNode father){
        if(father.left==null){
            father.left=new BinaryNode(val);
        }
        else
            father.right=new BinaryNode(val);
    }
    static void add(int a, int b){
        addNode(b,findNode(a,root));
    }
    static int depth(BinaryNode root){
        if(root == null) return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        if(count==0) {
            System.out.println(0);
            return;
        }
        if(count==1){
            System.out.println(1);
        }
        root = new BinaryNode(scanner.nextInt());
        root.left = new BinaryNode(scanner.nextInt());
        for (int i = 0; i < count-2; i++) {
            add(scanner.nextInt(),scanner.nextInt());
        }
        System.out.println(depth(root));
    }
}
