class Solution {
    public boolean isCompleteTree(TreeNode root) {

        if(root==null) return true;

        int lastLevel= height(root)-1;

        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level=0;

        while (!q.isEmpty()) {
            
        
            int levelSize = q.size();
            
            if(level!=lastLevel){
                if(levelSize!=Math.pow(2,level)) return false;
            }

            if(level==lastLevel){
                
                if(check(new ArrayList<>(q)) == false) return false;
                else return true;

               
            }
         
            while(levelSize!=0){
                
                TreeNode t= q.poll();
                //if(t==null){
                //    levelSize--;
                //    continue;
               // }
               
              if(level==lastLevel-1){
                q.offer(t.left);
                q.offer(t.right);
                levelSize--;
              }



               else{
               if(t.left!=null) q.offer(t.left);
               if(t.right!=null)  q.offer(t.right);
                levelSize--;
               }
            }


          level++;

        }
        return true;
        
    }

    public int height(TreeNode node){
        if(node==null) return 0;

        int l =height(node.left);
        int r = height(node.right);

        return 1+Math.max(l,r);
    }

    public boolean check(ArrayList<TreeNode> list){
     int i=0;
     while ( i<list.size() && list.get(i)!=null){
        i++;
     }
     
     while(i<list.size()){
        if(list.get(i)!=null) return false;
        i++;
     }

     return true;
    
    }
}