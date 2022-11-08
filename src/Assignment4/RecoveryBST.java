package Assignment4;

import java.util.ArrayList;
import java.util.List;

public class RecoveryBST {public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.left.right = new TreeNode(2);
    var recover = new RecoveryBST();
    recover.recoverTree(root);
}

    public void recoverTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraverse(root,res);
        int[] swapNums = findSwapNums(res);
        recover(root,2,swapNums[0],swapNums[1]);
    }
    public void inorderTraverse(TreeNode root, List<Integer> res){
        if(root==null)return ;
        inorderTraverse(root.left,res);
        res.add(root.val);
        inorderTraverse(root.right,res);
    }
    public int[] findSwapNums(List<Integer> res){
        int n = res.size();
        int x= -1;
        int y =-1;
        boolean swap_First = false;
        for(int i =0;i<n-1;i++){
            if(res.get(i+1)<res.get(i)){
                y = res.get(i+1);
                if(!swap_First){
                    x =res.get(i);
                    swap_First = true;
                }else{
                    break;
                }
            }
        }
        return new int[]{x,y};
    }
    public void recover(TreeNode root, int count, int x, int y){
        if(root!=null){
            if(root.val==x || root.val==y){
                root.val = root.val==x?y:x;
                if(count--==0)return;
            }
            recover(root.left,count,x,y);
            recover(root.right,count,x,y);
        }
    }
}
