class Solution {

    Deque<TreeNode> asc = new ArrayDeque<>();
    Deque<TreeNode> dsc = new ArrayDeque<>();

    public boolean findTarget(TreeNode root, int k) {

        TreeNode t = root;

       
        while (t != null) {
            asc.push(t);
            t = t.left;
        }

       
        t = root;

        while (t != null) {
            dsc.push(t);
            t = t.right;
        }

        int l = getSmall();
        int r = getBig();

        while (l < r) {

            if (l + r == k) {
                return true;
            }

            if (l + r < k) {
                l = getSmall();   
            } else {
                r = getBig();    
            }
        }

        return false;
    }

    public int getSmall() {

        TreeNode small = asc.pop();

        TreeNode rightChild = small.right;

        while (rightChild != null) {
            asc.push(rightChild);
            rightChild = rightChild.left;
        }

        return small.val;
    }

    public int getBig() {

        TreeNode big = dsc.pop();

        TreeNode leftChild = big.left;

        while (leftChild != null) {
            dsc.push(leftChild);
            leftChild = leftChild.right;
        }

        return big.val;
    }
}