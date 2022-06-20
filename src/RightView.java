import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class RightView {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public List<Integer> rightSideView(TreeNode root) {
        // base case
        if(root == null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        do {
            int size = queue.size();
            int iterator = 0;
            while (iterator < size) {
                TreeNode node = queue.remove();
                if (iterator + 1 == size) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                iterator++;
            }

        } while (!queue.isEmpty());
        return result;
    }
}