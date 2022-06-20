
class KthSmallestElementInBST {
    static int count;
    private RightView.TreeNode kthSmallestHelper(RightView.TreeNode root, int k) {
        if(root == null){
            return null;
        }
        RightView.TreeNode leftAns =  kthSmallestHelper(root.left, k);
        if(leftAns != null){
            return leftAns;
        }
        count+=1;
        if(count == k){
            return root;
        }
        return  kthSmallestHelper(root.right, k);
    }

    public int kthSmallest(RightView.TreeNode root, int k) {
        count = 0;
        RightView.TreeNode ans = kthSmallestHelper(root, k);
        if(ans != null){
            return ans.val;
        }else{
            return -1;
        }
    }
}