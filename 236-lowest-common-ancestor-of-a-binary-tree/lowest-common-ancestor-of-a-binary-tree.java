class Solution {

    TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return lca;
    }

    public int dfs(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null)
            return 0;

        int left = dfs(node.left, p, q); // left se pucho ki kitno ko boss karsakta he
        int right = dfs(node.right, p, q); // right se pucho ki kitno ko boss karsakta he

        int self = 0;
        if (node == p || node == q) {  // kya khud ko boss karsakta he ?
            self = 1;
        }


        if (left + right + self == 2 && lca == null) // total kitno ko karraha he 
                                                     // 0 kisiko nahi ,1 ek ko,2 dono ko 
            lca = node;                              // reccrsion me ans niche se aata he i.e bt so jo pehle mila vahi lowest thats why
                                                     // and lca==null lika matlab sab se pehla ans vahi lca hoga 
        

        return left + right + self; // return ki curr node kitno ka boss he 
    }
} // learned this from padho with pratysuh bhaya
